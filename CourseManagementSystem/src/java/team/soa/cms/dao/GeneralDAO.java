/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.dao;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Edison
 */
public class GeneralDAO {
    protected Connection conn = null;
    protected Statement stmt =null;
    protected ResultSet rs = null;
    protected String sql = null;
   
    public void OpenConnection(){
        String DBPORT ="8889";
        String DBNAME ="CourseRegistrationDB";
        String DBUSER ="root";
        String DBPASSWORD="root";
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection("jdbc:mysql://localhost:"+DBPORT+"/"+DBNAME,DBUSER,DBPASSWORD);
            stmt = conn.createStatement();
            /*sql = "select * from Student";
            rs = stmt.executeQuery(sql);
            
            while (rs.next()){
                String stu_name = rs.getString("name");
                System.out.println(stu_name);
            }
            rs.close();*/
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GeneralDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(GeneralDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(GeneralDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GeneralDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
