package com.spbgti.dispatcherapp.Entity.Event;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;


public class ClassParser {
    private final static String CLASS_NAME = "com.spbgti.dispatcherapp.Entity.";
    private static final Logger logger = LogManager.getLogger(ClassParser.class);

    public Object parse(LinkedHashMap map, String type) throws ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            NoSuchMethodException,
            InvocationTargetException {
        Class c = Class.forName(CLASS_NAME + firstCharToUpperCase(type));
        ObjectMapper mapper = new ObjectMapper();
        Object obj = mapper.convertValue(map, c);
        if (logger.isDebugEnabled()) {
            logger.debug(obj.toString());
        }
        return obj;
    }

    public String firstCharToUpperCase(String target) {
        return Character.toUpperCase(target.charAt(0)) + target.substring(1);
    }

    public Class getClassFor(String type) throws ClassNotFoundException {
        return Class.forName(CLASS_NAME + firstCharToUpperCase(type));
    }

    public Object getField(LinkedHashMap map, String type, String fieldName) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object object = parse(map, type);
        return object.getClass().getMethod("get" + firstCharToUpperCase(fieldName)).invoke(object);
    }
}
