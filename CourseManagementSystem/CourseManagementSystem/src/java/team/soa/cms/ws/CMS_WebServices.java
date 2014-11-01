/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.netbeans.xml.schema.studentxmlschema.Student;
import org.netbeans.xml.schema.classxmlschema.Class;
import team.soa.cms.dao.ClassDAO;
import team.soa.cms.dao.Implement.ClassDAOImpl;
import team.soa.cms.dao.Implement.StudentDAOImpl;
import team.soa.cms.dao.StudentDAO;


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
}
