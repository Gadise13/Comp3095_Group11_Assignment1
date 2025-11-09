package com.example.goaltracking.service;

import com.example.goaltracking.model.Goal;
import com.example.goaltracking.repository.GoalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    private final GoalRepository repo;

    public GoalService(GoalRepository repo) {
        this.repo = repo;
    }

    public Goal create(Goal goal) {
        return repo.save(goal);
    }

    public List<Goal> getAll() {
        return repo.findAll();
    }

    public Goal getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Goal> getByCategory(String category) {
        return repo.findByCategoryIgnoreCase(category);
    }

    public List<Goal> getByStatus(boolean completed) {
        return repo.findByCompleted(completed);
    }

    public Goal update(Long id, Goal goal) {
        goal.setId(id);
        return repo.save(goal);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
