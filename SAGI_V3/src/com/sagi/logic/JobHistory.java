package com.sagi.logic;
// Generated 03-feb-2014 12:00:45 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * JobHistory generated by hbm2java
 */
public class JobHistory  implements java.io.Serializable {


     private Date startDate;
     private Employees employees;
     private Jobs jobs;
     private Subdirectorates subdirectorates;
     private Date endDate;

    public JobHistory() {
    }

    public JobHistory(Date startDate, Employees employees, Jobs jobs, Subdirectorates subdirectorates, Date endDate) {
       this.startDate = startDate;
       this.employees = employees;
       this.jobs = jobs;
       this.subdirectorates = subdirectorates;
       this.endDate = endDate;
    }
   
    public Date getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public Employees getEmployees() {
        return this.employees;
    }
    
    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
    public Jobs getJobs() {
        return this.jobs;
    }
    
    public void setJobs(Jobs jobs) {
        this.jobs = jobs;
    }
    public Subdirectorates getSubdirectorates() {
        return this.subdirectorates;
    }
    
    public void setSubdirectorates(Subdirectorates subdirectorates) {
        this.subdirectorates = subdirectorates;
    }
    public Date getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }




}


