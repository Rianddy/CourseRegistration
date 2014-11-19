/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.netbeans.xml.schema.permissionxmlschema.Permission;
import team.soa.cms.dao.Implement.PermissionDAOImpl;

/**
 *
 * @author rianddy
 */
@WebService(serviceName = "RequestPermission")
public class RequestPermission {

    @WebMethod(operationName = "acceptStudentPermission")
    public Integer acceptStudentPermission(@WebParam(name = "studentID") int studentID, @WebParam(name = "classID") int classID, @WebParam(name = "facultyID") int facultyID) {
         PermissionDAOImpl impl = new PermissionDAOImpl();
        
        return impl.insertAcceptPerm(studentID, classID, facultyID);
    }
    
    @WebMethod(operationName = "checkPermissionCode")
    public Boolean checkPermissionCode(@WebParam(name = "studentID") int studentID, @WebParam(name = "classID") int classID, @WebParam(name = "permcode") int permcode) {

        PermissionDAOImpl impl = new PermissionDAOImpl();
        return impl.acceptCodeExist(studentID, classID, permcode);
    }
    
    @WebMethod(operationName = "PrereqMsgQueue")
    public String PrereqMsgQueue(@WebParam(name = "parameter") Permission parameter) {
        //TODO write your implementation code here:
        return null;
    }
    
    @WebMethod(operationName = "rejectStudentPermission")
    public Integer rejectStudentPermission(@WebParam(name = "studentID") int studentID, @WebParam(name = "classID") int classID, @WebParam(name = "facultyID") int facultyID) {
   
        PermissionDAOImpl impl = new PermissionDAOImpl();
        
        return impl.insertRejectPerm(studentID, classID, facultyID);
    }
}
