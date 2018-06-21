package com.test.spring.web.emzbankcustomer.config;

public class EMZBankWebConfiguration {

	/*	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(EMZBankSpringConfiguration.class);
		servletContext.addListener(new ContextLoaderListener());
		
		AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("customer", new DispatcherServlet(dispatcherContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/customer");
	}*/

}
