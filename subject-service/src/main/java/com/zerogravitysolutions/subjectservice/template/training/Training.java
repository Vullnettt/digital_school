package com.zerogravitysolutions.subjectservice.template.training;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zerogravitysolutions.subjectservice.commons.BaseEntity;
import com.zerogravitysolutions.subjectservice.template.group.Group;
import com.zerogravitysolutions.subjectservice.template.instructor.Instructor;
import com.zerogravitysolutions.subjectservice.subject.Subject;
import jakarta.persistence.*;


import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trainings")
public class Training extends BaseEntity {

    private String title;
    private String description;
    private Double price;

    @ManyToMany
    @JoinTable(
            name = "training_instructors",
            joinColumns = {@JoinColumn(name = "training_id")},
            inverseJoinColumns = {@JoinColumn(name = "instructor_id")}
    )
    @JsonIgnoreProperties("trainings")
    private Set<Instructor> instructors = new HashSet<>();

    @OneToMany(mappedBy = "training")
    private Set<Subject> subjects = new HashSet<>();

    @OneToMany(mappedBy = "training")
    @JsonIgnoreProperties("training")
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

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }
}
