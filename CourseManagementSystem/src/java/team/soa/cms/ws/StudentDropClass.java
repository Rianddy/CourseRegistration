/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import org.netbeans.xml.schema.checkdropclasses.CheckClasses;
import org.netbeans.xml.schema.dropclasses.DropStudentClasses;
import org.netbeans.xml.schema.dropclassinput.DropClassesInput;
import org.netbeans.xml.schema.stuenrolxmlschema.StuEnrollList;
import org.netbeans.xml.schema.stuenrolxmlschema.StuEnrollList.Oneenroll;
import team.soa.cms.ws.daoService.DAOService;

/**
 *
 * Created by Yaping Chen ,Edited by Zhefeng Chen
 */
@WebService(serviceName = "StudentDropClass")
public class StudentDropClass {
DAOService daoservice = new DAOService();

     /**
     * Web service operation 
     * 
     */
    @WebMethod(operationName = "isClassEnrolled")
    public CheckClasses isClassEnrolled(@WebParam(name = "classes") DropClassesInput classes) {
        CheckClasses returnedClasses=new CheckClasses();
        
        int studentid=classes.getStudentid();//get studentid for input;
        List<Integer> classIds=classes.getClassIds();//get the list of input classes that need to be dropped from input
        
        /*for (int classId :classIds){
            System.out.println("*****"+classId+"*****");
        }*/
        returnedClasses.setStudentid(studentid);// set studentid
        
        for(int i=0;i<classIds.size();++i){
            CheckClasses.Classes oneclass=new  CheckClasses.Classes();
            Oneenroll enrollment = daoservice.getStudentEnrollmentRecord(classIds.get(i), studentid); //get current class's enrollment info
             //if this class's status is not enroll or waitlist, student can't drop it, so set status as N
            if (enrollment==null){
                oneclass.setStatus("cannotDrop");
            }  
            else if(enrollment.getStatus().equals("enroll")||enrollment.getStatus().equals("waitlist")){
                oneclass.setStatus("canDrop");
            }else{
                oneclass.setStatus("finished");
            }
            oneclass.setClassid(classIds.get(i));
            returnedClasses.getClasses().add(oneclass); //add this course course list
        }
        
        //in this class, it includes student id, and course list including course id and its current status of "N" or "Y"
        return returnedClasses;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "studentDropClass")
    public DropStudentClasses studentDropClass(@WebParam(name = "inputClasses") CheckClasses classesStatus) {
        DropStudentClasses finalResult=new DropStudentClasses();
        finalResult.setStudentid(classesStatus.getStudentid()); //add student id
       
        for(int i=0;i<classesStatus.getClasses().size();++i){
           CheckClasses.Classes oneClass=new CheckClasses.Classes();
           DropStudentClasses.ClassResult coursesResult=new DropStudentClasses.ClassResult();
           oneClass=classesStatus.getClasses().get(i);
           if(oneClass.getStatus().equals("cannotDrop")){
               coursesResult.setClassid(oneClass.getClassid());
               coursesResult.setResult("failed");
               coursesResult.setReason("this course is not under enroll status, nor waitlist status!");
           }else if (oneClass.getStatus().equalsIgnoreCase("finished")){
               coursesResult.setClassid(oneClass.getClassid());
               coursesResult.setResult("failed");
               coursesResult.setReason("You hava already finished this class");
           }else{// this course is able to be dropped
               daoservice.dropEnrolledClass(oneClass.getClassid(),classesStatus.getStudentid());   // call daoservice to drop class
               coursesResult.setClassid(oneClass.getClassid());
               coursesResult.setResult("success");
               coursesResult.setReason("You have successfully drop the class");
           }
           finalResult.getClassResult().add(coursesResult); 
        }     
        return finalResult;
    }
    
  }
