
package com.btpn.ws.mdw.btpnfescustomerequation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addressEnquiry complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addressEnquiry">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addressEnquiryReq" type="{http://APPMDWDEV03.dev.corp.btpn.co.id/com.btpn.fes.ws.provider:BtpnFesCustomerEquation}addressEnquiryReq"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addressEnquiry", propOrder = {
    "addressEnquiryReq"
})
public class AddressEnquiry {

    @XmlElement(required = true, nillable = true)
    protected AddressEnquiryReq addressEnquiryReq;

    /**
     * Gets the value of the addressEnquiryReq property.
     * 
     * @return
     *     possible object is
     *     {@link AddressEnquiryReq }
     *     
     */
    public AddressEnquiryReq getAddressEnquiryReq() {
        return addressEnquiryReq;
    }

    /**
     * Sets the value of the addressEnquiryReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link AddressEnquiryReq }
     *     
     */
    public void setAddressEnquiryReq(AddressEnquiryReq value) {
        this.addressEnquiryReq = value;
    }

}
