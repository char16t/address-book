package com.vmanenkov.services.util;

public class ServicesConf {

    private final boolean testEnabled;

    public ServicesConf(boolean testEnabled) {
        this.testEnabled = testEnabled;
    }

    public boolean isTestEnabled() {
        return testEnabled;
    }

}
