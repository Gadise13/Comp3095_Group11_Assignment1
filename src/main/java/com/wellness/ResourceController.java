package com.group11.wellness.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResourceController {

    @GetMapping("/api/resources/{id}")
    public ResourceDto getResource(@PathVariable String id) {
        ResourceDto r = new ResourceDto();
        r.setId(id);
        r.setName("Sample resource " + id);
        r.setDescription("This is a sample resource from wellness-service.");
        return r;
    }

    static class ResourceDto {
        private String id;
        private String name;
        private String description;
        // getters/setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
    }
}
