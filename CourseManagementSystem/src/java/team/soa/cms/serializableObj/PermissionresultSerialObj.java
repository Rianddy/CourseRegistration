/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.serializableObj;

import java.io.Serializable;
import org.netbeans.xml.schema.stuclassppermresultxmlschema.Permissionresult;
import team.soa.cms.serializableObj.permissionresultSerializableObj.ClassinfoSerialObj;
import team.soa.cms.serializableObj.permissionresultSerializableObj.FacultyinfoSerialObj;
import team.soa.cms.serializableObj.permissionresultSerializableObj.StudentinfoSerialObj;

/**
 *
 * @author YIYI
 */
public class PermissionresultSerialObj implements Serializable{
    private StudentinfoSerialObj stuinfoserial;
    private ClassinfoSerialObj   classinfoserial;
    private FacultyinfoSerialObj facinfoserial;

    public PermissionresultSerialObj(){}
    
    public PermissionresultSerialObj(Permissionresult pr){
       this.stuinfoserial = new StudentinfoSerialObj(pr.getStudentinfo());
       this.classinfoserial = new ClassinfoSerialObj(pr.getClassinfo());
       this.facinfoserial = new FacultyinfoSerialObj(pr.getFacultyinfo());
    }
    public Permissionresult deserializeToPermissionresult(){
      Permissionresult re = new Permissionresult();
      re.setStudentinfo(stuinfoserial.deserializeToStudentinfo());
      re.setClassinfo(classinfoserial.deserializeToClassinfo());
      re.setFacultyinfo(facinfoserial.deserializeToFacultyinfo());
      return re;
    }
    
    public StudentinfoSerialObj getStuinfoserial() {
        return stuinfoserial;
    }

    public void setStuinfoserial(StudentinfoSerialObj stuinfoserial) {
        this.stuinfoserial = stuinfoserial;
    }

    public ClassinfoSerialObj getClassinfoserial() {
        return classinfoserial;
    }

    public void setClassinfoserial(ClassinfoSerialObj classinfoserial) {
        this.classinfoserial = classinfoserial;
    }

  

    public FacultyinfoSerialObj getFacinfoserial() {
        return facinfoserial;
    }

    public void setFacinfoserial(FacultyinfoSerialObj facinfoserial) {
        this.facinfoserial = facinfoserial;
    }
    
    
}