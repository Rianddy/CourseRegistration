package com.upittis2739.courseregistration.logic;

import com.upittis2739.courseregistration.model.Student;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author riand_000
 */
public class StudentLogic {
    public Student getStudentById(int Stu_ID) {
        return StudentDBOperation.getStudentById(Stu_ID);
    }
}
