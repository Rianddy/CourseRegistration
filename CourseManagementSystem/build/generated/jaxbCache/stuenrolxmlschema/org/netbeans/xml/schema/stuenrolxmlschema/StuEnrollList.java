//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.12.06 at 10:19:31 AM EST 
//


package org.netbeans.xml.schema.stuenrolxmlschema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for stuEnrollList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="stuEnrollList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="oneenroll" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="classid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="courseid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="grade" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="score" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *                   &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="stuenrolltime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *                   &lt;element name="stuenrollid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="stuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "stuEnrollList", propOrder = {
    "oneenroll"
})
public class StuEnrollList {

    @XmlElement(required = true)
    protected List<StuEnrollList.Oneenroll> oneenroll;

    /**
     * Gets the value of the oneenroll property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the oneenroll property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOneenroll().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StuEnrollList.Oneenroll }
     * 
     * 
     */
    public List<StuEnrollList.Oneenroll> getOneenroll() {
        if (oneenroll == null) {
            oneenroll = new ArrayList<StuEnrollList.Oneenroll>();
        }
        return this.oneenroll;
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
     *         &lt;element name="score" type="{http://www.w3.org/2001/XMLSchema}float"/>
     *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="stuenrolltime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
     *         &lt;element name="stuenrollid" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="stuid" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "score",
        "status",
        "stuenrolltime",
        "stuenrollid",
        "stuid"
    })
    public static class Oneenroll {

        @XmlElement(required = true)
        protected String classid;
        @XmlElement(required = true)
        protected String courseid;
        @XmlElement(required = true)
        protected String grade;
        protected float score;
        @XmlElement(required = true)
        protected String status;
        @XmlElement(required = true)
        @XmlSchemaType(name = "dateTime")
        protected XMLGregorianCalendar stuenrolltime;
        @XmlElement(required = true)
        protected String stuenrollid;
        @XmlElement(required = true)
        protected String stuid;

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
         * Gets the value of the score property.
         * 
         */
        public float getScore() {
            return score;
        }

        /**
         * Sets the value of the score property.
         * 
         */
        public void setScore(float value) {
            this.score = value;
        }

        /**
         * Gets the value of the status property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStatus() {
            return status;
        }

        /**
         * Sets the value of the status property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStatus(String value) {
            this.status = value;
        }

        /**
         * Gets the value of the stuenrolltime property.
         * 
         * @return
         *     possible object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public XMLGregorianCalendar getStuenrolltime() {
            return stuenrolltime;
        }

        /**
         * Sets the value of the stuenrolltime property.
         * 
         * @param value
         *     allowed object is
         *     {@link XMLGregorianCalendar }
         *     
         */
        public void setStuenrolltime(XMLGregorianCalendar value) {
            this.stuenrolltime = value;
        }

        /**
         * Gets the value of the stuenrollid property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getStuenrollid() {
            return stuenrollid;
        }

        /**
         * Sets the value of the stuenrollid property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setStuenrollid(String value) {
            this.stuenrollid = value;
        }

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

    }

}
