/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.dao;

import org.netbeans.xml.schema.stuenrolxmlschema.StuEnrollList;

/**
 *
 * @author Edison
 */
public interface StudentEnrollDAO {
    public String insert(int Class_ID, int Stu_ID);
    
    public StuEnrollList getStudentEnrollment(int Stu_ID);
}
