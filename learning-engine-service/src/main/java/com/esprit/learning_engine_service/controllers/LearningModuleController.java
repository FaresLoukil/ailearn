package com.esprit.learning_engine_service.controllers;

import com.esprit.learning_engine_service.entities.LearningModule;
import com.esprit.learning_engine_service.services.LearningModuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modules")
public class LearningModuleController {

    private final LearningModuleService service;

    public LearningModuleController(LearningModuleService service) {
        this.service = service;
    }

    // Get all modules
    @GetMapping
    public ResponseEntity<List<LearningModule>> getAllModules() {
        return ResponseEntity.ok(service.getAll());
    }

    // Get module by ID
    @GetMapping("/{id}")
    public ResponseEntity<LearningModule> getModuleById(@PathVariable String id) {
        LearningModule module = service.getById(id);
        if (module != null) {
            return ResponseEntity.ok(module);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create new module
    @PostMapping
    public ResponseEntity<LearningModule> createModule(@RequestBody LearningModule module) {
        return ResponseEntity.ok(service.save(module));
    }

    // Update module
    @PutMapping("/{id}")
    public ResponseEntity<LearningModule> updateModule(@PathVariable String id, @RequestBody LearningModule module) {
        LearningModule existing = service.getById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        module.setId(id); // Make sure ID is preserved
        return ResponseEntity.ok(service.save(module));
    }

    // Delete module
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable String id) {
        LearningModule existing = service.getById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}