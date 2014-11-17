//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.17 at 06:16:40 PM EST 
//


package org.netbeans.xml.schema.semesterxmlschema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for semester complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="semester">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="semid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="semname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="startdate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="enddate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="adddropdate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "semester", propOrder = {
    "semid",
    "semname",
    "startdate",
    "enddate",
    "adddropdate"
})
public class Semester {

    @XmlElement(required = true)
    protected String semid;
    @XmlElement(required = true)
    protected String semname;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startdate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar enddate;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar adddropdate;

    /**
     * Gets the value of the semid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSemid() {
        return semid;
    }

    /**
     * Sets the value of the semid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSemid(String value) {
        this.semid = value;
    }

    /**
     * Gets the value of the semname property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSemname() {
        return semname;
    }

    /**
     * Sets the value of the semname property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSemname(String value) {
        this.semname = value;
    }

    /**
     * Gets the value of the startdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getStartdate() {
        return startdate;
    }

    /**
     * Sets the value of the startdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setStartdate(XMLGregorianCalendar value) {
        this.startdate = value;
    }

    /**
     * Gets the value of the enddate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getEnddate() {
        return enddate;
    }

    /**
     * Sets the value of the enddate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setEnddate(XMLGregorianCalendar value) {
        this.enddate = value;
    }

    /**
     * Gets the value of the adddropdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAdddropdate() {
        return adddropdate;
    }

    /**
     * Sets the value of the adddropdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAdddropdate(XMLGregorianCalendar value) {
        this.adddropdate = value;
    }

}
