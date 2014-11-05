/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upittis2739.courseregistration.logic;

import com.upittis2739.courseregistration.model.Permission;
import com.upittis2739.courseregistration.model.RegClass;
import com.upittis2739.courseregistration.model.Student;
import java.util.UUID;

/**
 *
 * @author riand_000
 */
public class PermissionLogic {

    public boolean varifyPermission(int Perms_ID, String varifyCode) {
        Permission permission = PermissionDBOperation.getPermissionById(Perms_ID);
        String oriVarifyCode = permission.getVarifyCode();
        return varifyCode.equals(oriVarifyCode);
    }

    public Permission generateVarifyCode(Student student, RegClass regClass) {
        Permission permission = new Permission();
        permission.setPerm_student(student);
        permission.setPerm_class(regClass);
        String varifyCode = student.getStu_ID().hashCode() * regClass.getCls_ID().hashCode() + "";
        permission.setVarifyCode(varifyCode);
        PermissionDBOperation.savePermission(permission);
        return permission;
    }

    public String generatePermissionCode(Permission permission) {
        UUID permissionCodeUUID = UUID.randomUUID();
        String permissionCode = permissionCodeUUID.toString();
        permission.setPermissionCode(permissionCode);
        PermissionDBOperation.upadtePermission(permission);
        return permissionCode;
    }
}
