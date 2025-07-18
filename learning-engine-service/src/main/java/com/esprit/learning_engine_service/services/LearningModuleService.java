package com.esprit.learning_engine_service.services;


import com.esprit.learning_engine_service.DTO.LearningModuleDTO;

import java.util.List;

public interface LearningModuleService {
    List<LearningModuleDTO> getAll();
    LearningModuleDTO getById(String id);
    LearningModuleDTO save(LearningModuleDTO module);
    void delete(String id);
}
