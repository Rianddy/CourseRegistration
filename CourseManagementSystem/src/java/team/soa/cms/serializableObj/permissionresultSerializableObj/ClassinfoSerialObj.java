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
public class ClassinfoSerialObj implements Serializable{
    
    private String classid;
    private String courseid;
    private String coursename;
    private String opensemester;
    private String regresult;

    public  ClassinfoSerialObj(){}
    public  ClassinfoSerialObj(Permissionresult.Classinfo clainfo){
     
        this.classid = clainfo.getClassid();
        this.courseid = clainfo.getCourseid();
        this.coursename = clainfo.getCoursename();
        this.opensemester = clainfo.getOpensemester();
        this.regresult = clainfo.getRegresult();
    }
    public Permissionresult.Classinfo deserializeToClassinfo(){
    
       Permissionresult.Classinfo clain = new Permissionresult.Classinfo();
       clain.setClassid(classid);
       clain.setCourseid(courseid);
       clain.setCoursename(coursename);
       clain.setOpensemester(opensemester);
       clain.setRegresult(regresult);
       return clain;
    }
    
    public String getClassid() {
        return classid;
    }

    public void setClassid(String classid) {
        this.classid = classid;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getOpensemester() {
        return opensemester;
    }

    public void setOpensemester(String opensemester) {
        this.opensemester = opensemester;
    }

    public String getRegresult() {
        return regresult;
    }

    public void setRegresult(String regresult) {
        this.regresult = regresult;
    }
    
    
}
    

