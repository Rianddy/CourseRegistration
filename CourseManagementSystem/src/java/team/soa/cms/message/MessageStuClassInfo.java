/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.QueueConnectionFactory;
import javax.jms.Session;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.netbeans.xml.schema.stuclassmessagexmlschema.Stuclassmessage;
import team.soa.cms.serializableObj.StuClassInfoMQSerialObj;


/**
 *
 * @author YIYI
 */
@WebService(serviceName = "MessageStuClassInfo")
public class MessageStuClassInfo {

     /**
     * Web service operation
     */
    @WebMethod(operationName = "messageStuClassInfo")
    public String messageStuClassInfo(@WebParam(name = "stuclassInfo") Stuclassmessage stuclassInfo) {
        
        /*****************************************************************/
          String permissionID = "1000";
         /*****************************************************************/
         StuClassInfoMQSerialObj sobj = new StuClassInfoMQSerialObj(stuclassInfo);           
         MsgQueueProductor productor = new MsgQueueProductor("stuclassqcf", "stuclassqueue");
         List<String> propList = new ArrayList<String>();
         propList.add("PermissionID:"+permissionID);
         String status = productor.setObjMsg(sobj, propList);
      
        return status;

    }
}
