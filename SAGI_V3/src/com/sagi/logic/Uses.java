package com.sagi.logic;
// Generated 03-feb-2014 12:00:45 by Hibernate Tools 3.2.1.GA


import java.util.HashSet;
import java.util.Set;

/**
 * Uses generated by hbm2java
 */
public class Uses  implements java.io.Serializable {


     private int useId;
     private String useName;
     private Set<UseDescription> useDescriptions = new HashSet<UseDescription>(0);

    public Uses() {
    }

	
    public Uses(int useId, String useName) {
        this.useId = useId;
        this.useName = useName;
    }
    public Uses(int useId, String useName, Set<UseDescription> useDescriptions) {
       this.useId = useId;
       this.useName = useName;
       this.useDescriptions = useDescriptions;
    }
   
    public int getUseId() {
        return this.useId;
    }
    
    public void setUseId(int useId) {
        this.useId = useId;
    }
    public String getUseName() {
        return this.useName;
    }
    
    public void setUseName(String useName) {
        this.useName = useName;
    }
    public Set<UseDescription> getUseDescriptions() {
        return this.useDescriptions;
    }
    
    public void setUseDescriptions(Set<UseDescription> useDescriptions) {
        this.useDescriptions = useDescriptions;
    }




}


