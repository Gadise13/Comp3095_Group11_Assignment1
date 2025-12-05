package com.group11.goaltracking.client;

import com.group11.goaltracking.model.ResourceDto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WellnessClient {

    private final RestTemplate restTemplate;
    private final String wellnessBaseUrl;

    public WellnessClient(RestTemplate restTemplate,
                          @Value("${wellness.base-url}") String wellnessBaseUrl) {
        this.restTemplate = restTemplate;
        this.wellnessBaseUrl = wellnessBaseUrl;
    }

    // circuit breaker name "wellnessService" must match config in application.yml
    @CircuitBreaker(name = "wellnessService", fallbackMethod = "getResourceFallback")
    public ResourceDto getResourceById(String id) {
        String url = wellnessBaseUrl + "/api/resources/" + id;
        return restTemplate.getForObject(url, ResourceDto.class);
    }

    // fallback signature = same params + Throwable at end
    public ResourceDto getResourceFallback(String id, Throwable t) {
        ResourceDto fallback = new ResourceDto();
        fallback.setId(id);
        fallback.setName("Fallback Resource");
        fallback.setDescription("Returned by fallback because wellness-service is unavailable: " + t.toString());
        return fallback;
    }
}
