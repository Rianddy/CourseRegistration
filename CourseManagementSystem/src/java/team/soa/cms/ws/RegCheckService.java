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
import org.netbeans.xml.schema.permissionxmlschema.Permission;
import org.netbeans.xml.schema.studentprereqcheck.StudentClass;
import org.netbeans.xml.schema.studentregcheck.ClassInfo;
import org.netbeans.xml.schema.studentregcheck.ClassList;
import org.netbeans.xml.schema.studentregcheck.StuRegCheckInfo;
import org.netbeans.xml.schema.studentregcheck.StudentInformation;
import team.soa.cms.msgQueueService.ServicesQueueService;
import team.soa.cms.ws.basicCheck.ClassCanRegisterService;
import team.soa.cms.ws.basicCheck.ClassValidService;
import team.soa.cms.ws.basicCheck.PrereqMeetService;
import team.soa.cms.ws.basicCheck.StudentValidService;
import team.soa.cms.ws.daoService.DAOService;
import team.soa.cms.ws.permission.PermissionRequestService;

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
    PermissionRequestService permissionRequestService = new PermissionRequestService();
    ServicesQueueService servicesQueueService = new ServicesQueueService();

    @WebMethod(operationName = "checkStudentRegistration")
    public StuRegCheckInfo checkStudentRegistration(@WebParam(name = "Stu_ID") int Stu_ID, @WebParam(name = "Class_ID_List") List<Integer> ClsIdList, @WebParam(name = "Premission_Code_List") List<Integer> PremissionCodeList) {

        StuRegCheckInfo info = new StuRegCheckInfo();
        ClassList clsList = new ClassList();

        StudentInformation stu = new StudentInformation();
        StudentClass stucls = new StudentClass();

        boolean stuValid = studenValid.studentIsValid(Stu_ID);
        org.netbeans.xml.schema.studentxmlschema.Student stu2 = new org.netbeans.xml.schema.studentxmlschema.Student();
        if (stuValid) {
            stu2 = daoService.getStudentInfo(Stu_ID);
            converStuinfo(stu, stu2);
            stu.setStudentid(String.valueOf(Stu_ID));
            stu.setValid(stuValid);
            info.setStudentInfo(stu);

            for (int i = 0; i < ClsIdList.size(); i++) {
                int Class_ID = ClsIdList.get(i);

                boolean clsValid = classValid.classIsValid(Class_ID);
                if (clsValid) {
                    int PremissionCode = PremissionCodeList.get(i);

                    if (PremissionCode == 0) {
                        ClassInfo cls = new ClassInfo();
                        Integer classStatus = canRegister.classRegisterLeftSpace(Class_ID);
                        cls.setClassid(String.valueOf(Class_ID));
                        cls.setClassvalid(clsValid);
                        cls.setClassstatus(String.valueOf(classStatus));
                        stucls = prereqMeet.studentMeetsPrereq(Stu_ID, Class_ID);
                        convertStuclspreqToRegcheckprerq(cls.getPrereqClasses(), stucls.getClassPrereq());
                        cls.setCanTake(stucls.isCanTake()); //waitng one more operation;
                        cls.setFacultyEmail(daoService.getFacultyEmail(Class_ID));
                        if (classStatus > 0 && stucls.isCanTake()) {
                            if (daoService.getStudentEnrollmentRecord(Stu_ID, Class_ID).getStatus() == null || !daoService.getStudentEnrollmentRecord(Stu_ID, Class_ID).getStatus().equals("enroll")) {
                                daoService.insertStudentEnrollmentWithStatus(String.valueOf(Stu_ID), String.valueOf(Class_ID), "enroll");
                            }
                        } else {
                            servicesQueueService.setObjectBetweenService(this.getClass().getName(), PermissionRequestService.class.getName(), cls, stu, String.valueOf(String.valueOf(Stu_ID).hashCode() * String.valueOf(Class_ID).hashCode()));
                        }
                        
                        System.out.print(cls.getClassid() + " " + cls.getClassstatus());

                        //clsList.setClazz(cls);
                        clsList.getClazz().add(cls);
                    } else {
                        Permission permission = daoService.getOnePermissionInfo(PremissionCode);
                        if (permission != null && permission.getStatus().equals("accept")) {
                            if (Class_ID == Integer.valueOf(permission.getClassid())) {
                                ClassInfo cls = new ClassInfo();
                                Integer classStatus = canRegister.classRegisterLeftSpace(Class_ID);
                                cls.setClassid(String.valueOf(Class_ID));
                                cls.setClassvalid(true);
                                cls.setCanTake(true);
                                cls.setClassstatus(String.valueOf(classStatus));
                                daoService.insertStudentEnrollment(String.valueOf(Stu_ID), String.valueOf(Class_ID));
                                System.out.print(cls.getClassid() + " " + cls.getClassstatus());

                                clsList.getClazz().add(cls);
                            }
                        }
                    }
                }
            }

            info.setClazzInfo(clsList);
        } else {
            stu.setValid(stuValid);
            info.setStudentInfo(stu);
        }
        System.out.print(info.getStudentInfo());
        return info;

    }

    private void convertStuclspreqToRegcheckprerq(List<org.netbeans.xml.schema.studentregcheck.ClassPrereq> converTo, List<org.netbeans.xml.schema.studentprereqcheck.StudentClass.ClassPrereq> convertFrom) {
        for (org.netbeans.xml.schema.studentprereqcheck.StudentClass.ClassPrereq convertFromCur : convertFrom) {
            org.netbeans.xml.schema.studentregcheck.ClassPrereq convertToCur = new org.netbeans.xml.schema.studentregcheck.ClassPrereq();
            convertToCur.setClassid(convertFromCur.getClassid());
            convertToCur.setCourseid(convertFromCur.getCourseid());
            convertToCur.setGrade(convertFromCur.getGrade());
            converTo.add(convertToCur);
        }
    }

    private void converStuinfo(org.netbeans.xml.schema.studentregcheck.StudentInformation stu1, org.netbeans.xml.schema.studentxmlschema.Student stu2) {
        stu1.setEmail(stu2.getEmail());
    }
}
