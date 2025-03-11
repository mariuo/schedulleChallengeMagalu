package com.camel.scheduleNotification.controllers;

import com.camel.scheduleNotification.dtos.RequestScheduleDTO;
import com.camel.scheduleNotification.dtos.ResponseScheduleDTO;
import com.camel.scheduleNotification.entities.CommunicationSchedule;
import com.camel.scheduleNotification.services.CommunicationScheduleService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/schedule")
public class CommunicationScheduleController {

    private final CommunicationScheduleService service;

    public CommunicationScheduleController(CommunicationScheduleService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CommunicationSchedule> create(@Valid @RequestBody RequestScheduleDTO scheduleDto){
        return new ResponseEntity<CommunicationSchedule>(service.create(scheduleDto), HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseScheduleDTO> get(@Valid @PathVariable UUID id){
        ResponseScheduleDTO dto = service.getById(id);
        return ResponseEntity.ok().body(dto);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseScheduleDTO> cancel(@Valid @PathVariable UUID id){
        ResponseScheduleDTO dto = service.cancel(id);
        return ResponseEntity.ok().body(dto);
    }
}
