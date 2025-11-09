package com.example.wellness.repository;

import com.example.wellness.model.ResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ResourceRepository extends JpaRepository<ResourceEntity, Long> {
    List<ResourceEntity> findByCategoryIgnoreCase(String category);
}
