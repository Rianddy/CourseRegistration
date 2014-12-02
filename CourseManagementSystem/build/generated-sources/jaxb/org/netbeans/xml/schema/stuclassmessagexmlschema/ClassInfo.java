//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.25 at 05:15:17 PM EST 
//


package org.netbeans.xml.schema.stuclassmessagexmlschema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ClassInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ClassInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="classid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="classvalid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="classstatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="canTake" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="permid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="PrereqClasses" type="{http://xml.netbeans.org/schema/stuclassmessageXmlSchema}ClassPrereq" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassInfo", propOrder = {
    "classid",
    "classvalid",
    "classstatus",
    "canTake",
    "permid",
    "prereqClasses"
})
public class ClassInfo {

    @XmlElement(required = true)
    protected String classid;
    protected boolean classvalid;
    @XmlElement(required = true)
    protected String classstatus;
    protected boolean canTake;
    @XmlElement(required = true)
    protected String permid;
    @XmlElement(name = "PrereqClasses")
    protected List<ClassPrereq> prereqClasses;

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
     * Gets the value of the classvalid property.
     * 
     */
    public boolean isClassvalid() {
        return classvalid;
    }

    /**
     * Sets the value of the classvalid property.
     * 
     */
    public void setClassvalid(boolean value) {
        this.classvalid = value;
    }

    /**
     * Gets the value of the classstatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClassstatus() {
        return classstatus;
    }

    /**
     * Sets the value of the classstatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClassstatus(String value) {
        this.classstatus = value;
    }

    /**
     * Gets the value of the canTake property.
     * 
     */
    public boolean isCanTake() {
        return canTake;
    }

    /**
     * Sets the value of the canTake property.
     * 
     */
    public void setCanTake(boolean value) {
        this.canTake = value;
    }

    /**
     * Gets the value of the permid property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPermid() {
        return permid;
    }

    /**
     * Sets the value of the permid property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPermid(String value) {
        this.permid = value;
    }

    /**
     * Gets the value of the prereqClasses property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the prereqClasses property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPrereqClasses().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClassPrereq }
     * 
     * 
     */
    public List<ClassPrereq> getPrereqClasses() {
        if (prereqClasses == null) {
            prereqClasses = new ArrayList<ClassPrereq>();
        }
        return this.prereqClasses;
    }

}