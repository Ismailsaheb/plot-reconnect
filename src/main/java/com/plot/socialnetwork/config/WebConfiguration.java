package com.plot.socialnetwork.config;

import static com.plot.socialnetwork.config.Constants.AVATAR_FOLDER;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

	/*
	 * @Bean // TODO: Enables h2 console - only for development environment
	 * ServletRegistrationBean h2servletRegistration(){ ServletRegistrationBean
	 * registrationBean = new ServletRegistrationBean(new WebServlet());
	 * registrationBean.addUrlMappings("/console/*"); return registrationBean; }
	 */

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(AVATAR_FOLDER + "**").addResourceLocations(AVATAR_FOLDER);

		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//		registry.addResourceHandler("/webjars/**")
//				.addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

}
