package com.dubture;

import org.apache.wicket.protocol.http.WicketFilter;
import org.apache.wicket.spring.SpringWebApplicationFactory;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

@Configuration
public class WebInitializer implements ServletContextInitializer {

  private static final String PARAM_APP_BEAN = "applicationBean";

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {

    FilterRegistration filter = servletContext.addFilter("wicket-filter", WicketFilter.class);
    filter.setInitParameter(WicketFilter.APP_FACT_PARAM, SpringWebApplicationFactory.class.getName());
    filter.setInitParameter(PARAM_APP_BEAN, "wicketApplication");
    filter.setInitParameter(WicketFilter.FILTER_MAPPING_PARAM, "/*");
    filter.addMappingForUrlPatterns(null, false, "/*");

  }
}
