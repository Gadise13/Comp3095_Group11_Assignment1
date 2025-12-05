package com.group11.event-service.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CircuitBreakerEventLogger {
    private static final Logger logger = LoggerFactory.getLogger(CircuitBreakerEventLogger.class);
    private final CircuitBreakerRegistry registry;

    public CircuitBreakerEventLogger(CircuitBreakerRegistry registry) {
        this.registry = registry;
    }

    @PostConstruct
    public void register() {
        registry.getAllCircuitBreakers().forEach(cb -> {
            cb.getEventPublisher().onStateTransition(evt -> {
                logger.info("CircuitBreaker '{}' transition: {}", cb.getName(), evt.getStateTransition());
            });
        });
    }
}
