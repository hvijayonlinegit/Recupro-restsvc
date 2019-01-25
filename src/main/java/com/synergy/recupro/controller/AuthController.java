package com.synergy.recupro.controller;

import java.net.URI;
import java.util.Collections;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.synergy.recupro.exception.AppException;
import com.synergy.recupro.helper.MailHelper;
import com.synergy.recupro.model.Role;
import com.synergy.recupro.model.RoleName;
import com.synergy.recupro.model.User;
import com.synergy.recupro.payload.ApiResponse;
import com.synergy.recupro.payload.JwtAuthenticationResponse;
import com.synergy.recupro.payload.LoginRequest;
import com.synergy.recupro.payload.SignUpRequest;
import com.synergy.recupro.repository.RoleRepository;
import com.synergy.recupro.repository.UserRepository;
import com.synergy.recupro.security.JwtTokenProvider;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JwtTokenProvider tokenProvider;
    
    @Autowired
    MailHelper mailHelper;
    
    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsernameOrEmail(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
                
        try 
        {
   			mailHelper.sendLoggedInEmailInfo(loginRequest.getUsernameOrEmail());
        }
        catch(Exception ex) 
        {
       	 System.err.println("email exception"+ex);
       	 //TODO: Have to log error going forward
        }
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Email Address already in use!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), signUpRequest.getPassword());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new AppException("User Role not set."));

        user.setRoles(Collections.singleton(userRole));
        
        User result = userRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();
        
        if(!Objects.isNull(result))
        {
        	 try 
             {
        		 mailHelper.sendEmail(user,location.toString());
             }
             catch(Exception ex) 
             {
            	 System.err.println("exception in sending mail   :"+ex);
            	 //TODO: Have to log error going forward
             }
        }
        
        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }
        
}
