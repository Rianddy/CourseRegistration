/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.dao.Implement;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.xml.schema.coursexmlschema.Course;
import org.netbeans.xml.schema.prerequestxmlschema.Prerequestment;
import org.netbeans.xml.schema.prerequestxmlschema.Prerequestment.Onepre;
import team.soa.cms.dao.ClassDAO;
import team.soa.cms.dao.CourseDAO;
import team.soa.cms.dao.GeneralDAO;
import team.soa.cms.dao.PrerequestmentDAO;

/**
 *
 * @author Edison
 */
public class PrerequestmentDAOImpl extends GeneralDAO implements PrerequestmentDAO{

    @Override
    public Prerequestment getPrerequestmentByClassId(int class_ID) {
        Prerequestment preList = new Prerequestment();
        ClassDAO clsDAO = new ClassDAOImpl();
        int course_ID = Integer.parseInt(clsDAO.getOneClass(class_ID).getCosid());
        return this.getPrerequestmentByCourseId(course_ID);
    }

    @Override
    public Prerequestment getPrerequestmentByCourseId(int course_ID) {
        Prerequestment preList = new Prerequestment();
        try {
            this.OpenConnection();
            this.sql="SELECT * FROM course where course_ID="+course_ID;
            rs= stmt.executeQuery(sql);
            CourseDAO cosDAO = new CourseDAOImpl();
           
            while(rs.next()){
                Onepre pre = new Onepre();
                pre.setCourseid(rs.getString("Pre_Cos_ID"));
                Course cos =cosDAO.getOneCourse(Integer.parseInt(rs.getString("Pre_Cos_ID")));
                pre.setCoursename(cos.getCoursename());
                preList.getOnepre().add(pre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrerequestmentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return preList;
    }
    
}
