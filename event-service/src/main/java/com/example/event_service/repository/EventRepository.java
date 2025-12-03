package com.example.event_service.repository;

import com.example.event_service.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {

    // Find events by location
    List<Event> findByLocationIgnoreCase(String location);

    // Find events whose dateTime is in the future
    @Query("SELECT e FROM Event e WHERE e.dateTime > CURRENT_TIMESTAMP")
    List<Event> findUpcomingEvents();
}

