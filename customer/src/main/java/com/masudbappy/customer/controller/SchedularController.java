package com.masudbappy.customer.controller;

import com.masudbappy.customer.model.Schedule;
import com.masudbappy.customer.service.ScheduleService;
import com.masudbappy.customer.service.ScheduleServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schedular/v1")
public class SchedularController {

    private ScheduleService scheduleService;

    @Autowired
    public SchedularController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/save")
    public ResponseEntity<Schedule> saveSchedule(@RequestBody Schedule schedule){
        return ResponseEntity.ok(scheduleService.saveScheduleData(schedule));
    }

}
