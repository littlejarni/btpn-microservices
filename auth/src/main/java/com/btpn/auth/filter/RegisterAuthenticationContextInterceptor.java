package com.btpn.auth.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.btpn.auth.AuthenticatedUser;
import com.btpn.auth.AuthenticationConstant;
import com.btpn.auth.session.SessionConsumer;

public class RegisterAuthenticationContextInterceptor implements HandlerInterceptor {

	@Autowired
	SessionConsumer sessionConsumer;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		AuthenticatedUser usr = sessionConsumer.getLoginUser();
		if(usr!=null) {
			MDC.put(AuthenticationConstant.USER_NAME_LOG_CONTEXT, usr.getUserName());
			MDC.put(AuthenticationConstant.USER_ID_LOG_CONTEXT, usr.getUserId());
			MDC.put(AuthenticationConstant.AUTH_METHOD_LOG_CONTEXT, usr.getAuthenticatedMethod());
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
