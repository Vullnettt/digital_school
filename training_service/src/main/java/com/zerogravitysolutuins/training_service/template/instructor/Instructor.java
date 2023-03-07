package com.zerogravitysolutuins.training_service.template.instructor;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zerogravitysolutuins.training_service.commons.BaseEntity;
import com.zerogravitysolutuins.training_service.template.group.Group;
import com.zerogravitysolutuins.training_service.training.Training;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "instructors")
public class Instructor extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String bio;
    private String facebookProfile;
    private String linkedinProfile;
    private String profilePicture;

    @ManyToMany(mappedBy = "instructors")
    @JsonIgnoreProperties("instructors")
    private Set<Training> trainings = new HashSet<>();

    @ManyToMany(mappedBy = "instructors")
    @JsonIgnoreProperties("instructors")
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

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getFacebookProfile() {
        return facebookProfile;
    }

    public void setFacebookProfile(String facebookProfile) {
        this.facebookProfile = facebookProfile;
    }

    public String getLinkedinProfile() {
        return linkedinProfile;
    }

    public void setLinkedinProfile(String linkedinProfile) {
        this.linkedinProfile = linkedinProfile;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }
}


