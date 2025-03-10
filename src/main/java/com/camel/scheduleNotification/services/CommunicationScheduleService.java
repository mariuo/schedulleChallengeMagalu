package com.camel.scheduleNotification.services;

import com.camel.scheduleNotification.dtos.RequestScheduleDTO;
import com.camel.scheduleNotification.entities.CommunicationSchedule;
import com.camel.scheduleNotification.entities.ScheduleStatus;
import com.camel.scheduleNotification.repositories.CommunicationScheduleRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;


@Service
public class CommunicationScheduleService {
    private final CommunicationScheduleRepository communicationScheduleRepository;

    public CommunicationScheduleService(CommunicationScheduleRepository communicationScheduleRepository){
        this.communicationScheduleRepository = communicationScheduleRepository;
    }

    public CommunicationSchedule create(RequestScheduleDTO dto){
        CommunicationSchedule entity = toEntity(dto);
        entity.setStatus(ScheduleStatus.SCHEDULED);
        return communicationScheduleRepository.save(entity);
    }

    public CommunicationSchedule toEntity(RequestScheduleDTO dto){
        CommunicationSchedule entity = new CommunicationSchedule();
        entity.setRecipient(dto.recipient());
        entity.setMessage(dto.message());
        entity.setDate(dto.date());
        entity.setType(dto.type());
        entity.setCreadtedAt(LocalDateTime.now());;
        return entity;
    }
    public RequestScheduleDTO toDto(CommunicationSchedule entity){
        return new RequestScheduleDTO(
                entity.getDate(),
                entity.getMessage(),
                entity.getRecipient(),
                entity.getType()
        );
    }


}
