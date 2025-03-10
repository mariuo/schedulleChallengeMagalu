package com.camel.scheduleNotification.dtos;

import com.camel.scheduleNotification.entities.ScheduleStatus;

import java.time.LocalDateTime;

public record ResponseScheduleDTO(
        LocalDateTime date,
        String message,
        String recipient,
        ScheduleStatus status
) {
}
