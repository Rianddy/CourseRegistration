/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import org.netbeans.xml.schema.studentregcheck.ClassList;
import org.netbeans.xml.schema.studentregcheck.StuRegCheckInfo;
import team.soa.cms.ws.CheckStudentRegistrationResponse;
//import webservice.checkregistration.*;


/**
 *
 * @author KevinZhou
 */
public class RegCheckController {

    public static StuRegCheckInfo checkStudentRegistration(int stuID, java.util.List<java.lang.Integer> classIDList, java.util.List<java.lang.Integer> premissionCodeList) {
        team.soa.cms.ws.RegCheckService_Service service = new team.soa.cms.ws.RegCheckService_Service();
        team.soa.cms.ws.RegCheckService port = service.getRegCheckServicePort();
        return port.checkStudentRegistration(stuID, classIDList, premissionCodeList);
    }




}
