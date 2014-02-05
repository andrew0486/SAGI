package com.sagi.logic;
// Generated 03-feb-2014 12:00:45 by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Lands generated by hbm2java
 */
public class Lands  implements java.io.Serializable {


     private BigDecimal landId;
     private Locations locations;
     private String landName;
     private long landArea;
     private String landType;
     private String landStreetDirection;
     private String ownerName;
     private Set<Processes> processeses = new HashSet<Processes>(0);

    public Lands() {
    }

	
    public Lands(BigDecimal landId, Locations locations, String landName, long landArea, String landType, String landStreetDirection) {
        this.landId = landId;
        this.locations = locations;
        this.landName = landName;
        this.landArea = landArea;
        this.landType = landType;
        this.landStreetDirection = landStreetDirection;
    }
    public Lands(BigDecimal landId, Locations locations, String landName, long landArea, String landType, String landStreetDirection, String ownerName, Set<Processes> processeses) {
       this.landId = landId;
       this.locations = locations;
       this.landName = landName;
       this.landArea = landArea;
       this.landType = landType;
       this.landStreetDirection = landStreetDirection;
       this.ownerName = ownerName;
       this.processeses = processeses;
    }
   
    public BigDecimal getLandId() {
        return this.landId;
    }
    
    public void setLandId(BigDecimal landId) {
        this.landId = landId;
    }
    public Locations getLocations() {
        return this.locations;
    }
    
    public void setLocations(Locations locations) {
        this.locations = locations;
    }
    public String getLandName() {
        return this.landName;
    }
    
    public void setLandName(String landName) {
        this.landName = landName;
    }
    public long getLandArea() {
        return this.landArea;
    }
    
    public void setLandArea(long landArea) {
        this.landArea = landArea;
    }
    public String getLandType() {
        return this.landType;
    }
    
    public void setLandType(String landType) {
        this.landType = landType;
    }
    public String getLandStreetDirection() {
        return this.landStreetDirection;
    }
    
    public void setLandStreetDirection(String landStreetDirection) {
        this.landStreetDirection = landStreetDirection;
    }
    public String getOwnerName() {
        return this.ownerName;
    }
    
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    public Set<Processes> getProcesseses() {
        return this.processeses;
    }
    
    public void setProcesseses(Set<Processes> processeses) {
        this.processeses = processeses;
    }




}


