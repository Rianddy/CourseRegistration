//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.14 at 08:08:18 PM EST 
//


package org.netbeans.xml.schema.studentregcheck;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for StuRegCheckInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StuRegCheckInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="studentInfo" type="{http://xml.netbeans.org/schema/studentRegCheck}studentInformation"/>
 *         &lt;element name="clazzInfo" type="{http://xml.netbeans.org/schema/studentRegCheck}classList"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StuRegCheckInfo", propOrder = {
    "studentInfo",
    "clazzInfo"
})
public class StuRegCheckInfo {

    @XmlElement(required = true)
    protected StudentInformation studentInfo;
    @XmlElement(required = true)
    protected ClassList clazzInfo;

    /**
     * Gets the value of the studentInfo property.
     * 
     * @return
     *     possible object is
     *     {@link StudentInformation }
     *     
     */
    public StudentInformation getStudentInfo() {
        return studentInfo;
    }

    /**
     * Sets the value of the studentInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudentInformation }
     *     
     */
    public void setStudentInfo(StudentInformation value) {
        this.studentInfo = value;
    }

    /**
     * Gets the value of the clazzInfo property.
     * 
     * @return
     *     possible object is
     *     {@link ClassList }
     *     
     */
    public ClassList getClazzInfo() {
        return clazzInfo;
    }

    /**
     * Sets the value of the clazzInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassList }
     *     
     */
    public void setClazzInfo(ClassList value) {
        this.clazzInfo = value;
    }

}
