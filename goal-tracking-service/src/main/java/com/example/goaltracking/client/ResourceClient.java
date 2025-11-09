package com.example.goaltracking.client;

import com.example.goaltracking.dto.WellnessResource;
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
        // URL for the wellness-service endpoint
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

