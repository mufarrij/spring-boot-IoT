package it.uliana.service;

import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Francesco Uliana <francesco@uliana.it> on 21/05/16.
 */
@Service
public class CamService {

    private final static Logger logger = LoggerFactory.getLogger(CamService.class);
    public static final String FORMAT_NAME = "jpg";
    private static final String file = "web-cam-shot.jpg";

    public byte[] snap() throws IOException {

        Runtime rt = Runtime.getRuntime();
        Process pr = rt.exec("fswebcam -r 640x480 --jpeg 85 -D 1 " + file);
        InputStream is = pr.getInputStream();
        String s = IOUtils.toString(is);
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        IOUtils.copy(fis, bos);
        return bos.toByteArray();

    }
}
