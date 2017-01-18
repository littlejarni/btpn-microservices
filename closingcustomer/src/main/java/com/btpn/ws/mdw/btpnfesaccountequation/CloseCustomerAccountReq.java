
package com.btpn.ws.mdw.btpnfesaccountequation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for closeCustomerAccountReq complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="closeCustomerAccountReq">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CommonParam" type="{http://APPMDWDEV03.dev.corp.btpn.co.id/com.btpn.fes.ws.provider:BtpnFesAccountEquation}CommonParam2"/>
 *         &lt;element name="claData" type="{http://APPMDWDEV03.dev.corp.btpn.co.id/com.btpn.fes.ws.provider:BtpnFesAccountEquation}claData"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "closeCustomerAccountReq", propOrder = {
    "commonParam",
    "claData"
})
public class CloseCustomerAccountReq {

    @XmlElement(name = "CommonParam", required = true, nillable = true)
    protected CommonParam2 commonParam;
    @XmlElement(required = true, nillable = true)
    protected ClaData claData;

    /**
     * Gets the value of the commonParam property.
     * 
     * @return
     *     possible object is
     *     {@link CommonParam2 }
     *     
     */
    public CommonParam2 getCommonParam() {
        return commonParam;
    }

    /**
     * Sets the value of the commonParam property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommonParam2 }
     *     
     */
    public void setCommonParam(CommonParam2 value) {
        this.commonParam = value;
    }

    /**
     * Gets the value of the claData property.
     * 
     * @return
     *     possible object is
     *     {@link ClaData }
     *     
     */
    public ClaData getClaData() {
        return claData;
    }

    /**
     * Sets the value of the claData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClaData }
     *     
     */
    public void setClaData(ClaData value) {
        this.claData = value;
    }

}
