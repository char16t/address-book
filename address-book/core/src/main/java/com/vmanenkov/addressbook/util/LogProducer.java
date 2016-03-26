package com.vmanenkov.addressbook.util;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.lang.reflect.Member;
import java.util.logging.Logger;

/**
 * This class uses CDI to alias Logger resource to CDI beans
 */
public class LogProducer {

    @Produces
    public LoggerAB produceLogger(InjectionPoint injectionPoint) {
        Member member = injectionPoint.getMember();
        Class<?> declaringClass = member.getDeclaringClass();
        String name = declaringClass.getName();
        return new LoggerAB(Logger.getLogger(name));
    }
}
