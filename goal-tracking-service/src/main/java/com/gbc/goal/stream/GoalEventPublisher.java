package com.gbc.goal.stream;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GoalEventPublisher {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public GoalEventPublisher(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishGoalCompleted(String goalId, String studentId, long timestamp) {
        Map<String, Object> payload = Map.of(
                "goalId", goalId,
                "studentId", studentId,
                "timestamp", timestamp
        );
        kafkaTemplate.send("goal-completed", goalId, payload);
    }
}
