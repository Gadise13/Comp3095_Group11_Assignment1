package com.example.goaltracking.dto;

import com.example.goaltracking.model.Goal;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class GoalWithResources {
    private Goal goal;
    private List<WellnessResource> relatedResources;
}
