package com.bandex.api.web;

import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletContextEvent;

public class SpringContextLoaderListener extends ContextLoaderListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);

		WebApplicationContext context = (WebApplicationContext) event.getServletContext().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);

		SpringBeanProxy.setApplicationContext(context);
	}
}
