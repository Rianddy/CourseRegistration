/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.ws.permission;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.WebParam;
import org.netbeans.xml.schema.studentprereqcheck.StudentClass;
import org.netbeans.xml.schema.studentregcheck.ClassInfo;
import org.netbeans.xml.schema.studentregcheck.ClassList;
import org.netbeans.xml.schema.studentregcheck.StuRegCheckInfo;
import org.netbeans.xml.schema.studentregcheck.StudentInformation;
import team.soa.cms.ws.basicCheck.ClassCanRegisterService;
import team.soa.cms.ws.basicCheck.ClassValidService;
import team.soa.cms.ws.basicCheck.PrereqMeetService;
import team.soa.cms.ws.basicCheck.StudentValidService;

/**
 *
 * @author YIYI
 */
@WebService(serviceName = "CheckStudentRegistration")
public class CheckStudentRegistration {

    ClassCanRegisterService canRegister = new ClassCanRegisterService();
    ClassValidService classValid = new ClassValidService();
    StudentValidService studenValid = new StudentValidService();
    PrereqMeetService prereqMeet = new PrereqMeetService();
    CheckPermissionCode checkCode = new CheckPermissionCode();
    /**
     * Web service operation
     * @param studentID
     * @param ClsIdList
     * @param PermsIdList
     * @return StuRegCheckInfo 
     */
    @WebMethod(operationName = "checkStudentRegistration")
    public StuRegCheckInfo checkStudentRegistration(@WebParam(name = "studentID") int studentID, @WebParam(name = "ClsIdList") List<Integer> ClsIdList, @WebParam(name = "PermsIdList") List<Integer> PermsIdList) {
      
          StuRegCheckInfo info = new StuRegCheckInfo();
          ClassList clsList = new ClassList();
          StudentInformation stu = new StudentInformation();
          StudentClass stucls = new StudentClass();

          boolean stuValid = studenValid.studentIsValid(studentID);

          stu.setValid(stuValid);

          if (stuValid) {
            stu.setStudentid(String.valueOf(studentID));
            stu.setEmail("xxx@pitt.edu");
            info.setStudentInfo(stu);
           } 

          
          
          
          for (Integer Class_ID : ClsIdList) {
              //for each class in ClsIdList
              
            boolean clsValid = classValid.classIsValid(Class_ID);
            if (clsValid) {
            
                ClassInfo cls = new ClassInfo();
          
                for(Integer permcode: PermsIdList){
                
                    boolean codeIsValid = checkCode.checkPermissionCode(studentID, Class_ID, permcode);
                
                    if(codeIsValid){
                      //skip the call to classCanRegister (classRegisterLeftSpace) and studentMeetsPrereq if checkPermissionCode call returns true
                        cls.setClassid(String.valueOf(Class_ID));
                        cls.setClassvalid(clsValid);
                    
                    }else{
                    
                        Integer classStatus = canRegister.classRegisterLeftSpace(Class_ID);
                        cls.setClassid(String.valueOf(Class_ID));
                        cls.setClassvalid(clsValid);
                        cls.setClassstatus(String.valueOf(classStatus));
                        stucls = prereqMeet.studentMeetsPrereq(studentID, Class_ID);              
                        cls.setCanTake(stucls.isCanTake()); //waitng one more operation;
                        System.out.print(cls.getClassid() + " " + cls.getClassstatus());

                    }
                }
                
                clsList.getClazz().add(cls);
            }
        }

        info.setClazzInfo(clsList);

        System.out.print(info.getStudentInfo());
        return info;
        
        
    }
}























