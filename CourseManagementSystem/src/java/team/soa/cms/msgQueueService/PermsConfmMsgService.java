/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.msgQueueService;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.netbeans.xml.schema.stuclassmessagexmlschema.Stuclassmessage;
import team.soa.cms.msgUtil.MsgQueueProducer;
import team.soa.cms.msgUtil.MsgQueueReceiver;
import team.soa.cms.serializableObj.StuClassInfoMQSerialObj;

/**
 *
 * @author birui
 */
@WebService(serviceName = "PermsConfmMsgService")
public class PermsConfmMsgService {

  public String permsProp = "PermsId";
    public String permsConnPath = "permsPool";
    public String permsQueuePath = "permsStu";

    /**
     * @param PermsID permission id
     * @param studentMail send confirm email to student to show status change
     * @param stuclassInfo permsInfo
     *
     * @return sending status
     */
    @WebMethod(operationName = "setPermsConfirm")
    public String setPermsConfirm(@WebParam(name = "PermsID") String PermsID, @WebParam(name = "studentMail") String studentMail, @WebParam(name = "stuclassInfo") Stuclassmessage stuclassInfo) {

        StuClassInfoMQSerialObj sobj = new StuClassInfoMQSerialObj(stuclassInfo);
        MsgQueueProducer producer = new MsgQueueProducer(permsConnPath, permsQueuePath);
        List<String> propList = new ArrayList<String>();
        propList.add(permsProp + ":" + PermsID);

        // set permsInfo into MQ
        String status = producer.setObjMsg(sobj, propList);

        // call mail service
//        String mailContent="";
//        PermsReqMailService mail = new PermsReqMailService();
//        status += " " + mail.PermsConfirm(studentMail, mailContent);

        return status;

    }

}
