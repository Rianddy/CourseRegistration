/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.serializableObj.stuclassmessageSerializableObj;

import org.netbeans.xml.schema.stuclassmessagexmlschema.StudentInfo;
import org.netbeans.xml.schema.studentregcheck.StudentInformation;

/**
 *
 * @author riand_000
 */
public class StudentInfoSerialObj {

    private String stuid;
    private String email;
    private boolean valid;

    public StudentInfoSerialObj(StudentInfo studentInfo){
        this.stuid = studentInfo.getStudentid();
        this.email = studentInfo.getEmail();
        this.valid = studentInfo.isValid();
    }
    
    public StudentInfo deserializeToStudentInfo(){
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setEmail(email);
        studentInfo.setStudentid(stuid);
        studentInfo.setValid(valid);
        return studentInfo;
    }
    
    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
    
    
}
