package com.gbc.wellness.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ResourceController {

    @GetMapping("/api/resources")
    public List<String> listResources() {
        return List.of("Counselling", "Workshops", "Yoga");
    }
}
