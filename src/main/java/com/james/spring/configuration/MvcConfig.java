package com.james.spring.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home.html");
        registry.addViewController("/").setViewName("home.html");
        registry.addViewController("/hello").setViewName("hello.html");
        registry.addViewController("/login").setViewName("login.html");
        registry.addViewController("/greetingPage").setViewName("greetingPage.html");
        registry.addViewController("/error").setViewName("error.html");
        registry.addViewController("/uploadForm").setViewName("uploadForm.html");
        //registry.addViewController("/uploadFilesPage").setViewName("uploadFilesPage.html");
        
    }

}