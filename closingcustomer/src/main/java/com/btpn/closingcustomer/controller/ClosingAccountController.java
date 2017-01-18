package com.btpn.closingcustomer.controller;

import javax.xml.bind.JAXBException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.btpn.applicationconfig.ApplicationConfig;
import com.btpn.auth.AuthenticatedUser;
import com.btpn.auth.annotation.Authenticate;
import com.btpn.auth.session.SessionConsumer;
import com.btpn.closingcustomer.ClosingCustomerConstant;
import com.btpn.closingcustomer.soap.CloseAccountSoapClient;
import com.btpn.closingcustomer.soap.ClosingFeeSoapClient;
import com.btpn.closingcustomer.soap.TasklistSoapClient;
import com.btpn.closingcustomer.soap.entity.DocumentSaveDSCALLResponse;
import com.btpn.closingcustomer.soap.entity.StartTasklistDSCALLResponse;
import com.btpn.closingcustomer.soap.entity.UpdateDocumentStatusDSCALLResponse;
import com.btpn.closingcustomer.soap.entity.UpdateTasklistStatusDSCALLResponse;
import com.btpn.logging.annotation.Logging;
import com.btpn.persistence.entity.closingcustomer.ClosingApprovalEntity;
import com.btpn.persistence.service.closingcustomer.ClosingApprovalDaoService;
import com.btpn.response.exception.UserException;
import com.btpn.response.rest.CommonResponse;
import com.btpn.util.json.JsonUtil;
import com.btpn.ws.diasoft.frontws2.DSCALLFAULT_Exception;
import com.btpn.ws.mdw.btpnfesaccountequation.CloseCustomerAccountRes;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class ClosingAccountController {

	public static class ApproveClosingRequest {
		private String documentId;
		private String taskId;
		private String accountNo;
		private String accountCharge;

		public String getAccountNo() {
			return accountNo;
		}

		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}

		public String getDocumentId() {
			return documentId;
		}

		public String getTaskId() {
			return taskId;
		}

		public String getAccountCharge() {
			return accountCharge;
		}

		public void setAccountCharge(String accountCharge) {
			this.accountCharge = accountCharge;
		}

		public void setDocumentId(String documentId) {
			this.documentId = documentId;
		}

		public void setTaskId(String taskId) {
			this.taskId = taskId;
		}
	}

	public static class SubmitClosingRequest {
		private String accountNo;
		private String clientId;

		public String getAccountNo() {
			return accountNo;
		}

		public String getClientId() {
			return clientId;
		}

		public void setAccountNo(String accountNo) {
			this.accountNo = accountNo;
		}

		public void setClientId(String clientId) {
			this.clientId = clientId;
		}
	}

	public static final String SUBMIT_CLOSING_REQUEST_ADDR = "submitClosing";
	public static final String APPROVE_CLOSING_REQUEST_ADDR = "approveClosing";
	public static final String GET_CLOSING_DATA_REQUEST_ADDR = "getClosingData";

	@Autowired
	TasklistSoapClient tasklistSoapClient;
	@Autowired
	CloseAccountSoapClient closeAccountClient;
	@Autowired
	ClosingFeeSoapClient closingFeeClient;
	@Autowired
	ClosingApprovalDaoService daoService;
	@Autowired
	ApplicationConfig appConfig;
	@Autowired
	SessionConsumer sessionConsumer;

	@RequestMapping(method = RequestMethod.POST, value = SUBMIT_CLOSING_REQUEST_ADDR)
	@Logging
	@Authenticate
	public String submitClosing(
			HttpEntity<String> httpEntity
			) throws DSCALLFAULT_Exception, JAXBException, com.btpn.ws.diasoft.corews.DSCALLFAULT_Exception, Exception {
		String requestBody = httpEntity.getBody();
		SubmitClosingRequest request = JsonUtil.parseJson(requestBody, SubmitClosingRequest.class);
		AuthenticatedUser usr = sessionConsumer.getLoginUser();

		DocumentSaveDSCALLResponse documentSaveResponse = tasklistSoapClient.documentSave(request.getAccountNo(), request.getClientId(), usr.getUserName(), usr.getUserId());
		if (documentSaveResponse.getStatus() == null || !documentSaveResponse.getStatus().equalsIgnoreCase(ClosingCustomerConstant.OK_UPPER))
			throw new UserException(ClosingCustomerConstant.SAVE_DOCUMENT_ERROR_CODE, ClosingCustomerConstant.SAVE_DOCUMENT_ERROR_DESC);

		StartTasklistDSCALLResponse startTasklistResponse = tasklistSoapClient.startTasklist(request.getAccountNo(), usr.getSpvRole(), documentSaveResponse.getDocumentId());
		if (startTasklistResponse.getStatus() == null || !startTasklistResponse.getStatus().equalsIgnoreCase(ClosingCustomerConstant.OK_UPPER))
			throw new UserException(ClosingCustomerConstant.START_TASK_ERROR_CODE, ClosingCustomerConstant.START_TASK_ERROR_DESC);

		ClosingApprovalEntity closingApproval = new ClosingApprovalEntity();
		closingApproval.setData(requestBody);
		closingApproval.setDocumentId(documentSaveResponse.getDocumentId());
		closingApproval.setStatus(ClosingCustomerConstant.WAITING_APPROVAL_STATUS);
		daoService.saveClosingApproval(closingApproval);

		return JsonUtil.generateJson(new CommonResponse<Void>());
	}

	@RequestMapping(value = GET_CLOSING_DATA_REQUEST_ADDR)
	@Logging
	@Authenticate
	public String getClosingData(
			@Logging @RequestParam(name = "documentId") String documentId
			) throws JsonProcessingException {
		ClosingApprovalEntity cls = daoService.getClosingApprovalByDocument(documentId);
		CommonResponse<ClosingApprovalEntity> response = new CommonResponse<ClosingApprovalEntity>(cls);
		return JsonUtil.generateJson(response);
	}

	@RequestMapping(method = RequestMethod.POST, value = APPROVE_CLOSING_REQUEST_ADDR)
	@Logging
	@Authenticate
	public String approveClosing(
			@RequestBody ApproveClosingRequest request
			) throws Exception {
		AuthenticatedUser usr = sessionConsumer.getLoginUser();
		
		String fee = closingFeeClient.getClosingFee();

		CloseCustomerAccountRes closeCustomerAccountResponse = closeAccountClient.closeAccount(request.getAccountNo(), request.getAccountCharge(), fee, "049", "549");
		if (closeCustomerAccountResponse.getGeneralResponse() == null || !closeCustomerAccountResponse.getGeneralResponse().getResponseCode().equals(ClosingCustomerConstant.MDW_SUCCESS_CODE))
			throw new UserException(ClosingCustomerConstant.CLOSE_CUSTOMER_ERROR_CODE, ClosingCustomerConstant.CLOSE_CUSTOMER_ERROR_DESC);

		UpdateTasklistStatusDSCALLResponse updateTasklistStatusResponse = tasklistSoapClient.updateTasklistStatus(usr.getUserId(), request.getTaskId());
		if (updateTasklistStatusResponse.getStatus() == null || !updateTasklistStatusResponse.getStatus().equalsIgnoreCase(ClosingCustomerConstant.OK_UPPER))
			throw new UserException(ClosingCustomerConstant.UPDATE_TASK_ERROR_CODE, ClosingCustomerConstant.UPDATE_TASK_ERROR_DESC);

		UpdateDocumentStatusDSCALLResponse updateDocumentStatusResponse = tasklistSoapClient.updateDocumentStatus(request.getDocumentId(), usr.getUserName());
		if (updateDocumentStatusResponse.getStatus() == null || !updateDocumentStatusResponse.getStatus().equalsIgnoreCase(ClosingCustomerConstant.OK_UPPER))
			throw new UserException(ClosingCustomerConstant.UPDATE_TASK_ERROR_CODE, ClosingCustomerConstant.UPDATE_TASK_ERROR_DESC);

		daoService.closeClosingApproval(request.getDocumentId());

		return JsonUtil.generateJson(new CommonResponse<Void>());
	}
}
