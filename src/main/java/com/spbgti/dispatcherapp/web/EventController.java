package com.spbgti.dispatcherapp.web;

import com.spbgti.dispatcherapp.entity.Event.CreateCommand;
import com.spbgti.dispatcherapp.entity.Event.LinkedHashMapParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

@RestController
@RequestMapping(value = "/event")
public class EventController{

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addEvent(@RequestBody CreateCommand command){
        try {
            new LinkedHashMapParser().parse(command);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Class not found", HttpStatus.OK);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Something came wrong" + e.getLocalizedMessage(), HttpStatus.OK);
        }
        return new ResponseEntity(command.getEntity(), HttpStatus.OK);
    }

}
