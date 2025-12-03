package com.gbc.event.stream;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class GoalEventListener {

    @KafkaListener(topics = "goal-completed", groupId = "event-service")
    public void handleGoalCompleted(Map<String, Object> message) {
        String studentId = (String) message.get("studentId");
        String goalId = (String) message.get("goalId");
        Number ts = (Number) message.get("timestamp");
        System.out.println("[event-service] Received GoalCompletedEvent for student=" + studentId + " goal=" + goalId + " ts=" + ts);
        // TODO: call recommendation engine or store event
    }
}
