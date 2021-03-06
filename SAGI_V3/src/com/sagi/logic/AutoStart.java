package com.sagi.logic;
// Generated 03-feb-2014 12:00:45 by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * AutoStart generated by hbm2java
 */
public class AutoStart  implements java.io.Serializable {


     private int autoStartId;
     private Employees employeesByEmpIdAuthorizeAutoStart;
     private Employees employeesByEmpIdElaborateAutoStart;
     private Processes processes;
     private String autoDescription;
     private Date autoStartCreationDate;
     private Boolean statusAutoStart;

    public AutoStart() {
    }

	
    public AutoStart(int autoStartId, Processes processes, String autoDescription, Date autoStartCreationDate) {
        this.autoStartId = autoStartId;
        this.processes = processes;
        this.autoDescription = autoDescription;
        this.autoStartCreationDate = autoStartCreationDate;
    }
    public AutoStart(int autoStartId, Employees employeesByEmpIdAuthorizeAutoStart, Employees employeesByEmpIdElaborateAutoStart, Processes processes, String autoDescription, Date autoStartCreationDate, Boolean statusAutoStart) {
       this.autoStartId = autoStartId;
       this.employeesByEmpIdAuthorizeAutoStart = employeesByEmpIdAuthorizeAutoStart;
       this.employeesByEmpIdElaborateAutoStart = employeesByEmpIdElaborateAutoStart;
       this.processes = processes;
       this.autoDescription = autoDescription;
       this.autoStartCreationDate = autoStartCreationDate;
       this.statusAutoStart = statusAutoStart;
    }
   
    public int getAutoStartId() {
        return this.autoStartId;
    }
    
    public void setAutoStartId(int autoStartId) {
        this.autoStartId = autoStartId;
    }
    public Employees getEmployeesByEmpIdAuthorizeAutoStart() {
        return this.employeesByEmpIdAuthorizeAutoStart;
    }
    
    public void setEmployeesByEmpIdAuthorizeAutoStart(Employees employeesByEmpIdAuthorizeAutoStart) {
        this.employeesByEmpIdAuthorizeAutoStart = employeesByEmpIdAuthorizeAutoStart;
    }
    public Employees getEmployeesByEmpIdElaborateAutoStart() {
        return this.employeesByEmpIdElaborateAutoStart;
    }
    
    public void setEmployeesByEmpIdElaborateAutoStart(Employees employeesByEmpIdElaborateAutoStart) {
        this.employeesByEmpIdElaborateAutoStart = employeesByEmpIdElaborateAutoStart;
    }
    public Processes getProcesses() {
        return this.processes;
    }
    
    public void setProcesses(Processes processes) {
        this.processes = processes;
    }
    public String getAutoDescription() {
        return this.autoDescription;
    }
    
    public void setAutoDescription(String autoDescription) {
        this.autoDescription = autoDescription;
    }
    public Date getAutoStartCreationDate() {
        return this.autoStartCreationDate;
    }
    
    public void setAutoStartCreationDate(Date autoStartCreationDate) {
        this.autoStartCreationDate = autoStartCreationDate;
    }
    public Boolean getStatusAutoStart() {
        return this.statusAutoStart;
    }
    
    public void setStatusAutoStart(Boolean statusAutoStart) {
        this.statusAutoStart = statusAutoStart;
    }




}


