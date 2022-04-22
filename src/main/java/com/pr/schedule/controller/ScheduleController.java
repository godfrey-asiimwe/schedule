package com.pr.schedule.controller;

import java.util.List;

import com.pr.schedule.model.Schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import java.util.NoSuchElementException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    @Autowired
    private com.pr.schedule.service.scheduleService scheduleService;

    @GetMapping("")
    public List<Schedule> list() {
        return scheduleService.listAllSchedules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> get(@PathVariable Integer id) {
        try {
            Schedule schedule = scheduleService.getSchedule(id);
            return new ResponseEntity<Schedule>(schedule, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Schedule>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public void add(@RequestBody Schedule schedule) {
        scheduleService.saveSchedule(schedule);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody Schedule schedule, @PathVariable Integer id) {
        try {
            Schedule existSchedule = scheduleService.getSchedule(id);
            schedule.setId(id);
            scheduleService.saveSchedule(schedule);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        scheduleService.deleteSchedule(id);
    }

}