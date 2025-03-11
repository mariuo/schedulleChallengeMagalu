package com.camel.scheduleNotification.controllers;

import com.camel.scheduleNotification.dtos.RequestScheduleDTO;
import com.camel.scheduleNotification.dtos.ResponseScheduleDTO;
import com.camel.scheduleNotification.entities.CommunicationSchedule;
import com.camel.scheduleNotification.entities.ScheduleStatus;
import com.camel.scheduleNotification.entities.ScheduleType;
import com.camel.scheduleNotification.services.CommunicationScheduleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class CommunicationScheduleControllerTest {

    @Mock
    private CommunicationScheduleService service;

    @InjectMocks
    private CommunicationScheduleController controller;

    private RequestScheduleDTO requestScheduleDTO;
    private ResponseScheduleDTO responseScheduleDTO;
    private CommunicationSchedule communicationSchedule;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        requestScheduleDTO = new RequestScheduleDTO(
                LocalDateTime.now(),
                "Test Message",
                "test@example.com",
                ScheduleType.EMAIL
        );

        responseScheduleDTO = new ResponseScheduleDTO(
                LocalDateTime.now(),
                "Test Message",
                "test@example.com",
                ScheduleStatus.SCHEDULED
        );

        communicationSchedule = new CommunicationSchedule();
        communicationSchedule.setId(UUID.randomUUID());
        communicationSchedule.setDate(LocalDateTime.now());
        communicationSchedule.setMessage("Test Message");
        communicationSchedule.setRecipient("test@example.com");
        communicationSchedule.setType(ScheduleType.EMAIL);
        communicationSchedule.setStatus(ScheduleStatus.SCHEDULED);
        communicationSchedule.setCreadtedAt(LocalDateTime.now());
    }

    @Test
    void testCreate() {
        when(service.create(any(RequestScheduleDTO.class))).thenReturn(communicationSchedule);

        ResponseEntity<CommunicationSchedule> response = controller.create(requestScheduleDTO);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(communicationSchedule, response.getBody());
    }

    @Test
    void testGet() {
        UUID id = UUID.randomUUID();
        when(service.getById(id)).thenReturn(responseScheduleDTO);

        ResponseEntity<ResponseScheduleDTO> response = controller.get(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseScheduleDTO, response.getBody());
    }

    @Test
    void testCancel() {
        UUID id = UUID.randomUUID();
        when(service.cancel(id)).thenReturn(responseScheduleDTO);

        ResponseEntity<ResponseScheduleDTO> response = controller.cancel(id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(responseScheduleDTO, response.getBody());
    }
}