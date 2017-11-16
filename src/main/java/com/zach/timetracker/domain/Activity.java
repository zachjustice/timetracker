package com.zach.timetracker.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "activities")
public class Activity {

    @Id
    @Column(name = "id", insertable = false, updatable = false)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, scope = Activity.class)
    private int id;

    @NotEmpty
    @Column(name = "label")
    private String label;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
