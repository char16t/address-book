package com.vmanenkov.services.util;

import com.vmanenkov.profile.Profiled;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.Properties;

public class ConfigureServices {

    private static final String SERVICES_PROP_FILE = "address-book-services.properties";

    @Produces
    @Profiled
    public ServicesConf produceConfigurationServices(InjectionPoint injectionPoint) {
        Properties prop = new Properties();

        // TODO: not found .properties file
//        try {
//            InputStream tmp = ConfigureServices.class.getClassLoader().getResourceAsStream(SERVICES_PROP_FILE);
//            prop.load(tmp);
//
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        boolean testEnabled = "true".equals(prop.getProperty("test.enabled"));

        boolean testEnabled = true;

        ServicesConf conf = new ServicesConf(testEnabled);
        return conf;
    }

}
