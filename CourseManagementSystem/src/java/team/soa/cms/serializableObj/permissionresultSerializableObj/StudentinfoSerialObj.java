/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.serializableObj.permissionresultSerializableObj;

import java.io.Serializable;
import org.netbeans.xml.schema.stuclassppermresultxmlschema.Permissionresult;

/**
 *
 * @author YIYI
 */
public class StudentinfoSerialObj implements Serializable{
    
     private String stuid;
     private String stuname;
     private String stuemail;

     public StudentinfoSerialObj(){}
     public StudentinfoSerialObj(Permissionresult.Studentinfo stuinfo){
        this.stuid = stuinfo.getStuid();
        this.stuname = stuinfo.getStuname();
        this.stuemail = stuinfo.getStuemail();
     }
     
     public Permissionresult.Studentinfo deserializeToStudentinfo(){
     
         Permissionresult.Studentinfo stuin = new Permissionresult.Studentinfo();
         stuin.setStuid(stuid);
         stuin.setStuname(stuname);
         stuin.setStuemail(stuemail);
         return stuin;
     }
     
    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStuemail() {
        return stuemail;
    }

    public void setStuemail(String stuemail) {
        this.stuemail = stuemail;
    }
     
}


