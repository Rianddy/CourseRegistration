/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.ws.basicCheck;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import team.soa.cms.ws.daoService.DAOService;

/**
 *
 * @author xmrui_000
 */
@WebService(serviceName = "ClassValidService")
public class ClassValidService {
    DAOService daoService = new DAOService();
    /**
     * This is a sample web service operation
     */
  @WebMethod(operationName = "classIsValid")
    public Boolean classIsValid(@WebParam(name = "Class_ID") int Class_ID) {
        //class Class_ID exists or not
        try {
            org.netbeans.xml.schema.classxmlschema.Class cla = daoService.getClassInfo(Class_ID);

            if (cla != null) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }
}
