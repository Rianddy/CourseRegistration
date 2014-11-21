/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.serializableObj;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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

   //private List<Requestclassinfo> requestclasslist;
    public StuClassInfoMQSerialObj() {
    }

    public StuClassInfoMQSerialObj(Stuclassmessage scmg) {

//   this.stuid = Integer.valueOf(scmg.getStudentinfo().getStuid());
//   this.stuname = scmg.getStudentinfo().getStuname();
//   this.stuemail = scmg.getStudentinfo().getStuemail();
//   this.department = scmg.getStudentinfo().getDepartment();
//   this.major = scmg.getStudentinfo().getMajor();
//   this.concentration = scmg.getStudentinfo().getConcentration();
//   this.birthday = null;//scmg.getStudentinfo().getBirthday().toString();
//   this.address = scmg.getStudentinfo().getAddress();
//   this.cell = scmg.getStudentinfo().getCell();
//   
//   this.requestclasslist = new ArrayList<Requestclassinfo>();
//   
//   int size = scmg.getRequestclassinfo().size();
//   System.out.println("In StuClassInfoMQSerialObj, "+stuname+" has "+size +" courses which needs permission code.");
//   for(int i=0;i<size;i++){
//       
//      Requestclassinfo one = new Requestclassinfo();
//      one.setClassid(Integer.valueOf(scmg.getRequestclassinfo().get(i).getClassid()));
//      System.out.println("Class id: "+one.getClassid());
//      one.setCourseid(scmg.getRequestclassinfo().get(i).getCourseid());
//      System.out.println("Course id : "+one.getCourseid());
//      one.setCoursename(scmg.getRequestclassinfo().get(i).getCoursename());
//      System.out.println("Course name: "+one.getCoursename());
//      one.setMaxsize(scmg.getRequestclassinfo().get(i).getMaxsize());
//      System.out.println("Max size: "+one.getMaxsize());
//      one.setCurrsize(scmg.getRequestclassinfo().get(i).getCurrsize());
//      System.out.println("Current size: "+one.getCurrsize());
//      one.setMaxwaitlist(scmg.getRequestclassinfo().get(i).getMaxwaitlist());
//      System.out.println("Max waitlist: "+one.getMaxwaitlist());
//      one.setCurwaitlist(scmg.getRequestclassinfo().get(i).getCurwaitlist());
//      System.out.println("Current waitlist: "+one.getCurwaitlist());
//      one.setOpensemester(scmg.getRequestclassinfo().get(i).getOpensemester());
//      System.out.println("Open semester: "+one.getOpensemester());
//      one.setFacultyid(Integer.valueOf(scmg.getRequestclassinfo().get(i).getFacultyid()));
//      System.out.println("Faculty id: "+one.getFacultyid());
//      one.setFacultyname(scmg.getRequestclassinfo().get(i).getFacultyname());
//      System.out.println("Faculty name: "+one.getFacultyname());
//      
//   }
    }
//   
//   
//   
//   
//   
//
//    public int getStuid() {
//        return stuid;
//    }
//
//    public void setStuid(int stuid) {
//        this.stuid = stuid;
//    }
//
//    public String getStuname() {
//        return stuname;
//    }
//
//    public void setStuname(String stuname) {
//        this.stuname = stuname;
//    }
//
//    public String getStuemail() {
//        return stuemail;
//    }
//
//    public void setStuemail(String stuemail) {
//        this.stuemail = stuemail;
//    }
//
//    public String getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(String department) {
//        this.department = department;
//    }
//
//    public String getMajor() {
//        return major;
//    }
//
//    public void setMajor(String major) {
//        this.major = major;
//    }
//
//    public String getConcentration() {
//        return concentration;
//    }
//
//    public void setConcentration(String concentration) {
//        this.concentration = concentration;
//    }
//
//    public String getBirthday() {
//        return birthday;
//    }
//
//    public void setBirthday(String birthday) {
//        this.birthday = birthday;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getCell() {
//        return cell;
//    }
//
//    public void setCell(String cell) {
//        this.cell = cell;
//    }
//
//    public List<Requestclassinfo> getRequestclasslist() {
//        return requestclasslist;
//    }
//
//    public void setRequestclasslist(List<Requestclassinfo> requestclasslist) {
//        this.requestclasslist = requestclasslist;
//    }
//    
//    
//}
//class Requestclassinfo implements Serializable{
//
//  private int classid;
//  private String courseid;;
//  private String coursename;;
//  private int maxsize;;
//  private int currsize;;
//  private int maxwaitlist;;
//  private int curwaitlist;;
//  private String opensemester;;
//  private int facultyid;;
//  private String facultyname;
//
//    public int getClassid() {
//        return classid;
//    }
//
//    public void setClassid(int classid) {
//        this.classid = classid;
//    }
//
//    public String getCourseid() {
//        return courseid;
//    }
//
//    public void setCourseid(String courseid) {
//        this.courseid = courseid;
//    }
//
//    public String getCoursename() {
//        return coursename;
//    }
//
//    public void setCoursename(String coursename) {
//        this.coursename = coursename;
//    }
//
//    public int getMaxsize() {
//        return maxsize;
//    }
//
//    public void setMaxsize(int maxsize) {
//        this.maxsize = maxsize;
//    }
//
//    public int getCurrsize() {
//        return currsize;
//    }
//
//    public void setCurrsize(int currsize) {
//        this.currsize = currsize;
//    }
//
//    public int getMaxwaitlist() {
//        return maxwaitlist;
//    }
//
//    public void setMaxwaitlist(int maxwaitlist) {
//        this.maxwaitlist = maxwaitlist;
//    }
//
//    public int getCurwaitlist() {
//        return curwaitlist;
//    }
//
//    public void setCurwaitlist(int curwaitlist) {
//        this.curwaitlist = curwaitlist;
//    }
//
//    public String getOpensemester() {
//        return opensemester;
//    }
//
//    public void setOpensemester(String opensemester) {
//        this.opensemester = opensemester;
//    }
//
//    public int getFacultyid() {
//        return facultyid;
//    }
//
//    public void setFacultyid(int facultyid) {
//        this.facultyid = facultyid;
//    }
//
//    public String getFacultyname() {
//        return facultyname;
//    }
//
//    public void setFacultyname(String facultyname) {
//        this.facultyname = facultyname;
//    }
// 
//
//  
}
