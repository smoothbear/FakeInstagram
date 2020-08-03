package com.kjbin0420.fakeinstagram.Security;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
}