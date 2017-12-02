package com.james.spring.configuration;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.james.spring.service.IAuthenticationService;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static Logger logger = Logger.getLogger(CustomAuthenticationProvider.class);
    @Autowired
    private IAuthenticationService authenticationService;

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        return authenticationService.authenticate(authentication);
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}