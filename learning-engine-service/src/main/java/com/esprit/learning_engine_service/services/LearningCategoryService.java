package com.esprit.learning_engine_service.services;

import com.esprit.learning_engine_service.entities.LearningCategory;

import java.util.List;

public interface LearningCategoryService {
    List<LearningCategory> getAll();
    LearningCategory getById(String id);
    LearningCategory save(LearningCategory category);
    void delete(String id);
}
