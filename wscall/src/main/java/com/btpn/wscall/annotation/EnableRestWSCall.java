package com.btpn.wscall.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.btpn.wscall.config.RestWSCallConfig;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(RestWSCallConfig.class)
public @interface EnableRestWSCall {

}
