package com.esprit.learning_engine_service.services;

import com.esprit.learning_engine_service.entities.LearningModule;

import java.util.List;

public interface LearningModuleService {
    List<LearningModule> getAll();
    LearningModule getById(String id);
    LearningModule save(LearningModule module);
    void delete(String id);
}
