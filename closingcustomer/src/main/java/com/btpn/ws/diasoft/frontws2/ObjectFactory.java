
package com.btpn.ws.diasoft.frontws2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.btpn.ws.diasoft.frontws2 package. 
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

    private final static QName _DSCALLFAULT_QNAME = new QName("http://support.diasoft.ru", "DSCALLFAULT");
    private final static QName _DSCALL_QNAME = new QName("http://support.diasoft.ru", "DSCALL");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.btpn.ws.diasoft.frontws2
     * 
     */
    public ObjectFactory() {
    }


    /**
     * Create an instance of {@link DSCALLFAULT }
     * 
     */
    public DSCALLFAULT createDSCALLFAULT() {
        return new DSCALLFAULT();
    }

    /**
     * Create an instance of {@link DSCALL }
     * 
     */
    public DSCALL createDSCALL() {
        return new DSCALL();
    }


    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DSCALLFAULT }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.diasoft.ru", name = "DSCALLFAULT")
    public JAXBElement<DSCALLFAULT> createDSCALLFAULT(DSCALLFAULT value) {
        return new JAXBElement<DSCALLFAULT>(_DSCALLFAULT_QNAME, DSCALLFAULT.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DSCALL }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.diasoft.ru", name = "DSCALL")
    public JAXBElement<DSCALL> createDSCALL(DSCALL value) {
        return new JAXBElement<DSCALL>(_DSCALL_QNAME, DSCALL.class, null, value);
    }

}
