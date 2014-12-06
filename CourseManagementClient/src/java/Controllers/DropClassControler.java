/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

import org.netbeans.xml.schema.dropclasses.CheckClasses;
import org.netbeans.xml.schema.dropclasses.DropClassesInput;
import org.netbeans.xml.schema.dropclasses.DropStudentClasses;
import org.netbeans.xml.schema.studentinwaitlist.Waitlist;

/**
 *
 * @author Edison
 */
public class DropClassControler {
    public CheckClasses isClassEnrolled(DropClassesInput classes) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        
        team.soa.cms.ws.StudentDropClass_Service service = new team.soa.cms.ws.StudentDropClass_Service();
        team.soa.cms.ws.StudentDropClass port = service.getStudentDropClassPort();
        return port.isClassEnrolled(classes);
    }

    public DropStudentClasses studentDropClass(CheckClasses inputClasses) {
        team.soa.cms.ws.StudentDropClass_Service service = new team.soa.cms.ws.StudentDropClass_Service();
        team.soa.cms.ws.StudentDropClass port = service.getStudentDropClassPort();
        return port.studentDropClass(inputClasses);
    }
    
    public Waitlist getWaitingList(org.netbeans.xml.schema.dropclasses.CheckClasses checkClasses,org.netbeans.xml.schema.dropclasses.DropStudentClasses dropStudentClasses){
        team.soa.cms.ws.GetWaitlist_Service service = new team.soa.cms.ws.GetWaitlist_Service();
        team.soa.cms.ws.GetWaitlist port = service.getGetWaitlistPort();
        return port.operation(dropStudentClasses, checkClasses);
    }
}
