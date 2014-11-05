/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upittis2739.courseregistration.model;

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
@Table(name = "faculty")
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Fac_ID;

    private String Name;

    private boolean Status;

    private String Email;

    private String Cell;

    private int Dep_ID;

    public Integer getFac_ID() {
        return Fac_ID;
    }

    public void setFac_ID(Integer Fac_ID) {
        this.Fac_ID = Fac_ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean Status) {
        this.Status = Status;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCell() {
        return Cell;
    }

    public void setCell(String Cell) {
        this.Cell = Cell;
    }

    public int getDep_ID() {
        return Dep_ID;
    }

    public void setDep_ID(int Dep_ID) {
        this.Dep_ID = Dep_ID;
    }

}
