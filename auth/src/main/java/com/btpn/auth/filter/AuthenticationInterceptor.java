package com.btpn.auth.filter;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.btpn.auth.AuthenticatedUser;
import com.btpn.auth.AuthenticationConstant;
import com.btpn.auth.annotation.Authenticate;
import com.btpn.auth.session.SessionConsumer;

public class AuthenticationInterceptor implements HandlerInterceptor {

	@Autowired
	SessionConsumer sessionConsumer;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HandlerMethod hm = (HandlerMethod) handler;
		Authenticate authAnnotation = AnnotationUtils.findAnnotation(hm.getMethod(), Authenticate.class);
		if (authAnnotation == null) {
			return true;
		}
		
		AuthenticatedUser user = sessionConsumer.getLoginUser();
		if (user == null || user.equals("")) {
			response.sendError(HttpServletResponse.SC_UNAUTHORIZED, AuthenticationConstant.UNAUTHORIZED_MESSAGE);
			return false;
		}
		
		String[] methodServices = authAnnotation.value();
		if(methodServices == null || methodServices[0]==null || methodServices[0].equals(""))
			return true;
		
		List<String> userServices = user.getServices();
		for(String methodService : methodServices) {
			for(String userService : userServices) {
				if (userService.equals(methodService))
					return true;
			}
		}

		response.sendError(HttpServletResponse.SC_FORBIDDEN, AuthenticationConstant.FORBIDDEN_MESSAGE);
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
	}

}
