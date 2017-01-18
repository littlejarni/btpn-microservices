package com.btpn.applicationconfig.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;

import com.btpn.applicationconfig.config.LoadAppConfigurationConfig;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(LoadAppConfigurationConfig.class)
public @interface EnableLoadAppConfig {

}
