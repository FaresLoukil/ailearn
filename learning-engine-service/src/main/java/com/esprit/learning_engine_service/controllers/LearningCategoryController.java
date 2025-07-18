package com.esprit.learning_engine_service.controllers;

import com.esprit.learning_engine_service.entities.LearningCategory;
import com.esprit.learning_engine_service.services.LearningCategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class LearningCategoryController {

    private final LearningCategoryService service;

    public LearningCategoryController(LearningCategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<LearningCategory>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearningCategory> getById(@PathVariable String id) {
        LearningCategory category = service.getById(id);
        if (category == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(category);
    }

    @PostMapping
    public ResponseEntity<LearningCategory> create(@RequestBody LearningCategory category) {
        LearningCategory saved = service.save(category);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LearningCategory> update(@PathVariable String id, @RequestBody LearningCategory category) {
        if (service.getById(id) == null) return ResponseEntity.notFound().build();
        category.setId(id);
        LearningCategory updated = service.save(category);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (service.getById(id) == null) return ResponseEntity.notFound().build();
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
