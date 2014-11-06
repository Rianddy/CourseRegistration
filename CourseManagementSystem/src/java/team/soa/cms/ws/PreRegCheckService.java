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
import org.netbeans.xml.schema.studentxmlschema.Student;
import org.netbeans.xml.schema.classxmlschema.Class;
import org.netbeans.xml.schema.prerequestxmlschema.Prerequestment;
import org.netbeans.xml.schema.studentprereqcheck.StudentClass;
import org.netbeans.xml.schema.studentregcheck.ClassInfo;
import org.netbeans.xml.schema.studentregcheck.ClassInfo.ClassPrereq;
import org.netbeans.xml.schema.studentregcheck.ClassList;
import org.netbeans.xml.schema.studentregcheck.StuRegCheckInfo;
import org.netbeans.xml.schema.studentregcheck.StudentInformation;
import org.netbeans.xml.schema.stuenrolxmlschema.StuEnrollList;
import team.soa.cms.dao.ClassDAO;
import team.soa.cms.dao.Implement.ClassDAOImpl;
import team.soa.cms.dao.Implement.PrerequestmentDAOImpl;
import team.soa.cms.dao.Implement.StudentDAOImpl;
import team.soa.cms.dao.Implement.StudentEnrollDAOImpl;
import team.soa.cms.dao.StudentDAO;

/**
 *
 * @author birui
 */
@WebService(serviceName = "PreRegCheckService")
public class PreRegCheckService {

    /**
     * Web service operation
     *
     * @param Stu_ID one student id
     * @exception studentIdInvalidException
     * @return boolean
     */
    @WebMethod(operationName = "studentIsValid")
    public Boolean studentIsValid(@WebParam(name = "Stu_ID") int Stu_ID) {
        //TODO write your implementation code here:
        try {
            StudentDAO stuDAO = new StudentDAOImpl();
            Student stu = stuDAO.getOneStudent(Stu_ID);
            //System.out.print(stu);
            if (stu != null) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * Web service operation
     *
     * @param Class_ID one class id
     * @exception classIdInvalidException
     * @return boolean
     */
    @WebMethod(operationName = "classIsValid")
    public Boolean classIsValid(@WebParam(name = "Class_ID") int Class_ID) {
        //TODO write your implementation code here:        
        try {
            ClassDAO classDAO = new ClassDAOImpl();
            Class cls = classDAO.getOneClass(Class_ID);
            if (cls != null) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * Web service operation
     *
     * @param Class_ID validClassID
     * @exception NoClassStatusException
     * @return classStatus
     */
    @WebMethod(operationName = "classCanRegister")
    public String classCanRegister(@WebParam(name = "classStatus") int Class_ID) {
        //TODO write your implementation code here:
        String classStatus = null;
        try {
            ClassDAO classDAO = new ClassDAOImpl();
            Class cls = classDAO.getOneClass(Class_ID);
            int currentSize = cls.getCursize();
            if (currentSize < cls.getMaxsize()) {
                classStatus = "open";
            } else if (currentSize == cls.getMaxsize()) {
                if (cls.getCurwaitlist() < cls.getMaxwaitlist()) {
                    classStatus = "waitlist";
                } else {
                    classStatus = "closed";
                }
            }
            return classStatus;
        } catch (Exception e) {

            return null;
        }
    }

    
    
     /**
     * Web service operation
     * return studentClass
     * include:
     * classid； courseid； canTake； a list of classPrereq
     * list of clasPrereq include:
     * classid; courseid; grade; reqMet
     */
    @WebMethod(operationName = "studentMeetsPrereq")
    public StudentClass studentMeetsPrereq(@WebParam(name = "student_id") String student_id, @WebParam(name = "class_id") String class_id) {
        //TODO write your implementation code here:
        StudentClass studentClass = new StudentClass();
        
        //use studentID to get the student's enrolllist
        StudentEnrollDAOImpl enrollimpl = new StudentEnrollDAOImpl();
        StuEnrollList enrollList = new StuEnrollList();
        enrollList = enrollimpl.getStudentEnrollment(Integer.valueOf(student_id));
        
        //use classID to get the pre-requested classes of the class to be enrolled
        PrerequestmentDAOImpl preimpl = new PrerequestmentDAOImpl();
        Prerequestment prelist = new Prerequestment();
        prelist = preimpl.getPrerequestmentByClassId(Integer.valueOf(class_id));
        
        studentClass.setClassid(class_id);
        studentClass.setCourseid(class_id);//??????********courseid????where???????
        studentClass.setCanTake(true);
        
        List<StudentClass.ClassPrereq> classPrereq = studentClass.getClassPrereq();
        int size = prelist.getOnepre().size();
        if(size>0){//the classid has prerequisites
            for(int i=0; i<size; i++){
                //set the prereq courseid according to prelist
                classPrereq.get(i).setCourseid(prelist.getOnepre().get(i).getCourseid());
                
                //go through the enrolllist to find the prereq course and set the fields
                int len = enrollList.getOneenroll().size();
                for(int j=0; j<len; j++){
                    if(enrollList.getOneenroll().get(j).getCourseid().equals(prelist.getOnepre().get(i).getCourseid())){
                        classPrereq.get(i).setClassid(enrollList.getOneenroll().get(j).getClassid());
                        classPrereq.get(i).setGrade(enrollList.getOneenroll().get(j).getGrade());
                        classPrereq.get(i).setReqMet(true);
                        break;
                    }//end if found the enrolled course
                    else{
                        if(j==len-1){
                            //the last enroll class but not is required
                            //set the canTake to false
                            classPrereq.get(i).setClassid("");
                            classPrereq.get(i).setGrade("");
                            classPrereq.get(i).setReqMet(false);
                            studentClass.setCanTake(false);
                        }
                    }
                }//end for loop enrolllist
           
            }//end for loop classPrereq list
            
        }//end of if size>0
        
        
        return studentClass;
    }
    
     /**
     * Web service operation
     *
     * @param Stu_ID, Class_ID  validStuID, validClassID 
     * @see studentIsValid(stuID),classIsValid(classID), classCanRegister(classID), 
     * @exception 
     * @return StuRegCheckInfo(student with a list of classes)
     */
    
    @WebMethod(operationName = "checkStudentRegistration")
    public StuRegCheckInfo checkStudentRegistration(@WebParam(name = "Stu_ID") int stuID, @WebParam(name = "Class_ID") int classID) { // should it be a classid list?
        //TODO write your implementation code here:
        StuRegCheckInfo info = new StuRegCheckInfo();
        ClassList clsList = new ClassList();
        ClassInfo cls = new ClassInfo();
        StudentInformation stu = new StudentInformation();

        boolean stuValid = studentIsValid(stuID);
        System.out.print(stuValid);
        boolean clsValid = classIsValid(classID);
        System.out.print(clsValid);

        if (stuValid && clsValid) {

            stu.setStudentid(String.valueOf(stuID));
            stu.setValid(stuValid);
            stu.setEmail("xxx@pitt.edu");
            System.out.print(stu.getStudentid()+" "+stu.getEmail());
            // why it need stu email info?
            String classStatus = classCanRegister(classID);
            
            cls.setClassid(String.valueOf(classID));
            cls.setClassvalid(clsValid);
            cls.setClassstatus(classStatus);
            cls.setCanTake(true); //waitng one more operation;
            System.out.print(cls.getClassid()+" "+cls.getClassstatus());
            clsList.setClazz(cls);
            System.out.print(clsList);
            info.setClazzInfo(clsList);
            info.setStudentInfo(stu);
            System.out.print(info.getStudentInfo());
            return info;
        }
        return null;
    }
}
