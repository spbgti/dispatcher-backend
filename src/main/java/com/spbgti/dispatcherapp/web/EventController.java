package com.spbgti.dispatcherapp.web;

import com.spbgti.dispatcherapp.Entity.Event.CreateCommand;
import com.spbgti.dispatcherapp.Entity.Event.DeleteCommand;
import com.spbgti.dispatcherapp.Entity.Event.Query;
import com.spbgti.dispatcherapp.Entity.Event.UpdateCommand;
import com.spbgti.dispatcherapp.Service.EventService;
import org.hibernate.hql.internal.ast.QuerySyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;

@RestController
@RequestMapping(value = "/event")
public class EventController {

    @Autowired
    EventService eventService;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createModifyEvent(@RequestBody CreateCommand[] commands) {
        try {
            return new ResponseEntity<>(eventService.addModifyEvent(commands), HttpStatus.OK);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException | QuerySyntaxException e) {
            e.printStackTrace();
            eventService.addFailedModifyEvent(commands);
            return new ResponseEntity<>(e.getCause() + " " + e.getMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateModifyEvent(@RequestBody UpdateCommand[] commands) {
        try {
            return new ResponseEntity<>(eventService.addModifyEvent(commands), HttpStatus.OK);
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException | QuerySyntaxException e) {
            e.printStackTrace();
            eventService.addFailedModifyEvent(commands);
            return new ResponseEntity<>(e.getCause() + " " + e.getMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteModifyEvent(@RequestBody DeleteCommand[] commands) {
        try {
            return new ResponseEntity<>(eventService.addModifyEvent(commands), HttpStatus.OK);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException | QuerySyntaxException e) {
            e.printStackTrace();
            eventService.addFailedModifyEvent(commands);
            return new ResponseEntity<>(e.getCause() + " " + e.getMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.PATCH,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addReadEvent(@RequestBody Query[] queries) {
        try {
            return new ResponseEntity<>(eventService.addReadEvent(queries), HttpStatus.OK);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException | QuerySyntaxException e) {
            e.printStackTrace();
            eventService.addFailedReadEvent(queries);
            return new ResponseEntity<>(e.getCause() + " " + e.getMessage(), HttpStatus.OK);
        }
    }


}
