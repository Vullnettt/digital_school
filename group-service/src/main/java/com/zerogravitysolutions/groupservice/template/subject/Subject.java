package com.zerogravitysolutions.groupservice.template.subject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zerogravitysolutions.groupservice.commons.BaseEntity;
import com.zerogravitysolutions.groupservice.template.training.Training;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "subjects")
public class Subject extends BaseEntity {

    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "training_id")
    @JsonIgnore
    private Training training;


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

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}
