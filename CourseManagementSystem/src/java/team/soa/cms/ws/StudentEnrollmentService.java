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
import team.soa.cms.ws.daoService.DAOService;

/**
 *
 * @author zhouyizhou
 */
@WebService(serviceName = "StudentEnrollmentService")
public class StudentEnrollmentService {
    DAOService daoservice = new DAOService();
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getStudentEnrollList")
    public StuEnrollList getStudentEnrollList(@WebParam(name = "Stu_ID") String Stu_ID) {
        StuEnrollList stuEnrollList = new StuEnrollList();
        stuEnrollList = daoservice.getStudentEnrollment(Stu_ID);
        return stuEnrollList;
    }

    
}
