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
import org.netbeans.xml.schema.checkdropclasses.CheckClasses;
import org.netbeans.xml.schema.dropclasses.DropStudentClasses;
import org.netbeans.xml.schema.dropclassinput.InputClasses;
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
    public CheckClasses isClassEnrolled(@WebParam(name = "classes") InputClasses classes) {
        CheckClasses returnedClasses=new CheckClasses();
      
        int studentid=classes.getStudentid();//get studentid for input;
        List<Integer> courseid=classes.getClassid();//get the list of input classes that need to be dropped from input
        
        returnedClasses.setStudentid(studentid);// set studentid
        for(int i=0;i<courseid.size();++i){
            CheckClasses.Classes course=new  CheckClasses.Classes();
            Oneenroll enrollment = daoservice.getStudentEnrollmentRecord(courseid.get(i), studentid); //get current class's enrollment info
             //if this class's status is not enroll or waitlist, student can't drop it, so set status as N
              if(!enrollment.getStatus().equals("enroll")&&!enrollment.getStatus().equals("waitlist")) course.setStatus("N");
              else course.setStatus("Y");
              
             course.setClassid(courseid.get(i));
             returnedClasses.getClasses().add(course); //add this course course list
             
        }
        
                //in this class, it includes student id, and course list including course id and its current status of "N" or "Y"
           return returnedClasses;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "studentDropClass")
    public DropStudentClasses studentDropClass(@WebParam(name = "inputClasses") CheckClasses inputClasses) {
        DropStudentClasses finalResult=new DropStudentClasses();
        finalResult.setStudentid(inputClasses.getStudentid()); //add student id
       
        for(int i=0;i<inputClasses.getClasses().size();++i){
           CheckClasses.Classes course=new CheckClasses.Classes();
           DropStudentClasses.ClassResult coursesResult=new DropStudentClasses.ClassResult();
           course=inputClasses.getClasses().get(i);
           if(course.getStatus().equals("N")){
               coursesResult.setClassid(course.getClassid());
               coursesResult.setResult("failed");
               coursesResult.setReason("this course is not under enroll status, nor waitlist status!");
           }else{// this course is able to be dropped
               daoservice.dropEnrolledClass(course.getClassid(),inputClasses.getStudentid());   // call daoservice to drop class
                coursesResult.setClassid(course.getClassid());
               coursesResult.setResult("success");
               coursesResult.setReason("");
           }
           finalResult.getClassResult().add(coursesResult); 
        }     
    return finalResult;
    }
    
  }
