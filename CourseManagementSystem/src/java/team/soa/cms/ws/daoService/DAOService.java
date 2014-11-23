/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.ws.daoService;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.netbeans.xml.schema.facultyxmlschema.Faculty;
import org.netbeans.xml.schema.permissionxmlschema.Permission;
import org.netbeans.xml.schema.prerequestxmlschema.Prerequestment;
import org.netbeans.xml.schema.studentxmlschema.Student;
import org.netbeans.xml.schema.stuenrolxmlschema.StuEnrollList;
import org.netbeans.xml.schema.stuenrolxmlschema.StuEnrollList.Oneenroll;
import team.soa.cms.dao.ClassDAO;
import team.soa.cms.dao.FacultyDAO;
import team.soa.cms.dao.Implement.ClassDAOImpl;
import team.soa.cms.dao.Implement.FacultyDAOImpl;
import team.soa.cms.dao.Implement.PermissionDAOImpl;
import team.soa.cms.dao.Implement.PrerequestmentDAOImpl;
import team.soa.cms.dao.Implement.StudentDAOImpl;
import team.soa.cms.dao.Implement.StudentEnrollDAOImpl;
import team.soa.cms.dao.PermissionDAO;
import team.soa.cms.dao.PrerequestmentDAO;
import team.soa.cms.dao.StudentDAO;
import team.soa.cms.dao.StudentEnrollDAO;

/**
 *
 * @author birui, edited by Kevin
 */
@WebService(serviceName = "DAOService")
public class DAOService {

     @WebMethod(operationName = "getStudentInfo")
    public Student getStudentInfo(@WebParam(name = "Stu_ID") final int Stu_ID) {
        StudentDAO stuDAO = new StudentDAOImpl();
        Student stu =stuDAO.getOneStudent(Stu_ID);
        System.out.println("Service success!");
        return stu;
    }
    
    @WebMethod(operationName = "getClassInfo")
    public org.netbeans.xml.schema.classxmlschema.Class getClassInfo(@WebParam(name="Class_ID") final int Class_ID){
        ClassDAO classDAO = new ClassDAOImpl();
        org.netbeans.xml.schema.classxmlschema.Class cls = classDAO.getOneClass(Class_ID);
        System.out.println("Service success!");
        return cls;
    }
    
    @WebMethod(operationName = "getFacultyEmail")
    public String getFacultyEmail(@WebParam(name="Class_ID") final int Class_ID){
        ClassDAO classDAO = new ClassDAOImpl();
        String email = classDAO.getFacultyEmailFromClass(Class_ID);
        System.out.println("Service success!");
        return email;
    }
    
    
    @WebMethod(operationName = "getFacultyInfo")
    public Faculty getFacultyInfo(@WebParam(name="Fac_ID") final int Fac_ID){
        FacultyDAO facultyDAO = new FacultyDAOImpl();
        Faculty fac = facultyDAO.getOneFaculty(Fac_ID);
        System.out.println("Service success!");
        return fac;
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
    @WebMethod(operationName = "insertStudentEnrollmentWithStatus")
    public int insertStudentEnrollmentWithStatus(@WebParam(name = "Student_ID") String Student_ID, @WebParam(name = "Class_ID") String Class_ID, @WebParam(name = "Status") String Status) {
        StudentEnrollDAO stuEnrollDAO = new StudentEnrollDAOImpl();
        int enroll_ID = stuEnrollDAO.insertIDStatus(Integer.parseInt(Class_ID), Integer.parseInt(Student_ID), Status);
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateClassInfo")
    public Boolean updateClassInfo(@WebParam(name = "Class_ID") int Class_ID, @WebParam(name = "Cls") org.netbeans.xml.schema.classxmlschema.Class Cls) {
      
        boolean result = false;
        try{
         ClassDAOImpl classDaoImpl = new ClassDAOImpl();
         classDaoImpl.update(Class_ID, Cls);
         result = true;
        }catch(Exception e){
          result = false;
        }
        return result;
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "dropEnrolledClass")
    public void dropEnrolledClass(@WebParam(name = "courseid") int classid,@WebParam(name = "studentid") int studentid) {
        StudentEnrollDAO stuEnrollDAO = new StudentEnrollDAOImpl();
        stuEnrollDAO.dropEnrolledClass(classid,studentid);
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getStudentEnrollmentRecord")  //to get specific record in the studentEnrollment table
    public Oneenroll getStudentEnrollmentRecord(@WebParam(name = "studentid") int studentid, @WebParam(name = "courseid") int classid) {
        StudentEnrollDAO stuEnrollDAO = new StudentEnrollDAOImpl();
        return stuEnrollDAO.getOneEnrollmentInfo(studentid,classid);
    }
    
     /**
     * Web service operation
     */
    @WebMethod(operationName = "getOnePermissionInfo")
    public Permission getOnePermissionInfo(@WebParam(name = "permission_id") int permission_id) {
        PermissionDAO perDAO = new PermissionDAOImpl();
        return perDAO.getOnePermissionInfo(Integer.valueOf(permission_id));
    }
}
