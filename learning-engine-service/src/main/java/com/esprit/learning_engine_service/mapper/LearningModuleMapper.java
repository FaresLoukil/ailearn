package com.esprit.learning_engine_service.mapper;

import com.esprit.learning_engine_service.DTO.LearningModuleDTO;
import com.esprit.learning_engine_service.entities.LearningModule;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LearningModuleMapper {
    LearningModuleDTO toDTO(LearningModule module);
    LearningModule toEntity(LearningModuleDTO dto);
    List<LearningModuleDTO> toDTOList(List<LearningModule> modules);
}
