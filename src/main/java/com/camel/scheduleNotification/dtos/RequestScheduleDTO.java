package com.camel.scheduleNotification.dtos;

import com.camel.scheduleNotification.entities.ScheduleType;

import java.time.LocalDateTime;

public record RequestScheduleDTO(LocalDateTime scheduleDate,
                                 String message,
                                 String destination,
                                 ScheduleType scheduleType
) {
}
