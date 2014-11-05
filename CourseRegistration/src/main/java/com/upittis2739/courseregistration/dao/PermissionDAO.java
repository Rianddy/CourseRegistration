/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upittis2739.courseregistration.dao;

import com.upittis2739.courseregistration.model.Permission;

/**
 *
 * @author riand_000
 */
public interface PermissionDAO {
    public boolean validPermission(Permission permission, String unicode);
}
