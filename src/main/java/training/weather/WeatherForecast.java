package training.weather;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherForecast {

	public static String getCityWeather(String city, Date datetime) throws IOException {

		HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();

		// Si la fecha es null, se iguala a la fecha actual
		if (datetime == null)
			datetime = new Date();

		// Se valida la fecha y que la ciudad no esté vacía
		if (validateDate(datetime) && (!city.isEmpty() || !city.isBlank())) {

			// Se obtienen los datos de localización para la ciudad dada
			JSONObject locationData = getLocatonByCity(requestFactory, city);

			// Se obtienen las predicciones para la localización dada
			String forecast = getForecast(requestFactory, locationData);

			// Se genera el JSONArray con las fechas y el weathercode
			JSONArray dailyResults = new JSONObject(forecast).getJSONObject("daily").getJSONArray("time");
			JSONArray weatherCodeResults = new JSONObject(forecast).getJSONObject("daily").getJSONArray("weathercode");

			// Se recorre el array de resultados con la fecha
			for (int i = 0; i < dailyResults.length(); i++) {
				// Si el formato de la fecha obtenida por parámetro es igual al de la respuesta
				// devuelve el enumerado por el código
				if (new SimpleDateFormat("yyyy-MM-dd").format(datetime).equals(dailyResults.get(i).toString())) {
					return ForecastEnum.getEnumByCode((int) weatherCodeResults.get(i)).getDescription();
				}
			}
		}

		return "";
	}

	// Método que valida que la fecha no sea posterior a 6 días de la actual
	private static boolean validateDate(Date datetime) {
		return datetime.before(new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 6)));
	}

	// Método que obtiene las predicciones a partir de la localización
	private static String getForecast(HttpRequestFactory requestFactory, JSONObject locationData) throws IOException {
		String resultado = "";

		// Se obtienen la longitud y latitud a partir de los datos de localización
		String longitud = locationData.get("longt").toString();
		String latitud = locationData.get("latt").toString();

		// Se realiza una peticióncon los datos obtenidos
		HttpRequest request = requestFactory.buildGetRequest(
				new GenericUrl("https://api.open-meteo.com/v1/forecast?latitude=" + latitud + "&longitude=" + longitud
						+ "&daily=weathercode&current_weather=true&timezone=Europe%2FBerlin"));
		resultado = request.execute().parseAsString();

		return resultado;
	}

	// Método que obtiene datos de una localización a partir del nombre de la ciudad
	private static JSONObject getLocatonByCity(HttpRequestFactory requestFactory, String city) throws IOException {

		String resultado = "";

		try {
			HttpRequest request = requestFactory
					.buildGetRequest(new GenericUrl("https://geocode.xyz/" + city + "?json=1"));
			resultado = request.execute().parseAsString();
		} catch (Exception e) {
			System.out.println("No se ha encontrado la ciudad indicada");
		}

		return new JSONObject(resultado);
	}
}
