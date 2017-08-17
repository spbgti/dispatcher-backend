package com.spbgti.dispatcherapp.web;

import com.spbgti.dispatcherapp.Entity.Faculty;
import com.spbgti.dispatcherapp.Service.impl.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Faculty> addFaculty(@RequestBody Faculty faculty){
        return new ResponseEntity<>(facultyService.add(faculty), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        facultyService.delete(id);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Faculty> getByName(@PathVariable String name) {
        return new ResponseEntity<>(facultyService.getByName(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Faculty> edit(@RequestBody Faculty faculty) {
        return new ResponseEntity<>(facultyService.edit(faculty), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Faculty>> getAll() {
        return new ResponseEntity<>(facultyService.getAll(), HttpStatus.OK);
    }

}
