//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.18 at 10:27:15 PM EST 
//


package org.netbeans.xml.schema.classxmlschema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for class complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="class">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="classid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="cosid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="maxsize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="maxwaitlist" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cursize" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="curwaitlist" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="opensemid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="facultyname" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "class", propOrder = {
    "classid",
    "cosid",
    "maxsize",
    "maxwaitlist",
    "cursize",
    "curwaitlist",
    "opensemid",
    "facultyname",
    "semname",
    "startdate",
    "enddate",
    "adddropdate"
})
public class Class {

    @XmlElement(required = true)
    protected String classid;
    @XmlElement(required = true)
    protected String cosid;
    protected int maxsize;
    protected int maxwaitlist;
    protected int cursize;
    protected int curwaitlist;
    @XmlElement(required = true)
    protected String opensemid;
    @XmlElement(required = true)
    protected String facultyname;
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
     * Gets the value of the cosid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCosid() {
        return cosid;
    }

    /**
     * Sets the value of the cosid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCosid(String value) {
        this.cosid = value;
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
     * Gets the value of the cursize property.
     * 
     */
    public int getCursize() {
        return cursize;
    }

    /**
     * Sets the value of the cursize property.
     * 
     */
    public void setCursize(int value) {
        this.cursize = value;
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
     * Gets the value of the opensemid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpensemid() {
        return opensemid;
    }

    /**
     * Sets the value of the opensemid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpensemid(String value) {
        this.opensemid = value;
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
