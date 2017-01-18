package com.btpn.common.filter;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.btpn.common.CommonConstant;
import com.btpn.common.context.RequestContext;

public class RegisterRequestIdContextInterceptor implements HandlerInterceptor {

	@Autowired
	RequestContext requestContext;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestId = UUID.randomUUID().toString().replace("-", "");
		MDC.put(CommonConstant.REQUEST_ID_CONTEXT, requestId);
		if(requestContext!=null) {
			requestContext.put(CommonConstant.REQUEST_ID_CONTEXT, requestId);
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	}

}
