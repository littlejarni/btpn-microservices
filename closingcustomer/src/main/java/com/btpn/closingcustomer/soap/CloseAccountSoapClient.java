package com.btpn.closingcustomer.soap;

import com.btpn.ws.mdw.btpnfesaccountequation.CloseCustomerAccountRes;

public interface CloseAccountSoapClient {

	CloseCustomerAccountRes closeAccount(String account, String accountCharge, String fee, String drTransCode, String crTransCode) throws Exception;

}
