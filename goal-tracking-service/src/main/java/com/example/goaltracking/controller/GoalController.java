package com.example.goaltracking.controller;

import com.example.goaltracking.client.ResourceClient;
import com.example.goaltracking.dto.GoalWithResources;
import com.example.goaltracking.dto.WellnessResource;
import com.example.goaltracking.model.Goal;
import com.example.goaltracking.service.GoalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    private final GoalService service;
    private final ResourceClient resourceClient;

    public GoalController(GoalService service, ResourceClient resourceClient) {
        this.service = service;
        this.resourceClient = resourceClient;
    }

    @PostMapping
    public Goal create(@RequestBody Goal goal) {
        return service.create(goal);
    }

    @GetMapping
    public List<Goal> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        Goal goal = service.getById(id);
        if (goal == null) return ResponseEntity.notFound().build();

        // Fetch related resources from wellness-service
        List<WellnessResource> related = resourceClient.getResourcesByCategory(goal.getCategory());

        return ResponseEntity.ok(new GoalWithResources(goal, related));
    }

    @GetMapping("/category/{category}")
    public List<Goal> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    @GetMapping("/status/{completed}")
    public List<Goal> getByStatus(@PathVariable boolean completed) {
        return service.getByStatus(completed);
    }

    @PutMapping("/{id}")
    public Goal update(@PathVariable Long id, @RequestBody Goal goal) {
        return service.update(id, goal);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

