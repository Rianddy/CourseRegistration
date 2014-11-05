/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upittis2739.courseregistration.model;

import com.upittis2739.courseregistration.common.Constants;
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
@Table(name = "permission")
public class Permission implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Perms_ID;

    @ManyToOne
    @JoinColumn(name = "Cls_ID", nullable = false)
    private RegClass perm_class;
    
    @ManyToOne
    @JoinColumn(name = "Stu_ID", nullable = false)
    private Student perm_student;
    
    @Enumerated(EnumType.STRING)
    private Constants.perm_status Status;
    
    private String VarifyCode;
    
    private String PermissionCode;

    public Integer getPerms_ID() {
        return Perms_ID;
    }

    public void setPerms_ID(Integer Perms_ID) {
        this.Perms_ID = Perms_ID;
    }

    public RegClass getPerm_class() {
        return perm_class;
    }

    public void setPerm_class(RegClass perm_class) {
        this.perm_class = perm_class;
    }

    public Student getPerm_student() {
        return perm_student;
    }

    public void setPerm_student(Student perm_student) {
        this.perm_student = perm_student;
    }


    public Constants.perm_status getStatus() {
        return Status;
    }

    public void setStatus(Constants.perm_status Status) {
        this.Status = Status;
    }

    public String getVarifyCode() {
        return VarifyCode;
    }

    public void setVarifyCode(String VarifyCode) {
        this.VarifyCode = VarifyCode;
    }

    public String getPermissionCode() {
        return PermissionCode;
    }

    public void setPermissionCode(String PermissionCode) {
        this.PermissionCode = PermissionCode;
    }
    
}
