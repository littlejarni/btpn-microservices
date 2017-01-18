package com.btpn.closingcustomer.soap;

import java.net.MalformedURLException;

import javax.xml.bind.JAXBException;

import com.btpn.closingcustomer.soap.entity.DocumentSaveDSCALLResponse;
import com.btpn.closingcustomer.soap.entity.StartTasklistDSCALLResponse;
import com.btpn.closingcustomer.soap.entity.UpdateDocumentStatusDSCALLResponse;
import com.btpn.closingcustomer.soap.entity.UpdateTasklistStatusDSCALLResponse;
import com.btpn.ws.diasoft.frontws2.DSCALLFAULT_Exception;

public interface TasklistSoapClient {

	DocumentSaveDSCALLResponse documentSave(String accountNo, String clientId, String username, String userId) throws MalformedURLException, DSCALLFAULT_Exception, JAXBException;

	StartTasklistDSCALLResponse startTasklist(String accountNo, String roleId, String documentId) throws MalformedURLException, DSCALLFAULT_Exception, JAXBException, com.btpn.ws.diasoft.corews.DSCALLFAULT_Exception;

	UpdateTasklistStatusDSCALLResponse updateTasklistStatus(String userId, String taskId) throws MalformedURLException, com.btpn.ws.diasoft.corews.DSCALLFAULT_Exception, JAXBException;

	UpdateDocumentStatusDSCALLResponse updateDocumentStatus(String documentId, String userName) throws MalformedURLException, DSCALLFAULT_Exception, JAXBException;

}
