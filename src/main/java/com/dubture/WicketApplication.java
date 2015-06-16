package com.dubture;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class WicketApplication extends WebApplication {

  @Override
  public Class<? extends WebPage> getHomePage() {
    return HomePage.class;
  }

  @Autowired
  private ApplicationContext applicationContext;

  public static void main(String[] args) {
    SpringApplication.run(WicketApplication.class, args);
  }

  @Override
  public void init() {
    super.init();

    getComponentInstantiationListeners().add(
        new SpringComponentInjector(this, applicationContext));

  }
}
