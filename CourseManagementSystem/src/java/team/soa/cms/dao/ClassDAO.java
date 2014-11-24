/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.dao;
import org.netbeans.xml.schema.classxmlschema.Class;
import org.netbeans.xml.schema.facultyxmlschema.Faculty;
/**
 *
 * @author Edison
 */
public interface ClassDAO {
    public Class getOneClass(int class_id);
    
    public void insert(Class cls);
    
    public void delete(int class_id);
    
    public void update(int class_id, Class cls);
    
    public String getFacultyEmailFromClass(int class_id);
    
    public Faculty getFacultyInfo(int class_id) ;
    
}
