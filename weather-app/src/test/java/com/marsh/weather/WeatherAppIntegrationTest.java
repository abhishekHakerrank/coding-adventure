package com.marsh.weather;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.marsh.weather.controller.WeatherAppController;
import com.marsh.weather.model.WeatherForecast;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherAppIntegrationTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private WeatherAppController weatherAppController;
	
	@Test
	public void getWeatherData() {
		
		WeatherForecast response = weatherAppController.getWeatherData("20147");
		if (response != null) {
			logger.info(response.getName());
			if(response.getEntries() != null) {
				for (int i=0;i< response.getEntries().size();i++) {
					logger.info("The Weather Forecast For Tomorrow"+"Date and Time: "+response.getEntries().get(i).getTimestamp()+"MAX TEMP: "+response.getEntries().get(i).getTempMax()+"Min Temp:   "+response.getEntries().get(i).getTempMax());
				}
				
			}
		}
	}
	}
