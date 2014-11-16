/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cmsc.model;

import webservice.prereqmeet.StudentClass;

/**
 *
 * @author riand_000
 */
public class RegClassInfo {
    private int classID;
    private boolean isFull;
    private boolean classValid;
    private StudentClass studentClass;

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public boolean isClassValid() {
        return classValid;
    }

    public void setClassValid(boolean classValid) {
        this.classValid = classValid;
    }

    public StudentClass getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(StudentClass studentClass) {
        this.studentClass = studentClass;
    }

    public boolean isIsFull() {
        return isFull;
    }

    public void setIsFull(boolean isFull) {
        this.isFull = isFull;
    }
    
    
}
