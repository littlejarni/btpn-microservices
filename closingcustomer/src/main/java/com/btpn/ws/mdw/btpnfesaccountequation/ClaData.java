
package com.btpn.ws.mdw.btpnfesaccountequation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for claData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="claData">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="account" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="drTransCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="crTransCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="statementRequired" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="confirmRequired" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="chargeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="amountCharge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="accountCharge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="recalculateCharge" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "claData", propOrder = {
    "userId",
    "account",
    "drTransCode",
    "crTransCode",
    "statementRequired",
    "confirmRequired",
    "chargeCode",
    "amountCharge",
    "accountCharge",
    "recalculateCharge"
})
public class ClaData {

    @XmlElement(required = true, nillable = true)
    protected String userId;
    @XmlElement(required = true, nillable = true)
    protected String account;
    @XmlElementRef(name = "drTransCode", type = JAXBElement.class, required = false)
    protected JAXBElement<String> drTransCode;
    @XmlElementRef(name = "crTransCode", type = JAXBElement.class, required = false)
    protected JAXBElement<String> crTransCode;
    @XmlElement(required = true, nillable = true)
    protected String statementRequired;
    @XmlElement(required = true, nillable = true)
    protected String confirmRequired;
    @XmlElementRef(name = "chargeCode", type = JAXBElement.class, required = false)
    protected JAXBElement<String> chargeCode;
    @XmlElementRef(name = "amountCharge", type = JAXBElement.class, required = false)
    protected JAXBElement<String> amountCharge;
    @XmlElementRef(name = "accountCharge", type = JAXBElement.class, required = false)
    protected JAXBElement<String> accountCharge;
    @XmlElement(required = true, nillable = true)
    protected String recalculateCharge;

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the account property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccount() {
        return account;
    }

    /**
     * Sets the value of the account property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccount(String value) {
        this.account = value;
    }

    /**
     * Gets the value of the drTransCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDrTransCode() {
        return drTransCode;
    }

    /**
     * Sets the value of the drTransCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDrTransCode(JAXBElement<String> value) {
        this.drTransCode = value;
    }

    /**
     * Gets the value of the crTransCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCrTransCode() {
        return crTransCode;
    }

    /**
     * Sets the value of the crTransCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCrTransCode(JAXBElement<String> value) {
        this.crTransCode = value;
    }

    /**
     * Gets the value of the statementRequired property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatementRequired() {
        return statementRequired;
    }

    /**
     * Sets the value of the statementRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatementRequired(String value) {
        this.statementRequired = value;
    }

    /**
     * Gets the value of the confirmRequired property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConfirmRequired() {
        return confirmRequired;
    }

    /**
     * Sets the value of the confirmRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConfirmRequired(String value) {
        this.confirmRequired = value;
    }

    /**
     * Gets the value of the chargeCode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getChargeCode() {
        return chargeCode;
    }

    /**
     * Sets the value of the chargeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setChargeCode(JAXBElement<String> value) {
        this.chargeCode = value;
    }

    /**
     * Gets the value of the amountCharge property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAmountCharge() {
        return amountCharge;
    }

    /**
     * Sets the value of the amountCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAmountCharge(JAXBElement<String> value) {
        this.amountCharge = value;
    }

    /**
     * Gets the value of the accountCharge property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAccountCharge() {
        return accountCharge;
    }

    /**
     * Sets the value of the accountCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAccountCharge(JAXBElement<String> value) {
        this.accountCharge = value;
    }

    /**
     * Gets the value of the recalculateCharge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecalculateCharge() {
        return recalculateCharge;
    }

    /**
     * Sets the value of the recalculateCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecalculateCharge(String value) {
        this.recalculateCharge = value;
    }

}
