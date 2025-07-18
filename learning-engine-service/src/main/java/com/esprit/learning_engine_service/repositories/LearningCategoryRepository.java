package com.esprit.learning_engine_service.repositories;

import com.esprit.learning_engine_service.entities.LearningCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LearningCategoryRepository extends MongoRepository<LearningCategory, String> {
}
