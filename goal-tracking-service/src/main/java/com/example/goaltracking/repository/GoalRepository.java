package com.example.goaltracking.repository;

import com.example.goaltracking.model.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByCategoryIgnoreCase(String category);
    List<Goal> findByCompleted(boolean completed);
}
