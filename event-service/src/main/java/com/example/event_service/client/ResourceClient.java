package com.example.event_service.client;


import com.example.event_service.dto.WellnessResource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class ResourceClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<WellnessResource> getResourcesByCategory(String category) {
        String url = "http://wellness-service:8080/api/resources/category/" + category;

        ResponseEntity<List<WellnessResource>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<WellnessResource>>() {}
        );

        return response.getBody();
    }
}
