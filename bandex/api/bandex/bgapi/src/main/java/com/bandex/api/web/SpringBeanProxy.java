package com.bandex.api.web;

import com.bandex.api.annotations.FunctionCode;
import org.springframework.context.ApplicationContext;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SpringBeanProxy {

	private static ApplicationContext applicationContext;
	private static Map<String, Object> functionCodeBeanMap = new HashMap<String, Object>();
	// private static Map<String, String> functionCodeBeanNameMap = new
	// HashMap<String, String>();
	private static Map<String, Method> functionCodeMethodMap = new HashMap<String, Method>();

	private static Map<String, String> functionCodeCatalogMap = new HashMap<String, String>();
	private static Map<String, Map<String, String>> functionCodeListMap = new HashMap<String, Map<String, String>>();

	//
	// private static Map<String, String> functionCodeMethodNameMap = new
	// HashMap<String, String>();
	// private static Map<String, Class<?>[]> functionCodeMethodParamMap = new
	// HashMap<String, Class<?>[]>();

	public synchronized static void setApplicationContext(ApplicationContext arg0) {
		applicationContext = arg0;

		Map<String, Object> tempMap = applicationContext.getBeansWithAnnotation(FunctionCode.class);
		if (tempMap != null && tempMap.size() > 0) {
			for (Map.Entry<String, Object> entry : tempMap.entrySet()) {
				// String beanName = entry.getKey();
				Object bean = entry.getValue();
				FunctionCode beanFc = bean.getClass().getAnnotation(FunctionCode.class);
				if (beanFc != null) {
					String beanFunctionCode = beanFc.value();
					functionCodeBeanMap.put(beanFunctionCode, bean);
					//
					// functionCodeBeanNameMap.put(beanFunctionCode, beanName);
					functionCodeCatalogMap.put(beanFunctionCode, beanFc.descript());

					Method[] methodArr = bean.getClass().getDeclaredMethods();
					if (methodArr != null && methodArr.length > 0) {
						Map<String, String> methodFunctionCodeMap = new HashMap<String, String>();
						for (Method method : methodArr) {
							FunctionCode methodFc = method.getAnnotation(FunctionCode.class);
							if (methodFc != null) {
								String methodFunctionCode = methodFc.value();
								functionCodeMethodMap.put(methodFunctionCode, method);
								//
								// functionCodeMethodNameMap.put(methodFunctionCode,
								// method.getName());
								// functionCodeMethodParamMap.put(methodFunctionCode,
								// method.getParameterTypes());
								methodFunctionCodeMap.put(methodFunctionCode, methodFc.descript());
							}
						}
						functionCodeListMap.put(beanFunctionCode, methodFunctionCodeMap);
					}
				}
			}
		}
		System.out.println("========functionCodeBeanMap=====" + functionCodeBeanMap.toString());
		// System.out.println("========functionCodeBeanNameMap=====" +
		// functionCodeBeanNameMap.toString());
		System.out.println("========functionCodeMethodMap=====" + functionCodeMethodMap.toString());
		//
		// System.out.println("========functionCodeMethodNameMap=====" +
		// functionCodeMethodNameMap.toString());
		// System.out.println("========functionCodeMethodParamMap=====" +
		// functionCodeMethodParamMap.toString());
	}

	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

	public static Object getBeanByFunctionCode(String functionCode) {
		return functionCodeBeanMap.get(functionCode);
	}

	public static Method getMethodByFunctionCode(String functionCode) {
		return functionCodeMethodMap.get(functionCode);
	}

	public static Map<String, String> getFunctionCodeCatalogMap() {
		return functionCodeCatalogMap;
	}

	public static Map<String, Map<String, String>> getFunctionCodeListMap() {
		return functionCodeListMap;
	}

}
