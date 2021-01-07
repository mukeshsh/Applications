package com.erasmith.foodie.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.erasmith.foodie.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {
	
	 @Value("${api.jwt.expiration}")
	    private String expiration;

	    @Value("${api.jwt.secret}")
	    private String secret;

	    public String generateToken(Authentication authentication) {
	        User authenticatedSource = (User) authentication.getPrincipal();
	        Date currentDate = new Date();
	        Date expirationDate = new Date(currentDate.getTime() + Long.parseLong(expiration));

	        return Jwts.builder()
	                .setIssuer("B2B Food Delivery")
	                .setSubject(authenticatedSource.getId().toString())
	                .setIssuedAt(currentDate)
	                .setExpiration(expirationDate)
	                .signWith(SignatureAlgorithm.HS512, secret)
	                .compact();
	    }

	    public boolean validToken(String token) {
	        try {
	            Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    public Long getUserIdFromToken(String token) {
	        Claims claims = Jwts.parser().setSigningKey(this.secret).parseClaimsJws(token).getBody();

	        return Long.parseLong(claims.getSubject());
	    }
	}
