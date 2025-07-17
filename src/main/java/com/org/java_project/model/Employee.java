package com.org.java_project.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;
    private String skills;
    private int totalExperience;
    private LocalDate benchStartDate;

    private boolean tagged;
    private boolean positionFilled;
    private boolean demandClosed;

    private String interviewStatus;
    private String projectAllocation;

    // Getters and Setters

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public int getTotalExperience() {
        return totalExperience;
    }

    public void setTotalExperience(int totalExperience) {
        this.totalExperience = totalExperience;
    }

    public LocalDate getBenchStartDate() {
        return benchStartDate;
    }

    public void setBenchStartDate(LocalDate benchStartDate) {
        this.benchStartDate = benchStartDate;
    }

    public boolean isTagged() {
        return tagged;
    }

    public void setTagged(boolean tagged) {
        this.tagged = tagged;
    }

    public boolean isPositionFilled() {
        return positionFilled;
    }

    public void setPositionFilled(boolean positionFilled) {
        this.positionFilled = positionFilled;
    }

    public boolean isDemandClosed() {
        return demandClosed;
    }

    public void setDemandClosed(boolean demandClosed) {
        this.demandClosed = demandClosed;
    }

    public String getInterviewStatus() {
        return interviewStatus;
    }

    public void setInterviewStatus(String interviewStatus) {
        this.interviewStatus = interviewStatus;
    }

    public String getProjectAllocation() {
        return projectAllocation;
    }

    public void setProjectAllocation(String projectAllocation) {
        this.projectAllocation = projectAllocation;
    }
}
