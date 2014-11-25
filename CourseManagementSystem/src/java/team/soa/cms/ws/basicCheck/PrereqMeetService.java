/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.ws.basicCheck;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.netbeans.xml.schema.prerequestxmlschema.Prerequestment;
import org.netbeans.xml.schema.studentprereqcheck.StudentClass;
import org.netbeans.xml.schema.studentprereqcheck.StudentClass.ClassPrereq;
import org.netbeans.xml.schema.stuenrolxmlschema.StuEnrollList;
import team.soa.cms.ws.daoService.DAOService;

/**
 *
 * @author xmrui_000
 */
@WebService(serviceName = "PrereqMeetService")
public class PrereqMeetService {

    DAOService daoService = new DAOService();
    /**
     * This is a sample web service operation
     */
      /**
     * Web service operation Check the classes satisfy prereqs
     *
     * @param Stu_ID, Class_ID
     * @return StudentClass (student and clazz prereq status)
     */
    @WebMethod(operationName = "studentMeetsPrereq")
    public StudentClass studentMeetsPrereq(@WebParam(name = "Stu_ID") int Stu_ID, @WebParam(name = "Class_ID") int Class_ID) {

        StudentClass studentClass = new StudentClass();

        //use studentID to get the student's enrolllist
        Integer stuidInt = new Integer(Stu_ID);
        String stuid = stuidInt.toString();
        StuEnrollList enrollList = daoService.getStudentEnrollment(stuid);

        //use classID to get the pre-requested classes of the class to be enrolled
        Integer classidInt = new Integer(Class_ID);
        String classid = classidInt.toString();
        Prerequestment prelist = daoService.cgetClassPrerequisite(classid);

        String courseid = daoService.getClassInfo(Class_ID).getCosid();

        studentClass.setClassid(classid);
        studentClass.setCourseid(courseid);
        studentClass.setCanTake(true);

        List<StudentClass.ClassPrereq> classPrereq = studentClass.getClassPrereq();
        int size = prelist.getOnepre().size();

        if (size > 0) {
            //the classid has prerequisites

            for (int i = 0; i < size; i++) {

                //set the prereq courseid according to prelist
                
                ClassPrereq clsprereq = new ClassPrereq();
                clsprereq.setCourseid(prelist.getOnepre().get(i).getCourseid());
                classPrereq.add(clsprereq);

                //go through the enrolllist to find the prereq course and set the fields
                int len = enrollList.getOneenroll().size();
                int j = 0;
                for (; j < len; j++) {

                    if (enrollList.getOneenroll().get(j).getCourseid().equals(prelist.getOnepre().get(i).getCourseid())) {
                        classPrereq.get(i).setClassid(enrollList.getOneenroll().get(j).getClassid());
                        classPrereq.get(i).setGrade(enrollList.getOneenroll().get(j).getGrade());
                        classPrereq.get(i).setReqMet(true);
                        
                        break;
                        //end if found the enrolled course
                    } 
                }//end for loop enrolllist
                if (len==0||j == len ) {
                    //the last enroll class but not is required
                    //set the canTake to false
                    classPrereq.get(i).setClassid("");
                    classPrereq.get(i).setGrade("");
                    classPrereq.get(i).setReqMet(false);
                    studentClass.setCanTake(false);
                }

            }//end for loop classPrereq list    

        }// end of if(size>0)
        System.out.println("hhhhhhhhhhhh: "+studentClass.isCanTake());
        return studentClass;
    }
}
