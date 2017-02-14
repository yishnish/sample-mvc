package com.yishnish.samplemvc;

import com.yishnish.samplemvc.core.AppContextConfig;
import com.yishnish.samplemvc.web.WebApplicationContextConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Properties;

public class MyWebAppInitializer implements WebApplicationInitializer {

    public void onStartup(javax.servlet.ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(AppContextConfig.class);

        Properties properties = PropertiesLoader.loadProperties("/environment.properties");
        applicationContext.getEnvironment().addActiveProfile(properties.getProperty("active.profiles"));

        servletContext.addListener(new ContextLoaderListener(applicationContext));

        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(WebApplicationContextConfig.class);

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(webApplicationContext));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
    }
}
