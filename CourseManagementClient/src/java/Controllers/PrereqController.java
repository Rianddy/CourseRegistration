/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import webservice.prereqmeet.StudentClass;

/**
 *
 * @author riand_000
 */
public class PrereqController {

    public static StudentClass studentMeetsPrereq(int stuID, int classID) {
        webservice.prereqmeet.PrereqMeetService_Service service = new webservice.prereqmeet.PrereqMeetService_Service();
        webservice.prereqmeet.PrereqMeetService port = service.getPrereqMeetServicePort();
        return port.studentMeetsPrereq(stuID, classID);
    }
    
}
