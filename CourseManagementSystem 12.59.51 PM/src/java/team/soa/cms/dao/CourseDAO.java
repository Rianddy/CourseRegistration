/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.dao;

import org.netbeans.xml.schema.coursexmlschema.Course;

/**
 *
 * @author Edison
 */
public interface CourseDAO {
    public Course getOneCourse(int course_ID);
}
