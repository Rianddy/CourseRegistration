/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.netbeans.xml.schema.classxmlschema.Class;
import org.netbeans.xml.schema.prerequestxmlschema.Prerequestment;
import org.netbeans.xml.schema.studentxmlschema.Student;
import org.netbeans.xml.schema.stuenrolxmlschema.StuEnrollList;
import team.soa.cms.dao.ClassDAO;
import team.soa.cms.dao.Implement.ClassDAOImpl;
import team.soa.cms.dao.Implement.PrerequestmentDAOImpl;
import team.soa.cms.dao.Implement.StudentDAOImpl;
import team.soa.cms.dao.Implement.StudentEnrollDAOImpl;
import team.soa.cms.dao.PrerequestmentDAO;
import team.soa.cms.dao.StudentDAO;
import team.soa.cms.dao.StudentEnrollDAO;


/**
 *
 * @author Edison
 */
@WebService(serviceName = "CMS_WebServices")
public class CMS_WebServices {

    @WebMethod(operationName = "getStudentInfo")
    public Student getStudentInfo(@WebParam(name = "Stu_ID") final int Stu_ID) {
        StudentDAO stuDAO = new StudentDAOImpl();
        Student stu =stuDAO.getOneStudent(Stu_ID);
        return stu;
    }
    
    @WebMethod(operationName = "getClassInfo")
    public Class getClassInfo(@WebParam(name="Class_ID") final int Class_ID){
        ClassDAO classDAO = new ClassDAOImpl();
        Class cls = classDAO.getOneClass(Class_ID);
        return cls;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "insertStudentEnrollment")
    public String insertStudentEnrollment(@WebParam(name = "Student_ID") String Student_ID, @WebParam(name = "Class_ID") String Class_ID) {
        StudentEnrollDAO stuEnrollDAO = new StudentEnrollDAOImpl();
        String enroll_ID = stuEnrollDAO.insert(Integer.parseInt(Class_ID), Integer.parseInt(Student_ID));
        return enroll_ID;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getStudentEnrollment")
    public StuEnrollList getStudentEnrollment(@WebParam(name = "Student_ID") String Student_ID) {
        StudentEnrollDAO stuEnrollDAO = new StudentEnrollDAOImpl();
        return stuEnrollDAO.getStudentEnrollment(Integer.parseInt(Student_ID));
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "cgetClassPrerequisite")
    public Prerequestment cgetClassPrerequisite(@WebParam(name = "Class_ID") String Class_ID) {
        PrerequestmentDAO preDAO = new PrerequestmentDAOImpl();
        return preDAO.getPrerequestmentByClassId(Integer.parseInt(Class_ID));
        //TODO write your implementation code here: 
    }
    
    
    
}
