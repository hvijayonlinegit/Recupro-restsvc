package com.synergy.recupro.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationEntryPoint.class);
    @Override
    public void commence(HttpServletRequest httpServletRequest,
                         HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {
        
         if (e instanceof BadCredentialsException) {
        	 logger.error("Responding with Bad Request error , please check username and password or create new user. Message - {}", e.getMessage());
        	 httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST,
                     "Invalid user name and Password, please correct or create a new User ");
		}
         else {
        //	 InsufficientAuthenticationException
        	 logger.error("Responding with unauthorized error. Message - {}", e.getMessage());
        	 httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED,
        			 "Sorry, You're not authorized to access this resource.");
         }
                
    }
}
