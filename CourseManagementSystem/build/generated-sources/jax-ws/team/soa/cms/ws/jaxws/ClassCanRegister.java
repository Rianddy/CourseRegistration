
package team.soa.cms.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "classCanRegister", namespace = "http://ws.cms.soa.team/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "classCanRegister", namespace = "http://ws.cms.soa.team/")
public class ClassCanRegister {

    @XmlElement(name = "classStatus", namespace = "")
    private int classStatus;

    /**
     * 
     * @return
     *     returns int
     */
    public int getClassStatus() {
        return this.classStatus;
    }

    /**
     * 
     * @param classStatus
     *     the value for the classStatus property
     */
    public void setClassStatus(int classStatus) {
        this.classStatus = classStatus;
    }

}
