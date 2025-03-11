package com.camel.scheduleNotification.services;

import com.camel.scheduleNotification.dtos.RequestScheduleDTO;
import com.camel.scheduleNotification.dtos.ResponseScheduleDTO;
import com.camel.scheduleNotification.entities.CommunicationSchedule;
import com.camel.scheduleNotification.entities.ScheduleStatus;
import com.camel.scheduleNotification.exceptions.ResourceNotFoundException;
import com.camel.scheduleNotification.repositories.CommunicationScheduleRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

/**
 * Service class for managing communication schedules.
 */
@Service
public class CommunicationScheduleService {
    private final CommunicationScheduleRepository communicationScheduleRepository;

    public CommunicationScheduleService(CommunicationScheduleRepository communicationScheduleRepository){
        this.communicationScheduleRepository = communicationScheduleRepository;
    }

    /**
     * Creates a new communication schedule.
     *
     * @param dto the DTO containing schedule details
     * @return the created CommunicationSchedule
     */
    public CommunicationSchedule create(@Valid RequestScheduleDTO dto){
        CommunicationSchedule entity = toEntity(dto);
        entity.setStatus(ScheduleStatus.SCHEDULED);
        return communicationScheduleRepository.save(entity);
    }

    /**
     * Converts a RequestScheduleDTO to a CommunicationSchedule entity.
     *
     * @param dto the DTO containing schedule details
     * @return the CommunicationSchedule entity
     */
    public CommunicationSchedule toEntity(RequestScheduleDTO dto){
        CommunicationSchedule entity = new CommunicationSchedule();
        entity.setRecipient(dto.recipient());
        entity.setMessage(dto.message());
        entity.setDate(dto.date());
        entity.setType(dto.type());
        entity.setCreadtedAt(LocalDateTime.now());
        return entity;
    }

    /**
     * Converts a CommunicationSchedule entity to a RequestScheduleDTO.
     *
     * @param entity the CommunicationSchedule entity
     * @return the RequestScheduleDTO
     */
    public RequestScheduleDTO toDtoRequest(CommunicationSchedule entity){
        return new RequestScheduleDTO(
                entity.getDate(),
                entity.getMessage(),
                entity.getRecipient(),
                entity.getType()
        );
    }

    /**
     * Converts a CommunicationSchedule entity to a ResponseScheduleDTO.
     *
     * @param entity the CommunicationSchedule entity
     * @return the ResponseScheduleDTO
     */
    public ResponseScheduleDTO toDtoResponse(CommunicationSchedule entity){
        return new ResponseScheduleDTO(
                entity.getDate(),
                entity.getMessage(),
                entity.getRecipient(),
                entity.getStatus()
        );
    }

    /**
     * Retrieves a communication schedule by its ID.
     *
     * @param id the UUID of the schedule
     * @return the ResponseScheduleDTO containing schedule details
     * @throws ResourceNotFoundException if the schedule is not found
     */
    public ResponseScheduleDTO getById(@Valid UUID id){
        Optional<CommunicationSchedule> obj = communicationScheduleRepository.findById(id);
        CommunicationSchedule entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return toDtoResponse(entity);
    }

    /**
     * Cancels a communication schedule by its ID.
     *
     * @param id the UUID of the schedule
     * @return the ResponseScheduleDTO containing updated schedule details
     * @throws ResourceNotFoundException if the schedule is not found
     */
    public ResponseScheduleDTO cancel(@Valid UUID id) {
        Optional<CommunicationSchedule> obj = communicationScheduleRepository.findById(id);
        CommunicationSchedule entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        entity.setStatus(ScheduleStatus.CANCELED);
        entity = communicationScheduleRepository.save(entity);
        return toDtoResponse(entity);
    }
}