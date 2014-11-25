/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.dao;
import org.netbeans.xml.schema.semesterxmlschema.Semester;
/**
 *
 * @author Edison
 */
public interface SemesterDAO {
    public Semester getOneSemester(int Sem_ID);
}
