
package com.btpn.ws.mdw.btpnfesaccountequation;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.btpn.ws.mdw.btpnfesaccountequation package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CloseCustomerAccount_QNAME = new QName("http://APPMDWDEV03.dev.corp.btpn.co.id/com.btpn.fes.ws.provider:BtpnFesAccountEquation", "closeCustomerAccount");
    private final static QName _CloseCustomerAccountResponse_QNAME = new QName("http://APPMDWDEV03.dev.corp.btpn.co.id/com.btpn.fes.ws.provider:BtpnFesAccountEquation", "closeCustomerAccountResponse");
    private final static QName _CbrDataChargeCode_QNAME = new QName("", "chargeCode");
    private final static QName _CommonParam2Amount_QNAME = new QName("", "amount");
    private final static QName _CommonParam2Currencyfee_QNAME = new QName("", "currencyfee");
    private final static QName _CommonParam2Original_QNAME = new QName("", "original");
    private final static QName _CommonParam2ReferenceNo_QNAME = new QName("", "referenceNo");
    private final static QName _CommonParam2ProcessingCode_QNAME = new QName("", "processingCode");
    private final static QName _CommonParam2Fee_QNAME = new QName("", "fee");
    private final static QName _CommonParam2CurrencyAmount_QNAME = new QName("", "currencyAmount");
    private final static QName _CommonParam2ChannelType_QNAME = new QName("", "channelType");
    private final static QName _CommonParam2TerminalId_QNAME = new QName("", "terminalId");
    private final static QName _CommonParam2UserId_QNAME = new QName("", "userId");
    private final static QName _CommonParam2AcqId_QNAME = new QName("", "acqId");
    private final static QName _CommonParam2TransmissionDateTime_QNAME = new QName("", "transmissionDateTime");
    private final static QName _CommonParam2Node_QNAME = new QName("", "node");
    private final static QName _CommonParam2TerminalName_QNAME = new QName("", "terminalName");
    private final static QName _CommonParam2RequestId_QNAME = new QName("", "requestId");
    private final static QName _CommonParam2Pan_QNAME = new QName("", "pan");
    private final static QName _CommonParam2ChannelId_QNAME = new QName("", "channelId");
    private final static QName _ClaDataCrTransCode_QNAME = new QName("", "crTransCode");
    private final static QName _ClaDataAmountCharge_QNAME = new QName("", "amountCharge");
    private final static QName _ClaDataAccountCharge_QNAME = new QName("", "accountCharge");
    private final static QName _ClaDataDrTransCode_QNAME = new QName("", "drTransCode");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.btpn.ws.mdw.btpnfesaccountequation
     * 
     */
    public ObjectFactory() {
    }


    /**
     * Create an instance of {@link CloseCustomerAccount }
     * 
     */
    public CloseCustomerAccount createCloseCustomerAccount() {
        return new CloseCustomerAccount();
    }


    /**
     * Create an instance of {@link CloseCustomerAccountResponse }
     * 
     */
    public CloseCustomerAccountResponse createCloseCustomerAccountResponse() {
        return new CloseCustomerAccountResponse();
    }



    /**
     * Create an instance of {@link ClaData }
     * 
     */
    public ClaData createClaData() {
        return new ClaData();
    }



    /**
     * Create an instance of {@link GenericResponseDoc }
     * 
     */
    public GenericResponseDoc createGenericResponseDoc() {
        return new GenericResponseDoc();
    }

    /**
     * Create an instance of {@link CommonParam2 }
     * 
     */
    public CommonParam2 createCommonParam2() {
        return new CommonParam2();
    }


    /**
     * Create an instance of {@link CloseCustomerAccountRes }
     * 
     */
    public CloseCustomerAccountRes createCloseCustomerAccountRes() {
        return new CloseCustomerAccountRes();
    }

    /**
     * Create an instance of {@link CloseCustomerAccountReq }
     * 
     */
    public CloseCustomerAccountReq createCloseCustomerAccountReq() {
        return new CloseCustomerAccountReq();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloseCustomerAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://APPMDWDEV03.dev.corp.btpn.co.id/com.btpn.fes.ws.provider:BtpnFesAccountEquation", name = "closeCustomerAccount")
    public JAXBElement<CloseCustomerAccount> createCloseCustomerAccount(CloseCustomerAccount value) {
        return new JAXBElement<CloseCustomerAccount>(_CloseCustomerAccount_QNAME, CloseCustomerAccount.class, null, value);
    }



    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CloseCustomerAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://APPMDWDEV03.dev.corp.btpn.co.id/com.btpn.fes.ws.provider:BtpnFesAccountEquation", name = "closeCustomerAccountResponse")
    public JAXBElement<CloseCustomerAccountResponse> createCloseCustomerAccountResponse(CloseCustomerAccountResponse value) {
        return new JAXBElement<CloseCustomerAccountResponse>(_CloseCustomerAccountResponse_QNAME, CloseCustomerAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "amount", scope = CommonParam2 .class)
    public JAXBElement<String> createCommonParam2Amount(String value) {
        return new JAXBElement<String>(_CommonParam2Amount_QNAME, String.class, CommonParam2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "currencyfee", scope = CommonParam2 .class)
    public JAXBElement<String> createCommonParam2Currencyfee(String value) {
        return new JAXBElement<String>(_CommonParam2Currencyfee_QNAME, String.class, CommonParam2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "original", scope = CommonParam2 .class)
    public JAXBElement<String> createCommonParam2Original(String value) {
        return new JAXBElement<String>(_CommonParam2Original_QNAME, String.class, CommonParam2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "referenceNo", scope = CommonParam2 .class)
    public JAXBElement<String> createCommonParam2ReferenceNo(String value) {
        return new JAXBElement<String>(_CommonParam2ReferenceNo_QNAME, String.class, CommonParam2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "processingCode", scope = CommonParam2 .class)
    public JAXBElement<String> createCommonParam2ProcessingCode(String value) {
        return new JAXBElement<String>(_CommonParam2ProcessingCode_QNAME, String.class, CommonParam2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "fee", scope = CommonParam2 .class)
    public JAXBElement<String> createCommonParam2Fee(String value) {
        return new JAXBElement<String>(_CommonParam2Fee_QNAME, String.class, CommonParam2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "currencyAmount", scope = CommonParam2 .class)
    public JAXBElement<String> createCommonParam2CurrencyAmount(String value) {
        return new JAXBElement<String>(_CommonParam2CurrencyAmount_QNAME, String.class, CommonParam2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "channelType", scope = CommonParam2 .class)
    public JAXBElement<String> createCommonParam2ChannelType(String value) {
        return new JAXBElement<String>(_CommonParam2ChannelType_QNAME, String.class, CommonParam2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "terminalId", scope = CommonParam2 .class)
    public JAXBElement<String> createCommonParam2TerminalId(String value) {
        return new JAXBElement<String>(_CommonParam2TerminalId_QNAME, String.class, CommonParam2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "userId", scope = CommonParam2 .class)
    public JAXBElement<String> createCommonParam2UserId(String value) {
        return new JAXBElement<String>(_CommonParam2UserId_QNAME, String.class, CommonParam2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "acqId", scope = CommonParam2 .class)
    public JAXBElement<String> createCommonParam2AcqId(String value) {
        return new JAXBElement<String>(_CommonParam2AcqId_QNAME, String.class, CommonParam2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "transmissionDateTime", scope = CommonParam2 .class)
    public JAXBElement<String> createCommonParam2TransmissionDateTime(String value) {
        return new JAXBElement<String>(_CommonParam2TransmissionDateTime_QNAME, String.class, CommonParam2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "node", scope = CommonParam2 .class)
    public JAXBElement<String> createCommonParam2Node(String value) {
        return new JAXBElement<String>(_CommonParam2Node_QNAME, String.class, CommonParam2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "terminalName", scope = CommonParam2 .class)
    public JAXBElement<String> createCommonParam2TerminalName(String value) {
        return new JAXBElement<String>(_CommonParam2TerminalName_QNAME, String.class, CommonParam2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "requestId", scope = CommonParam2 .class)
    public JAXBElement<String> createCommonParam2RequestId(String value) {
        return new JAXBElement<String>(_CommonParam2RequestId_QNAME, String.class, CommonParam2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "pan", scope = CommonParam2 .class)
    public JAXBElement<String> createCommonParam2Pan(String value) {
        return new JAXBElement<String>(_CommonParam2Pan_QNAME, String.class, CommonParam2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "channelId", scope = CommonParam2 .class)
    public JAXBElement<String> createCommonParam2ChannelId(String value) {
        return new JAXBElement<String>(_CommonParam2ChannelId_QNAME, String.class, CommonParam2 .class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "crTransCode", scope = ClaData.class)
    public JAXBElement<String> createClaDataCrTransCode(String value) {
        return new JAXBElement<String>(_ClaDataCrTransCode_QNAME, String.class, ClaData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "amountCharge", scope = ClaData.class)
    public JAXBElement<String> createClaDataAmountCharge(String value) {
        return new JAXBElement<String>(_ClaDataAmountCharge_QNAME, String.class, ClaData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "accountCharge", scope = ClaData.class)
    public JAXBElement<String> createClaDataAccountCharge(String value) {
        return new JAXBElement<String>(_ClaDataAccountCharge_QNAME, String.class, ClaData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "drTransCode", scope = ClaData.class)
    public JAXBElement<String> createClaDataDrTransCode(String value) {
        return new JAXBElement<String>(_ClaDataDrTransCode_QNAME, String.class, ClaData.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "chargeCode", scope = ClaData.class)
    public JAXBElement<String> createClaDataChargeCode(String value) {
        return new JAXBElement<String>(_CbrDataChargeCode_QNAME, String.class, ClaData.class, value);
    }

}