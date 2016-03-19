package com.vmanenkov.addressbook.util;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.logging.Level;

@SuppressWarnings("serial")
public class LoggerCommons implements Serializable {

    private java.util.logging.Logger logger;

    public LoggerCommons(java.util.logging.Logger logger) {

        this.logger = logger;
    }

    public static LoggerCommons getAnonymousLogger() {
        return new LoggerCommons(java.util.logging.Logger.getAnonymousLogger());
    }

    public static LoggerCommons getLogger(String name) {
        return new LoggerCommons(java.util.logging.Logger.getLogger(name));
    }

    public void info(String messageFormat, Object... object) {

        logger.log(Level.INFO, messageFormat, object);
    }

    public void config(String messageFormat, Object... object) {

        logger.log(Level.CONFIG, messageFormat, object);
    }

    public void fine(String messageFormat, Object... object) {

        logger.log(Level.FINE, messageFormat, object);
    }

    public void severe(String messageFormat, Object... object) {

        logger.log(Level.SEVERE, messageFormat, object);
    }

    public void exception(Exception e) {

        if (logger.isLoggable(Level.FINEST)) {
            logger.log(Level.SEVERE, e.getMessage(), e);
        } else {
            logger.log(Level.SEVERE, "{0}:{1}", new Object[] { e.getClass().getName(), e.getMessage() });
        }

    }

    public void exception(Exception e, String messageFormat, Object... object) {

        if (logger.isLoggable(Level.FINEST)) {
            logger.log(Level.SEVERE, MessageFormat.format(messageFormat, object), e);
        } else {
            logger.log(Level.SEVERE, messageFormat, object);
        }
    }

}
