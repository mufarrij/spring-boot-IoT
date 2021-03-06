package it.uliana.service;

import it.uliana.dto.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by Francesco Uliana <francesco@uliana.it> on 21/05/16.
 */

@Service
public class WeatherService {

    private final static Logger logger = LoggerFactory.getLogger(WeatherService.class);

    private final static String url = "http://api.openweathermap.org/data/2.5/weather?id={id}&appid={appid}";

    @Autowired
    private RestTemplate restTemplate;

    public Optional<Weather> getWeather() {

        Map<String, String> map = new HashMap();

        map.put("id", "3169071");
        map.put("appid", "XYZ");

        try {
            ResponseEntity<Weather> w = restTemplate
                    .getForEntity(url, Weather.class, map);
            logger.info(w.hasBody() ? w.getBody().toString() : "no content");

            return Optional.of(w.getBody());
        } catch (RestClientException e) {
            logger.error("unable to get weather data", e);
            return Optional.empty();
        }


    }

}
