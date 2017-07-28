package com.spbgti.dispatcherapp.web;

import com.spbgti.dispatcherapp.entity.Chair;
import com.spbgti.dispatcherapp.service.impl.ChairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChairController {

    @Autowired
    ChairService service;

    @RequestMapping(value = "/chair/{name}", method = RequestMethod.POST)
    public ResponseEntity<Chair> addChair(@PathVariable String name){
        return new ResponseEntity<>(service.add(new Chair(name)), HttpStatus.OK);
    }

    @RequestMapping(value = "/chair/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @RequestMapping(value = "/chair/{name}", method = RequestMethod.GET)
    public ResponseEntity<Chair> getByName(@PathVariable String name) {
        return new ResponseEntity<>(service.getByName(name), HttpStatus.OK);
    }

    @RequestMapping(value = "/chair",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Chair> edit(@RequestBody Chair chair) {
        return new ResponseEntity<>(service.edit(chair), HttpStatus.OK);
    }

    @RequestMapping(value = "/chair", method = RequestMethod.GET)
    public ResponseEntity<List<Chair>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

}
