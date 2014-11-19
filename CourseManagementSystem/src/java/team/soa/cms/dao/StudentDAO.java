/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.dao;

import org.netbeans.xml.schema.studentxmlschema.Student;

/**
 *
 * @author Edison
 */
public interface StudentDAO {
    public Student getOneStudent(int stu_id);
    
    public void insert(Student stu);
    
    public void delete(int ori_stu_id);
    
    public void updata(int ori_stu_id, Student stu);
}
