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
import org.netbeans.xml.schema.studentprereqcheck.StudentClass;
import org.netbeans.xml.schema.studentregcheck.ClassInfo;
import org.netbeans.xml.schema.studentregcheck.ClassList;
import org.netbeans.xml.schema.studentregcheck.StuRegCheckInfo;
import org.netbeans.xml.schema.studentregcheck.StudentInformation;
import team.soa.cms.ws.basicCheck.ClassCanRegisterService;
import team.soa.cms.ws.basicCheck.ClassValidService;
import team.soa.cms.ws.basicCheck.PrereqMeetService;
import team.soa.cms.ws.basicCheck.StudentValidService;
import team.soa.cms.ws.daoService.DAOService;

/**
 *
 * @author xmrui_000
 */
@WebService(serviceName = "RegCheckService")
public class RegCheckService {
    
    ClassCanRegisterService canRegister = new ClassCanRegisterService();
    ClassValidService classValid = new ClassValidService();
    StudentValidService studenValid = new StudentValidService();
    PrereqMeetService prereqMeet = new PrereqMeetService();
    DAOService daoService = new DAOService();

   @WebMethod(operationName = "checkStudentRegistration")
    public StuRegCheckInfo checkStudentRegistration(@WebParam(name = "Stu_ID") int Stu_ID, @WebParam(name = "Class_ID_List") List<Integer> ClsIdList) {

        StuRegCheckInfo info = new StuRegCheckInfo();
        ClassList clsList = new ClassList();
        
        StudentInformation stu = new StudentInformation();
        StudentClass stucls = new StudentClass();

        boolean stuValid = studenValid.studentIsValid(Stu_ID);

        if (stuValid) {
            stu.setStudentid(String.valueOf(Stu_ID));
            stu.setValid(stuValid);
            stu.setEmail("xxx@pitt.edu");
            info.setStudentInfo(stu);
        } else {
            stu.setValid(stuValid);
        }

        for (Integer Class_ID : ClsIdList) {
            boolean clsValid = classValid.classIsValid(Class_ID);
            if (clsValid) {
                ClassInfo cls = new ClassInfo();
                Integer classStatus = canRegister.classRegisterLeftSpace(Class_ID);
                cls.setClassid(String.valueOf(Class_ID));
                cls.setClassvalid(clsValid);
                cls.setClassstatus(String.valueOf(classStatus));
                stucls = prereqMeet.studentMeetsPrereq(Stu_ID, Class_ID);              
                cls.setCanTake(stucls.isCanTake()); //waitng one more operation;
                if(classStatus>0&&stucls.isCanTake()){
                    daoService.insertStudentEnrollment(String.valueOf(Stu_ID), String.valueOf(Class_ID));
                }
                System.out.print(cls.getClassid() + " " + cls.getClassstatus());

                //clsList.setClazz(cls);
                clsList.getClazz().add(cls);
            }
        }

        info.setClazzInfo(clsList);

        System.out.print(info.getStudentInfo());
        return info;

    }
}
