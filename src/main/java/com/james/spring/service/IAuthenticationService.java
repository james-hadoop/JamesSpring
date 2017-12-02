package com.james.spring.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public interface IAuthenticationService {
    Authentication authenticate(final Authentication authentication) throws AuthenticationException;
}
