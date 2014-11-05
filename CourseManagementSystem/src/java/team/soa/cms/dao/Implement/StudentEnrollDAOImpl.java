/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.dao.Implement;

import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.netbeans.xml.schema.stuenrolxmlschema.StuEnrollList;
import org.netbeans.xml.schema.stuenrolxmlschema.StuEnrollList.Oneenroll;
import team.soa.cms.dao.ClassDAO;
import team.soa.cms.dao.CourseDAO;
import team.soa.cms.dao.GeneralDAO;
import team.soa.cms.dao.StudentEnrollDAO;

/**
 *
 * @author Edison
 */
public class StudentEnrollDAOImpl extends GeneralDAO implements StudentEnrollDAO{

    @Override
    public String insert(int Class_ID, int Stu_ID) {
        try{
            this.OpenConnection();
            this.sql ="INSERT INTO StudentEnrollment(Stu_ID,Cls_ID) values("+Stu_ID+","+Class_ID+")";
            return ""+stmt.executeUpdate(sql);
        }catch (SQLException ex) {
            Logger.getLogger(StudentEnrollDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return ""+-1;
    }

    @Override
    public StuEnrollList getStudentEnrollment(int Stu_ID) {
        StuEnrollList enrollList = new StuEnrollList();
        try {
            this.OpenConnection();
            this.sql ="SELECT * FROM StudentEnrollment where Stu_ID="+Stu_ID+ " AND (Grade !='F' or Grade is NULL)";
            System.out.println(sql);
            rs = stmt.executeQuery(sql);
            XMLGregorianCalendar xmlDate;
            GregorianCalendar cal = new GregorianCalendar();
            ClassDAO clsDAO = new ClassDAOImpl();
            while (rs.next()){
                Oneenroll enroll = new Oneenroll();
                enroll.setClassid(rs.getString("Cls_ID"));
                enroll.setGrade(rs.getString("Grade"));
                enroll.setScore(Integer.parseInt(rs.getString("Score")));
                enroll.setStatus(rs.getString("status"));
                
                enroll.setCourseid(clsDAO.getOneClass(Integer.parseInt(rs.getString("Cls_ID"))).getCosid());
                cal.setTime(rs.getTimestamp("Stu_Enroll_Time"));
                xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);//(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), cal.get(Calendar.HOUR),cal.get(Calendar.MINUTE),cal.get(Calendar.SECOND),DatatypeConstants.FIELD_UNDEFINED);
                enroll.setStuenrolltime(xmlDate);
                enrollList.getOneenroll().add(enroll);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentEnrollDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(StudentEnrollDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return enrollList;
    }
    
    
    public static void main(String args[]){
        StudentEnrollDAO enrollDAO = new StudentEnrollDAOImpl();
        StuEnrollList list = enrollDAO.getStudentEnrollment(1);
        for (Oneenroll enroll : list.getOneenroll()){
            System.out.println(enroll.getStuenrolltime());
        }
        
        enrollDAO.insert(1,1);
    }
}
