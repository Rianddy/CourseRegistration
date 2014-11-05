/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upittis2739.courseregistration.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author riand_000
 */

@Entity
@Table(name="class")
public class RegClass implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Cls_ID;
    
    private Integer Cos_ID;
    
    private Integer Max_Size;
    
    private Integer Max_WaitList;
    
    private Integer Cur_Size;
    
    private Integer Cur_WaitList;
    
    private int Open_Sem_ID;
    
     @ManyToOne
    @JoinColumn(name = "Fac_ID", nullable = false)
    private Faculty faculty;

    public Integer getCls_ID() {
        return Cls_ID;
    }

    public void setCls_ID(Integer Cls_ID) {
        this.Cls_ID = Cls_ID;
    }

    public Integer getCos_ID() {
        return Cos_ID;
    }

    public void setCos_ID(Integer Cos_ID) {
        this.Cos_ID = Cos_ID;
    }


    public Integer getMax_Size() {
        return Max_Size;
    }

    public void setMax_Size(Integer Max_Size) {
        this.Max_Size = Max_Size;
    }

    public Integer getMax_WaitList() {
        return Max_WaitList;
    }

    public void setMax_WaitList(Integer Max_WaitList) {
        this.Max_WaitList = Max_WaitList;
    }

    public Integer getCur_Size() {
        return Cur_Size;
    }

    public void setCur_Size(Integer Cur_Size) {
        this.Cur_Size = Cur_Size;
    }

    public Integer getCur_WaitList() {
        return Cur_WaitList;
    }

    public void setCur_WaitList(Integer Cur_WaitList) {
        this.Cur_WaitList = Cur_WaitList;
    }

    public int getOpen_Sem_ID() {
        return Open_Sem_ID;
    }

    public void setOpen_Sem_ID(int Open_Sem_ID) {
        this.Open_Sem_ID = Open_Sem_ID;
    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

}
