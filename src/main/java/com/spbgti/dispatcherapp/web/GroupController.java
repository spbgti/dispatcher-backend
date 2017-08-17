package com.spbgti.dispatcherapp.web;

import com.spbgti.dispatcherapp.Entity.Group;
import com.spbgti.dispatcherapp.Service.impl.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Gilbord on 29.07.2017.
 */
@RestController
@RequestMapping(value = "/group")
public class GroupController {
    @Autowired
    private GroupService groupService;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> addGroup(@RequestBody Group group){
        return new ResponseEntity<>(groupService.add(group), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        groupService.delete(id);
    }

    @RequestMapping(value = "/{number}", method = RequestMethod.GET)
    public ResponseEntity<Group> getByNumber(@PathVariable String num) {
        return new ResponseEntity<>(groupService.getByName(num), HttpStatus.OK);
    }

    @RequestMapping( method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Group> edit(@RequestBody Group group) {
        return new ResponseEntity<>(groupService.edit(group), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Group>> getAll() {
        return new ResponseEntity<>(groupService.getAll(), HttpStatus.OK);
    }
}
