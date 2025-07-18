package com.esprit.learning_engine_service.services.servicesImpl;

import com.esprit.learning_engine_service.DTO.LearningModuleDTO;
import com.esprit.learning_engine_service.entities.LearningModule;
import com.esprit.learning_engine_service.mapper.LearningModuleMapper;
import com.esprit.learning_engine_service.repositories.LearningModuleRepository;
import com.esprit.learning_engine_service.services.LearningModuleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LearningModuleServiceImpl implements LearningModuleService {

    private final LearningModuleRepository repo;
    private final LearningModuleMapper mapper;

    public LearningModuleServiceImpl(LearningModuleRepository repo, LearningModuleMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public List<LearningModuleDTO> getAll() {
        List<LearningModule> modules = repo.findAll();
        return mapper.toDTOList(modules);
    }

    @Override
    public LearningModuleDTO getById(String id) {
        return repo.findById(id)
                .map(mapper::toDTO)
                .orElse(null);
    }

    @Override
    public LearningModuleDTO save(LearningModuleDTO moduleDTO) {
        LearningModule entity = mapper.toEntity(moduleDTO);
        LearningModule saved = repo.save(entity);
        return mapper.toDTO(saved);
    }

    @Override
    public void delete(String id) {
        repo.deleteById(id);
    }
}
