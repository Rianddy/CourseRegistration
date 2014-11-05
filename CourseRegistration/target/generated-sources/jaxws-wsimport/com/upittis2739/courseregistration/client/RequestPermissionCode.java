
package com.upittis2739.courseregistration.client;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for requestPermissionCode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="requestPermissionCode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Stu_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Cls_ID" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "requestPermissionCode", propOrder = {
    "stuID",
    "clsID"
})
public class RequestPermissionCode {

    @XmlElement(name = "Stu_ID")
    protected int stuID;
    @XmlElement(name = "Cls_ID")
    protected int clsID;

    /**
     * Gets the value of the stuID property.
     * 
     */
    public int getStuID() {
        return stuID;
    }

    /**
     * Sets the value of the stuID property.
     * 
     */
    public void setStuID(int value) {
        this.stuID = value;
    }

    /**
     * Gets the value of the clsID property.
     * 
     */
    public int getClsID() {
        return clsID;
    }

    /**
     * Sets the value of the clsID property.
     * 
     */
    public void setClsID(int value) {
        this.clsID = value;
    }

}
