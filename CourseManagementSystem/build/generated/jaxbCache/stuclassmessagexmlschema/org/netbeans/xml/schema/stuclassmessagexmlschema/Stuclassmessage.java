//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.16 at 10:48:15 AM EST 
//


package org.netbeans.xml.schema.stuclassmessagexmlschema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for stuclassmessage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stuclassmessage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="studentinfo">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="stuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="stuname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="stuemail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="department" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="major" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="concentration" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="birthday" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *                   &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="cell" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="requestclassinfo" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="classid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="courseid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="coursename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="maxsize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="currsize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="maxwaitlist" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="curwaitlist" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                   &lt;element name="opensemester" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="facultyid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="facultyname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "stuclassmessage", propOrder = {
    "studentinfo",
    "requestclassinfo"
})
public class Stuclassmessage {

    @XmlElement(required = true)
    protected Stuclassmessage.Studentinfo studentinfo;
    @XmlElement(required = true)
    protected List<Stuclassmessage.Requestclassinfo> requestclassinfo;

    /**
     * Gets the value of the studentinfo property.
     * 
     * @return
     *     possible object is
     *     {@link Stuclassmessage.Studentinfo }
     *     
     */
    public Stuclassmessage.Studentinfo getStudentinfo() {
        return studentinfo;
    }

    /**
     * Sets the value of the studentinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Stuclassmessage.Studentinfo }
     *     
     */
    public void setStudentinfo(Stuclassmessage.Studentinfo value) {
        this.studentinfo = value;
    }

    /**
     * Gets the value of the requestclassinfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the requestclassinfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRequestclassinfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Stuclassmessage.Requestclassinfo }
     * 
     * 
     */
    public List<Stuclassmessage.Requestclassinfo> getRequestclassinfo() {
        if (requestclassinfo == null) {
            requestclassinfo = new ArrayList<Stuclassmessage.Requestclassinfo>();
        }
        return this.requestclassinfo;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="classid" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="courseid" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="coursename" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="maxsize" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="currsize" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="maxwaitlist" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="curwaitlist" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *         &lt;element name="opensemester" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="facultyid" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="facultyname" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "classid",
        "courseid",
        "coursename",
        "maxsize",
        "currsize",
        "maxwaitlist",
        "curwaitlist",
        "opensemester",
        "facultyid",
        "facultyname"
    })
    public static class Requestclassinfo {

        @XmlElement(required = true)
        protected String classid;
        @XmlElement(required = true)
        protected String courseid;
        @XmlElement(required = true)
        protected String coursename;
        protected int maxsize;
        protected int currsize;
        protected int maxwaitlist;
        protected int curwaitlist;
        @XmlElement(required = true)
        protected String opensemester;
        @XmlElement(required = true)
        protected String facultyid;
        @XmlElement(required = true)
        protected String facultyname;

        /**
         * Gets the value of the classid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getClassid() {
            return classid;
        }

        /**
         * Sets the value of the classid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setClassid(String value) {
            this.classid = value;
        }

        /**
         * Gets the value of the courseid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCourseid() {
            return courseid;
        }

        /**
         * Sets the value of the courseid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCourseid(String value) {
            this.courseid = value;
        }

        /**
         * Gets the value of the coursename property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCoursename() {
            return coursename;
        }

        /**
         * Sets the value of the coursename property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCoursename(String value) {
            this.coursename = value;
        }

        /**
         * Gets the value of the maxsize property.
         * 
         */
        public int getMaxsize() {
            return maxsize;
        }

        /**
         * Sets the value of the maxsize property.
         * 
         */
        public void setMaxsize(int value) {
            this.maxsize = value;
        }

        /**
         * Gets the value of the currsize property.
         * 
         */
        public int getCurrsize() {
            return currsize;
        }

        /**
         * Sets the value of the currsize property.
         * 
         */
        public void setCurrsize(int value) {
            this.currsize = value;
        }

        /**
         * Gets the value of the maxwaitlist property.
         * 
         */
        public int getMaxwaitlist() {
            return maxwaitlist;
        }

        /**
         * Sets the value of the maxwaitlist property.
         * 
         */
        public void setMaxwaitlist(int value) {
            this.maxwaitlist = value;
        }

        /**
         * Gets the value of the curwaitlist property.
         * 
         */
        public int getCurwaitlist() {
            return curwaitlist;
        }

        /**
         * Sets the value of the curwaitlist property.
         * 
         */
        public void setCurwaitlist(int value) {
            this.curwaitlist = value;
        }

        /**
         * Gets the value of the opensemester property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOpensemester() {
            return opensemester;
        }

        /**
         * Sets the value of the opensemester property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOpensemester(String value) {
            this.opensemester = value;
        }

        /**
         * Gets the value of the facultyid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFacultyid() {
            return facultyid;
        }

        /**
         * Sets the value of the facultyid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFacultyid(String value) {
            this.facultyid = value;
        }

        /**
         * Gets the value of the facultyname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getFacultyname() {
            return facultyname;
        }

        /**
         * Sets the value of the facultyname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setFacultyname(String value) {
            this.facultyname = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="stuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="stuname" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="stuemail" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="department" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="major" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="concentration" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="birthday" type="{http://www.w3.org/2001/XMLSchema}date"/>
     *         &lt;element name="address" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="cell" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "stuid",
        "stuname",
        "stuemail",
        "department",
        "major",
        "concentration",
        "birthday",
        "address",
        "cell"
    })
    public static class Studentinfo {

        @XmlElement(required = true)
        protected String stuid;
        @XmlElement(required = true)
        protected String stuname;
        @XmlElement(required = true)
        protected String stuemail;
        @XmlElement(required = true)
        protected String department;
        @XmlElement(required = true)
        protected String major;
        @XmlElement(required = true)
        protected String concentration;
        @XmlElement(required = true)
        @XmlSchemaType(name = "date")
        protected XMLGregorianCalendar birthday;
        @XmlElement(required = true)
        protected String address;
        @XmlElement(required = true)
        protected String cell;

        /**
         * Gets the value of the stuid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStuid() {
            return stuid;
        }

        /**
         * Sets the value of the stuid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStuid(String value) {
            this.stuid = value;
        }

        /**
         * Gets the value of the stuname property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStuname() {
            return stuname;
        }

        /**
         * Sets the value of the stuname property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStuname(String value) {
            this.stuname = value;
        }

        /**
         * Gets the value of the stuemail property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStuemail() {
            return stuemail;
        }

        /**
         * Sets the value of the stuemail property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStuemail(String value) {
            this.stuemail = value;
        }

        /**
         * Gets the value of the department property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getDepartment() {
            return department;
        }

        /**
         * Sets the value of the department property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setDepartment(String value) {
            this.department = value;
        }

        /**
         * Gets the value of the major property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getMajor() {
            return major;
        }

        /**
         * Sets the value of the major property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setMajor(String value) {
            this.major = value;
        }

        /**
         * Gets the value of the concentration property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getConcentration() {
            return concentration;
        }

        /**
         * Sets the value of the concentration property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setConcentration(String value) {
            this.concentration = value;
        }

        /**
         * Gets the value of the birthday property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getBirthday() {
            return birthday;
        }

        /**
         * Sets the value of the birthday property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setBirthday(XMLGregorianCalendar value) {
            this.birthday = value;
        }

        /**
         * Gets the value of the address property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getAddress() {
            return address;
        }

        /**
         * Sets the value of the address property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setAddress(String value) {
            this.address = value;
        }

        /**
         * Gets the value of the cell property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getCell() {
            return cell;
        }

        /**
         * Sets the value of the cell property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setCell(String value) {
            this.cell = value;
        }

    }

}
