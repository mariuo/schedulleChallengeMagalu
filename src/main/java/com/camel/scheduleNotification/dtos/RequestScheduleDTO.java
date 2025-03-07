package com.camel.scheduleNotification.dtos;

import com.camel.scheduleNotification.entities.ScheduleType;

import java.time.LocalDateTime;

public record RequestScheduleDTO(LocalDateTime date,
                                 String message,
                                 String recipient,
                                 ScheduleType type
) {
}
