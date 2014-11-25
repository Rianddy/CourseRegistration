/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.dao.Implement;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.xml.schema.permissionxmlschema.Permission;
import team.soa.cms.dao.GeneralDAO;
import team.soa.cms.dao.PermissionDAO;

/**
 *
 * @author YIYI
 */
public class PermissionDAOImpl extends GeneralDAO implements PermissionDAO{

    @Override
    public Permission getOnePermissionInfo(int permission_id) {
     
        Permission rePermission = new Permission();
     
        try {
            this.OpenConnection();
            
            this.sql = "select * from `permission` where Perms_ID = "+permission_id+";";            
            rs =stmt.executeQuery(sql);
             
            while (rs.next()){
     
                rePermission.setPermsid(rs.getString("Perms_ID"));
                rePermission.setStuid(rs.getString("Stu_ID"));
                rePermission.setFacultyid(rs.getString("Fac_ID"));
                rePermission.setStatus(rs.getString("Status"));
                rePermission.setClassid(rs.getString("Class_ID"));
             }
             
             
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     
     
     return rePermission;
    }

    @Override
    public void insert(Permission permission) {
    
        
          try {
            this.OpenConnection();
            
            this.sql = "insert into `permission` values("+permission.getPermsid()+","+permission.getStuid()+","+
                    permission.getFacultyid()+","+permission.getStatus()+","+permission.getClassid()+");";
            /*permission status
            1: submit 
            2: transfer
            3: reject
            4: accept
            */
            stmt.execute(sql);
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }

    @Override
    public int insertAcceptPerm(int studentID, int classID, int facultyID) {
        
      int permissionID = -1;
      try{
            this.OpenConnection();
          
            this.sql = "select count(*) AS num from permission;";            
           
            rs =stmt.executeQuery(sql);
           
            int permid = 0; 
            while (rs.next()){
              permid = Integer.valueOf(rs.getString("num"))+1;
            }
           
            
            
            String pid = permid+"";
            String sid = studentID+"";
            String fid = facultyID+"";
            String status ="4";//accept
            String cid = classID+"";
            
             /*permission status
            1: submit 
            2: transfer
            3: reject
            4: accept
            */
            
            // insert record into the permission table with 'accept' status
            this.sql = "insert into `permission` values("+pid+","+sid+","+fid+","+status+","+cid+");";           
            stmt.execute(sql);
            
            //if success, find the permissionid and return
            this.sql = "select Perms_ID from permission where Stu_ID = "+studentID+" AND Fac_ID = "+facultyID+" AND Status = 4 AND Class_ID = "+classID+";";
            
            rs =stmt.executeQuery(sql);
            while (rs.next()){
              permissionID = Integer.valueOf(rs.getString("Perms_ID"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     
    return  permissionID;
    
    }
    @Override
    public int insertRejectPerm(int studentID, int classID, int facultyID) {
       
      int permissionID = -1;
      
      try{
            this.OpenConnection();
          
            this.sql = "select count(*) AS num from permission;";            
           
            rs =stmt.executeQuery(sql);
           
            int permid = 0; 
            while (rs.next()){
              permid = Integer.valueOf(rs.getString("num"))+1;
            }
           
            
            
            String pid = permid+"";
            String sid = studentID+"";
            String fid = facultyID+"";
            String status ="3";//reject
            String cid = classID+"";
            
             /*permission status
            1: submit 
            2: transfer
            3: reject
            4: accept
            */
            
            // insert record into the permission table with 'accept' status
            this.sql = "insert into `permission` values("+pid+","+sid+","+fid+","+status+","+cid+");";           
            stmt.execute(sql);
            
            //if success, find the permissionid and return
            this.sql = "select Perms_ID from permission where Stu_ID = "+studentID+" AND Fac_ID = "+facultyID+" AND Status = 3 AND Class_ID = "+classID+";";
            
            rs =stmt.executeQuery(sql);
            while (rs.next()){
              permissionID = Integer.valueOf(rs.getString("Perms_ID"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     
    return  permissionID;
    
    }

    
    @Override
    public void delete(Permission permission) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }

    @Override
    public void updateStatus(int permission_id, String permissionStatus) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public  boolean acceptCodeExist(int studentID, int classID, int permcode) {
      
        boolean result = false;
        String status = ""; 
       //the permission code record exists and status is 'accept'
       //the value of permcode equals with the value of Perms_ID
     
        this.OpenConnection();
        String pcode = permcode+"";
        String sid = studentID+"";
        String cid = classID+"";
        
        try {
            this.sql = "select Status from `permission` where Perms_ID = "+pcode+" AND Stu_ID = "+sid+" AND Class_ID = "+cid+";";           
            rs =stmt.executeQuery(sql);
            
         while (rs.next()){
              status = rs.getString("Status");
            }
        
         if(status.equals("accept"))
             result = true;
         
        } catch (SQLException ex) {
            Logger.getLogger(PermissionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
           
        return result;
    }

   /**
    * insert permission method
    * @editor Yan
    */
    
    public int insertPerm(int studentID, int classID, int facultyID, String state) {
       
      int permissionID = -1;
      
      try{
            this.OpenConnection();
          
            this.sql = "select count(*) AS num from permission;";            
           
            rs =stmt.executeQuery(sql);
           
            int permid = 0; 
            while (rs.next()){
              permid = Integer.valueOf(rs.getString("num"))+1;
            }
           
            
            
            String pid = permid+"";
            String sid = studentID+"";
            String fid = facultyID+"";
            String status = state;//accept or reject
            String cid = classID+"";
            
             /*permission status
            1: submit 
            2: transfer
            3: reject
            4: accept
            */
            
            // insert record into the permission table with 'accept' status
            this.sql = "insert into `permission`(`Perms_ID`,`Stu_ID`,`Fac_ID`,`Class_ID`,`Status`) values("+pid+","+sid+","+fid+","+cid+", '"+status+"');";           
            stmt.execute(sql);
            
            //if success, find the permissionid and return
            this.sql = "select Perms_ID from permission where Stu_ID = "+studentID+" AND Fac_ID = "+facultyID+" AND Status = '"+status+"' AND Class_ID = "+classID+";";
            
            rs =stmt.executeQuery(sql);
            while (rs.next()){
              permissionID = Integer.valueOf(rs.getString("Perms_ID"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ClassDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         
     
    return  permissionID;
    
    }
    
}
