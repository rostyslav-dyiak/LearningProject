package org.learning.project.conroller.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.learning.project.dao.config.RepositoryContext;
import org.learning.project.service.config.ServiceContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfigurator implements WebApplicationInitializer {
	private static final Logger LOG = LoggerFactory.getLogger(WebConfigurator.class);

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		LOG.info("Setting up dispatcher servlet!");
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RepositoryContext.class, ServiceContext.class);

		servletContext.addListener(new ContextLoaderListener(rootContext));

		AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
		dispatcherServlet.register(WebApplicationContext.class);

		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");
		LOG.info("Dispatcher servlet is ready for use");
	}
}
