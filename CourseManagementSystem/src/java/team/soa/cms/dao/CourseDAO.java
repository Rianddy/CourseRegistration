/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.dao;

import java.util.List;
import org.netbeans.xml.schema.coursexmlschema.Course;

/**
 *
 * @author Edison, edited by Kevin
 */
public interface CourseDAO {
    public Course getOneCourse(int course_ID);
    
    public List<Course> getAllCourses();
}
