package com.wellness;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ResourceService {
    private final ResourceRepository repo;
    public ResourceService(ResourceRepository repo) { this.repo = repo; }

    @Cacheable("resources")
    public List<Resource> getAll() { return repo.findAll(); }

    @CacheEvict(value = "resources", allEntries = true)
    public Resource create(Resource r) { return repo.save(r); }

    @CacheEvict(value = "resources", allEntries = true)
    public void delete(Long id) { repo.deleteById(id); }
}
