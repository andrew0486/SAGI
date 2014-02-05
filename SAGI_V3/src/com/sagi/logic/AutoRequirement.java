package com.sagi.logic;
// Generated 03-feb-2014 12:00:45 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * AutoRequirement generated by hbm2java
 */
public class AutoRequirement  implements java.io.Serializable {


     private int autoRequirementId;
     private Employees employeesByEmpIdAuthorizeRequirement;
     private Employees employeesByEmpIdElaborateRequirement;
     private Processes processes;
     private String autoRequirementDescription;
     private Date autoRequirementCreationDate;
     private Boolean statusAutoRequirement;

    public AutoRequirement() {
    }

	
    public AutoRequirement(int autoRequirementId, Processes processes, String autoRequirementDescription, Date autoRequirementCreationDate) {
        this.autoRequirementId = autoRequirementId;
        this.processes = processes;
        this.autoRequirementDescription = autoRequirementDescription;
        this.autoRequirementCreationDate = autoRequirementCreationDate;
    }
    public AutoRequirement(int autoRequirementId, Employees employeesByEmpIdAuthorizeRequirement, Employees employeesByEmpIdElaborateRequirement, Processes processes, String autoRequirementDescription, Date autoRequirementCreationDate, Boolean statusAutoRequirement) {
       this.autoRequirementId = autoRequirementId;
       this.employeesByEmpIdAuthorizeRequirement = employeesByEmpIdAuthorizeRequirement;
       this.employeesByEmpIdElaborateRequirement = employeesByEmpIdElaborateRequirement;
       this.processes = processes;
       this.autoRequirementDescription = autoRequirementDescription;
       this.autoRequirementCreationDate = autoRequirementCreationDate;
       this.statusAutoRequirement = statusAutoRequirement;
    }
   
    public int getAutoRequirementId() {
        return this.autoRequirementId;
    }
    
    public void setAutoRequirementId(int autoRequirementId) {
        this.autoRequirementId = autoRequirementId;
    }
    public Employees getEmployeesByEmpIdAuthorizeRequirement() {
        return this.employeesByEmpIdAuthorizeRequirement;
    }
    
    public void setEmployeesByEmpIdAuthorizeRequirement(Employees employeesByEmpIdAuthorizeRequirement) {
        this.employeesByEmpIdAuthorizeRequirement = employeesByEmpIdAuthorizeRequirement;
    }
    public Employees getEmployeesByEmpIdElaborateRequirement() {
        return this.employeesByEmpIdElaborateRequirement;
    }
    
    public void setEmployeesByEmpIdElaborateRequirement(Employees employeesByEmpIdElaborateRequirement) {
        this.employeesByEmpIdElaborateRequirement = employeesByEmpIdElaborateRequirement;
    }
    public Processes getProcesses() {
        return this.processes;
    }
    
    public void setProcesses(Processes processes) {
        this.processes = processes;
    }
    public String getAutoRequirementDescription() {
        return this.autoRequirementDescription;
    }
    
    public void setAutoRequirementDescription(String autoRequirementDescription) {
        this.autoRequirementDescription = autoRequirementDescription;
    }
    public Date getAutoRequirementCreationDate() {
        return this.autoRequirementCreationDate;
    }
    
    public void setAutoRequirementCreationDate(Date autoRequirementCreationDate) {
        this.autoRequirementCreationDate = autoRequirementCreationDate;
    }
    public Boolean getStatusAutoRequirement() {
        return this.statusAutoRequirement;
    }
    
    public void setStatusAutoRequirement(Boolean statusAutoRequirement) {
        this.statusAutoRequirement = statusAutoRequirement;
    }




}

