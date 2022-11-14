package training.weather;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;

public class WeatherForecastTest {

	// Prueba con una ciudad real y la fecha actual
	@Test
	public void testWeatherForecastMadrid() throws IOException {
		String forecast = WeatherForecast.getCityWeather("Madrid", new Date());
		assertNotNull("Predicción no obtenida", forecast);
	}

	// Prueba con la ciudad en blanco y la fecha actual
	@Test
	public void testWeatherForecastEmptyCity() throws IOException {
		String forecast = WeatherForecast.getCityWeather("", new Date());
		assertEquals("", forecast);
	}

	// Prueba con una ciudad en real y la fecha futura a más de 6 días
	@Test
	public void testWeatherForecastFutureDate() throws IOException {
		String forecast = WeatherForecast.getCityWeather("Madrid", new Date(new Date().getTime() + (618400000)));
		assertNotNull("Predicción no obtenida", forecast);
		assertEquals("", forecast);
	}

	// Prueba con una ciudad que no existe y la fecha actual
	@Test(expected = Exception.class)
	public void testWeatherForecastNarnia() throws IOException {
		String forecast = WeatherForecast.getCityWeather("Narnia", new Date());
	}

	// Prueba de tiempo óptimo
	@Test(timeout = 100)
	public void testWeatherForecastOptimo() throws IOException {
		String forecast = WeatherForecast.getCityWeather("Madrid", new Date());
		assertNotNull("Predicción no obtenida", forecast);
	}

}