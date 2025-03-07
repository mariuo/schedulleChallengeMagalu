package com.camel.schedulleNotification.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class CommunicationSchedulle {
    private UUID id;
    private LocalDateTime date;
    private String message;
    private String recipient;

    private ScheduleStatus status;
    private ScheduleType type;

    private LocalDateTime creadtedAt;
    private LocalDateTime updatedAt;

}
