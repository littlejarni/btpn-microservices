
package com.btpn.ws.mdw.btpnfescustomerequation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addressEnquiryReq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addressEnquiryReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CommonParam2" type="{http://APPMDWDEV03.dev.corp.btpn.co.id/com.btpn.fes.ws.provider:BtpnFesCustomerEquation}CommonParam2"/>
 *         &lt;element name="dataAaeReq" type="{http://APPMDWDEV03.dev.corp.btpn.co.id/com.btpn.fes.ws.provider:BtpnFesCustomerEquation}dataAaeReq"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addressEnquiryReq", propOrder = {
    "commonParam2",
    "dataAaeReq"
})
public class AddressEnquiryReq {

    @XmlElement(name = "CommonParam2", required = true, nillable = true)
    protected CommonParam2 commonParam2;
    @XmlElement(required = true, nillable = true)
    protected DataAaeReq dataAaeReq;

    /**
     * Gets the value of the commonParam2 property.
     * 
     * @return
     *     possible object is
     *     {@link CommonParam2 }
     *     
     */
    public CommonParam2 getCommonParam2() {
        return commonParam2;
    }

    /**
     * Sets the value of the commonParam2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommonParam2 }
     *     
     */
    public void setCommonParam2(CommonParam2 value) {
        this.commonParam2 = value;
    }

    /**
     * Gets the value of the dataAaeReq property.
     * 
     * @return
     *     possible object is
     *     {@link DataAaeReq }
     *     
     */
    public DataAaeReq getDataAaeReq() {
        return dataAaeReq;
    }

    /**
     * Sets the value of the dataAaeReq property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataAaeReq }
     *     
     */
    public void setDataAaeReq(DataAaeReq value) {
        this.dataAaeReq = value;
    }

}
