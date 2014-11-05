
package com.upittis2739.courseregistration.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.upittis2739.courseregistration.client package. 
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

    private final static QName _RequestPermissionCode_QNAME = new QName("http://service.courseregistration.upittis2739.com/", "requestPermissionCode");
    private final static QName _RequestPermissionCodeResponse_QNAME = new QName("http://service.courseregistration.upittis2739.com/", "requestPermissionCodeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.upittis2739.courseregistration.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link RequestPermissionCodeResponse }
     * 
     */
    public RequestPermissionCodeResponse createRequestPermissionCodeResponse() {
        return new RequestPermissionCodeResponse();
    }

    /**
     * Create an instance of {@link RequestPermissionCode }
     * 
     */
    public RequestPermissionCode createRequestPermissionCode() {
        return new RequestPermissionCode();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestPermissionCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.courseregistration.upittis2739.com/", name = "requestPermissionCode")
    public JAXBElement<RequestPermissionCode> createRequestPermissionCode(RequestPermissionCode value) {
        return new JAXBElement<RequestPermissionCode>(_RequestPermissionCode_QNAME, RequestPermissionCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RequestPermissionCodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.courseregistration.upittis2739.com/", name = "requestPermissionCodeResponse")
    public JAXBElement<RequestPermissionCodeResponse> createRequestPermissionCodeResponse(RequestPermissionCodeResponse value) {
        return new JAXBElement<RequestPermissionCodeResponse>(_RequestPermissionCodeResponse_QNAME, RequestPermissionCodeResponse.class, null, value);
    }

}
