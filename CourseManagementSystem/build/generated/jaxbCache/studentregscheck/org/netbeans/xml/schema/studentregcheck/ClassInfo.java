//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.29 at 10:25:48 PM EST 
//


package org.netbeans.xml.schema.studentregcheck;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for classInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="classInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="classid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="classvalid" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="classstatus" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="canTake" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="classPrereq" maxOccurs="unbounded" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="classid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="courseid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="grade" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="reqMet" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
@XmlType(name = "classInfo", propOrder = {
    "classid",
    "classvalid",
    "classstatus",
    "canTake",
    "classPrereq"
})
public class ClassInfo {

    @XmlElement(required = true)
    protected String classid;
    protected boolean classvalid;
    @XmlElement(required = true)
    protected String classstatus;
    protected boolean canTake;
    protected List<ClassInfo.ClassPrereq> classPrereq;

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
     * Gets the value of the classPrereq property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classPrereq property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassPrereq().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClassInfo.ClassPrereq }
     * 
     * 
     */
    public List<ClassInfo.ClassPrereq> getClassPrereq() {
        if (classPrereq == null) {
            classPrereq = new ArrayList<ClassInfo.ClassPrereq>();
        }
        return this.classPrereq;
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
    @XmlType(name = "", propOrder = {
        "classid",
        "courseid",
        "grade",
        "reqMet"
    })
    public static class ClassPrereq {

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

}