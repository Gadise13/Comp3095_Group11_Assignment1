package com.example.event_service.service;

import com.example.event_service.model.Event;
import com.example.event_service.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository repo;

    public EventService(EventRepository repo) {
        this.repo = repo;
    }

    public Event create(Event event) {
        return repo.save(event);
    }

    public List<Event> getAll() {
        return repo.findAll();
    }

    public Event getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Event> getByLocation(String location) {
        return repo.findByLocationIgnoreCase(location);
    }

    public List<Event> getUpcoming() {
        return repo.findUpcomingEvents(); // make sure this method exists in repository
    }

    public Event update(Long id, Event event) {
        event.setId(id);
        return repo.save(event);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}

