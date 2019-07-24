package com.gym.controller;

import com.gym.dto.ScheduleDto;
import com.gym.entity.Schedule;
import com.gym.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @GetMapping(value = "/")
    ResponseEntity<List<Schedule>> findAll(){
        return new ResponseEntity<>(scheduleService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/id/{id}")
    ResponseEntity<Schedule> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(scheduleService.findById(id), HttpStatus.OK);
    }

    @GetMapping(value = "/room_id/{room_id}")
    ResponseEntity<List<Schedule>> findByRoomId(@PathVariable("room_id")Integer id){
        return new ResponseEntity<>(scheduleService.findByRoomId(id), HttpStatus.OK);
    }

    @GetMapping(value = "/office_id/{office_id}")
    ResponseEntity<List<Schedule>> findByOfficeId(@PathVariable("office_id") Integer id){
        return new ResponseEntity<>(scheduleService.findByOfficeId(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    ResponseEntity<Void> save(@Validated @RequestBody ScheduleDto scheduleDto){
        scheduleService.save(scheduleDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    ResponseEntity<Schedule> deleteById(@RequestParam("id") Integer id){
        scheduleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
