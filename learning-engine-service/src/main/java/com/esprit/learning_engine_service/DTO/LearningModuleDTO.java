package com.esprit.learning_engine_service.DTO;

import lombok.Getter;
import lombok.Setter;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
@Getter
@Setter
public class LearningModuleDTO {
    private String id;
    private String title;
    private String description;
    private String level;

    public LearningModuleDTO() {}

    public LearningModuleDTO(String id, String title, String description, String level) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.level = level;
    }
}
