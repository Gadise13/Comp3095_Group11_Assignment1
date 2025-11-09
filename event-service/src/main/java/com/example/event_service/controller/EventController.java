package com.example.event_service.controller;

import com.example.event_service.client.ResourceClient;
import com.example.event_service.dto.EventWithResources;
import com.example.event_service.dto.WellnessResource;
import com.example.event_service.model.Event;
import com.example.event_service.service.EventService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService service;
    private final ResourceClient resourceClient;

    public EventController(EventService service, ResourceClient resourceClient) {
        this.service = service;
        this.resourceClient = resourceClient;
    }

    @PostMapping
    public Event create(@RequestBody Event event) {
        return service.create(event);
    }

    @GetMapping
    public List<Event> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Event event = service.getById(id);
        if (event == null) return ResponseEntity.notFound().build();

        // Fetch related wellness resources for the event category
        List<WellnessResource> relatedResources = resourceClient.getResourcesByCategory(event.getCategory());

        return ResponseEntity.ok(new EventWithResources(event, relatedResources));
    }

    @GetMapping("/location/{location}")
    public List<Event> getByLocation(@PathVariable String location) {
        return service.getByLocation(location);
    }

    @GetMapping("/upcoming")
    public List<Event> getUpcoming() {
        return service.getUpcoming();
    }

    @PutMapping("/{id}")
    public Event update(@PathVariable Long id, @RequestBody Event event) {
        return service.update(id, event);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}


