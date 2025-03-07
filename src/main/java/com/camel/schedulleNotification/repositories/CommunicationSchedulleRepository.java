package com.camel.schedulleNotification.repositories;

import com.camel.schedulleNotification.entities.CommunicationSchedulle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CommunicationSchedulleRepository extends JpaRepository<CommunicationSchedulle, UUID> {

}
