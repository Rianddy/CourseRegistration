/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.dao.Implement;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.netbeans.xml.schema.semesterxmlschema.Semester;
import team.soa.cms.dao.GeneralDAO;
import team.soa.cms.dao.SemesterDAO;

/**
 *
 * @author Edison
 */
public class SemesterDAOImpl extends GeneralDAO implements SemesterDAO {
    
    public SemesterDAOImpl(){
    
    }
    @Override
    public Semester getOneSemester(int Sem_ID) {
        Semester sem = new Semester();
        try {
            
            this.OpenConnection();
            this.sql = "select * from Semester where Sem_ID="+Sem_ID;
            rs = stmt.executeQuery(sql);
            XMLGregorianCalendar xmlDate;
            GregorianCalendar cal = new GregorianCalendar();

            while (rs.next()){
                sem.setSemname(rs.getString("Short_Name"));
                sem.setSemid(rs.getString("Sem_ID"));
                
                cal.setTime(rs.getDate("Add_Drop_Date"));
                xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
                sem.setAdddropdate(xmlDate);
                
                cal.setTime(rs.getDate("End_Date"));
                xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
                sem.setEnddate(xmlDate);
                
                cal.setTime(rs.getDate("Start_Date"));
                xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH)+1, cal.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
                sem.setStartdate(xmlDate);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(SemesterDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(SemesterDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sem;
    }
    
    public  static  void main(String args[]){
        SemesterDAOImpl semDAO = new SemesterDAOImpl();
        Semester sem=semDAO.getOneSemester(1);
        System.out.println(sem.getAdddropdate());
        
        System.out.println(sem.getEnddate());
        
        System.out.println(sem.getStartdate());
        
        System.out.println(sem.getSemname());
        
    }
    
}
