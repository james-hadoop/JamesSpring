package com.james.spring.configuration;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.james.spring.entity.User;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        User user = new User();
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();

        user.setUsername("james");
        user.setPassword("james");

        grantedAuthorities.add(new SimpleGrantedAuthority("STATIC"));

        authentication.setAuthenticated(true);

        final UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user, "james",
                grantedAuthorities);
        result.setDetails(authentication.getDetails());
        return result;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        // return authentication.equals(UsernamePasswordAuthenticationToken.class);
        return true;
    }
}
