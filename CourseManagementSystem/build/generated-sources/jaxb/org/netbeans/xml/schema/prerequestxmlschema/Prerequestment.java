//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.23 at 05:33:07 PM EST 
//


package org.netbeans.xml.schema.prerequestxmlschema;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for prerequestment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="prerequestment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="onepre" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="courseid" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                   &lt;element name="coursename" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "prerequestment", propOrder = {
    "onepre"
})
public class Prerequestment {

    @XmlElement(required = true)
    protected List<Prerequestment.Onepre> onepre;

    /**
     * Gets the value of the onepre property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the onepre property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOnepre().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Prerequestment.Onepre }
     * 
     * 
     */
    public List<Prerequestment.Onepre> getOnepre() {
        if (onepre == null) {
            onepre = new ArrayList<Prerequestment.Onepre>();
        }
        return this.onepre;
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
     *         &lt;element name="courseid" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *         &lt;element name="coursename" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
        "courseid",
        "coursename"
    })
    public static class Onepre {

        @XmlElement(required = true)
        protected String courseid;
        @XmlElement(required = true)
        protected String coursename;

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

    }

}
