package com.zerogravitysolutuins.training_service.template.group;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zerogravitysolutuins.training_service.commons.BaseEntity;
import com.zerogravitysolutuins.training_service.template.instructor.Instructor;
import com.zerogravitysolutuins.training_service.template.student.Student;
import com.zerogravitysolutuins.training_service.training.Training;
import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToMany
    @JoinTable(
            name = "group_instructors",
            joinColumns = {@JoinColumn(name = "group_id")},
            inverseJoinColumns = {@JoinColumn(name = "instructor_id")}
    )
    @JsonIgnoreProperties("groups")
    private Set<Instructor> instructors = new HashSet<>();

    @ManyToMany(mappedBy = "groups")
    @JsonIgnoreProperties("groups")
    private Set<Student> students = new HashSet<>();

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
