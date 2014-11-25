/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cmsc.servlet.faculty;

import team.soa.cms.msgqueueservice.ClassInfoOfMessageSerialObj;
import team.soa.cms.msgqueueservice.StuClassInfoMQSerialObj;
import team.soa.cms.msgqueueservice.StudentInfoOfMessageSerialObj;

/**
 *
 * @author birui
 * 
 * This is just a test class 
 * Do not use this
 */
public class SetQueueTest {
     public static void main(String[] args) {
        StuClassInfoMQSerialObj obj = new StuClassInfoMQSerialObj();
        StudentInfoOfMessageSerialObj stuInfo =  new StudentInfoOfMessageSerialObj();
        stuInfo.setStuid("1");
        stuInfo.setEmail("xmruibi@sina.com");
        
         ClassInfoOfMessageSerialObj clsInfo = new ClassInfoOfMessageSerialObj();
        clsInfo.setClassid("1");
        clsInfo.setCanTake(true);
        clsInfo.setClassstatus("closed");
        
        obj.setStudentInfo(stuInfo);
        obj.setClassInfo(clsInfo);
        
      
        int status = setPermsReq("1111", "xmruibi@gmail.com", obj);
        System.out.println(status);
        
    }

    private static int setPermsReq(java.lang.String permsID, java.lang.String falEmail, team.soa.cms.msgqueueservice.StuClassInfoMQSerialObj permsInfo) {
        team.soa.cms.msgqueueservice.PermsReqMsgService_Service service = new team.soa.cms.msgqueueservice.PermsReqMsgService_Service();
        team.soa.cms.msgqueueservice.PermsReqMsgService port = service.getPermsReqMsgServicePort();
        return port.setPermsReq(permsID, falEmail, permsInfo);
    }


}
