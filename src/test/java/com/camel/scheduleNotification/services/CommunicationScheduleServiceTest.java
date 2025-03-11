package com.camel.scheduleNotification.services;

import com.camel.scheduleNotification.dtos.RequestScheduleDTO;
import com.camel.scheduleNotification.dtos.ResponseScheduleDTO;
import com.camel.scheduleNotification.entities.CommunicationSchedule;
import com.camel.scheduleNotification.entities.ScheduleStatus;
import com.camel.scheduleNotification.entities.ScheduleType;
import com.camel.scheduleNotification.exceptions.ResourceNotFoundException;
import com.camel.scheduleNotification.repositories.CommunicationScheduleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;

public class CommunicationScheduleServiceTest {
    @Mock
    private CommunicationScheduleRepository repository;

    @InjectMocks
    private CommunicationScheduleService service;

    private UUID testId;
    private RequestScheduleDTO request;
    private CommunicationSchedule entity;
    private ResponseScheduleDTO response;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        testId = UUID.randomUUID();
        request = new RequestScheduleDTO(
                LocalDateTime.now().plusHours(1),
                "test@example.com",
                "Hello, this is a test message!",
                ScheduleType.EMAIL
        );

        entity = new CommunicationSchedule();
        entity.setId(testId);
        entity.setDate(request.date());
        entity.setRecipient(request.recipient());
        entity.setMessage(request.message());
        entity.setType(request.type());
        entity.setStatus(ScheduleStatus.SCHEDULED);

        response = new ResponseScheduleDTO(
                request.date(),
                request.message(),
                request.recipient(),
                ScheduleStatus.SCHEDULED
        );

    }

    @Test
    void createShouldReturnCommunicationSchedule() {
        when(repository.save(any(CommunicationSchedule.class))).thenReturn(entity);

        CommunicationSchedule result = service.create(request);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(testId, result.getId());
        Assertions.assertEquals(ScheduleStatus.SCHEDULED, result.getStatus());
        verify(repository, times(1)).save(any(CommunicationSchedule.class));
    }
    @Test
    void getByIdShouldReturnResponseScheduleDTO() {
        when(repository.findById(testId)).thenReturn(Optional.of(entity));

        ResponseScheduleDTO result = service.getById(testId);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(response.date(), result.date());
        Assertions.assertEquals(response.message(), result.message());
        Assertions.assertEquals(response.recipient(), result.recipient());
        Assertions.assertEquals(response.status(), result.status());
        verify(repository, times(1)).findById(testId);
    }

    @Test
    void getByIdShouldThrowResourceNotFoundException() {
        when(repository.findById(testId)).thenReturn(Optional.empty());

        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            service.getById(testId);
        });

        verify(repository, times(1)).findById(testId);
    }
}
