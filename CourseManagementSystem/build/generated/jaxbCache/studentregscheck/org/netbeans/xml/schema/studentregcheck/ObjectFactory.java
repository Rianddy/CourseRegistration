//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.11.16 at 10:21:42 PM EST 
//


package org.netbeans.xml.schema.studentregcheck;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.netbeans.xml.schema.studentregcheck package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.netbeans.xml.schema.studentregcheck
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClassInfo }
     * 
     */
    public ClassInfo createClassInfo() {
        return new ClassInfo();
    }

    /**
     * Create an instance of {@link StuRegCheckInfo }
     * 
     */
    public StuRegCheckInfo createStuRegCheckInfo() {
        return new StuRegCheckInfo();
    }

    /**
     * Create an instance of {@link StudentInformation }
     * 
     */
    public StudentInformation createStudentInformation() {
        return new StudentInformation();
    }

    /**
     * Create an instance of {@link ClassList }
     * 
     */
    public ClassList createClassList() {
        return new ClassList();
    }

    /**
     * Create an instance of {@link ClassInfo.ClassPrereq }
     * 
     */
    public ClassInfo.ClassPrereq createClassInfoClassPrereq() {
        return new ClassInfo.ClassPrereq();
    }

}
