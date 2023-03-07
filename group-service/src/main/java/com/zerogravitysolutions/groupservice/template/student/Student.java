package com.zerogravitysolutions.groupservice.template.student;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zerogravitysolutions.groupservice.commons.BaseEntity;
import com.zerogravitysolutions.groupservice.group.Group;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String personalNumber;
    private String profilePicture;

    @ManyToMany
    @JoinTable(
            name = "student_groups",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "group_id")}
    )
    @JsonIgnoreProperties("students")
    private Set<Group> groups = new HashSet<>();


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
