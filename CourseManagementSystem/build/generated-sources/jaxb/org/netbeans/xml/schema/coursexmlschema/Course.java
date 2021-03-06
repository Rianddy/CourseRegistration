//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.06 at 10:19:29 AM EST 
//


package org.netbeans.xml.schema.coursexmlschema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for course complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="course">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="courseid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="departname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="major" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="concentrationname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coursename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coursedescription" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coursecredits" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="coursestatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prerequestid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "course", propOrder = {
    "courseid",
    "departname",
    "major",
    "concentrationname",
    "coursename",
    "coursedescription",
    "coursecredits",
    "coursestatus",
    "prerequestid"
})
public class Course {

    @XmlElement(required = true)
    protected String courseid;
    @XmlElement(required = true)
    protected String departname;
    @XmlElement(required = true)
    protected String major;
    @XmlElement(required = true)
    protected String concentrationname;
    @XmlElement(required = true)
    protected String coursename;
    @XmlElement(required = true)
    protected String coursedescription;
    @XmlElement(required = true)
    protected String coursecredits;
    @XmlElement(required = true)
    protected String coursestatus;
    @XmlElement(required = true)
    protected String prerequestid;

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
     * Gets the value of the departname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepartname() {
        return departname;
    }

    /**
     * Sets the value of the departname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepartname(String value) {
        this.departname = value;
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
     * Gets the value of the concentrationname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConcentrationname() {
        return concentrationname;
    }

    /**
     * Sets the value of the concentrationname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConcentrationname(String value) {
        this.concentrationname = value;
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
     * Gets the value of the coursedescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoursedescription() {
        return coursedescription;
    }

    /**
     * Sets the value of the coursedescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoursedescription(String value) {
        this.coursedescription = value;
    }

    /**
     * Gets the value of the coursecredits property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoursecredits() {
        return coursecredits;
    }

    /**
     * Sets the value of the coursecredits property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoursecredits(String value) {
        this.coursecredits = value;
    }

    /**
     * Gets the value of the coursestatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoursestatus() {
        return coursestatus;
    }

    /**
     * Sets the value of the coursestatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoursestatus(String value) {
        this.coursestatus = value;
    }

    /**
     * Gets the value of the prerequestid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrerequestid() {
        return prerequestid;
    }

    /**
     * Sets the value of the prerequestid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrerequestid(String value) {
        this.prerequestid = value;
    }

}
