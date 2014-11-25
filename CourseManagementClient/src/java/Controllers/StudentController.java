/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import webservice.basic.Student;

/**
 *
 * @author riand_000
 */
public class StudentController {

    public static Boolean studentIsValid(int stuID) {
        webservice.checkstudent.StudentValidService_Service service = new webservice.checkstudent.StudentValidService_Service();
        webservice.checkstudent.StudentValidService port = service.getStudentValidServicePort();
        return port.studentIsValid(stuID);
    }

    public static Student getStudentInfo(int stuID) {
        webservice.basic.DAOService_Service service = new webservice.basic.DAOService_Service();
        webservice.basic.DAOService port = service.getDAOServicePort();
        return port.getStudentInfo(stuID);
    }
    
    
    
}
