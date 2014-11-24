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




    
    
    
    public static void main(String[] args) throws DatatypeConfigurationException {
        String permsID = "1000";
        String email = "xmruibi@hotmail.com";


     //   System.out.println(setPermsConfirm(permsID, email, stuclassInfo));

       


    }
}

