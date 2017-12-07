package com.james.spring.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.james.spring.util.DataUtil;

@Service
public class AuthorityFilter implements Filter {
    private static int qualifiedInterval = 1000 * 30;

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
            if (currentURL.contains("static")) {
                String queryString = request.getQueryString();

                if (null == queryString || 0 == queryString.length()) {
                    isQulifiedStaticResourceAccess = false;
                } else {
                    isQulifiedStaticResourceAccess = DataUtil.isQulifiedStaticResourceAccess(queryString,
                            qualifiedInterval);
                }
            } else {
                isQulifiedStaticResourceAccess = true;
            }

        } catch (Exception e) {
            // e.printStackTrace();
            System.out.println("AuthorityFilter.doFilter() exception detected");
            isQulifiedStaticResourceAccess = false;
        }

        if (false == isQulifiedStaticResourceAccess) {
            response.sendRedirect("/errorPage");
        }

        chain.doFilter(request, response);
    }
}