/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.serializableObj;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.netbeans.xml.schema.stuclassmessagexmlschema.Stuclassmessage;

/**
 *
 * @author YIYI
 */
public class StuClassInfoMQSerialObj implements Serializable {

    private int stuid;
    private String stuname;
    private String stuemail;
    private String department;
    private String major;
    private String concentration;
    private String birthday;
    private String address;
    private String cell;

    private List<Requestclassinfo> requestclasslist;

    public StuClassInfoMQSerialObj() {
    }

    public StuClassInfoMQSerialObj(Stuclassmessage scmg) {

        this.stuid = Integer.valueOf(scmg.getStudentinfo().getStuid());
        this.stuname = scmg.getStudentinfo().getStuname();
        this.stuemail = scmg.getStudentinfo().getStuemail();
        this.department = scmg.getStudentinfo().getDepartment();
        this.major = scmg.getStudentinfo().getMajor();
        this.concentration = scmg.getStudentinfo().getConcentration();

        XMLGregorianCalendar xmlDatetime = scmg.getStudentinfo().getBirthday();
        GregorianCalendar nowGregorianCalendar = xmlDatetime.toGregorianCalendar();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateTimeString = simpleDateFormat.format(nowGregorianCalendar.getTime());
        this.birthday = dateTimeString;//yyyy-MM-dd 

        this.address = scmg.getStudentinfo().getAddress();
        this.cell = scmg.getStudentinfo().getCell();

        this.requestclasslist = new ArrayList<Requestclassinfo>();

        int size = scmg.getRequestclassinfo().size();
        System.out.println("In StuClassInfoMQSerialObj, " + stuname + " has " + size + " courses which needs permission code.");
        for (int i = 0; i < size; i++) {

            Requestclassinfo one = new Requestclassinfo();
            one.setClassid(Integer.valueOf(scmg.getRequestclassinfo().get(i).getClassid()));
            System.out.println("Class id: " + one.getClassid());
            one.setCourseid(scmg.getRequestclassinfo().get(i).getCourseid());
            System.out.println("Course id : " + one.getCourseid());
            one.setCoursename(scmg.getRequestclassinfo().get(i).getCoursename());
            System.out.println("Course name: " + one.getCoursename());
            one.setMaxsize(scmg.getRequestclassinfo().get(i).getMaxsize());
            System.out.println("Max size: " + one.getMaxsize());
            one.setCurrsize(scmg.getRequestclassinfo().get(i).getCurrsize());
            System.out.println("Current size: " + one.getCurrsize());
            one.setMaxwaitlist(scmg.getRequestclassinfo().get(i).getMaxwaitlist());
            System.out.println("Max waitlist: " + one.getMaxwaitlist());
            one.setCurwaitlist(scmg.getRequestclassinfo().get(i).getCurwaitlist());
            System.out.println("Current waitlist: " + one.getCurwaitlist());
            one.setOpensemester(scmg.getRequestclassinfo().get(i).getOpensemester());
            System.out.println("Open semester: " + one.getOpensemester());
            one.setFacultyid(Integer.valueOf(scmg.getRequestclassinfo().get(i).getFacultyid()));
            System.out.println("Faculty id: " + one.getFacultyid());
            one.setFacultyname(scmg.getRequestclassinfo().get(i).getFacultyname());
            System.out.println("Faculty name: " + one.getFacultyname());

        }

    }

    /**
     * ************************************************11/17/2014 Update --- Start*********************************************
     */
      public Stuclassmessage deserializeToStuclassmessage(){
      Stuclassmessage scmsg = new Stuclassmessage();
      Stuclassmessage.Studentinfo stuinfo = new Stuclassmessage.Studentinfo();
      
      String sid = this.stuid+"";
      System.out.println("deserializeToStuclassmessage "+sid);
      stuinfo.setStuid(sid);
      stuinfo.setStuname(stuname);
      stuinfo.setStuemail(stuemail);
      stuinfo.setDepartment(department);
      stuinfo.setMajor(major);
      stuinfo.setConcentration(concentration);
      
      GregorianCalendar nowGregorianCalendar =new GregorianCalendar(); 
      SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy-MM-dd");  
      XMLGregorianCalendar xmlDatetime = null;
      try {      
           nowGregorianCalendar.setTime(simpleDateFormat.parse(birthday));
           xmlDatetime= DatatypeFactory.newInstance().newXMLGregorianCalendar(nowGregorianCalendar);
                   
       } catch (ParseException ex) {
           Logger.getLogger(StuClassInfoMQSerialObj.class.getName()).log(Level.SEVERE, null, ex);
       } catch (DatatypeConfigurationException ex) {
           Logger.getLogger(StuClassInfoMQSerialObj.class.getName()).log(Level.SEVERE, null, ex);
       }
      
      stuinfo.setBirthday(xmlDatetime);
      stuinfo.setAddress(address);
      stuinfo.setCell(cell);
  
      scmsg.setStudentinfo(stuinfo);

      int size = requestclasslist.size();
      for(int j=0;j<size;j++){
      
        Stuclassmessage.Requestclassinfo reclassinfo = new  Stuclassmessage.Requestclassinfo();
        
        String ccid = requestclasslist.get(j).getClassid()+"";
        reclassinfo.setClassid(ccid);
        String csid = requestclasslist.get(j).getCourseid()+"";
        reclassinfo.setCourseid(csid);
        reclassinfo.setCoursename(requestclasslist.get(j).getCoursename());
        reclassinfo.setMaxsize(requestclasslist.get(j).getMaxsize());
        reclassinfo.setCurrsize(requestclasslist.get(j).getCurrsize());
        reclassinfo.setMaxwaitlist(requestclasslist.get(j).getMaxwaitlist());
        reclassinfo.setCurwaitlist(requestclasslist.get(j).getCurwaitlist());
        reclassinfo.setOpensemester(requestclasslist.get(j).getOpensemester());
        String ffid = (requestclasslist.get(j).getFacultyid())+"";
        reclassinfo.setFacultyid(ffid);
        reclassinfo.setFacultyname(requestclasslist.get(j).getFacultyname());
       
        scmsg.getRequestclassinfo().add(reclassinfo);
      }
      
      
      
      return scmsg;
   }

    /**
     * ************************************************11/17/2014 Update --- End*********************************************
     */
    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getConcentration() {
        return concentration;
    }

    public void setConcentration(String concentration) {
        this.concentration = concentration;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public List<Requestclassinfo> getRequestclasslist() {
        return requestclasslist;
    }

    public void setRequestclasslist(List<Requestclassinfo> requestclasslist) {
        this.requestclasslist = requestclasslist;
    }

}

class Requestclassinfo implements Serializable {

    private int classid;
    private String courseid;
    private String coursename;
    private int maxsize;
    private int currsize;
    private int maxwaitlist;
    private int curwaitlist;
    private String opensemester;
    private int facultyid;
    private String facultyname;

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
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

    public int getMaxsize() {
        return maxsize;
    }

    public void setMaxsize(int maxsize) {
        this.maxsize = maxsize;
    }

    public int getCurrsize() {
        return currsize;
    }

    public void setCurrsize(int currsize) {
        this.currsize = currsize;
    }

    public int getMaxwaitlist() {
        return maxwaitlist;
    }

    public void setMaxwaitlist(int maxwaitlist) {
        this.maxwaitlist = maxwaitlist;
    }

    public int getCurwaitlist() {
        return curwaitlist;
    }

    public void setCurwaitlist(int curwaitlist) {
        this.curwaitlist = curwaitlist;
    }

    public String getOpensemester() {
        return opensemester;
    }

    public void setOpensemester(String opensemester) {
        this.opensemester = opensemester;
    }

    public int getFacultyid() {
        return facultyid;
    }

    public void setFacultyid(int facultyid) {
        this.facultyid = facultyid;
    }

    public String getFacultyname() {
        return facultyname;
    }

    public void setFacultyname(String facultyname) {
        this.facultyname = facultyname;
    }

}
