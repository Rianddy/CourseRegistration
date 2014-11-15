/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.dao;
import org.netbeans.xml.schema.classxmlschema.Class;
/**
 *
 * @author Edison
 */
public interface ClassDAO {
    public Class getOneClass(int class_id);
    
    public void insert(Class cls);
    
    public void delete(int class_id);
    
    public void update(int class_id, Class cls);
    
}
