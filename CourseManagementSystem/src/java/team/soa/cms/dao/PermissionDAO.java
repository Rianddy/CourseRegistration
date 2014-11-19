/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.dao;

import org.netbeans.xml.schema.permissionxmlschema.Permission;

/**
 *
 * @author YIYI
 */
public interface PermissionDAO {

    public Permission getOnePermissionInfo(int permission_id);
    
    public void insert(Permission permission);
    
    public int insertAcceptPerm(int studentID, int classID, int facultyID);
    
    public int insertRejectPerm(int studentID, int classID, int facultyID);
    
    public boolean acceptCodeExist(int studentID, int classID, int permcode);
    
    public void delete(Permission permission);
    
    public void updateStatus(int permission_id,String permissionStatus);//(int class_id, org.netbeans.xml.schema.classxmlschema.Class cls);
}
