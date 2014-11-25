/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.dao.Implement;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.xml.schema.facultyxmlschema.Faculty;
import team.soa.cms.dao.FacultyDAO;
import team.soa.cms.dao.GeneralDAO;

/**
 *
 * @author Edison
 */
public class FacultyDAOImpl extends GeneralDAO implements FacultyDAO {
    
    public FacultyDAOImpl(){
        
    }
    
    @Override
    public Faculty getOneFaculty(int Fac_ID) {
        Faculty fac = new Faculty();
        try {
            this.OpenConnection();
            this.sql = "SELECT * FROM Faculty where Fac_ID="+Fac_ID;
            rs =stmt.executeQuery(sql);
            while(rs.next()){
                fac.setFaccell(rs.getString("cell"));
                fac.setFacdepart(rs.getString("Dep_ID"));
                fac.setFacstatus(rs.getString("status"));
                fac.setFacname(rs.getString("name"));
                fac.setFacid(rs.getString("Fac_ID"));
                fac.setFacemail(rs.getString("email"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FacultyDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return fac;
    }
    
}
