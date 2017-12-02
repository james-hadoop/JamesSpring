package com.james.spring.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.james.spring.entity.User;
import com.james.spring.service.IAuthenticationService;

@Service
public class InMemoryAuthenticationServiceImpl implements IAuthenticationService {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user=new User();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>(); 
        
        final UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user, authentication.getCredentials(), grantedAuthorities);
        result.setDetails(authentication.getDetails());
        return result;
    }
}