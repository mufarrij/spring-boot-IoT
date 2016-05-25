package it.uliana.resource;

import it.uliana.dto.Weather;
import it.uliana.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Francesco Uliana <francesco@uliana.it> on 21/05/16.
 */

@RestController
public class WeatherResource {

    private final static Logger logger = LoggerFactory.getLogger(WeatherResource.class);


    @Autowired
    private WeatherService weatherService;

    @RequestMapping("api/weather")
    public Weather get() {
        logger.info("Weather API access");
        return weatherService.getWeather();
    }
}
