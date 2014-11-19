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
import org.netbeans.xml.schema.stuclassmessagexmlschema.Stuclassmessage.*;
import team.soa.cms.msgqueueservice.StuClassInfoMQSerialObj;



/**
 *
 * @author birui
 */
public class PermsMsgTest {

    public static void main(String[] args) throws DatatypeConfigurationException {
        String permsID = "1000";
        String email = "xmruibi@hotmail.com";
        System.out.println(setPermsMsg(permsID,email));
        getPermsMsg(permsID);

    }

    public static String setPermsMsg(String permID, String facultyEmail) throws DatatypeConfigurationException {
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

        Requestclassinfo reclassInfo = new Requestclassinfo();

        reclassInfo.setClassid("20002");
        reclassInfo.setCourseid("2220005");
        reclassInfo.setCoursename("Web service");
        reclassInfo.setMaxsize(30);
        reclassInfo.setCurrsize(20);
        reclassInfo.setMaxwaitlist(10);
        reclassInfo.setCurwaitlist(0);
        reclassInfo.setOpensemester("Fall2014");
        reclassInfo.setFacultyid("9009");
        reclassInfo.setFacultyname("Spring");

        stuclassInfo.getRequestclassinfo().add(reclassInfo);

        Requestclassinfo reclassInfo2 = new Requestclassinfo();

        reclassInfo2.setClassid("20003");
        reclassInfo2.setCourseid("2220006");
        reclassInfo2.setCoursename("Web Tech");
        reclassInfo2.setMaxsize(30);
        reclassInfo2.setCurrsize(20);
        reclassInfo2.setMaxwaitlist(10);
        reclassInfo2.setCurwaitlist(0);
        reclassInfo2.setOpensemester("Fall2014");
        reclassInfo2.setFacultyid("9009");
        reclassInfo2.setFacultyname("Spring");

        stuclassInfo.getRequestclassinfo().add(reclassInfo2);

        System.out.println("In PermsMsgTest.java : student name = " + stuclassInfo.getStudentinfo().getStuname());

        String str = setPermsInfo(permID,facultyEmail,stuclassInfo);
        return str;
    }

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






}
