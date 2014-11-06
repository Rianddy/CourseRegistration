
package team.soa.cms.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "classIsValid", namespace = "http://ws.cms.soa.team/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "classIsValid", namespace = "http://ws.cms.soa.team/")
public class ClassIsValid {

    @XmlElement(name = "Class_ID", namespace = "")
    private int classID;

    /**
     * 
     * @return
     *     returns int
     */
    public int getClassID() {
        return this.classID;
    }

    /**
     * 
     * @param classID
     *     the value for the classID property
     */
    public void setClassID(int classID) {
        this.classID = classID;
    }

}
