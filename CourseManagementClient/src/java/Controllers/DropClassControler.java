/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import org.netbeans.xml.schema.checkdropclasses.CheckClasses;
import org.netbeans.xml.schema.dropclasses.DropStudentClasses;

/**
 *
 * @author Edison
 */
public class DropClassControler {
    public CheckClasses isClassEnrolled(org.netbeans.xml.schema.dropclassinput.DropClassesInput classes) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        
        team.soa.cms.ws.StudentDropClass_Service service = new team.soa.cms.ws.StudentDropClass_Service();
        team.soa.cms.ws.StudentDropClass port = service.getStudentDropClassPort();
        return port.isClassEnrolled(classes);
    }

    public DropStudentClasses studentDropClass(org.netbeans.xml.schema.checkdropclasses.CheckClasses inputClasses) {
        team.soa.cms.ws.StudentDropClass_Service service = new team.soa.cms.ws.StudentDropClass_Service();
        team.soa.cms.ws.StudentDropClass port = service.getStudentDropClassPort();
        return port.studentDropClass(inputClasses);
    }
}
