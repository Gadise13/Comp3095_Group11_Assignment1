package com.example.event_service.dto;

import com.example.event_service.model.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.List;

@Data
@AllArgsConstructor
public class EventWithResources {
    private Event event;
    private List<WellnessResource> resources;
}
