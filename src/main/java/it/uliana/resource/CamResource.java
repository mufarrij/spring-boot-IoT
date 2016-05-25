package it.uliana.resource;

import it.uliana.service.CamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.io.IOException;

/**
 * Created by Francesco Uliana <francesco@uliana.it> on 21/05/16.
 */

@RestController
public class CamResource {

    private final static Logger logger = LoggerFactory.getLogger(CamResource.class);

    @Autowired
    private CamService camService;

    @RequestMapping(value = "api/cam", method = RequestMethod.GET, produces = "image/jpeg")
    public @ResponseBody byte[] getFile()  {
        logger.info("Cam API access");
        try {
            return camService.snap();
        } catch (IOException e) {
            logger.error("unable to access webcam", e);
            throw new HttpClientErrorException(HttpStatus.EXPECTATION_FAILED, "error accessing webcam");
        }
    }

}
