package com.spbgti.dispatcherapp.web;

import com.spbgti.dispatcherapp.entity.Faculty;
import com.spbgti.dispatcherapp.service.impl.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @RequestMapping(value = "/faculty", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty){
        return new ResponseEntity<>(facultyService.add(faculty), HttpStatus.OK);
    }

    @RequestMapping(value = "/faculty/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        facultyService.delete(id);
    }

    @RequestMapping(value = "/faculty/{name}", method = RequestMethod.GET)
    public ResponseEntity<Faculty> getByName(@PathVariable String name) {
        return new ResponseEntity<>(facultyService.getByName(name), HttpStatus.OK);
    }

    @RequestMapping(value = "/faculty",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Faculty> edit(@RequestBody Faculty faculty) {
        return new ResponseEntity<>(facultyService.edit(faculty), HttpStatus.OK);
    }

    @RequestMapping(value = "/faculty", method = RequestMethod.GET)
    public ResponseEntity<List<Faculty>> getAll() {
        return new ResponseEntity<>(facultyService.getAll(), HttpStatus.OK);
    }

}
