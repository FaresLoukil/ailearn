package com.esprit.learning_engine_service.controllers;

import com.esprit.learning_engine_service.DTO.LearningModuleDTO;
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

    @GetMapping
    public ResponseEntity<List<LearningModuleDTO>> getAllModules() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LearningModuleDTO> getModuleById(@PathVariable String id) {
        LearningModuleDTO module = service.getById(id);
        if (module != null) {
            return ResponseEntity.ok(module);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<LearningModuleDTO> createModule(@RequestBody LearningModuleDTO module) {
        return ResponseEntity.ok(service.save(module));
    }

    // Update module
    @PutMapping("/{id}")
    public ResponseEntity<LearningModuleDTO> updateModule(@PathVariable String id, @RequestBody LearningModuleDTO module) {
        LearningModuleDTO existing = service.getById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        module.setId(id); // Make sure ID is preserved
        return ResponseEntity.ok(service.save(module));
    }

    // Delete module
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable String id) {
        LearningModuleDTO existing = service.getById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}