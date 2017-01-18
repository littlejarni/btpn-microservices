
package com.btpn.ws.mdw.btpnfesaccountequation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for closeCustomerAccount complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="closeCustomerAccount">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RequestCLA" type="{http://APPMDWDEV03.dev.corp.btpn.co.id/com.btpn.fes.ws.provider:BtpnFesAccountEquation}closeCustomerAccountReq"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "closeCustomerAccount", propOrder = {
    "requestCLA"
})
public class CloseCustomerAccount {

    @XmlElement(name = "RequestCLA", required = true, nillable = true)
    protected CloseCustomerAccountReq requestCLA;

    /**
     * Gets the value of the requestCLA property.
     * 
     * @return
     *     possible object is
     *     {@link CloseCustomerAccountReq }
     *     
     */
    public CloseCustomerAccountReq getRequestCLA() {
        return requestCLA;
    }

    /**
     * Sets the value of the requestCLA property.
     * 
     * @param value
     *     allowed object is
     *     {@link CloseCustomerAccountReq }
     *     
     */
    public void setRequestCLA(CloseCustomerAccountReq value) {
        this.requestCLA = value;
    }

}
