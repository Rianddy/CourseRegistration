//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.25 at 05:15:17 PM EST 
//


package org.netbeans.xml.schema.stuclassmessagexmlschema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="studentinfo" type="{http://xml.netbeans.org/schema/stuclassmessageXmlSchema}StudentInfo"/>
 *         &lt;element name="RequestClass" type="{http://xml.netbeans.org/schema/stuclassmessageXmlSchema}ClassInfo"/>
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
    "requestClass"
})
public class Stuclassmessage {

    @XmlElement(required = true)
    protected StudentInfo studentinfo;
    @XmlElement(name = "RequestClass", required = true)
    protected ClassInfo requestClass;

    /**
     * Gets the value of the studentinfo property.
     * 
     * @return
     *     possible object is
     *     {@link StudentInfo }
     *     
     */
    public StudentInfo getStudentinfo() {
        return studentinfo;
    }

    /**
     * Sets the value of the studentinfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link StudentInfo }
     *     
     */
    public void setStudentinfo(StudentInfo value) {
        this.studentinfo = value;
    }

    /**
     * Gets the value of the requestClass property.
     * 
     * @return
     *     possible object is
     *     {@link ClassInfo }
     *     
     */
    public ClassInfo getRequestClass() {
        return requestClass;
    }

    /**
     * Sets the value of the requestClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassInfo }
     *     
     */
    public void setRequestClass(ClassInfo value) {
        this.requestClass = value;
    }

}
