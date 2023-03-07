package com.zerogravitysolutuins.training_service.training;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zerogravitysolutuins.training_service.commons.BaseDto;
import com.zerogravitysolutuins.training_service.group.Group;
import com.zerogravitysolutuins.training_service.instructor.Instructor;
import com.zerogravitysolutuins.training_service.subject.Subject;

import java.util.HashSet;
import java.util.Set;

public class TrainingDto extends BaseDto {

    private String title;
    private String description;
    private Double price;

    @JsonIgnoreProperties("trainings")
    private Set<Instructor> instructors = new HashSet<>();

    private Set<Subject> subjects = new HashSet<>();

    private Set<Group> groups = new HashSet<>();

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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(Set<Instructor> instructors) {
        this.instructors = instructors;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
