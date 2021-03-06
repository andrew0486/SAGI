package com.sagi.logic;
// Generated 11-dic-2013 13:19:53 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Functions generated by hbm2java
 */
public class Functions  implements java.io.Serializable {


     private int functionId;
     private Employees employees;
     private boolean createUser;
     private boolean uploadUser;
     private boolean deleteUser;
     private boolean createFile;
     private boolean uploadFile;
     private boolean deleteFile;
     private boolean createProcess;
     private boolean uploadProcess;
     private boolean deleteProcess;
     private boolean createAutoStart;
     private boolean uploadAutoStart;
     private boolean deleteAutoStart;
     private boolean createAutoRequeriment;
     private boolean uploadAutoRequeriment;
     private boolean deleteAutoRequeriment;
     private boolean createNotice;
     private boolean uploadNotice;
     private boolean deleteNotice;
     private boolean createTechnicalConcept;
     private boolean uploadTechnicalConcept;
     private boolean deleteTechnicalConcept;
     private boolean createResolution;
     private boolean uploadResolution;
     private boolean deleteResolution;
     private int numberFiles;
     private Set<Employees> employeeses = new HashSet<Employees>(0);

    public Functions() {
    }

	
    public Functions(boolean createUser, boolean uploadUser, boolean deleteUser, boolean createFile, boolean uploadFile,
    		boolean deleteFile, boolean createProcess, boolean uploadProcess, boolean deleteProcess, boolean createAutoStart, 
    		boolean uploadAutoStart, boolean deleteAutoStart, boolean createAutoRequeriment, boolean uploadAutoRequeriment, 
    		boolean deleteAutoRequeriment, boolean createNotice, boolean uploadNotice, boolean deleteNotice, 
    		boolean createTechnicalConcept, boolean uploadTechnicalConcept, boolean deleteTechnicalConcept, 
    		boolean createResolution, boolean uploadResolution, boolean deleteResolution) {
        this.createUser = createUser;
        this.uploadUser = uploadUser;
        this.deleteUser = deleteUser;
        this.createFile = createFile;
        this.uploadFile = uploadFile;
        this.deleteFile = deleteFile;
        this.createProcess = createProcess;
        this.uploadProcess = uploadProcess;
        this.deleteProcess = deleteProcess;
        this.createAutoStart = createAutoStart;
        this.uploadAutoStart = uploadAutoStart;
        this.deleteAutoStart = deleteAutoStart;
        this.createAutoRequeriment = createAutoRequeriment;
        this.uploadAutoRequeriment = uploadAutoRequeriment;
        this.deleteAutoRequeriment = deleteAutoRequeriment;
        this.createNotice = createNotice;
        this.uploadNotice = uploadNotice;
        this.deleteNotice = deleteNotice;
        this.createTechnicalConcept = createTechnicalConcept;
        this.uploadTechnicalConcept = uploadTechnicalConcept;
        this.deleteTechnicalConcept = deleteTechnicalConcept;
        this.createResolution = createResolution;
        this.uploadResolution = uploadResolution;
        this.deleteResolution = deleteResolution;
    }
    public Functions(Employees employees, boolean createUser, boolean uploadUser, 
    		boolean deleteUser, boolean createFile, boolean uploadFile, boolean deleteFile, 
    		boolean createProcess, boolean uploadProcess, boolean deleteProcess, boolean createAutoStart, 
    		boolean uploadAutoStart, boolean deleteAutoStart, boolean createAutoRequeriment, boolean uploadAutoRequeriment, 
    		boolean deleteAutoRequeriment, boolean createNotice, boolean uploadNotice, boolean deleteNotice,
    		boolean createTechnicalConcept, boolean uploadTechnicalConcept, boolean deleteTechnicalConcept, 
    		boolean createResolution, boolean uploadResolution, boolean deleteResolution, Set<Employees> employeeses) {
       this.employees = employees;
       this.createUser = createUser;
       this.uploadUser = uploadUser;
       this.deleteUser = deleteUser;
       this.createFile = createFile;
       this.uploadFile = uploadFile;
       this.deleteFile = deleteFile;
       this.createProcess = createProcess;
       this.uploadProcess = uploadProcess;
       this.deleteProcess = deleteProcess;
       this.createAutoStart = createAutoStart;
       this.uploadAutoStart = uploadAutoStart;
       this.deleteAutoStart = deleteAutoStart;
       this.createAutoRequeriment = createAutoRequeriment;
       this.uploadAutoRequeriment = uploadAutoRequeriment;
       this.deleteAutoRequeriment = deleteAutoRequeriment;
       this.createNotice = createNotice;
       this.uploadNotice = uploadNotice;
       this.deleteNotice = deleteNotice;
       this.createTechnicalConcept = createTechnicalConcept;
       this.uploadTechnicalConcept = uploadTechnicalConcept;
       this.deleteTechnicalConcept = deleteTechnicalConcept;
       this.createResolution = createResolution;
       this.uploadResolution = uploadResolution;
       this.deleteResolution = deleteResolution;
       this.employeeses = employeeses;
    }
   
    public int getFunctionId() {
        return this.functionId;
    }
    
    public void setFunctionId(int functionId) {
        this.functionId = functionId;
    }
    public Employees getEmployees() {
        return this.employees;
    }
    
    public void setEmployees(Employees employees) {
        this.employees = employees;
    }
    public boolean isCreateUser() {
        return this.createUser;
    }
    
    public void setCreateUser(boolean createUser) {
        this.createUser = createUser;
    }
    public boolean isUploadUser() {
        return this.uploadUser;
    }
    
    public void setUploadUser(boolean uploadUser) {
        this.uploadUser = uploadUser;
    }
    public boolean isDeleteUser() {
        return this.deleteUser;
    }
    
    public void setDeleteUser(boolean deleteUser) {
        this.deleteUser = deleteUser;
    }
    public boolean isCreateFile() {
        return this.createFile;
    }
    
    public void setCreateFile(boolean createFile) {
        this.createFile = createFile;
    }
    public boolean isUploadFile() {
        return this.uploadFile;
    }
    
    public void setUploadFile(boolean uploadFile) {
        this.uploadFile = uploadFile;
    }
    public boolean isDeleteFile() {
        return this.deleteFile;
    }
    
    public void setDeleteFile(boolean deleteFile) {
        this.deleteFile = deleteFile;
    }
    public boolean isCreateProcess() {
        return this.createProcess;
    }
    
    public void setCreateProcess(boolean createProcess) {
        this.createProcess = createProcess;
    }
    public boolean isUploadProcess() {
        return this.uploadProcess;
    }
    
    public void setUploadProcess(boolean uploadProcess) {
        this.uploadProcess = uploadProcess;
    }
    public boolean isDeleteProcess() {
        return this.deleteProcess;
    }
    
    public void setDeleteProcess(boolean deleteProcess) {
        this.deleteProcess = deleteProcess;
    }
    public boolean isCreateAutoStart() {
        return this.createAutoStart;
    }
    
    public void setCreateAutoStart(boolean createAutoStart) {
        this.createAutoStart = createAutoStart;
    }
    public boolean isUploadAutoStart() {
        return this.uploadAutoStart;
    }
    
    public void setUploadAutoStart(boolean uploadAutoStart) {
        this.uploadAutoStart = uploadAutoStart;
    }
    public boolean isDeleteAutoStart() {
        return this.deleteAutoStart;
    }
    
    public void setDeleteAutoStart(boolean deleteAutoStart) {
        this.deleteAutoStart = deleteAutoStart;
    }
    public boolean isCreateAutoRequeriment() {
        return this.createAutoRequeriment;
    }
    
    public void setCreateAutoRequeriment(boolean createAutoRequeriment) {
        this.createAutoRequeriment = createAutoRequeriment;
    }
    public boolean isUploadAutoRequeriment() {
        return this.uploadAutoRequeriment;
    }
    
    public void setUploadAutoRequeriment(boolean uploadAutoRequeriment) {
        this.uploadAutoRequeriment = uploadAutoRequeriment;
    }
    public boolean isDeleteAutoRequeriment() {
        return this.deleteAutoRequeriment;
    }
    
    public void setDeleteAutoRequeriment(boolean deleteAutoRequeriment) {
        this.deleteAutoRequeriment = deleteAutoRequeriment;
    }
    public boolean isCreateNotice() {
        return this.createNotice;
    }
    
    public void setCreateNotice(boolean createNotice) {
        this.createNotice = createNotice;
    }
    public boolean isUploadNotice() {
        return this.uploadNotice;
    }
    
    public void setUploadNotice(boolean uploadNotice) {
        this.uploadNotice = uploadNotice;
    }
    public boolean isDeleteNotice() {
        return this.deleteNotice;
    }
    
    public void setDeleteNotice(boolean deleteNotice) {
        this.deleteNotice = deleteNotice;
    }
    public boolean isCreateTechnicalConcept() {
        return this.createTechnicalConcept;
    }
    
    public void setCreateTechnicalConcept(boolean createTechnicalConcept) {
        this.createTechnicalConcept = createTechnicalConcept;
    }
    public boolean isUploadTechnicalConcept() {
        return this.uploadTechnicalConcept;
    }
    
    public void setUploadTechnicalConcept(boolean uploadTechnicalConcept) {
        this.uploadTechnicalConcept = uploadTechnicalConcept;
    }
    public boolean isDeleteTechnicalConcept() {
        return this.deleteTechnicalConcept;
    }
    
    public void setDeleteTechnicalConcept(boolean deleteTechnicalConcept) {
        this.deleteTechnicalConcept = deleteTechnicalConcept;
    }
    public boolean isCreateResolution() {
        return this.createResolution;
    }
    
    public void setCreateResolution(boolean createResolution) {
        this.createResolution = createResolution;
    }
    public boolean isUploadResolution() {
        return this.uploadResolution;
    }
    
    public void setUploadResolution(boolean uploadResolution) {
        this.uploadResolution = uploadResolution;
    }
    public boolean isDeleteResolution() {
        return this.deleteResolution;
    }
    
    public void setDeleteResolution(boolean deleteResolution) {
        this.deleteResolution = deleteResolution;
    }
    public Set<Employees> getEmployeeses() {
        return this.employeeses;
    }
    
    public void setEmployeeses(Set<Employees> employeeses) {
        this.employeeses = employeeses;
    }

    public int getNumberFiles() {
        return this.numberFiles;
    }
    
    public void setNumberFiles(int numberFiles) {
        this.numberFiles = numberFiles;
    }
}


