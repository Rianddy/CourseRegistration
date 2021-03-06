/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.dao.Implement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.xml.schema.coursexmlschema.Course;
import team.soa.cms.dao.CourseDAO;
import team.soa.cms.dao.GeneralDAO;

/**
 *
 * @author Edison, edited by Kevin
 */
public class CourseDAOImpl extends GeneralDAO implements CourseDAO{

    @Override
    public Course getOneCourse(int course_ID) {
        Course cos = new Course();
        try {
            this.OpenConnection();
            this.sql = "select * from Course where Cos_ID="+course_ID;
            rs =stmt.executeQuery(sql);
            while (rs.next()){
                cos.setCoursename(rs.getString("Name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cos;
    }
    
    @Override
    public List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<Course>();
        Course cos = new Course();
        try {
            this.OpenConnection();
            this.sql = "select * from Course";
            rs =stmt.executeQuery(sql);
            while (rs.next()){
                cos.setCoursename(rs.getString("Name"));
                courses.add(cos);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courses;
    }
    
}
