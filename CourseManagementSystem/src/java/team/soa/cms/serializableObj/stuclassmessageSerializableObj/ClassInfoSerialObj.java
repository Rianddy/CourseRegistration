/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.serializableObj.stuclassmessageSerializableObj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.netbeans.xml.schema.stuclassmessagexmlschema.ClassInfo;
import org.netbeans.xml.schema.stuclassmessagexmlschema.ClassPrereq;

/**
 *
 * @author YIYI
 */
public class ClassInfoSerialObj implements Serializable{
    
    private  String classid;
    private  boolean classvalid;
    private  String classstatus;
    private  boolean canTake;
    private  List<ClassPrereqSerialObj> prereqClasses;
    
    public ClassInfoSerialObj(){}
    
    public ClassInfoSerialObj(ClassInfo obj){
    
        this.classid = obj.getClassid();
        this.classvalid = obj.isClassvalid();
        this.classstatus = obj.getClassstatus();
        this.canTake = obj.isCanTake();
        
        this.prereqClasses = new ArrayList();
    
        int size = obj.getPrereqClasses().size();
        
        for(int i=0;i<size;i++){
        
           ClassPrereqSerialObj serialObj = new ClassPrereqSerialObj( obj.getPrereqClasses().get(i));
           this.prereqClasses.add(serialObj);
        
        }
    }
    
    
     public ClassInfo deserializeToClassInfo(){
       ClassInfo retciObj = new ClassInfo();
       retciObj.setClassid(classid);
       retciObj.setClassvalid(classvalid);
       retciObj.setClassstatus(classstatus);
       retciObj.setCanTake(canTake);
       int s = prereqClasses.size();
       
       for(int j=0;j<s;j++){
          
           ClassPrereq cpr = new ClassPrereq();
           cpr = prereqClasses.get(j).deserializeToClassPrereq();
           retciObj.getPrereqClasses().add(cpr);
       }
       
       return retciObj;
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
     * @return the classvalid
     */
    public boolean isClassvalid() {
        return classvalid;
    }

    /**
     * @param classvalid the classvalid to set
     */
    public void setClassvalid(boolean classvalid) {
        this.classvalid = classvalid;
    }

    /**
     * @return the classstatus
     */
    public String getClassstatus() {
        return classstatus;
    }

    /**
     * @param classstatus the classstatus to set
     */
    public void setClassstatus(String classstatus) {
        this.classstatus = classstatus;
    }

    /**
     * @return the canTake
     */
    public boolean isCanTake() {
        return canTake;
    }

    /**
     * @param canTake the canTake to set
     */
    public void setCanTake(boolean canTake) {
        this.canTake = canTake;
    }

    /**
     * @return the prereqClasses
     */
    public List<ClassPrereqSerialObj> getPrereqClasses() {
        return prereqClasses;
    }

    /**
     * @param prereqClasses the prereqClasses to set
     */
    public void setPrereqClasses(List<ClassPrereqSerialObj> prereqClasses) {
        this.prereqClasses = prereqClasses;
    }




}
    