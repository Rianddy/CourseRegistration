/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.serializableObj;

import java.io.Serializable;
import org.netbeans.xml.schema.stuclassmessagexmlschema.Stuclassmessage;
import team.soa.cms.serializableObj.stuclassmessageSerializableObj.StudentInfoOfMessageSerialObj;
import team.soa.cms.serializableObj.stuclassmessageSerializableObj.ClassInfoOfMessageSerialObj;

/**
 *
 * @author YIYI
 */
public class StuClassInfoMQSerialObj implements Serializable {

    private StudentInfoOfMessageSerialObj studentInfo;
    
    private ClassInfoOfMessageSerialObj classInfo;

    public StuClassInfoMQSerialObj(){};
    
    public StuClassInfoMQSerialObj(Stuclassmessage stuClassMessage){
        this.studentInfo = new StudentInfoOfMessageSerialObj(stuClassMessage.getStudentinfo());
        this.classInfo = new ClassInfoOfMessageSerialObj(stuClassMessage.getRequestClass());
    }
    
    public Stuclassmessage deserializeToStuClass(){
        Stuclassmessage stuClassInfo = new Stuclassmessage();
        stuClassInfo.setRequestClass(classInfo.deserializeToClassInfo());
        stuClassInfo.setStudentinfo(studentInfo.deserializeToStudentInfo());
        return stuClassInfo;
    }
    
    public StudentInfoOfMessageSerialObj getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfoOfMessageSerialObj studentInfo) {
        this.studentInfo = studentInfo;
    }

    public ClassInfoOfMessageSerialObj getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfoOfMessageSerialObj classInfo) {
        this.classInfo = classInfo;
    }
    
    
    
}
