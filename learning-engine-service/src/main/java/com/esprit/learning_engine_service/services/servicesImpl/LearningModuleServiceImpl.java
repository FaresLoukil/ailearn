package com.esprit.learning_engine_service.services.servicesImpl;

import com.esprit.learning_engine_service.entities.LearningModule;
import com.esprit.learning_engine_service.repositories.LearningModuleRepository;
import com.esprit.learning_engine_service.services.LearningModuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningModuleServiceImpl implements LearningModuleService {

    private final LearningModuleRepository repo;

    public LearningModuleServiceImpl(LearningModuleRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<LearningModule> getAll() {
        return repo.findAll();
    }

    @Override
    public LearningModule getById(String id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public LearningModule save(LearningModule module) {
        return repo.save(module);
    }

    @Override
    public void delete(String id) {
        repo.deleteById(id);
    }
}
