package com.zerogravitysolutions.groupservice.group;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zerogravitysolutions.groupservice.commons.BaseDto;
import com.zerogravitysolutions.groupservice.template.instructor.Instructor;
import com.zerogravitysolutions.groupservice.template.student.Student;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

public class GroupDto extends BaseDto{

    private String title;
    private String description;
    private Timestamp startDate;
    private Timestamp endDate;
    private Long trainingId;

    @JsonIgnoreProperties("groups")
    private Set<Instructor> instructors = new HashSet<>();

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

    public Long getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }

    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(Set<Instructor> instructors) {
        this.instructors = instructors;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
