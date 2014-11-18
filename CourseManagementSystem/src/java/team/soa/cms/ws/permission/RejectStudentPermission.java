/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.ws.permission;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import team.soa.cms.dao.Implement.PermissionDAOImpl;

/**
 *
 * @author YIYI
 */
@WebService(serviceName = "RejectStudentPermission")
public class RejectStudentPermission {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "rejectStudentPermission")
    public Integer rejectStudentPermission(@WebParam(name = "studentID") int studentID, @WebParam(name = "classID") int classID, @WebParam(name = "facultyID") int facultyID) {
   
        PermissionDAOImpl impl = new PermissionDAOImpl();
        
        return impl.insertRejectPerm(studentID, classID, facultyID);
    }
}
