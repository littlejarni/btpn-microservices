package com.btpn.wscall;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;

import com.btpn.applicationconfig.ApplicationConfig;
import com.btpn.persistence.service.runningnumber.RunningNumberService;
import com.btpn.wscall.entity.CommonParam;

public class CommonParamGenerator {

	public static final String PREFIX_KEY = "common.param.default";
	public static final String TRANSMISSION_DATE_TIME_FIELD_LOWER = "transmissiondatetime";
	public static final String TRANSMISSION_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm:ss+07:00";
	public static final String REQUEST_ID_FIELD_LOWER = "requestid";
	public static final String REQUEST_ID_TEMPLATE = "%06d";
	public static final String REFERENCE_NO_TEMPLATE = "%012d";
	public static final String REFERENCE_NO_FIELD_LOWER = "referenceno";

	@Autowired
	ApplicationConfig appConfig;
	
	@Autowired
	RunningNumberService runningNumber;
	
	public <T> T generateCommonParamWithStringProp(Class<T> cls) throws Exception {
		return generateCommonParam(cls, null);
	}
	
	public <T> T generateCommonParam(Class<T> cls, Object objFactory) throws Exception {
		T commonParam = cls.newInstance();
		Field[] fields = cls.getDeclaredFields();
		int id = runningNumber.getRunningNumber();
		for(Field field : fields) {
			if (!Modifier.isFinal(field.getModifiers())) {
				if(field.getName().equalsIgnoreCase(TRANSMISSION_DATE_TIME_FIELD_LOWER)) {
					setData(commonParam, getTransmissionDate(), field, objFactory);
				} else if(field.getName().equalsIgnoreCase(REQUEST_ID_FIELD_LOWER)) {
					String formatted = String.format(REQUEST_ID_TEMPLATE, id);
//					field.setAccessible(true);
//					field.set(commonParam, formatted);
					setData(commonParam, formatted, field, objFactory);
				} else if(field.getName().equalsIgnoreCase(REFERENCE_NO_FIELD_LOWER)) {
					String formatted = String.format(REFERENCE_NO_TEMPLATE, id);
//					field.setAccessible(true);
//					field.set(commonParam, formatted);
					setData(commonParam, formatted, field, objFactory);
				} else {
					String defaultValue = appConfig.getConfig(PREFIX_KEY + "." + field.getName().toLowerCase());
					if(defaultValue!=null && !defaultValue.equals("")) {
//						field.setAccessible(true);
//						field.set(commonParam, defaultValue);
						setData(commonParam, defaultValue, field, objFactory);
					}
				}
			}
		}
		return commonParam;
	}

	private <T> void setData(T commonParam, String value, Field field, Object factory) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		if(field.getType() == String.class) {
			field.setAccessible(true);
			field.set(commonParam, value);
		} else if(field.getType() == JAXBElement.class){
			@SuppressWarnings("rawtypes")
			Class factoryClass = factory.getClass();
			String comParClassName = commonParam.getClass().getSimpleName();
			String fieldName = field.getName();
			String methodTargetLower = "create" + comParClassName.toLowerCase() + fieldName.toLowerCase();
			Method[] methods = factoryClass.getMethods();
			
			for(Method method : methods) {
				if(method.getName().toLowerCase().equals(methodTargetLower)) {
					Object ret = method.invoke(factory, value);
					field.setAccessible(true);
					field.set(commonParam, ret);
				}
			}
		}
	}

	private String getTransmissionDate() {
		SimpleDateFormat sdf = new SimpleDateFormat(TRANSMISSION_DATE_TIME_FORMAT);
		return sdf.format(new Date());
	}

	public CommonParam generateCommonParam() throws Exception {
		return generateCommonParamWithStringProp(CommonParam.class);
	}

}
