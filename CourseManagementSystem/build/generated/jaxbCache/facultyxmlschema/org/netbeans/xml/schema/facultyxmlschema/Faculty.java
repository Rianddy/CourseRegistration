//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.10 at 06:28:21 PM EST 
//


package org.netbeans.xml.schema.facultyxmlschema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for faculty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="faculty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="facid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="facname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="facstatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="facemail" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="faccell" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="facdepart" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "faculty", propOrder = {
    "facid",
    "facname",
    "facstatus",
    "facemail",
    "faccell",
    "facdepart"
})
public class Faculty {

    @XmlElement(required = true)
    protected String facid;
    @XmlElement(required = true)
    protected String facname;
    @XmlElement(required = true)
    protected String facstatus;
    @XmlElement(required = true)
    protected String facemail;
    @XmlElement(required = true)
    protected String faccell;
    @XmlElement(required = true)
    protected String facdepart;

    /**
     * Gets the value of the facid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacid() {
        return facid;
    }

    /**
     * Sets the value of the facid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacid(String value) {
        this.facid = value;
    }

    /**
     * Gets the value of the facname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacname() {
        return facname;
    }

    /**
     * Sets the value of the facname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacname(String value) {
        this.facname = value;
    }

    /**
     * Gets the value of the facstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacstatus() {
        return facstatus;
    }

    /**
     * Sets the value of the facstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacstatus(String value) {
        this.facstatus = value;
    }

    /**
     * Gets the value of the facemail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacemail() {
        return facemail;
    }

    /**
     * Sets the value of the facemail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacemail(String value) {
        this.facemail = value;
    }

    /**
     * Gets the value of the faccell property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaccell() {
        return faccell;
    }

    /**
     * Sets the value of the faccell property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaccell(String value) {
        this.faccell = value;
    }

    /**
     * Gets the value of the facdepart property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFacdepart() {
        return facdepart;
    }

    /**
     * Sets the value of the facdepart property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFacdepart(String value) {
        this.facdepart = value;
    }

}
