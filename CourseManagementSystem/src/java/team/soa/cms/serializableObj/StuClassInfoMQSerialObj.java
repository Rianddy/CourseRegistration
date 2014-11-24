/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.serializableObj;

import java.io.Serializable;
import org.netbeans.xml.schema.stuclassmessagexmlschema.Stuclassmessage;
import team.soa.cms.serializableObj.stuclassmessageSerializableObj.StudentInfoSerialObj;
import team.soa.cms.serializableObj.stuclassmessageSerializableObj.ClassInfoSerialObj;

/**
 *
 * @author YIYI
 */
public class StuClassInfoMQSerialObj implements Serializable {

    private StudentInfoSerialObj studentInfo;
    
    private ClassInfoSerialObj classInfo;

    
    public StuClassInfoMQSerialObj(Stuclassmessage stuClassMessage){
        this.studentInfo = new StudentInfoSerialObj(stuClassMessage.getStudentinfo());
        this.classInfo = new ClassInfoSerialObj(stuClassMessage.getRequestClass());
    }
    
    public Stuclassmessage deserializeToStuClass(){
        Stuclassmessage stuClassInfo = new Stuclassmessage();
        stuClassInfo.setRequestClass(classInfo.deserializeToClassInfo());
        stuClassInfo.setStudentinfo(studentInfo.deserializeToStudentInfo());
        return stuClassInfo;
    }
    
    public StudentInfoSerialObj getStudentInfo() {
        return studentInfo;
    }

    public void setStudentInfo(StudentInfoSerialObj studentInfo) {
        this.studentInfo = studentInfo;
    }

    public ClassInfoSerialObj getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfoSerialObj classInfo) {
        this.classInfo = classInfo;
    }
    
    
    
}
