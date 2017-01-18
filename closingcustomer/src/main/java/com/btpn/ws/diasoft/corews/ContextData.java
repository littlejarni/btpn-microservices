
package com.btpn.ws.diasoft.corews;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for ContextData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ContextData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fromSystem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="toSystem" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="processId" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="locale" type="{http://www.w3.org/2001/XMLSchema}language"/>
 *         &lt;element name="pageflowId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="pageflowName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="initiatorIp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ContextData", propOrder = {
    "fromSystem",
    "toSystem",
    "sessionId",
    "processId",
    "locale",
    "pageflowId",
    "pageflowName",
    "initiatorIp"
})
public class ContextData {

    @XmlElement(required = true)
    protected String fromSystem;
    @XmlElement(required = true)
    protected String toSystem;
    @XmlElement(required = true)
    protected String sessionId;
    protected long processId;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlSchemaType(name = "language")
    protected String locale;
    @XmlElement(required = true)
    protected String pageflowId;
    @XmlElement(required = true)
    protected String pageflowName;
    @XmlElement(required = true)
    protected String initiatorIp;

    /**
     * Gets the value of the fromSystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromSystem() {
        return fromSystem;
    }

    /**
     * Sets the value of the fromSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromSystem(String value) {
        this.fromSystem = value;
    }

    /**
     * Gets the value of the toSystem property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToSystem() {
        return toSystem;
    }

    /**
     * Sets the value of the toSystem property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToSystem(String value) {
        this.toSystem = value;
    }

    /**
     * Gets the value of the sessionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Sets the value of the sessionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionId(String value) {
        this.sessionId = value;
    }

    /**
     * Gets the value of the processId property.
     * 
     */
    public long getProcessId() {
        return processId;
    }

    /**
     * Sets the value of the processId property.
     * 
     */
    public void setProcessId(long value) {
        this.processId = value;
    }

    /**
     * Gets the value of the locale property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocale() {
        return locale;
    }

    /**
     * Sets the value of the locale property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocale(String value) {
        this.locale = value;
    }

    /**
     * Gets the value of the pageflowId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPageflowId() {
        return pageflowId;
    }

    /**
     * Sets the value of the pageflowId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPageflowId(String value) {
        this.pageflowId = value;
    }

    /**
     * Gets the value of the pageflowName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPageflowName() {
        return pageflowName;
    }

    /**
     * Sets the value of the pageflowName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPageflowName(String value) {
        this.pageflowName = value;
    }

    /**
     * Gets the value of the initiatorIp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInitiatorIp() {
        return initiatorIp;
    }

    /**
     * Sets the value of the initiatorIp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInitiatorIp(String value) {
        this.initiatorIp = value;
    }

}
