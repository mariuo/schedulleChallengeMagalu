package com.camel.scheduleNotification.mappers;

import com.camel.scheduleNotification.dtos.RequestScheduleDTO;
import com.camel.scheduleNotification.entities.CommunicationSchedule;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

    ScheduleMapper INSTANCE = Mappers.getMapper(ScheduleMapper.class);

    CommunicationSchedule toEntity(RequestScheduleDTO request);

    ScheduleMapper toDto(CommunicationSchedule entity);
}
