package com.james.spring.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.james.spring.service.impl.StaticResourceAuthenticationServiceImpl;

@Service
public class AuthorityFilter implements Filter {
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("init() arg0=" + arg0);
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String currentURL = request.getRequestURI();
        System.out.println("currentURL: " + currentURL);

        ServletContext servletContext = request.getSession().getServletContext();
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        StaticResourceAuthenticationServiceImpl staticResourceAuthenticationServiceImpl = ctx
                .getBean(StaticResourceAuthenticationServiceImpl.class);
        boolean isAuthenticated = staticResourceAuthenticationServiceImpl.isPass(true);
        System.out.println("isAuthenticated=" + isAuthenticated);

        chain.doFilter(request, response);
    }
}