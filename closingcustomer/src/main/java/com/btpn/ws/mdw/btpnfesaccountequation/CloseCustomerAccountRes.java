
package com.btpn.ws.mdw.btpnfesaccountequation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for closeCustomerAccountRes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="closeCustomerAccountRes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="GeneralResponse" type="{http://APPMDWDEV03.dev.corp.btpn.co.id/com.btpn.fes.ws.provider:BtpnFesAccountEquation}GenericResponseDoc"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "closeCustomerAccountRes", propOrder = {
    "generalResponse"
})
public class CloseCustomerAccountRes {

    @XmlElement(name = "GeneralResponse", required = true, nillable = true)
    protected GenericResponseDoc generalResponse;

    /**
     * Gets the value of the generalResponse property.
     * 
     * @return
     *     possible object is
     *     {@link GenericResponseDoc }
     *     
     */
    public GenericResponseDoc getGeneralResponse() {
        return generalResponse;
    }

    /**
     * Sets the value of the generalResponse property.
     * 
     * @param value
     *     allowed object is
     *     {@link GenericResponseDoc }
     *     
     */
    public void setGeneralResponse(GenericResponseDoc value) {
        this.generalResponse = value;
    }

}
