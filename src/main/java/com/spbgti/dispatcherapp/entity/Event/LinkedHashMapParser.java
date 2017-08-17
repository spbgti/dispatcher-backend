package com.spbgti.dispatcherapp.entity.Event;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.InvocationTargetException;


public class LinkedHashMapParser {
    private final String CLASS_NAME = "com.spbgti.dispatcherapp.entity.";

    public Object parse(CreateCommand command) throws ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            NoSuchMethodException,
            InvocationTargetException {
        Class c = Class.forName(CLASS_NAME + firstCharToUpperCase(command.getType()));
        ObjectMapper mapper = new ObjectMapper();
        Object obj = mapper.convertValue(command.getEntity(), c);
        System.out.println(obj);
        return obj;
    }

    public String firstCharToUpperCase(String target) {
        return new String(Character.toUpperCase(target.charAt(0)) + target.substring(1));
    }
}
