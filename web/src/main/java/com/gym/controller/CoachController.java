package com.gym.controller;

import com.gym.dto.CoachDto;
import com.gym.entity.Coach;
import com.gym.service.CoahService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coachs")
public class CoachController {

    private final CoahService coahService;

    @Autowired
    public CoachController(CoahService coahService) {
        this.coahService = coahService;
    }

   @GetMapping(value = "/")
   ResponseEntity<List<Coach>> findAll(){
        return new ResponseEntity<>(coahService.findAll(), HttpStatus.OK);
   }

    @GetMapping(value = "/name/{name}")
    ResponseEntity<List<Coach>> findByName(@PathVariable("name") String name){
        return new ResponseEntity<>(coahService.findByName(name), HttpStatus.OK);
    }

    @GetMapping(value = "/id/{id}")
    ResponseEntity<Coach> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(coahService.findById(id), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Void> deleteById(@PathVariable("id") Integer id){
        coahService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Void> save(@Validated @RequestBody CoachDto coachDto){
        coahService.save(coachDto);
        return new ResponseEntity<>( HttpStatus.CREATED);
    }
}
