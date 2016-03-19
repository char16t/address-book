package com.vmanenkov.services.util;

import com.vmanenkov.profile.Profiled;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigureServices {

    private static final String SERVICES_PROP_FILE = "address-book-services.properties";

    @Produces
    @Profiled
    public ServicesConf produceConfigurationServices(InjectionPoint injectionPoint) {
        Properties prop = new Properties();
        try {
            InputStream tmp = ConfigureServices.class.getClassLoader().getResourceAsStream(SERVICES_PROP_FILE);
            prop.load(tmp);

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        boolean testEnabled = "true".equals(prop.getProperty("test.enabled"));

        ServicesConf conf = new ServicesConf(testEnabled);
        return conf;
    }

}
