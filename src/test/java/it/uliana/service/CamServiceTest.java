package it.uliana.service;

import it.uliana.Uniroma3IotApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Francesco Uliana <francesco@uliana.it> on 21/05/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Uniroma3IotApplication.class)
@WebAppConfiguration
public class CamServiceTest {

    private final static Logger logger = LoggerFactory.getLogger(CamServiceTest.class);

    @Autowired
    private CamService camService;

    @Test
    public void testSnap() throws Exception {
        byte[] b = camService.snap();

        logger.info("image of {} bytes", b.length);


    }
}