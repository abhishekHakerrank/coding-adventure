package com.marsh.weather;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

import com.marsh.weather.model.WeatherForecast;

@SpringBootApplication
public class WeatherAppClientApplication implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(WeatherAppClientApplication.class);
	public static void main(String[] args) {
		
		SpringApplication.run(WeatherAppClientApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		logger.info("Argument------------------"+Arrays.toString(args.getSourceArgs()));
	//	String[] parameter = args.getSourceArgs();
		RestTemplate restTemplate = new RestTemplate();
		WeatherForecast forecast =  restTemplate.getForObject("http://localhost:9999/weatherForecast/"+args.getSourceArgs()[1], WeatherForecast.class);;
		/*
		 * if(parameter.length >0 && parameter.length < 2 ) { for (String arg :
		 * parameter) {
		 * 
		 * forecast=
		 * restTemplate.getForObject("http://localhost:9999/weatherForecast/"+arg,
		 * WeatherForecast.class); } } else {
		 * logger.info("Argument------------------"+"Initiating Default call");
		 * 
		 * forecast =
		 * restTemplate.getForObject("http://localhost:9999/weatherForecast/20120",
		 * WeatherForecast.class); }
		 */
		logger.info("Tomorrow's Weather Fore Cast --"+forecast.getEntries());
	}


}
