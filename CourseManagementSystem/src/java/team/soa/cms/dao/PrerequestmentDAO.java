/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.dao;

import org.netbeans.xml.schema.prerequestxmlschema.Prerequestment;

/**
 *
 * @author Edison
 */
public interface PrerequestmentDAO {
    public Prerequestment getPrerequestmentByClassId(int class_ID);
    public Prerequestment getPrerequestmentByCourseId(int course_ID);
}


