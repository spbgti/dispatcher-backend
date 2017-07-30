package com.spbgti.dispatcherapp.web;

import com.spbgti.dispatcherapp.entity.Senior;
import com.spbgti.dispatcherapp.service.impl.SeniorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Gilbord on 29.07.2017.
 */
public class SeniorController {
    @Autowired
    SeniorService service;

    @RequestMapping(value = "/senior",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Senior> addSenior(@RequestBody Senior senior){
        return new ResponseEntity<>(service.add(senior), HttpStatus.OK);
    }

    @RequestMapping(value = "/senior/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @RequestMapping(value = "/senior/{number}", method = RequestMethod.GET)
    public ResponseEntity<Senior> getByNumber(@PathVariable String num) {
        return new ResponseEntity<>(service.getByName(num), HttpStatus.OK);
    }

    @RequestMapping(value = "/senior",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Senior> edit(@RequestBody Senior senior) {
        return new ResponseEntity<>(service.edit(senior), HttpStatus.OK);
    }

    @RequestMapping(value = "/senior", method = RequestMethod.GET)
    public ResponseEntity<List<Senior>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}
