package com.camel.scheduleNotification.repositories;

import com.camel.scheduleNotification.entities.CommunicationSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommunicationScheduleRepository extends JpaRepository<CommunicationSchedule, UUID> {

}
