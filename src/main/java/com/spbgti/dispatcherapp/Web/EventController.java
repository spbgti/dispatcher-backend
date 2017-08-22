package com.spbgti.dispatcherapp.Web;

import com.spbgti.dispatcherapp.Entity.Event.Command.CreateCommand;
import com.spbgti.dispatcherapp.Entity.Event.Command.DeleteCommand;
import com.spbgti.dispatcherapp.Entity.Event.Command.Query;
import com.spbgti.dispatcherapp.Entity.Event.Command.UpdateCommand;
import com.spbgti.dispatcherapp.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @RequestMapping(value = "/create",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createModifyEvent(@RequestBody CreateCommand[] commands) {
        try {
            return new ResponseEntity<>(eventService.addModifyEvent(commands), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            eventService.addFailedModifyEvent(commands, e);
            return new ResponseEntity<>(e.getCause() + " " + e.getMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateModifyEvent(@RequestBody UpdateCommand[] commands) {
        try {
            return new ResponseEntity<>(eventService.addModifyEvent(commands), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            eventService.addFailedModifyEvent(commands, e);
            return new ResponseEntity<>(e.getCause() + " " + e.getMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/delete",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteModifyEvent(@RequestBody DeleteCommand[] commands) {
        try {
            return new ResponseEntity<>(eventService.addModifyEvent(commands), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            eventService.addFailedModifyEvent(commands, e);
            return new ResponseEntity<>(e.getCause() + " " + e.getMessage(), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/query",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addReadEvent(@RequestBody Query[] queries) {
        try {
            return new ResponseEntity<>(eventService.addReadEvent(queries), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            eventService.addFailedReadEvent(queries, e);
            return new ResponseEntity<>(e.getCause() + " " + e.getMessage(), HttpStatus.OK);
        }
    }


}
