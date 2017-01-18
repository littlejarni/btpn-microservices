package com.btpn.closingcustomer.soap;

import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;

import org.springframework.beans.factory.annotation.Autowired;

import com.btpn.applicationconfig.ApplicationConfig;
import com.btpn.closingcustomer.ClosingCustomerConstant;
import com.btpn.closingcustomer.soap.entity.DocumentSaveDSCALLResponse;
import com.btpn.closingcustomer.soap.entity.StartTasklistDSCALLResponse;
import com.btpn.closingcustomer.soap.entity.UpdateDocumentStatusDSCALLResponse;
import com.btpn.closingcustomer.soap.entity.UpdateTasklistStatusDSCALLResponse;
import com.btpn.ws.diasoft.corews.COREWSPORTTYPE;
import com.btpn.ws.diasoft.corews.COREWSSERVICE;
import com.btpn.ws.diasoft.corews.ContextData;
import com.btpn.ws.diasoft.frontws2.DSCALLFAULT_Exception;
import com.btpn.ws.diasoft.frontws2.FRONTWS2PORTTYPE;
import com.btpn.ws.diasoft.frontws2.FRONTWS2SERVICE;
import com.btpn.wscall.soap.FxWsSecurityGenerator;

public class TasklistSoapClientImpl implements TasklistSoapClient {

	public static final String DOCUMENT_SAVE_COMMAND_TEXT = "documentSave";
	public static final String DOCUMENT_SAVE_COMMAND_DATA_TEMPLATE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
									+ "<BODY version=\"2.11\">"
									+ "<DOCNUMBERMASK type=\"java.lang.String\">CLA_CASA</DOCNUMBERMASK>"
									+ "<ACCOUNTNUMBER type=\"java.lang.String\">%s</ACCOUNTNUMBER>"
									+ "<CLIENTLINKTYPE type=\"java.lang.String\">Client</CLIENTLINKTYPE>"
									+ "<CLIENTID type=\"java.lang.String\">%s</CLIENTID>"
									+ "<USERNAME type=\"java.lang.String\">%s</USERNAME>"
									+ "<PROJECTSYSNAME type=\"java.lang.String\">FTFDEPOSITFab</PROJECTSYSNAME>"
									+ "<CREATEDBY type=\"java.lang.String\">%s</CREATEDBY>"
									+ "<ReturnAsHashMap type=\"java.lang.String\">TRUE</ReturnAsHashMap>"
									+ "<DOCTYPESYSNAME type=\"java.lang.String\">closeSavingAccountApp</DOCTYPESYSNAME>"
									+ "<STATESYSNAME type=\"java.lang.String\">SPVChecking</STATESYSNAME>"
									+ "<STAGESYSNAME type=\"java.lang.String\">appControlSPV</STAGESYSNAME>"
									+ "<STAGERESULT type=\"java.lang.String\">Success</STAGERESULT>"
									+ "</BODY>";
	private static final String START_TASKLIST_COMMAND_TEXT = "startprocess";
	private static final String START_TASKLIST_COMMAND_DATA_TEMPLATE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+ "<BODY version=\"2.11\">"
					+ "<PROCESSNAME type=\"java.lang.String\">DEPOSIT/CloseSavingAccount</PROCESSNAME>"
					+ "<ACCOUNTNUMBER type=\"java.lang.String\">%s</ACCOUNTNUMBER>"
					+ "<ASSIGNTYPE type=\"java.lang.String\">USERROLE</ASSIGNTYPE>"
					+ "<ASSIGNOBJECT type=\"java.lang.String\">%s</ASSIGNOBJECT>"
					+ "<PROJECTID type=\"java.lang.String\">3003</PROJECTID>"
					+ "<OBJECTTYPE type=\"java.lang.String\">DEPOSIT/closeSavingAccount/task/SPVappControl</OBJECTTYPE>"
					+ "<OBJECTID type=\"java.lang.Long\">%s</OBJECTID>"
					+ "</BODY>";
	private static final String UPDATE_TASKLIST_STATUS_COMMAND_TEXT = "changetaskstatus";
	private static final String UPDATE_TASKLIST_STATUS_COMMAND_DATA_TEMPLATE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			+ "<BODY version=\"2.11\">"
			+ "<CHANGEAUTHOR type=\"java.lang.Long\">%s</CHANGEAUTHOR>"
			+ "<STATUS type=\"java.lang.String\">PROCESSED</STATUS>"
			+ "<TASKID type=\"java.lang.Long\">%s</TASKID>"
			+ "</BODY>";
	private static final String UPDATE_DOCUMENT_STATUS_COMMAND_TEXT = "documentSave";
	private static final String UPDATE_DOCUMENT_STATUS_COMMAND_DATA_TEMPLATE = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
			+ "<BODY version=\"2.11\">"
			+ "<DOCUMENTID type=\"java.lang.Long\">%s</DOCUMENTID>"
			+ "<USERNAME type=\"java.lang.String\">%s</USERNAME>"
			+ "<STAGESYSNAME type=\"java.lang.String\">appProcessingComplete</STAGESYSNAME>"
			+ "<STAGERESULT type=\"java.lang.String\">Approve</STAGERESULT>"
			+ "<STATESYSNAME type=\"java.lang.String\">approved</STATESYSNAME>"
			+ "<TRANSITIONSYSNAME type=\"java.lang.String\">approveCloseSavingAccount</TRANSITIONSYSNAME>"
			+ "</BODY>";
	private static final String COREWS_TOSYSTEM = "corews";
	
	@Autowired
	ApplicationConfig appConfig;
	
	@Autowired
	FxWsSecurityGenerator fxWsSecurityGenerator;

	@Override
	public DocumentSaveDSCALLResponse documentSave(String accountNo, String clientId, String username, String userId) throws MalformedURLException, DSCALLFAULT_Exception, JAXBException {
		String endPoint = appConfig.getConfig(ClosingCustomerConstant.DOCUMENT_SAVE_ENDPOINT_KEY);
		FRONTWS2SERVICE service = new FRONTWS2SERVICE(new URL(endPoint));
		FRONTWS2PORTTYPE servicePort = service.getFRONTWS2PORT();

		BindingProvider bindingProvider = (BindingProvider) servicePort;
		@SuppressWarnings("rawtypes")
		List<Handler> handlerChain = new ArrayList<Handler>();
		handlerChain.add(fxWsSecurityGenerator.generateHeaderSOAPHandler());
		bindingProvider.getBinding().setHandlerChain(handlerChain);

		String commandData = String.format(DOCUMENT_SAVE_COMMAND_DATA_TEMPLATE, accountNo, clientId, username, userId);
		String wsResponse = servicePort.dscall(DOCUMENT_SAVE_COMMAND_TEXT, commandData);

		JAXBContext context = JAXBContext.newInstance(DocumentSaveDSCALLResponse.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (DocumentSaveDSCALLResponse) unmarshaller.unmarshal(new StringReader(wsResponse));
	}
	
	@Override
	public StartTasklistDSCALLResponse startTasklist(String accountNo, String roleId, String documentId) throws MalformedURLException, DSCALLFAULT_Exception, JAXBException, com.btpn.ws.diasoft.corews.DSCALLFAULT_Exception {
		String endPoint = appConfig.getConfig(ClosingCustomerConstant.START_TASKLIST_ENDPOINT_KEY);
		COREWSSERVICE service = new COREWSSERVICE(new URL(endPoint));
		COREWSPORTTYPE servicePort = service.getCOREWSPORT();

		BindingProvider bindingProvider = (BindingProvider) servicePort;
		@SuppressWarnings("rawtypes")
		List<Handler> handlerChain = new ArrayList<Handler>();
		handlerChain.add(fxWsSecurityGenerator.generateHeaderSOAPHandler());
		bindingProvider.getBinding().setHandlerChain(handlerChain);

		String commandData = String.format(START_TASKLIST_COMMAND_DATA_TEMPLATE, accountNo, roleId, documentId);
		ContextData contextdata = new ContextData();
		contextdata.setToSystem(COREWS_TOSYSTEM);
		String wsResponse = servicePort.dscall(START_TASKLIST_COMMAND_TEXT, commandData, contextdata);

		JAXBContext context = JAXBContext.newInstance(StartTasklistDSCALLResponse.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (StartTasklistDSCALLResponse) unmarshaller.unmarshal(new StringReader(wsResponse));
	}
	
	@Override
	public UpdateTasklistStatusDSCALLResponse updateTasklistStatus(String userId, String taskId) throws MalformedURLException, com.btpn.ws.diasoft.corews.DSCALLFAULT_Exception, JAXBException {
		String endPoint = appConfig.getConfig(ClosingCustomerConstant.UPDATE_TASKLIST_STATUS_ENDPOINT_KEY);
		COREWSSERVICE service = new COREWSSERVICE(new URL(endPoint));
		COREWSPORTTYPE servicePort = service.getCOREWSPORT();

		BindingProvider bindingProvider = (BindingProvider) servicePort;
		@SuppressWarnings("rawtypes")
		List<Handler> handlerChain = new ArrayList<Handler>();
		handlerChain.add(fxWsSecurityGenerator.generateHeaderSOAPHandler());
		bindingProvider.getBinding().setHandlerChain(handlerChain);

		String commandData = String.format(UPDATE_TASKLIST_STATUS_COMMAND_DATA_TEMPLATE, userId, taskId);
		ContextData contextdata = new ContextData();
		contextdata.setToSystem(COREWS_TOSYSTEM);
		String wsResponse = servicePort.dscall(UPDATE_TASKLIST_STATUS_COMMAND_TEXT, commandData, contextdata);
		
		JAXBContext context = JAXBContext.newInstance(UpdateTasklistStatusDSCALLResponse.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (UpdateTasklistStatusDSCALLResponse) unmarshaller.unmarshal(new StringReader(wsResponse));
	}
	
	@Override
	public UpdateDocumentStatusDSCALLResponse updateDocumentStatus(String documentId, String userName) throws MalformedURLException, DSCALLFAULT_Exception, JAXBException {
		String endPoint = appConfig.getConfig(ClosingCustomerConstant.UPDATE_DOCUMENT_STATUS_ENDPOINT_KEY);
		FRONTWS2SERVICE service = new FRONTWS2SERVICE(new URL(endPoint));
		FRONTWS2PORTTYPE servicePort = service.getFRONTWS2PORT();

		BindingProvider bindingProvider = (BindingProvider) servicePort;
		@SuppressWarnings("rawtypes")
		List<Handler> handlerChain = new ArrayList<Handler>();
		handlerChain.add(fxWsSecurityGenerator.generateHeaderSOAPHandler());
		bindingProvider.getBinding().setHandlerChain(handlerChain);

		String commandData = String.format(UPDATE_DOCUMENT_STATUS_COMMAND_DATA_TEMPLATE, documentId, userName);
		String wsResponse = servicePort.dscall(UPDATE_DOCUMENT_STATUS_COMMAND_TEXT, commandData);
		
		JAXBContext context = JAXBContext.newInstance(UpdateDocumentStatusDSCALLResponse.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		return (UpdateDocumentStatusDSCALLResponse) unmarshaller.unmarshal(new StringReader(wsResponse));
	}
	
	
}
