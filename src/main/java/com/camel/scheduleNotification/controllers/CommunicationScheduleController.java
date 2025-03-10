package com.camel.scheduleNotification.controllers;

import com.camel.scheduleNotification.dtos.RequestScheduleDTO;
import com.camel.scheduleNotification.entities.CommunicationSchedule;
import com.camel.scheduleNotification.services.CommunicationScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/schedule")
public class CommunicationScheduleController {

    private final CommunicationScheduleService service;

    public CommunicationScheduleController(CommunicationScheduleService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CommunicationSchedule> create(@RequestBody RequestScheduleDTO scheduleDto){
        return new ResponseEntity<CommunicationSchedule>(service.create(scheduleDto), HttpStatus.CREATED);
    }
}
