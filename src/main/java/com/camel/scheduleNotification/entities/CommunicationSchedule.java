package com.camel.scheduleNotification.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "communication_schedules")

public class CommunicationSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String recipient;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ScheduleStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ScheduleType type;

    private LocalDateTime creadtedAt;
    private LocalDateTime updatedAt;

    public CommunicationSchedule() {
    }

    public CommunicationSchedule(UUID id, LocalDateTime date, String message, String recipient, ScheduleStatus status, ScheduleType type, LocalDateTime creadtedAt, LocalDateTime updatedAt) {
        this.id = id;
        this.date = date;
        this.message = message;
        this.recipient = recipient;
        this.status = status;
        this.type = type;
        this.creadtedAt = creadtedAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }

    public String getRecipient() {
        return recipient;
    }

    public ScheduleStatus getStatus() {
        return status;
    }

    public ScheduleType getType() {
        return type;
    }

    public LocalDateTime getCreadtedAt() {
        return creadtedAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setStatus(ScheduleStatus status) {
        this.status = status;
    }

    public void setType(ScheduleType type) {
        this.type = type;
    }

    public void setCreadtedAt(LocalDateTime creadtedAt) {
        this.creadtedAt = creadtedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CommunicationSchedule that = (CommunicationSchedule) o;
        return Objects.equals(id, that.id) && Objects.equals(date, that.date) && Objects.equals(message, that.message) && Objects.equals(recipient, that.recipient) && status == that.status && type == that.type && Objects.equals(creadtedAt, that.creadtedAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, message, recipient, status, type, creadtedAt, updatedAt);
    }

    @Override
    public String toString() {
        return "CommunicationSchedule{" +
                "id=" + id +
                ", date=" + date +
                ", message='" + message + '\'' +
                ", recipient='" + recipient + '\'' +
                ", status=" + status +
                ", type=" + type +
                ", creadtedAt=" + creadtedAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
