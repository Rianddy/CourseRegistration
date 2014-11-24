/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.serializableObj.stuclassmessageSerializableObj;

import java.io.Serializable;
import org.netbeans.xml.schema.stuclassmessagexmlschema.ClassPrereq;

/**
 *
 * @author YIYI
 */
public class ClassPrereqSerialObj implements Serializable{
     
    private String classid;
    private String courseid;
    private String grade;
    private boolean reqMet;
    
    public ClassPrereqSerialObj(){}
 
    public ClassPrereqSerialObj( ClassPrereq obj){
     
        this.classid = obj.getClassid();
        this.courseid = obj.getCourseid();
        this.grade = obj.getGrade();
        this.reqMet = obj.isReqMet();
    }
    

    public ClassPrereq deserializeToClassPrereq(){
      ClassPrereq retObj = new ClassPrereq();
      retObj.setClassid(classid);
      retObj.setCourseid(courseid);
      retObj.setGrade(grade);
      retObj.setReqMet(reqMet);
      return retObj;
    }
    
    
    /**
     * @return the classid
     */
    public String getClassid() {
        return classid;
    }

    /**
     * @param classid the classid to set
     */
    public void setClassid(String classid) {
        this.classid = classid;
    }

    /**
     * @return the courseid
     */
    public String getCourseid() {
        return courseid;
    }

    /**
     * @param courseid the courseid to set
     */
    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    /**
     * @return the grade
     */
    public String getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(String grade) {
        this.grade = grade;
    }

    /**
     * @return the reqMet
     */
    public boolean isReqMet() {
        return reqMet;
    }

    /**
     * @param reqMet the reqMet to set
     */
    public void setReqMet(boolean reqMet) {
        this.reqMet = reqMet;
    }
}