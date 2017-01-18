
package com.btpn.ws.mdw.btpnfescustomerequation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addressEnquiryResp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addressEnquiryResp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GenericResponseDoc" type="{http://APPMDWDEV03.dev.corp.btpn.co.id/com.btpn.fes.ws.provider:BtpnFesCustomerEquation}GenericResponseDoc"/>
 *         &lt;element name="dataAaeResp" type="{http://APPMDWDEV03.dev.corp.btpn.co.id/com.btpn.fes.ws.provider:BtpnFesCustomerEquation}dataAaeResp"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addressEnquiryResp", propOrder = {
    "genericResponseDoc",
    "dataAaeResp"
})
public class AddressEnquiryResp {

    @XmlElement(name = "GenericResponseDoc", required = true, nillable = true)
    protected GenericResponseDoc genericResponseDoc;
    @XmlElement(required = true, nillable = true)
    protected DataAaeResp dataAaeResp;

    /**
     * Gets the value of the genericResponseDoc property.
     * 
     * @return
     *     possible object is
     *     {@link GenericResponseDoc }
     *     
     */
    public GenericResponseDoc getGenericResponseDoc() {
        return genericResponseDoc;
    }

    /**
     * Sets the value of the genericResponseDoc property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericResponseDoc }
     *     
     */
    public void setGenericResponseDoc(GenericResponseDoc value) {
        this.genericResponseDoc = value;
    }

    /**
     * Gets the value of the dataAaeResp property.
     * 
     * @return
     *     possible object is
     *     {@link DataAaeResp }
     *     
     */
    public DataAaeResp getDataAaeResp() {
        return dataAaeResp;
    }

    /**
     * Sets the value of the dataAaeResp property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataAaeResp }
     *     
     */
    public void setDataAaeResp(DataAaeResp value) {
        this.dataAaeResp = value;
    }

}
