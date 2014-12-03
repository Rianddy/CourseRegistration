/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.ws;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.netbeans.xml.schema.coursexmlschema.Course;
import org.netbeans.xml.schema.stuenrolxmlschema.StuEnrollList;
import team.soa.cms.ws.daoService.DAOService;

/**
 *
 * @author zhouyizhou
 */
@WebService(serviceName = "StudentEnrollmentService")
public class StudentEnrollmentService {
    DAOService daoservice = new DAOService();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getStudentEnrollList")
    public StuEnrollList getStudentEnrollList(@WebParam(name = "Stu_ID") String Stu_ID) {
        StuEnrollList stuEnrollList = new StuEnrollList();
        stuEnrollList = daoservice.getStudentEnrollment(Stu_ID);
        return stuEnrollList;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllCourses")
    public List<Course> getAllCourses() {
        //TODO write your implementation code here:
        List<Course> courses = new ArrayList<Course>();
        courses = daoservice.getAllCourses();
        return courses;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getAllClasses")
    public List<org.netbeans.xml.schema.classxmlschema.Class> getAllClasses() {
        //TODO write your implementation code here:
        List<org.netbeans.xml.schema.classxmlschema.Class> classes = new ArrayList<org.netbeans.xml.schema.classxmlschema.Class>();
        classes = daoservice.getAllClasses();
        for (int i=0; i<classes.size(); i++) {
            System.out.println("class id: " + classes.get(i).getClassid());
        }
        return classes;
    }

    
}
