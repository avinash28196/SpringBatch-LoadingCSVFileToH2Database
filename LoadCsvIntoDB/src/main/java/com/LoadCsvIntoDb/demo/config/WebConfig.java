package com.LoadCsvIntoDb.demo.config;
//package com.LendingClub.demo.config;
//
//import org.h2.server.web.WebServlet;
//import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
//import org.springframework.boot.web.servlet.ServletRegistrationBean;
//import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@SuppressWarnings({ "rawtypes", "unchecked" })
//@Configuration
//public class WebConfig {
//
//	@Bean
//	ServletRegistrationBean h2servletRegistration() {
//		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());
//		registrationBean.addUrlMappings("/h2-console/*");
//		return registrationBean;
//	}
//
//	@Bean
//	ServletWebServerFactory servletWebServerFactory() {
//		return new TomcatServletWebServerFactory();
//	}
//}