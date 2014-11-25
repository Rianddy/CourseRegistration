/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.dao.Implement;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.xml.schema.classxmlschema.Class;
import org.netbeans.xml.schema.facultyxmlschema.Faculty;
import org.netbeans.xml.schema.semesterxmlschema.Semester;
import team.soa.cms.dao.ClassDAO;
import team.soa.cms.dao.FacultyDAO;
import team.soa.cms.dao.GeneralDAO;
import team.soa.cms.dao.SemesterDAO;
/**
 *
 * @author Edison
 */
public class ClassDAOImpl extends GeneralDAO implements ClassDAO{
    
    public ClassDAOImpl(){
        
    }
    /*
	Ruiting Yi Nov 6
	
	
	*/

    @Override
    public void update(int class_id, Class cls) {
       
          String class_ID = cls.getClassid();
          int maxSize = cls.getMaxsize();
          int maxWaitList = cls.getMaxwaitlist();
          
          int curSize = cls.getCursize();
          int curWaitList = cls.getCurwaitlist();
            
          try {
            this.OpenConnection();
            
            this.sql = "UPDATE class SET Max_Size = '"+maxSize+"',Max_WaitList ='"+maxWaitList+"',Cur_Size='"+curSize+"',Cur_WaitList='"+curWaitList+"' WHERE Cls_ID  = '"+class_ID+"' ";
            
            stmt.executeUpdate(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    @Override
    public Faculty getFacultyInfo(int class_id) {
        try {
            this.OpenConnection();
            this.sql = "select * from Class where cls_id="+class_id;
            rs =stmt.executeQuery(sql);
            String fac_ID="",Open_Sem_ID="";
            while (rs.next()){
                fac_ID =rs.getString("Fac_ID"); 
            }
            Faculty fac= new Faculty();
            FacultyDAO facDAO = new FacultyDAOImpl();
            fac =facDAO.getOneFaculty(Integer.parseInt(fac_ID));
            return fac;
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public Class getOneClass(int class_id) {
        Class cls = new Class();
        try {
            this.OpenConnection();
            this.sql = "select * from Class where cls_id="+class_id;
            rs =stmt.executeQuery(sql);
            String fac_ID="",Open_Sem_ID="";
            while (rs.next()){
                cls.setClassid(rs.getString("cls_ID"));
                cls.setCosid(rs.getString("cos_ID"));
                cls.setCursize(Integer.parseInt(rs.getString("Cur_Size")));
                cls.setCurwaitlist(Integer.parseInt(rs.getString("Cur_WaitList")));
                cls.setMaxsize(Integer.parseInt(rs.getString("Max_Size")));
                cls.setMaxwaitlist(Integer.parseInt(rs.getString("Max_WaitList")));
                fac_ID =rs.getString("Fac_ID");
                Open_Sem_ID =rs.getString("Open_Sem_ID");   
            }
            Faculty fac= new Faculty();
            FacultyDAO facDAO = new FacultyDAOImpl();
            fac =facDAO.getOneFaculty(Integer.parseInt(fac_ID));
            cls.setFacultyname(fac.getFacname());
            
            Semester sem = new Semester();
            SemesterDAO semDAO = new SemesterDAOImpl();
            sem =semDAO.getOneSemester(Integer.parseInt(Open_Sem_ID));
            cls.setAdddropdate(sem.getAdddropdate());
            cls.setOpensemid(sem.getSemid());
            cls.setSemname(sem.getSemname());
            cls.setStartdate(sem.getStartdate());
            cls.setEnddate(sem.getEnddate());
            /*To do the other information*/
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cls; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getFacultyEmailFromClass(int class_id) {
        Class cls = new Class();
        try {
            this.OpenConnection();
            this.sql = "select * from Class where cls_id="+class_id;
            rs =stmt.executeQuery(sql);
            String fac_ID="",Open_Sem_ID="";
            while (rs.next()){
                cls.setClassid(rs.getString("cls_ID"));
                cls.setCosid(rs.getString("cos_ID"));
                cls.setCursize(Integer.parseInt(rs.getString("Cur_Size")));
                cls.setCurwaitlist(Integer.parseInt(rs.getString("Cur_WaitList")));
                cls.setMaxsize(Integer.parseInt(rs.getString("Max_Size")));
                cls.setMaxwaitlist(Integer.parseInt(rs.getString("Max_WaitList")));
                fac_ID =rs.getString("Fac_ID");
                Open_Sem_ID =rs.getString("Open_Sem_ID");   
            }
            Faculty fac= new Faculty();
            FacultyDAO facDAO = new FacultyDAOImpl();
            fac =facDAO.getOneFaculty(Integer.parseInt(fac_ID));
            return fac.getFacemail();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    @Override
    public void insert(Class cls) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int class_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
    
}
