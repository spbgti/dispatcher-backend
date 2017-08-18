package com.spbgti.dispatcherapp.web;

import com.spbgti.dispatcherapp.Entity.Event.CreateCommand;
import com.spbgti.dispatcherapp.Entity.Event.DeleteCommand;
import com.spbgti.dispatcherapp.Entity.Event.LinkedHashMapParser;
import com.spbgti.dispatcherapp.Entity.Event.UpdateCommand;
import com.spbgti.dispatcherapp.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping(value = "/event")
public class EventController {

    @Autowired
    EventService eventService;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createModifyEvent(@RequestBody CreateCommand[] commands) {
        return new ResponseEntity<>(eventService.addModifyEvent(commands), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateModifyEvent(@RequestBody UpdateCommand[] commands) {
        return new ResponseEntity<>(eventService.addModifyEvent(commands), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteModifyEvent(@RequestBody DeleteCommand[] commands) {
        return new ResponseEntity<>(eventService.addModifyEvent(commands), HttpStatus.OK);
    }

}
