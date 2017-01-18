package com.btpn.util.http;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class HTTPUtil {

	public static Cookie getCookieByName(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();
		
		if(cookies == null ) 
			return null;
		if(name == null)
			return null;
		
		for (Cookie c : cookies) {
			if (name.equals(c.getName())) {
				return c;
			}
		}
		
		return null;
	}
}
