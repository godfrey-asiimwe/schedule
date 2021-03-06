package com.pr.schedule.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "scheduleName")
    private String scheduleName;

    @Column(name = "description")
    private String description;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "projectId")
    private String projectId;

    public Schedule() {

    }

    public Schedule(String scheduleName, String description,Date startDate,Date endDate, String projectId) {
        super();
        this.scheduleName = scheduleName;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.projectId = projectId;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getScheduleName(){
        return scheduleName;
    }

    public void setScheduleName(String scheduleName){
        this.scheduleName = scheduleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectid(String projectId) {
        this.projectId = projectId;
    }


    
}