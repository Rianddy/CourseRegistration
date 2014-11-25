/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import webservice.basic.Class;

/**
 *
 * @author riand_000
 */
public class ClassController {

    public static Boolean classIsValid(int classID) {
        webservice.classvalid.ClassValidService_Service service = new webservice.classvalid.ClassValidService_Service();
        webservice.classvalid.ClassValidService port = service.getClassValidServicePort();
        return port.classIsValid(classID);
    }

    public static Class getClassInfo(int classID) {
        webservice.basic.DAOService_Service service = new webservice.basic.DAOService_Service();
        webservice.basic.DAOService port = service.getDAOServicePort();
        return port.getClassInfo(classID);
    }

    public static Integer classRegisterLeftSpace(int classID) {
        webservice.classregister.ClassCanRegisterService_Service service = new webservice.classregister.ClassCanRegisterService_Service();
        webservice.classregister.ClassCanRegisterService port = service.getClassCanRegisterServicePort();
        return port.classRegisterLeftSpace(classID);
    }
    
    
    
}
