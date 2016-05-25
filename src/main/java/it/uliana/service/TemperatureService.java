package it.uliana.service;

import com.pi4j.io.i2c.I2CBus;
import com.pi4j.io.i2c.I2CDevice;
import com.pi4j.io.i2c.I2CFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by francesco on 24/05/16.
 */

@Service
public class TemperatureService {

    private final static Logger logger = LoggerFactory.getLogger(TemperatureService.class);
    public static final int ADDRESS = 0x48;
    public static final int BUS_NUMBER = I2CBus.BUS_1;

    public Optional<Integer> getTemperature() {
        Optional<Integer> optionalTemperature;
        try {
            logger.info("reading value from {} {}", BUS_NUMBER, ADDRESS);
            I2CBus bus = I2CFactory.getInstance(BUS_NUMBER);
            I2CDevice device = bus.getDevice(ADDRESS);
            int value = device.read(0);
            logger.info("temperature = {}", value);
            optionalTemperature = Optional.of(value);
        } catch (IOException e) {
            logger.error("unable to get sensor data", e);
            optionalTemperature = Optional.empty();
        }
        return optionalTemperature;
    }


}
