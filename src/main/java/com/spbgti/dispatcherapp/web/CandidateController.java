package com.spbgti.dispatcherapp.web;

import com.spbgti.dispatcherapp.entity.Candidate;
import com.spbgti.dispatcherapp.service.impl.CandidateService;
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
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @RequestMapping(value = "/candidate",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Candidate> addSenior(@RequestBody Candidate candidate){
        return new ResponseEntity<>(candidateService.add(candidate), HttpStatus.OK);
    }

    @RequestMapping(value = "/candidate/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable long id) {
        candidateService.delete(id);
    }

    @RequestMapping(value = "/candidate/{number}", method = RequestMethod.GET)
    public ResponseEntity<Candidate> getByNumber(@PathVariable String num) {
        return new ResponseEntity<>(candidateService.getByName(num), HttpStatus.OK);
    }

    @RequestMapping(value = "/candidate",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Candidate> edit(@RequestBody Candidate candidate) {
        return new ResponseEntity<>(candidateService.edit(candidate), HttpStatus.OK);
    }

    @RequestMapping(value = "/candidate", method = RequestMethod.GET)
    public ResponseEntity<List<Candidate>> getAll() {
        return new ResponseEntity<>(candidateService.getAll(), HttpStatus.OK);
    }
}
