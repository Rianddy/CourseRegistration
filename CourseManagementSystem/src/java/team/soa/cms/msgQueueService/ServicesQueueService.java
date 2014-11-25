/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.msgQueueService;

import java.util.ArrayList;
import java.util.List;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.netbeans.xml.schema.studentregcheck.ClassInfo;
import org.netbeans.xml.schema.studentregcheck.ClassPrereq;
import org.netbeans.xml.schema.studentregcheck.StuRegCheckInfo;
import org.netbeans.xml.schema.studentregcheck.StudentInformation;
import team.soa.cms.msgUtil.MsgQueueProducer;
import team.soa.cms.msgUtil.MsgQueueReceiver;
import team.soa.cms.serializableObj.StuClassInfoMQSerialObj;
import team.soa.cms.serializableObj.stuclassmessageSerializableObj.StudentInfoOfMessageSerialObj;
import team.soa.cms.serializableObj.stuclassmessageSerializableObj.ClassInfoOfMessageSerialObj;
import team.soa.cms.serializableObj.stuclassmessageSerializableObj.ClassPrereqOfMessageSerialObj;

/**
 *
 * @author riand_000
 */
public class ServicesQueueService {

    private final String linkingQueueConnPath = "permsPool";
    private final String linkingQueuePath = "servicequeue";
    private final String From = "From";
    private final String To = "To";
    private final String Local_ID = "Local_ID";

    @WebMethod(operationName = "setObjectBetweenService")
    public int setObjectBetweenService(@WebParam(name = "From") String From, @WebParam(name = "To") String To, @WebParam(name = "ClassInfo") ClassInfo classInfo, @WebParam(name = "studentInformation") StudentInformation studentInformation, @WebParam(name = "Local_ID") String Local_ID) {

        MsgQueueProducer producer = new MsgQueueProducer(linkingQueueConnPath, linkingQueuePath);
        List<String> propList = new ArrayList<String>();
        propList.add(this.From + ":" + From);
        propList.add(this.To + ":" + To);
        propList.add(this.Local_ID + ":" + Local_ID);

        // set permsInfo into MQ
        int status = producer.setObjMsg(convertStuRegCheckInfoToSerialObject(classInfo, studentInformation), propList);

        return status;
    }

    @WebMethod(operationName = "getObjectBetweenService")
    public ObjectMessage getObjectBetweenService(@WebParam(name = "From") String From, @WebParam(name = "To") String To, @WebParam(name = "Local_ID") String Local_ID) {
        //TODO write your implementation code here:
        MsgQueueReceiver receiver = new MsgQueueReceiver(linkingQueueConnPath, linkingQueuePath);
        List<Message> msgList = new ArrayList<Message>();
        String selector = this.From + " = '" + From + "' AND " + this.To + " = '" + To + "' AND " + this.Local_ID + " = '" + Local_ID + "'";

        msgList = receiver.browserMessage(selector);
        ObjectMessage objMsg = null;
        for (Message msg : msgList) {
            objMsg = (ObjectMessage) msg;
        }
        receiver.consumeMessage(selector);
        return objMsg;
    }
    
    private StuClassInfoMQSerialObj convertStuRegCheckInfoToSerialObject(ClassInfo classInfo, StudentInformation studentInformation){
        ClassInfoOfMessageSerialObj classInfoSerialObj = new ClassInfoOfMessageSerialObj();
        classInfoSerialObj.setCanTake(classInfo.isCanTake());
        classInfoSerialObj.setClassid(classInfo.getClassid());
        classInfoSerialObj.setClassstatus(classInfo.getClassstatus());
        classInfoSerialObj.setClassvalid(classInfo.isClassvalid());
        List<ClassPrereqOfMessageSerialObj> prereqSerialList = new ArrayList<ClassPrereqOfMessageSerialObj>();
        for(ClassPrereq originalPrereq:classInfo.getPrereqClasses()){
            ClassPrereqOfMessageSerialObj classPrereqSerialObj = new ClassPrereqOfMessageSerialObj();
            classPrereqSerialObj.setClassid(originalPrereq.getClassid());
            classPrereqSerialObj.setCourseid(originalPrereq.getCourseid());
            classPrereqSerialObj.setGrade(originalPrereq.getGrade());
            classPrereqSerialObj.setReqMet(originalPrereq.isReqMet());
            prereqSerialList.add(classPrereqSerialObj);
        }
        classInfoSerialObj.setPrereqClasses(prereqSerialList);
        
        StudentInfoOfMessageSerialObj studentInfoSerialObj = new StudentInfoOfMessageSerialObj();
        studentInfoSerialObj.setEmail(studentInformation.getEmail());
        studentInfoSerialObj.setStuid(studentInformation.getStudentid());
        studentInfoSerialObj.setValid(studentInformation.isValid());
        
        StuClassInfoMQSerialObj stuClassInfoMQSerialObj = new StuClassInfoMQSerialObj();
        stuClassInfoMQSerialObj.setClassInfo(classInfoSerialObj);
        stuClassInfoMQSerialObj.setStudentInfo(studentInfoSerialObj);
        
        return stuClassInfoMQSerialObj;
    }
}
