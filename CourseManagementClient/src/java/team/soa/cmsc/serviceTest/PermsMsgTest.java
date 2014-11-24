/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cmsc.serviceTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.netbeans.xml.schema.stuclassmessagexmlschema.Stuclassmessage;
import org.netbeans.xml.schema.stuclassmessagexmlschema.Stuclassmessage.Studentinfo;
import org.netbeans.xml.schema.stuclassmessagexmlschema.Stuclassmessage.RequestClass;
import team.soa.cms.msgqueueservice.StuClassInfoMQSerialObj;

/**
 *
 * @author birui
 */
public class PermsMsgTest{


    



    public static List<StuClassInfoMQSerialObj> getPermsMsg(String permsId) {
        List<StuClassInfoMQSerialObj> permsObj = new ArrayList<StuClassInfoMQSerialObj>();
        permsObj = (List<StuClassInfoMQSerialObj>) getPermsInfo(permsId);
        return permsObj;
    }

    private static java.util.List<team.soa.cms.msgqueueservice.StuClassInfoMQSerialObj> getPermsInfo(java.lang.String permsID) {
        team.soa.cms.msgqueueservice.PermsReqMsgService_Service service = new team.soa.cms.msgqueueservice.PermsReqMsgService_Service();
        team.soa.cms.msgqueueservice.PermsReqMsgService port = service.getPermsReqMsgServicePort();
        return port.getPermsInfo(permsID);
    }

    private static String setPermsInfo(java.lang.String permsID, java.lang.String facultyMail, org.netbeans.xml.schema.stuclassmessagexmlschema.Stuclassmessage stuclassInfo) {
        team.soa.cms.msgqueueservice.PermsReqMsgService_Service service = new team.soa.cms.msgqueueservice.PermsReqMsgService_Service();
        team.soa.cms.msgqueueservice.PermsReqMsgService port = service.getPermsReqMsgServicePort();
        return port.setPermsInfo(permsID, facultyMail, stuclassInfo);
    }

    private static String setPermsConfirm(java.lang.String permsID, java.lang.String studentMail, org.netbeans.xml.schema.stuclassmessagexmlschema.Stuclassmessage stuclassInfo) {
        team.soa.cms.msgqueueservice.PermsConfmMsgService_Service service = new team.soa.cms.msgqueueservice.PermsConfmMsgService_Service();
        team.soa.cms.msgqueueservice.PermsConfmMsgService port = service.getPermsConfmMsgServicePort();
        return port.setPermsConfirm(permsID, studentMail, stuclassInfo);
    }

    private static String setMsgListener(java.lang.String permsID) {
        team.soa.cms.msgqueueservice.PermsConfmMsgService_Service service = new team.soa.cms.msgqueueservice.PermsConfmMsgService_Service();
        team.soa.cms.msgqueueservice.PermsConfmMsgService port = service.getPermsConfmMsgServicePort();
        return port.setMsgListener(permsID);
    }


    
    
    
    public static void main(String[] args) throws DatatypeConfigurationException {
        String permsID = "1000";
        String email = "xmruibi@hotmail.com";

        Stuclassmessage stuclassInfo = new Stuclassmessage();
        Studentinfo stuinfo = new Studentinfo();
        stuinfo.setStuid("66666");
        stuinfo.setStuname("R");
        stuinfo.setStuemail("rub@pitt.edu");
        stuinfo.setDepartment("IS");
        stuinfo.setMajor("Web System");
        stuinfo.setConcentration("RUYConcentration");

        //GregorianCalendar-〉XMLGregorianCalendar   
        GregorianCalendar nowGregorianCalendar = new GregorianCalendar();
        XMLGregorianCalendar xmlDatetime = DatatypeFactory.newInstance().newXMLGregorianCalendar(nowGregorianCalendar);

        //XMLGregorianCalendar ->GregorianCalendar  
        nowGregorianCalendar = xmlDatetime.toGregorianCalendar();
        //GregorianCalendar->String  
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateTimeString = simpleDateFormat.format(nowGregorianCalendar.getTime());

        stuinfo.setBirthday(xmlDatetime);

        stuinfo.setAddress("5700 Bunkerhill st");
        stuinfo.setCell("RUYCell");
        stuclassInfo.setStudentinfo(stuinfo);

        RequestClass classInfo = new RequestClass();

        classInfo.setClassid("20002");
        classInfo.setClassvalid(true);

        stuclassInfo.setRequestClass(classInfo);

        System.out.println(setPermsConfirm(permsID, email, stuclassInfo));

       


    }
}

