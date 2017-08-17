package com.spbgti.dispatcherapp.web;

import com.spbgti.dispatcherapp.Entity.Chair;
import com.spbgti.dispatcherapp.Service.impl.ChairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/chair")
public class ChairController {

    @Autowired
    private ChairService chairService;

    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Chair> addChair(@RequestBody Chair chair){
        return new ResponseEntity<>(chairService.add(chair), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        chairService.delete(id);
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public ResponseEntity<Chair> getByName(@PathVariable String name) {
        return new ResponseEntity<>(chairService.getByName(name), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Chair> edit(@RequestBody Chair chair) {
        return new ResponseEntity<>(chairService.edit(chair), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Chair>> getAll() {
        return new ResponseEntity<>(chairService.getAll(), HttpStatus.OK);
    }

}
