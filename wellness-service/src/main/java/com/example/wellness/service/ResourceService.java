package com.example.wellness.service;

import com.example.wellness.model.ResourceEntity;
import com.example.wellness.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    private final ResourceRepository repo;

    public ResourceService(ResourceRepository repo) {
        this.repo = repo;
    }

    // Create a new resource
    public ResourceEntity create(ResourceEntity resource) {
        return repo.save(resource);
    }

    // Get all resources
    public List<ResourceEntity> getAll() {
        return repo.findAll();
    }

    // Get a resource by ID
    public ResourceEntity getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    // Get resources by category
    public List<ResourceEntity> getByCategory(String category) {
        return repo.findByCategoryIgnoreCase(category);
    }

    // Update a resource
    public ResourceEntity update(Long id, ResourceEntity resource) {
        // Fetch the existing resource from DB
        ResourceEntity existing = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Resource not found with id " + id));

        // Update fields
        existing.setTitle(resource.getTitle());
        existing.setDescription(resource.getDescription());
        existing.setCategory(resource.getCategory());
        existing.setUrl(resource.getUrl());

        // Save updated entity
        return repo.save(existing);
    }

    // Delete a resource
    public void delete(Long id) {
        repo.deleteById(id);
    }
}

