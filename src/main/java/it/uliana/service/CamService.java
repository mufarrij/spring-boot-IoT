package it.uliana.service;

import com.github.sarxos.webcam.Webcam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

/**
 * Created by Francesco Uliana <francesco@uliana.it> on 21/05/16.
 */
@Service
public class CamService {

    private final static Logger logger = LoggerFactory.getLogger(CamService.class);
    public static final String FORMAT_NAME = "jpg";

    public byte[] snap() throws IOException {
        logger.debug("opening webcam");
        Webcam webcam = Optional
                .ofNullable(Webcam.getDefault())
                .orElseThrow(() -> new IOException("webcam is not present"));

        logger.info("using webcam {} - {}", webcam.getName(), webcam.getDevice().getName());
        webcam.open();
        BufferedImage img = webcam.getImage();
        webcam.close();

        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ImageIO.write(img, FORMAT_NAME, bao);
        byte[] bytes = bao.toByteArray();
        logger.info("created image {} of size {}", FORMAT_NAME, bytes.length);
        return bytes;
    }
}
