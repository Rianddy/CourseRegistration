
package team.soa.cms.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "studentIsValid", namespace = "http://ws.cms.soa.team/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "studentIsValid", namespace = "http://ws.cms.soa.team/")
public class StudentIsValid {

    @XmlElement(name = "Stu_ID", namespace = "")
    private int stuID;

    /**
     * 
     * @return
     *     returns int
     */
    public int getStuID() {
        return this.stuID;
    }

    /**
     * 
     * @param stuID
     *     the value for the stuID property
     */
    public void setStuID(int stuID) {
        this.stuID = stuID;
    }

}
