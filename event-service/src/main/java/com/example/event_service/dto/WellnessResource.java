package com.example.event_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WellnessResource {
    private Long id;
    private String title;
    private String description;
    private String category;
    private String url;
}
