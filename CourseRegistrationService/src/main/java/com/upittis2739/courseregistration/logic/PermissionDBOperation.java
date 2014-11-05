/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upittis2739.courseregistration.logic;

import com.upittis2739.courseregistration.common.HinberateUtill;
import com.upittis2739.courseregistration.model.Permission;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author riand_000
 */
public class PermissionDBOperation {
    public static void savePermission(Permission permission) {
        Session session = HinberateUtill.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(permission);
        transaction.commit();
    }

    
    public static void upadtePermission(Permission permission) {
        Session session = HinberateUtill.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.update(permission);
        transaction.commit();
    }

    
    public static Permission getPermissionById(int Perms_ID) {
        Session session = HinberateUtill.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        return (Permission) session.get(Permission.class, Perms_ID);
    }

}
