
package com.btpn.ws.diasoft.corews;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.btpn.ws.diasoft.corews package. 
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
    private final static QName _DSCALLRESPONSE_QNAME = new QName("http://support.diasoft.ru", "DSCALLRESPONSE");
    private final static QName _DSCALL_QNAME = new QName("http://support.diasoft.ru", "DSCALL");
    private final static QName _DSCALLASYNC_QNAME = new QName("http://support.diasoft.ru", "DSCALLASYNC");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.btpn.ws.diasoft.corews
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DSCALLRESPONSE }
     * 
     */
    public DSCALLRESPONSE createDSCALLRESPONSE() {
        return new DSCALLRESPONSE();
    }

    /**
     * Create an instance of {@link DSCALLFAULT }
     * 
     */
    public DSCALLFAULT createDSCALLFAULT() {
        return new DSCALLFAULT();
    }

    /**
     * Create an instance of {@link DSCALLASYNC }
     * 
     */
    public DSCALLASYNC createDSCALLASYNC() {
        return new DSCALLASYNC();
    }

    /**
     * Create an instance of {@link DSCALL }
     * 
     */
    public DSCALL createDSCALL() {
        return new DSCALL();
    }

    /**
     * Create an instance of {@link ContextData }
     * 
     */
    public ContextData createContextData() {
        return new ContextData();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DSCALLRESPONSE }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.diasoft.ru", name = "DSCALLRESPONSE")
    public JAXBElement<DSCALLRESPONSE> createDSCALLRESPONSE(DSCALLRESPONSE value) {
        return new JAXBElement<DSCALLRESPONSE>(_DSCALLRESPONSE_QNAME, DSCALLRESPONSE.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DSCALL }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.diasoft.ru", name = "DSCALL")
    public JAXBElement<DSCALL> createDSCALL(DSCALL value) {
        return new JAXBElement<DSCALL>(_DSCALL_QNAME, DSCALL.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DSCALLASYNC }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://support.diasoft.ru", name = "DSCALLASYNC")
    public JAXBElement<DSCALLASYNC> createDSCALLASYNC(DSCALLASYNC value) {
        return new JAXBElement<DSCALLASYNC>(_DSCALLASYNC_QNAME, DSCALLASYNC.class, null, value);
    }

}
