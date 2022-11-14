package training.weather;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.util.Date;

import org.junit.Test;

public class WeatherForecastTest {

	@Test
	public void testWeatherForecastMadrid() throws IOException {
		String forecast = WeatherForecast.getCityWeather("Madrid", new Date());
		assertNotNull("Predicción no obtenida", forecast);
	}

	@Test
	public void testWeatherForecastEmptyCity() throws IOException {
		String forecast = WeatherForecast.getCityWeather("", new Date());
		assertEquals("", forecast);
	}

	@Test
	public void testWeatherForecastFutureDate() throws IOException {
		String forecast = WeatherForecast.getCityWeather("Madrid", new Date(new Date().getTime() + (618400000)));
	assertNotNull("Predicción no obtenida", forecast);
		assertEquals("", forecast);
	}

}