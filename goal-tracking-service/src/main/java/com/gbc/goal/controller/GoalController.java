package com.gbc.goal.controller;

import com.gbc.goal.stream.GoalEventPublisher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    private final GoalEventPublisher publisher;

    public GoalController(GoalEventPublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping("/{id}/complete")
    public ResponseEntity<?> completeGoal(@PathVariable String id, @RequestBody Map<String,String> body) {
        String studentId = body.getOrDefault("studentId", "unknown");
        long ts = System.currentTimeMillis();
        publisher.publishGoalCompleted(id, studentId, ts);
        return ResponseEntity.ok(Map.of("status","published","goalId", id));
    }
}
