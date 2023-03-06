package com.zerogravitysolutions.groupservice.training;

import com.zerogravitysolutions.groupservice.commons.BaseEntity;
import com.zerogravitysolutions.groupservice.group.Group;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "trainings")
public class Training extends BaseEntity {

    private String title;
    private String description;
    private Double price;

    @OneToMany(mappedBy = "training")
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

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }
}
