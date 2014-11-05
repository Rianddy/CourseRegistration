/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upittis2739.courseregistration.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



/**
 *
 * @author riand_000
 */

@Entity
@Table(name="student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Stu_ID;
    
    private String Name;
    
    private String Email;
    
    private int Dep_ID;
    
    private int Maj_ID;
    
    private int Conc_ID;
    
    private Date Birthday;
    
    private String Address;
    
    private String Cell;

    public Integer getStu_ID() {
        return Stu_ID;
    }

    public void setStu_ID(Integer Stu_ID) {
        this.Stu_ID = Stu_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getDep_ID() {
        return Dep_ID;
    }

    public void setDep_ID(int Dep_ID) {
        this.Dep_ID = Dep_ID;
    }

    public int getMaj_ID() {
        return Maj_ID;
    }

    public void setMaj_ID(int Maj_ID) {
        this.Maj_ID = Maj_ID;
    }

    public int getConc_ID() {
        return Conc_ID;
    }

    public void setConc_ID(int Conc_ID) {
        this.Conc_ID = Conc_ID;
    }

    public Date getBirthday() {
        return Birthday;
    }

    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }
    
    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getCell() {
        return Cell;
    }

    public void setCell(String Cell) {
        this.Cell = Cell;
    }
    
    
}
