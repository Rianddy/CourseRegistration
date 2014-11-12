/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.ws;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import  org.netbeans.xml.schema.classxmlschema.Class;
import org.netbeans.xml.schema.stuenrolxmlschema.StuEnrollList;
import org.netbeans.xml.schema.stuenrolxmlschema.StuEnrollList.Oneenroll;
import team.soa.cms.ws.daoService.DAOService;

/**
 *
 * @author seven
 */
@WebService(serviceName = "StudentDropClass")
public class StudentDropClass {
DAOService daoservice = new DAOService();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "isClassEnrolled")
    public int isClassEnrolled(@WebParam(name = "studentID") String studentID, @WebParam(name = "classID") int classID,@WebParam(name = "status") String status) {
         StuEnrollList enrolledClasses = daoservice.getStudentEnrollment(studentID);        
    int Stu_Enroll_ID=-1;
   List<Oneenroll> enrolls=enrolledClasses.getOneenroll();
   for(int i=0;i<enrolls.size();++i){
       if(Integer.parseInt(enrolls.get(i).getClassid())==classID && enrolls.get(i).getStatus().equals(status)) {
           Stu_Enroll_ID=Integer.parseInt(enrolls.get(i).getStuenrollid());
           break;
       }
   }
   
   
   return Stu_Enroll_ID; // return stu_enroll_id;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "studentDropClass")
    public Boolean studentDropClass(@WebParam(name = "Stu_Enroll_ID") int Stu_Enroll_ID) {
         return daoservice.dropEnrolledClass(Stu_Enroll_ID);       
       
    }
    
  }
