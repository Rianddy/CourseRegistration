/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team.soa.cms.ws.basicCheck;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import team.soa.cms.ws.daoService.DAOService;

/**
 *
 * @author xmrui_000
 */
@WebService(serviceName = "ClassCanRegisterService")
public class ClassCanRegisterService {

    /**
     * This is a sample web service operation
     */
   DAOService daoservice = new DAOService();
    
    /**
     * Web service operation
     * @param Class_ID
     * @return spaceLeft
     */
    @WebMethod(operationName = "classRegisterLeftSpace")
    public Integer classRegisterLeftSpace(@WebParam(name = "Class_ID") int Class_ID) {
       
         int spaceLeft=0;  //integer denoting spaces left
        
        
            try{
           
            org.netbeans.xml.schema.classxmlschema.Class oneClass = daoservice.getClassInfo(Class_ID);
            int currentSize = oneClass.getCursize();
            int maxSize = oneClass.getMaxsize();
            int curWaitSize = oneClass.getCurwaitlist();
            int maxWaitSize = oneClass.getMaxwaitlist();
            
            if(currentSize < maxSize)
                spaceLeft = maxSize - currentSize;//classStatus = "open";
            else if(currentSize == maxSize){
              
                if(curWaitSize < maxWaitSize)
                    //-2 means 2 waitlist spaces left 
                    spaceLeft = curWaitSize - maxWaitSize;//classStatus = "waitlist";
                else
                     spaceLeft = 0;//classStatus = "closed";             
                   }
             }catch(Exception e){
               spaceLeft = 0;
        }
        
        return spaceLeft;
        
        //if spaceLeft>0, there are class spaces left
        //if spaceLeft<0, there are waitlist spaces left
        //if spaceLeft=o, no space left or exception
    }
}
