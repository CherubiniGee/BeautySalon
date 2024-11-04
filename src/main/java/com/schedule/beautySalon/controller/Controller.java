package com.schedule.beautySalon.controller;

import com.schedule.beautySalon.model.Schedule;
import com.schedule.beautySalon.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/schedule")
public class Controller {
    @Autowired
    private Service service;

    @PostMapping
    public ResponseEntity<Schedule> post(@RequestBody Schedule schedule) {
        Schedule response = service.post(schedule);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Schedule>> get() {
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("/date/{scheduledDate}")
    public ResponseEntity<List<Schedule>> getByDate(@PathVariable LocalDate scheduledDate) {
        List<Schedule> response = service.getByDate(scheduledDate);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Schedule> getById(@PathVariable Long id) {
        Optional<Schedule> response = service.getById(id);
        return ResponseEntity.ok(response.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> update(@PathVariable Long id, @RequestBody Schedule updatedSchedule) {
        Schedule response = service.update(id, updatedSchedule);
        return ResponseEntity.ok(response);
    }
}
