//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.03 at 09:56:12 PM EST 
//


package org.netbeans.xml.schema.stuclassmessagexmlschema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClassPrereq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClassPrereq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="classid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="courseid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="grade" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reqMet" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassPrereq", propOrder = {
    "classid",
    "courseid",
    "grade",
    "reqMet"
})
public class ClassPrereq {

    @XmlElement(required = true)
    protected String classid;
    @XmlElement(required = true)
    protected String courseid;
    @XmlElement(required = true)
    protected String grade;
    protected boolean reqMet;

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
     * Gets the value of the grade property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGrade() {
        return grade;
    }

    /**
     * Sets the value of the grade property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGrade(String value) {
        this.grade = value;
    }

    /**
     * Gets the value of the reqMet property.
     * 
     */
    public boolean isReqMet() {
        return reqMet;
    }

    /**
     * Sets the value of the reqMet property.
     * 
     */
    public void setReqMet(boolean value) {
        this.reqMet = value;
    }

}
