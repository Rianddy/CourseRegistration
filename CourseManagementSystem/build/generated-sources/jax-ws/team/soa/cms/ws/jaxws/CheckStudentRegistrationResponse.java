
package team.soa.cms.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.netbeans.xml.schema.studentregcheck.StuRegCheckInfo;

@XmlRootElement(name = "checkStudentRegistrationResponse", namespace = "http://ws.cms.soa.team/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkStudentRegistrationResponse", namespace = "http://ws.cms.soa.team/")
public class CheckStudentRegistrationResponse {

    @XmlElement(name = "return", namespace = "")
    private StuRegCheckInfo _return;

    /**
     * 
     * @return
     *     returns StuRegCheckInfo
     */
    public StuRegCheckInfo getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(StuRegCheckInfo _return) {
        this._return = _return;
    }

}
