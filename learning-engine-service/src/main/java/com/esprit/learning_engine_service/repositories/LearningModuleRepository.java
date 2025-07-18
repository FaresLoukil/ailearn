package com.esprit.learning_engine_service.repositories;


import com.esprit.learning_engine_service.entities.LearningModule;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LearningModuleRepository extends MongoRepository<LearningModule, String> {
}
