/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.ws.basicCheck;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.netbeans.xml.schema.studentxmlschema.Student;
import org.netbeans.xml.schema.stuenrolxmlschema.StuEnrollList;
import team.soa.cms.ws.daoService.DAOService;

/**
 *
 * @author xmrui_000
 */
@WebService(serviceName = "StudentValidService")
public class StudentValidService {

   DAOService daoService = new DAOService();

    /**
     * Web service operation
     *
     * @param Stu_ID one student id
     * @exception studentIdInvalidException
     * @return boolean
     */
    @WebMethod(operationName = "studentIsValid")
    public Boolean studentIsValid(@WebParam(name = "Stu_ID") int Stu_ID) {
        // student Stu_ID exists or not
        try {
            Student stu = daoService.getStudentInfo(Stu_ID);
            if (stu.getStuid()!= null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
