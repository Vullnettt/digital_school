package com.zerogravitysolutuins.training_service.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zerogravitysolutuins.training_service.commons.BaseEntity;
import com.zerogravitysolutuins.training_service.training.Training;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Timestamp;

@Entity
@Table(name = "groups")
public class Group extends BaseEntity {

    private String title;
    private String description;
    private Timestamp startDate;
    private Timestamp endDate;

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

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }
}
