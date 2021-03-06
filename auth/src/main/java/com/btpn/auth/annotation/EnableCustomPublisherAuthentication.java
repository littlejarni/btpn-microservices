package com.btpn.auth.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.btpn.auth.config.AuthenticationCustomPublisherConfig;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AuthenticationCustomPublisherConfig.class)
public @interface EnableCustomPublisherAuthentication {

}
