package com.esprit.learning_engine_service.services.servicesImpl;

import com.esprit.learning_engine_service.entities.LearningCategory;
import com.esprit.learning_engine_service.repositories.LearningCategoryRepository;
import com.esprit.learning_engine_service.services.LearningCategoryService;
import org.springframework.stereotype.Service;
import tn.esprit.spring.commonlib.exceptions.ResourceNotFoundException;

import java.util.List;

@Service
public class LearningCategoryServiceImpl implements LearningCategoryService {

    private final LearningCategoryRepository repo;

    public LearningCategoryServiceImpl(LearningCategoryRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<LearningCategory> getAll() {
        return repo.findAll();
    }

    @Override
    public LearningCategory getById(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("LearningCategory not found with id: " + id));
    }

    @Override
    public LearningCategory save(LearningCategory category) {
        return repo.save(category);
    }

    @Override
    public void delete(String id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("LearningCategory not found with id: " + id);
        }
        repo.deleteById(id);
    }
}
