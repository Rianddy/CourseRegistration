/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.netbeans.xml.schema.stuenrolxmlschema.StuEnrollList;
import team.soa.cms.dao.Implement.StudentEnrollDAOImpl;
import team.soa.cms.dao.StudentEnrollDAO;

/**
 *
 * @author YIYI
 * @editor RuiBi
 */
@WebService(serviceName = "InsertStudentEnrollment")
public class InsertStudentEnrollment {

    /**
     * Web service operation
     *
     * @param Stu_ID
     * @param Class_ID
     * @param status is 'enroll' or 'waitlist'
     * @return student Enrollment ID
     */
    @WebMethod(operationName = "insertStudentEnrollment")
    public Integer insertStudentEnrollment(@WebParam(name = "Stu_ID") int Stu_ID, @WebParam(name = "Class_ID") int Class_ID, @WebParam(name = "status") String status) {

        StudentEnrollDAO stuEnrollDAO = new StudentEnrollDAOImpl();
        int reEnrollId = -1;

        int res = stuEnrollDAO.insertIDStatus(Class_ID, Stu_ID, status);

        if (res > 0) {
            //insert successfully
            StudentEnrollDAOImpl impl = new StudentEnrollDAOImpl();
            StuEnrollList.Oneenroll onee = impl.getOneEnrollmentInfo(Class_ID, Stu_ID, status);
            reEnrollId = Integer.valueOf(onee.getStuenrollid());
        }

        return reEnrollId;

    }
}
