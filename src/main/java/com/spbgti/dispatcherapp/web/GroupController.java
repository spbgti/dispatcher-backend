package com.spbgti.dispatcherapp.web;

import com.spbgti.dispatcherapp.entity.Group;
import com.spbgti.dispatcherapp.service.impl.GroupService;
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
public class GroupController {
    @Autowired
    GroupService service;

    @RequestMapping(value = "/group",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> addGroup(@RequestBody Group group){
        return new ResponseEntity<>(service.add(group), HttpStatus.OK);
    }

    @RequestMapping(value = "/group/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        service.delete(id);
    }

    @RequestMapping(value = "/group/{number}", method = RequestMethod.GET)
    public ResponseEntity<Group> getByNumber(@PathVariable String num) {
        return new ResponseEntity<>(service.getByName(num), HttpStatus.OK);
    }

    @RequestMapping(value = "/group",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> edit(@RequestBody Group group) {
        return new ResponseEntity<>(service.edit(group), HttpStatus.OK);
    }

    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public ResponseEntity<List<Group>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
}
