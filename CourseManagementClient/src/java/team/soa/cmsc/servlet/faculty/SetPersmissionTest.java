/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cmsc.servlet.faculty;

import org.netbeans.xml.schema.stuclassmessagexmlschema.ClassInfo;
import org.netbeans.xml.schema.stuclassmessagexmlschema.Stuclassmessage;
import org.netbeans.xml.schema.stuclassmessagexmlschema.StudentInfo;
import team.soa.cms.msgqueueservice.ClassInfoOfMessageSerialObj;
import team.soa.cms.msgqueueservice.StuClassInfoMQSerialObj;
import team.soa.cms.msgqueueservice.StudentInfoOfMessageSerialObj;

/**
 *
 * @author birui
 */
public class SetPersmissionTest {
    
    public static void main(String[] args) {
        Stuclassmessage obj = new Stuclassmessage();
        StudentInfo stuInfo =  new StudentInfo();
        stuInfo.setStudentid("1");
        stuInfo.setEmail("xmruibi@sina.com");
        
        ClassInfo clsInfo = new ClassInfo();
        clsInfo.setClassid("1");
        clsInfo.setCanTake(true);
        clsInfo.setClassstatus("closed");
        
        obj.setStudentinfo(stuInfo);
        obj.setRequestClass(clsInfo);
        
      
        String status = setPermsReq("1111", "xmruibi@gmail.com", obj);
        System.out.println(status);
        
    }

    private static String setPermsReq(java.lang.String permsID, java.lang.String falEmail, org.netbeans.xml.schema.stuclassmessagexmlschema.Stuclassmessage permsInfo) {
        team.soa.cms.msgqueueservice.PermsReqMsgService_Service service = new team.soa.cms.msgqueueservice.PermsReqMsgService_Service();
        team.soa.cms.msgqueueservice.PermsReqMsgService port = service.getPermsReqMsgServicePort();
        return port.setPermsReq(permsID, falEmail, permsInfo);
    }
    
}
