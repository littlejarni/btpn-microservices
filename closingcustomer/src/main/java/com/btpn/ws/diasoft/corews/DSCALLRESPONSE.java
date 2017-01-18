
package com.btpn.ws.diasoft.corews;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DSCALLRESPONSE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DSCALLRESPONSE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="commandresult" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DSCALLRESPONSE", propOrder = {
    "commandresult"
})
public class DSCALLRESPONSE {

    @XmlElement(required = true)
    protected String commandresult;

    /**
     * Gets the value of the commandresult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommandresult() {
        return commandresult;
    }

    /**
     * Sets the value of the commandresult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommandresult(String value) {
        this.commandresult = value;
    }

}
