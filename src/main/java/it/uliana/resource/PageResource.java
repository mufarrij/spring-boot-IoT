package it.uliana.resource;

import it.uliana.service.TemperatureService;
import it.uliana.service.WeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by francesco on 24/05/16.
 */

@RestController
public class PageResource {

    private final static Logger logger = LoggerFactory.getLogger(PageResource.class);

    private static final String html = "<!DOCTYPE html>" +
            "<html>" +
            "<head>" +
            "<meta charset=\"utf-8\">" +
            "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">" +
            "<title>IoT demo</title>" +
            "<link rel=\"stylesheet\" href=\"\">" +
            "</head>" +
            "<body>" +
            "<p>" +
            "<b>Temperatura:</b> %s" +
            "</p>" +
            "<p>" +
            "<b>Meteo:</b> %s" +
            "</p>" +
            "<img src=\"/api/cam\" alt=\"Webcam\" />" +
            "</body>" +
            "</html>";

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private TemperatureService temperatureService;

    @RequestMapping(name = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home () {
        logger.info("Home Access");
        String temperature = temperatureService.getTemperature().map(String::valueOf).orElse("non disponibile");
        String description = weatherService.getWeather().getWeather().get(0).getDescription();
        return String.format(html, temperature, description);
    }


}
