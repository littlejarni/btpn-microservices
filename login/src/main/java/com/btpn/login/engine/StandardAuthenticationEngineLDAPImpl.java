package com.btpn.login.engine;

import java.util.Hashtable;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.btpn.auth.AuthenticatedUser;
import com.btpn.auth.AuthenticationConstant;
import com.btpn.applicationconfig.ApplicationConfig;
import com.btpn.response.exception.UserException;
import com.btpn.login.LoginConstant;

public class StandardAuthenticationEngineLDAPImpl implements StandardAuthenticationEngine {

	@Autowired
	ApplicationConfig appConfig;

	Logger log = LoggerFactory.getLogger(StandardAuthenticationEngineLDAPImpl.class);
	
	@Override
	public AuthenticatedUser authenticate(String username, String password) throws UserException, NamingException {
		DirContext ldapContext;
		AuthenticatedUser usr = new AuthenticatedUser();
		String host = appConfig.getConfig(LoginConstant.LDAP_HOST_KEY);
		String domain = appConfig.getConfig(LoginConstant.LDAP_DOMAIN_KEY);
		String nameField = appConfig.getConfig(LoginConstant.LDAP_NAME_FIELD_KEY);
		String nikField = appConfig.getConfig(LoginConstant.LDAP_NIK_FIELD_KEY);
		String searchBase = appConfig.getConfig(LoginConstant.LDAP_SEARCH_BASE_KEY);

		Hashtable<String, String> ldapEnv = new Hashtable<String, String>(11);
		ldapEnv.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		ldapEnv.put(Context.PROVIDER_URL, host);
		ldapEnv.put(Context.SECURITY_AUTHENTICATION, "simple");
		ldapEnv.put(Context.SECURITY_PRINCIPAL, username + "@" + domain);
		ldapEnv.put(Context.SECURITY_CREDENTIALS, password);
		try {
			ldapContext = new InitialDirContext(ldapEnv);
		} catch(AuthenticationException e) {
			log.error("LDAP Authentication on user {} failed", username, e);
			throw new UserException(LoginConstant.INVALID_LOGIN_LDAP_ERROR_CODE, LoginConstant.INVALID_LOGIN_LDAP_ERROR_DESC);
		}

		SearchControls searchCtls = new SearchControls();
		String returnedAtts[] = { nameField, nikField };
		searchCtls.setReturningAttributes(returnedAtts);

		searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
		String searchFilter = "(" + nikField + "=" + username + ")";

		NamingEnumeration<SearchResult> answer = ldapContext.search(searchBase, searchFilter, searchCtls);

		if(answer.hasMoreElements()) {
			SearchResult sr = (SearchResult) answer.next();
			Attributes attrs = sr.getAttributes();
			String name = (String) attrs.get(nameField).get();
			
			usr.setUserName(username);
			usr.setName(name);
			usr.setAuthenticatedMethod(AuthenticationConstant.AUTHENTICATION_METHOD_LDAP);
		}
		ldapContext.close();
		return usr;
	}

}
