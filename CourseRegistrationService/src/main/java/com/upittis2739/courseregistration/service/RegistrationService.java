/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.upittis2739.courseregistration.service;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import com.upittis2739.courseregistration.common.Constants;
import com.upittis2739.courseregistration.model.Permission;
import com.upittis2739.courseregistration.model.RegClass;
import com.upittis2739.courseregistration.model.Student;
import com.upittis2739.courseregistration.logic.PermissionLogic;
import com.upittis2739.courseregistration.logic.RegClassLogic;
import com.upittis2739.courseregistration.logic.StudentLogic;
import java.util.HashMap;
import java.util.Map.Entry;
/**
 *
 * @author riand_000
 */
@WebService(serviceName = "RegistrationService")
public class RegistrationService{

    @Resource(mappedName = "jms/maildest")
    private Queue maildest;
    @Inject
    @JMSConnectionFactory("jms/mailqueue")
    private JMSContext context;

    @WebMethod(operationName = "requestPermissionCode")
    public boolean requestPermissionCode(@WebParam(name = "Stu_ID") int Stu_ID, @WebParam(name = "Cls_ID") int Cls_ID) {
        PermissionLogic permissionLogic = new PermissionLogic();
        StudentLogic studentLogic = new StudentLogic();
        RegClassLogic regClassLogic = new RegClassLogic();
        Student student = studentLogic.getStudentById(Stu_ID);
        RegClass regClass = regClassLogic.getRegClassById(Cls_ID);
        Permission permission = permissionLogic.generateVarifyCode(student, regClass);
        return sendJMSMessageToMaildest(regClass.getFaculty().getEmail(), permission);
    }

    private boolean sendJMSMessageToMaildest( String toAddress, Permission permission) {
        try {
            String mailContent = generateContent(permission);
            String title = "Request for permission code";
            
            // Create mail's TextMessage and push the message to mailqueue
            TextMessage student = context.createTextMessage();
            student.setStringProperty(Constants.mailContent, mailContent);
            student.setStringProperty(Constants.toAddress, toAddress);
            student.setStringProperty(Constants.title, title);
            context.createProducer().send(maildest, student);
            
            return true;
        } catch (Exception e) {
            System.out.println("Exception raised: " + e.toString());
            return false;
        }
    }
    
    private static String generateContent(Permission permission) {
        StringBuilder sb = new StringBuilder();
        
        // Add the web service client's address information to content
        sb.append("Please click the below link to make a choice:");
        sb.append(Constants.clientAddress);
        sb.append(Constants.responsePermissionAddress);
        sb.append("?");
        
        // Create a hashmap to store the parameter's name and value
        HashMap<String, String> parametersMap = new HashMap<String, String>();
        parametersMap.put("varifycode", permission.getVarifyCode());
        parametersMap.put("permid", permission.getPerms_ID()+"");
        sb.append(generateParameters(parametersMap));
        
        return sb.toString();
    }
    
    private static String generateParameters(HashMap<String, String> parameterMap){
        StringBuilder sb = new StringBuilder();
        
        // Generate the request parameters' string after http
        for (Entry<String, String> entry : parameterMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            sb.append(entry.getValue());
            sb.append("&");
        }
        
        return sb.toString();
    }

}
