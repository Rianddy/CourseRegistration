/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.dao.Implement;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.netbeans.xml.schema.studentxmlschema.Student;
import team.soa.cms.dao.GeneralDAO;
import team.soa.cms.dao.StudentDAO;

/**
 *
 * @author Edison
 */
public class StudentDAOImpl extends GeneralDAO implements StudentDAO {
    public StudentDAOImpl(){
        
    }

    @Override
    public Student getOneStudent(int stu_id) {
        Student stu = new Student();
        try {
            this.OpenConnection();
            sql = "select * from Student where Stu_ID="+stu_id;
            rs =stmt.executeQuery(sql);
            while (rs.next()){
                System.out.println("query success!");
                String stu_ID = rs.getString("stu_ID");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String dep_ID = rs.getString("Dep_ID");
                String maj_ID = rs.getString("Maj_ID");
                String conc_ID = rs.getString("Conc_ID");
                String birthday = rs.getString("Birthday");
                String address =rs.getString("Address");
                String cell = rs.getString("Cell");
                
                stu.setStuid(stu_ID);
                stu.setName(name);
                stu.setEmail(email);
                stu.setDepartment(dep_ID);
                stu.setConcentration(conc_ID);
                stu.setMajor(maj_ID);
                stu.setBirthday(birthday);
                stu.setAddress(address);
                stu.setCell(cell);
                System.out.println(stu.getName());
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stu;
    }

    @Override
    public void insert(Student stu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int ori_stu_id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updata(int ori_stu_id, Student stu) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
