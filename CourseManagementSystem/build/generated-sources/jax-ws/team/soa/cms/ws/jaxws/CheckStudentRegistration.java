
package team.soa.cms.ws.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "checkStudentRegistration", namespace = "http://ws.cms.soa.team/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "checkStudentRegistration", namespace = "http://ws.cms.soa.team/", propOrder = {
    "stuID",
    "classIDList"
})
public class CheckStudentRegistration {

    @XmlElement(name = "Stu_ID", namespace = "")
    private int stuID;
    @XmlElement(name = "Class_ID_List", namespace = "")
    private List<Integer> classIDList;

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
     *     returns List<Integer>
     */
    public List<Integer> getClassIDList() {
        return this.classIDList;
    }

    /**
     * 
     * @param classIDList
     *     the value for the classIDList property
     */
    public void setClassIDList(List<Integer> classIDList) {
        this.classIDList = classIDList;
    }

}
