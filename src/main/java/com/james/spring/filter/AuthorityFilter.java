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
import com.james.spring.util.DataUtil;

@Service
public class AuthorityFilter implements Filter {
    private static int qualifiedInterval = 1000*60*60*2;

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

        boolean isQulifiedStaticResourceAccess = false;
        try {
            String currentURL = request.getRequestURI();
            // System.out.println("currentURL=" + currentURL);
            if (currentURL.contains("static")) {
                String queryString = request.getQueryString();
                // System.out.println("queryString=" + queryString);

                isQulifiedStaticResourceAccess = DataUtil.isQulifiedStaticResourceAccess(queryString,
                        qualifiedInterval);
            } else {
                isQulifiedStaticResourceAccess = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            isQulifiedStaticResourceAccess=false;
        }

        // /*
        // *
        // */
        // System.out.println("rotocol: " + request.getProtocol());
        // System.out.println("Scheme: " + request.getScheme());
        // System.out.println("Server Name: " + request.getServerName() );
        // System.out.println("Server Port: " + request.getServerPort());
        // System.out.println("rotocol: " + request.getProtocol());
        // System.out.println("Remote Addr: " + request.getRemoteAddr());
        // System.out.println("Remote Host: " + request.getRemoteHost());
        // System.out.println("Character Encoding: " + request.getCharacterEncoding());
        // System.out.println("Content Length: " + request.getContentLength());
        // System.out.println("Content Type: "+ request.getContentType());
        // System.out.println("Auth Type: " + request.getAuthType());
        // System.out.println("HTTP Method: " + request.getMethod());
        // System.out.println("ath Info: " + request.getPathInfo());
        // System.out.println("ath Trans: " + request.getPathTranslated());
        // System.out.println("Query String: " + request.getQueryString());
        // System.out.println("Remote User: " + request.getRemoteUser());
        // System.out.println("Session Id: " + request.getRequestedSessionId());
        // System.out.println("Request URI: " + request.getRequestURI());
        // System.out.println("Servlet Path: " + request.getServletPath());
        // System.out.println("Accept: " + request.getHeader("Accept"));
        // System.out.println("Host: " + request.getHeader("Host"));
        // System.out.println("Referer : " + request.getHeader("Referer"));
        // System.out.println("Accept-Language : " +
        // request.getHeader("Accept-Language"));
        // System.out.println("Accept-Encoding : " +
        // request.getHeader("Accept-Encoding"));
        // System.out.println("User-Agent : " + request.getHeader("User-Agent"));
        // System.out.println("Connection : " + request.getHeader("Connection"));
        // System.out.println("Cookie : " + request.getHeader("Cookie"));
        // /*
        // *
        // */

        // ServletContext servletContext = request.getSession().getServletContext();
        // WebApplicationContext ctx =
        // WebApplicationContextUtils.getWebApplicationContext(servletContext);
        // StaticResourceAuthenticationServiceImpl
        // staticResourceAuthenticationServiceImpl = ctx
        // .getBean(StaticResourceAuthenticationServiceImpl.class);
        // boolean isAuthenticated =
        // staticResourceAuthenticationServiceImpl.isPass(true);
        // System.out.println("isAuthenticated=" + isAuthenticated);

        if (false == isQulifiedStaticResourceAccess) {
            System.out.println("false==isQulifiedStaticResourceAccess");
            response.sendRedirect("/errorPage");
        }

        chain.doFilter(request, response);
    }
}