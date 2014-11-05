/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upittis2739.courseregistration.logic;

import com.upittis2739.courseregistration.common.HinberateUtill;
import com.upittis2739.courseregistration.model.Student;
import org.hibernate.Session;

/**
 *
 * @author riand_000
 */
public class StudentDBOperation {

    public static Student getStudentById(int Stu_ID) {

        Session session = HinberateUtill.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        return (Student) session.get(Student.class, Stu_ID);
    }
}
