package it.uliana.resource;

import it.uliana.dto.Temperature;
import it.uliana.service.TemperatureService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Created by Francesco Uliana <francesco@uliana.it> on 21/05/16.
 */

@RestController
public class TemperatureResource {

    private final static Logger logger = LoggerFactory.getLogger(TemperatureResource.class);
    public static final String STATUS_TEXT = "unable to get device data";

    @Autowired
    private TemperatureService temperatureService;

    @RequestMapping("api/temperature")
    public Temperature get() {
        logger.info("Temperature API access");
        return temperatureService
                .getTemperature()
                .map(value -> new Temperature(value))
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NO_CONTENT, STATUS_TEXT));
    }

}
