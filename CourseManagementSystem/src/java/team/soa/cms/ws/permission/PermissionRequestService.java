/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.ws.permission;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.netbeans.xml.schema.stuclassmessagexmlschema.Stuclassmessage;
import org.netbeans.xml.schema.stuclassmessagexmlschema.Stuclassmessage.RequestClass;
import org.netbeans.xml.schema.stuclassmessagexmlschema.Stuclassmessage.Studentinfo;
import org.netbeans.xml.schema.studentregcheck.StudentInformation;
import org.netbeans.xml.schema.studentregcheck.ClassInfo;
import org.netbeans.xml.schema.studentxmlschema.Student;
/**
 *
 * @author birui
 */
@WebService(serviceName = "PermissionRequestService")
public class PermissionRequestService {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "PrereqMsgQueue")
    public String PrereqMsgQueue(@WebParam(name = "stu1") Student stu1, @WebParam(name = "classInfo1")ClassInfo classInfo1) {
        Stuclassmessage stuClassMessage = new Stuclassmessage();
        Studentinfo stu2 = new Studentinfo();
        convertStudent(stu1, stu2);
        RequestClass classInfo2 = new RequestClass();
        convertClassInfo(classInfo1,classInfo2);
        int permId = stu2.getStuid().hashCode()*classInfo2.getClassid().hashCode();
        
        return String.valueOf(permId);
    }
    
    private void convertStudent(Student stu1, Studentinfo stu2){
        stu2.setAddress(stu1.getAddress());
        stu2.setCell(stu1.getCell());
        stu2.setConcentration(stu1.getConcentration());
        stu2.setDepartment(stu1.getDepartment());
        stu2.setMajor(stu1.getMajor());
        stu2.setStuname(stu1.getName());
        stu2.setStuemail(stu1.getEmail());
        stu2.setStuid(stu1.getStuid());
    } 
    
    private void convertClassInfo(ClassInfo classInfo1, RequestClass classInfo2){
        classInfo2.setClassid(classInfo1.getClassid());
        classInfo2.setClassstatus(classInfo1.getClassstatus());
        for(org.netbeans.xml.schema.studentregcheck.ClassPrereq prereqClass: classInfo1.getPrereqClasses()){
            org.netbeans.xml.schema.stuclassmessagexmlschema.ClassPrereq prereqClass2 = new org.netbeans.xml.schema.stuclassmessagexmlschema.ClassPrereq();
            prereqClass2.setClassid(prereqClass.getClassid());
            prereqClass2.setCourseid(prereqClass.getCourseid());
            prereqClass2.setGrade(prereqClass.getGrade());
            prereqClass2.setReqMet(prereqClass.isReqMet());
            classInfo2.getPrereqClasses().add(prereqClass2);
        }
    } 

    /**
     * This is a sample web service operation
     */
    
}
