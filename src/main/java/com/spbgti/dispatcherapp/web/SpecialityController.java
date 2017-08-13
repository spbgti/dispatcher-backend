package com.spbgti.dispatcherapp.web;

import com.spbgti.dispatcherapp.entity.Speciality;
import com.spbgti.dispatcherapp.service.impl.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/speciality")
public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Speciality> addSpeciality(@RequestBody Speciality speciality){
        return new ResponseEntity<>(specialityService.add(speciality), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        specialityService.delete(id);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Speciality> getByName(@PathVariable String name) {
        return new ResponseEntity<>(specialityService.getByName(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Speciality> edit(@RequestBody Speciality speciality) {
        return new ResponseEntity<>(specialityService.edit(speciality), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Speciality>> getAll() {
        return new ResponseEntity<>(specialityService.getAll(), HttpStatus.OK);
    }
}
