/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.ws;

import java.util.HashMap;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.netbeans.xml.schema.checkdropclasses.CheckClasses;
import org.netbeans.xml.schema.dropclasses.DropStudentClasses;
import org.netbeans.xml.schema.dropclasses.DropStudentClasses.ClassResult;
import org.netbeans.xml.schema.studentinwaitlist.Waitlist;
import org.netbeans.xml.schema.studentinwaitlist.Waitlist.Student;
import org.netbeans.xml.schema.stuenrolxmlschema.StuEnrollList;
import org.netbeans.xml.schema.stuenrolxmlschema.StuEnrollList.Oneenroll;
import team.soa.cms.ws.daoService.DAOService;

/**
 *
 * @author Yaping Chen
 */
@WebService(serviceName = "getWaitlist")
public class getWaitlist {
    DAOService daoservice = new DAOService();

    /**
     * Web service operation
     */
    @WebMethod(operationName = "operation")
    public Waitlist operation(@WebParam(name = "droppedClassesInfo") DropStudentClasses droppedClassesInfo,@WebParam(name = "classes") CheckClasses classes) {
      
        List<ClassResult> classesInfo=droppedClassesInfo.getClassResult(); /*get current student's dropped classInfo. 
                                                                             It includes all successful and unsuccessful results*/
        Waitlist wi=new Waitlist();
        List<Student> stus=wi.getStudent();
        //covert to hashmap to make search status convenient
          HashMap<Integer,String> classStatus = new HashMap<Integer,String>();
            for (CheckClasses.Classes checkClass :classes.getClasses()){
                classStatus.put(checkClass.getClassid(),checkClass.getStatus());
            }
        for(int i=0;i<classesInfo.size();++i){
            Oneenroll firstStudent=new Oneenroll();
            //only student dropped class successfully, we have to consider about getting information from waitlist
            String status=(String)classStatus.get(classesInfo.get(i).getClassid()); //get dropped class's status, only it's enroll status, we do operations
            if(classesInfo.get(i).getResult().equals("success")&&status.equals("ENROLL")){
               firstStudent= daoservice.firstStudentInWaitlist(classesInfo.get(i).getClassid(), "waitlist");
               //there is student in waitlist for this class
               if(firstStudent!=null){
                   Student st=new Student(); // Student class is for waitlist
                   String email= daoservice.getStudentInfo(Integer.parseInt(firstStudent.getStuid())).getEmail();
                   st.setClassID(firstStudent.getClassid());
                   st.setStudentID(firstStudent.getStuid());
                   st.setEmail(email);
                   stus.add(st);
                   daoservice.updateStuEnroll(Integer.parseInt(st.getStudentID()), Integer.parseInt(st.getClassID()));
               } 
            }
        }
        
        return wi;
    }

}
