/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package team.soa.cms.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import  org.netbeans.xml.schema.classxmlschema.Class;
import team.soa.cms.ws.daoService.DAOService;
/**
 *
 * @author YIYI
 * @editor RuiBi
 */
@WebService(serviceName = "UpdateClass")
public class UpdateClass {

     DAOService daoservice = new DAOService();
     
    /**
     * Web service operation
     * @param Class_ID
     * @param changeType  cur_Size or cur_waitlist
     * @param changeValue
     * @return 
     */
    @WebMethod(operationName = "updateClass")
    public Boolean updateClass(@WebParam(name = "Class_ID") int Class_ID, @WebParam(name = "changeType") String changeType, @WebParam(name = "changeValue") int changeValue) {
       
        boolean reStatus = false;
       
        Class cls = daoservice.getClassInfo(Class_ID);
        
        if(changeType.equals("curSize")){
            if((changeValue <= cls.getMaxsize())&&(cls.getCurwaitlist() == 0)){
             
                cls.setCursize(changeValue);
                reStatus = daoservice.updateClassInfo(Class_ID, cls);
            
            }
            
        }else if(changeType.equals("curWaitlist")){
        
            if((cls.getCursize() == cls.getMaxsize())&&(changeValue <= cls.getMaxwaitlist())){
           
                cls.setCurwaitlist(changeValue);
                reStatus = daoservice.updateClassInfo(Class_ID, cls);  
            
            }
        }
       
        
       
        return reStatus;
    }
}
