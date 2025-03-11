package com.camel.scheduleNotification.dtos;

import com.camel.scheduleNotification.entities.ScheduleType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record RequestScheduleDTO(
        @NotNull(message = "Scheduled time is required.")
        LocalDateTime date,
        @NotBlank(message = "Message cannot be empty")
        String message,
        @Size(max = 500, message="Message cannot exceed 500 chars.")
        @NotBlank(message = "Recipient is required.")
        String recipient,
        @NotNull(message = "Communication type is required.")
        ScheduleType type
) {
}
