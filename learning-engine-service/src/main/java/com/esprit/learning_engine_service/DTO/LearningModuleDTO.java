package com.esprit.learning_engine_service.DTO;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public class LearningModuleDTO {
    private String id;
    private String title;
    private String description;
    private String level;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public LearningModuleDTO() {}

    public LearningModuleDTO(String id, String title, String description, String level) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.level = level;
    }
}
