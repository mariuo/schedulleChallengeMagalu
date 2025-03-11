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

/**
 * REST controller for managing communication schedules.
 */
@RestController
@RequestMapping("/schedule")
public class CommunicationScheduleController {

    private final CommunicationScheduleService service;

    public CommunicationScheduleController(CommunicationScheduleService service){
        this.service = service;
    }

    /**
     * Creates a new communication schedule.
     *
     * @param scheduleDto the DTO containing schedule details
     * @return the created CommunicationSchedule
     */
    @PostMapping
    public ResponseEntity<CommunicationSchedule> create(@Valid @RequestBody RequestScheduleDTO scheduleDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(scheduleDto));
    }

    /**
     * Retrieves a communication schedule by its ID.
     *
     * @param id the UUID of the schedule
     * @return the ResponseScheduleDTO containing schedule details
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseScheduleDTO> get(@PathVariable UUID id){
        ResponseScheduleDTO dto = service.getById(id);
        return ResponseEntity.ok().body(dto);
    }
    /**
     * Cancels a communication schedule by its ID.
     *
     * @param id the UUID of the schedule
     * @return the ResponseScheduleDTO containing updated schedule details
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ResponseScheduleDTO> cancel(@PathVariable UUID id){
        ResponseScheduleDTO dto = service.cancel(id);
        return ResponseEntity.ok().body(dto);
    }
}
