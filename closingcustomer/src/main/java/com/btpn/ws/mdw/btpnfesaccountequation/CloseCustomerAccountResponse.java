
package com.btpn.ws.mdw.btpnfesaccountequation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for closeCustomerAccountResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="closeCustomerAccountResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ResponseCLA" type="{http://APPMDWDEV03.dev.corp.btpn.co.id/com.btpn.fes.ws.provider:BtpnFesAccountEquation}closeCustomerAccountRes"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "closeCustomerAccountResponse", propOrder = {
    "responseCLA"
})
public class CloseCustomerAccountResponse {

    @XmlElement(name = "ResponseCLA", required = true, nillable = true)
    protected CloseCustomerAccountRes responseCLA;

    /**
     * Gets the value of the responseCLA property.
     * 
     * @return
     *     possible object is
     *     {@link CloseCustomerAccountRes }
     *     
     */
    public CloseCustomerAccountRes getResponseCLA() {
        return responseCLA;
    }

    /**
     * Sets the value of the responseCLA property.
     * 
     * @param value
     *     allowed object is
     *     {@link CloseCustomerAccountRes }
     *     
     */
    public void setResponseCLA(CloseCustomerAccountRes value) {
        this.responseCLA = value;
    }

}
