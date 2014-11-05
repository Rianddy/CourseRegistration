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
import javax.persistence.Table;

/**
 *
 * @author riand_000
 */

@Entity
@Table(name="student")
public class Class implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Cls_ID;
    
    private Integer Cod_ID;
    
    private Integer Max_Size;
    
    private Integer Max_WaitList;
    
    private Integer Cur_Size;
    
    private Integer Cur_WaitList;
    
    private int Open_Sem_ID;
    
    private int Fac_ID;

    public Integer getCls_ID() {
        return Cls_ID;
    }

    public void setCls_ID(Integer Cls_ID) {
        this.Cls_ID = Cls_ID;
    }

    public Integer getCod_ID() {
        return Cod_ID;
    }

    public void setCod_ID(Integer Cod_ID) {
        this.Cod_ID = Cod_ID;
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

    public int getFac_ID() {
        return Fac_ID;
    }

    public void setFac_ID(int Fac_ID) {
        this.Fac_ID = Fac_ID;
    }
    
    
}
