package com.vmanenkov.addressbook.util;

import java.util.logging.Logger;

@SuppressWarnings("serial")
public class LoggerAB extends LoggerCommons {

    public LoggerAB(Logger logger) {
        super(logger);
    }

    public static LoggerAB getAnonymousLogger() {
        return new LoggerAB(java.util.logging.Logger.getAnonymousLogger());
    }
}
