package com.btpn.wscall.rest.auth.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.btpn.wscall.rest.auth.config.AuthenticationCustomConsumerConfig;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(AuthenticationCustomConsumerConfig.class)
public @interface EnableCustomConsumerAuthentication {

}
