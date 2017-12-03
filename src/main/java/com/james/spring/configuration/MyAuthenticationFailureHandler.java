package com.james.spring.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Service;

@Service
public class MyAuthenticationFailureHandler  extends SimpleUrlAuthenticationFailureHandler {
    @Override  
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,  
            AuthenticationException exception) throws IOException, ServletException {
        response.getWriter().write("failed to be authenticated...");
    }
}