package com.btpn.closingcustomer.soap;

import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;

import com.btpn.applicationconfig.ApplicationConfig;
import com.btpn.closingcustomer.ClosingCustomerConstant;
import com.btpn.ws.mdw.btpnfesaccountequation.BtpnFesAccountEquationPortType;
import com.btpn.ws.mdw.btpnfesaccountequation.ClaData;
import com.btpn.ws.mdw.btpnfesaccountequation.CloseCustomerAccountReq;
import com.btpn.ws.mdw.btpnfesaccountequation.CloseCustomerAccountRes;
import com.btpn.ws.mdw.btpnfesaccountequation.ComBtpnFesWsProviderBtpnFesAccountEquation;
import com.btpn.ws.mdw.btpnfesaccountequation.CommonParam2;
import com.btpn.ws.mdw.btpnfesaccountequation.ObjectFactory;
import com.btpn.wscall.CommonParamGenerator;

public class CloseAccountSoapClientImpl implements CloseAccountSoapClient {

	@Autowired
	ApplicationConfig appConfig;
	
	@Autowired
	CommonParamGenerator comParGen;

	@Override
	public CloseCustomerAccountRes closeAccount(String account, String accountCharge, String fee, String drTransCode, String crTransCode) throws Exception {
		String endPoint = appConfig.getConfig(ClosingCustomerConstant.CLOSING_ACCOUNT_ENDPOINT_KEY);
		ComBtpnFesWsProviderBtpnFesAccountEquation service = new ComBtpnFesWsProviderBtpnFesAccountEquation(new URL(endPoint));
		BtpnFesAccountEquationPortType servicePort = service.getComBtpnFesWsProviderBtpnFesAccountEquationPort();

		ObjectFactory objFactory = new ObjectFactory();
		CommonParam2 comPar = comParGen.generateCommonParam(CommonParam2.class, objFactory);
		comPar.setProcessingCode(objFactory.createCommonParam2ProcessingCode("640028"));

		String eqUserId = appConfig.getConfig(ClosingCustomerConstant.EQ_USER_DEFAULT_KEY);
		String claChargeCode = appConfig.getConfig(ClosingCustomerConstant.EQ_CLA_CHARGE_CODE_KEY);

		CloseCustomerAccountReq requestCLA = new CloseCustomerAccountReq();
		ClaData claData = new ClaData();
		claData.setUserId(eqUserId);
		claData.setAccount(account);
		claData.setDrTransCode(objFactory.createClaDataDrTransCode(drTransCode));
		claData.setCrTransCode(objFactory.createClaDataCrTransCode(crTransCode));
		claData.setStatementRequired(ClosingCustomerConstant.SHORT_YES);
		claData.setConfirmRequired(ClosingCustomerConstant.SHORT_YES);
		claData.setChargeCode(objFactory.createClaDataChargeCode(claChargeCode));
		claData.setAmountCharge(objFactory.createClaDataAmountCharge(fee));
		claData.setAccountCharge(objFactory.createClaDataAccountCharge(accountCharge));
		claData.setRecalculateCharge(ClosingCustomerConstant.SHORT_NO);
		
		requestCLA.setCommonParam(comPar);
		requestCLA.setClaData(claData);
		
		CloseCustomerAccountRes closeCustomerAccountResponse = servicePort.closeCustomerAccount(requestCLA);
		return closeCustomerAccountResponse;
	}
}
