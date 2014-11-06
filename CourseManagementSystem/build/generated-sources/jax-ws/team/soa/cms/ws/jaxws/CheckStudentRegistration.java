
package team.soa.cms.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "checkStudentRegistration", namespace = "http://ws.cms.soa.team/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkStudentRegistration", namespace = "http://ws.cms.soa.team/", propOrder = {
    "stuID",
    "classID"
})
public class CheckStudentRegistration {

    @XmlElement(name = "Stu_ID", namespace = "")
    private int stuID;
    @XmlElement(name = "Class_ID", namespace = "")
    private int classID;

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
