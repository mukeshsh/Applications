package com.erasmith.foodie.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erasmith.foodie.dto.TokenDto;
import com.erasmith.foodie.form.LoginForm;
import com.erasmith.foodie.response.Response;
import com.erasmith.foodie.security.TokenService;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	 @Autowired
	    private AuthenticationManager authenticationManager;

	    @Autowired
	    private TokenService tokenService;

	    @PostMapping
	    public ResponseEntity<Response<TokenDto>> login(@RequestBody LoginForm loginForm) {
	        Response<TokenDto> response = new Response<>();
	        UsernamePasswordAuthenticationToken login = loginForm.convertToUsernamePasswordAuthenticationToken();
	        try {
	            Authentication authentication = authenticationManager.authenticate(login);
	            String token = tokenService.generateToken(authentication);
	            TokenDto tokenDto = new TokenDto(token, "Bearer");
	            response.setValue(tokenDto);
	            return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
	        } catch (AuthenticationException e) {
	            response.addError("Incorrect email and/or password");
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	        }
	    }

	}
