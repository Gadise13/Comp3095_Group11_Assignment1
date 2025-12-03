package com.example.wellness.controller;

import com.example.wellness.model.ResourceEntity;
import com.example.wellness.service.ResourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resources")
public class ResourceController {

    private final ResourceService service;

    public ResourceController(ResourceService service) {
        this.service = service;
    }

    @PostMapping
    public ResourceEntity create(@RequestBody ResourceEntity resource) {
        return service.create(resource);
    }

    @GetMapping
    public List<ResourceEntity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceEntity> getById(@PathVariable Long id) {
        ResourceEntity res = service.getById(id);
        return (res != null) ? ResponseEntity.ok(res) : ResponseEntity.notFound().build();
    }

    @GetMapping("/category/{category}")
    public List<ResourceEntity> getByCategory(@PathVariable String category) {
        return service.getByCategory(category);
    }

    @PutMapping("/{id}")
    public ResourceEntity update(@PathVariable Long id, @RequestBody ResourceEntity resource) {
        return service.update(id, resource);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
