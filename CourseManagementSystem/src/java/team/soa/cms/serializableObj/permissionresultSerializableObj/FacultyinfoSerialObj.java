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
public class FacultyinfoSerialObj implements Serializable{
     private String facid;
     private String facname;
     private String facemail;
     
     public FacultyinfoSerialObj(){}
     
     public FacultyinfoSerialObj(Permissionresult.Facultyinfo facinfo){
        this.facid = facinfo.getFacid();
        this.facname = facinfo.getFacname();
        this.facemail = facinfo.getFacemail();
     }

     public Permissionresult.Facultyinfo deserializeToFacultyinfo(){
       Permissionresult.Facultyinfo facin = new Permissionresult.Facultyinfo();
       facin.setFacid(facid);
       facin.setFacname(facname);
       facin.setFacemail(facemail);
       return facin;
     }
      
    public String getFacid() {
        return facid;
    }

    public void setFacid(String facid) {
        this.facid = facid;
    }

    public String getFacname() {
        return facname;
    }

    public void setFacname(String facname) {
        this.facname = facname;
    }

    public String getFacemail() {
        return facemail;
    }

    public void setFacemail(String facemail) {
        this.facemail = facemail;
    }

}