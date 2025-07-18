package com.esprit.learning_engine_service.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "learning_categories")
@Getter
@Setter
public class LearningCategory {
    @Id
    private String id;
    private String name;
    private String description;

    public LearningCategory() {}

    public LearningCategory(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
