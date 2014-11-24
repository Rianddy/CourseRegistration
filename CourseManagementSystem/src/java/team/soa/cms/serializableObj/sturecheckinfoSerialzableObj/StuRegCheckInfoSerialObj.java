/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.serializableObj.sturecheckinfoSerialzableObj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.netbeans.xml.schema.studentregcheck.ClassInfo;
import org.netbeans.xml.schema.studentregcheck.ClassList;
import org.netbeans.xml.schema.studentregcheck.StuRegCheckInfo;
import org.netbeans.xml.schema.studentregcheck.StudentInformation;

/**
 *
 * @author YIYI
 */
public class StuRegCheckInfoSerialObj  implements Serializable {
  
     private int stuid;
     private String email;
     private boolean valid;
     
     private List<ClassInfoSerialObj> classlist;
   

     public StuRegCheckInfoSerialObj (){}

     public StuRegCheckInfoSerialObj (StuRegCheckInfo srcinfoObj){
     
     this.stuid = Integer.valueOf(srcinfoObj.getStudentInfo().getStudentid());
     this.email = srcinfoObj.getStudentInfo().getEmail();
     this.valid = srcinfoObj.getStudentInfo().isValid();
     this.classlist = new ArrayList();
     
     int size = srcinfoObj.getClazzInfo().getClazz().size();
     
      for(int i=0;i<size;i++){
       
           ClassInfoSerialObj serialObj = new ClassInfoSerialObj(srcinfoObj.getClazzInfo().getClazz().get(i));
           this.classlist.add(serialObj);
        
        }
     }
     
       public StuRegCheckInfo deserializeToStuRegCheckInfo(){
       
         StuRegCheckInfo srcinfo = new StuRegCheckInfo();
         StudentInformation stuinfo = new StudentInformation();
         stuinfo.setStudentid(stuid+"");
         stuinfo.setEmail(email);
         stuinfo.setValid(valid);
         srcinfo.setStudentInfo(stuinfo);
         
         ClassList clist = new ClassList(); 
         
         for(int i=0;i<classlist.size();i++){
               ClassInfo classinfo = classlist.get(i).deserializeToClassInfo();
               clist.getClazz().add(classinfo);
            }
         
         srcinfo.setClazzInfo(clist);
         
         return srcinfo;
       }
     
     
     
     
    /**
     * @return the stuid
     */
    public int getStuid() {
        return stuid;
    }

    /**
     * @param stuid the stuid to set
     */
    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the valid
     */
    public boolean isValid() {
        return valid;
    }

    /**
     * @param valid the valid to set
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    /**
     * @return the classlist
     */
    public List<ClassInfoSerialObj> getClasslist() {
        return classlist;
    }

    /**
     * @param classlist the classlist to set
     */
    public void setClasslist(List<ClassInfoSerialObj> classlist) {
        this.classlist = classlist;
    }



}



