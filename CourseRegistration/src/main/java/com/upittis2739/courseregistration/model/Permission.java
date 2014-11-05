/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upittis2739.courseregistration.model;

import com.upittis2739.courseregistration.coomon.Constants;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author riand_000
 */
@Entity
@Table(name = "student")
public class Permission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Perms_ID;

    @ManyToOne
    @JoinColumn(name = "Cls_ID", nullable = false)
    private Class perm_class;
    
    @ManyToOne
    @JoinColumn(name = "Stu_ID", nullable = false)
    private Class perm_student;
    
    @Enumerated(EnumType.STRING)
    private Constants.perm_status Status;

    public Integer getPerms_ID() {
        return Perms_ID;
    }

    public void setPerms_ID(Integer Perms_ID) {
        this.Perms_ID = Perms_ID;
    }

    public Class getPerm_class() {
        return perm_class;
    }

    public void setPerm_class(Class perm_class) {
        this.perm_class = perm_class;
    }

    public Class getPerm_student() {
        return perm_student;
    }

    public void setPerm_student(Class perm_student) {
        this.perm_student = perm_student;
    }

    public Constants.perm_status getStatus() {
        return Status;
    }

    public void setStatus(Constants.perm_status Status) {
        this.Status = Status;
    }
    
    
}
