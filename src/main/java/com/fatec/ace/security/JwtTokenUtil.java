package com.fatec.ace.security;

import java.util.Date;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fatec.ace.enums.Role;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtTokenUtil {

	@Value("${jwt.secret}")
    private String secretKey;
	@Value("${jwt.expiration}")
    private long expiration;

    private SecretKey getSigningKey() {
        return Keys.hmacShaKeyFor(secretKey.getBytes());
    }

    @SuppressWarnings("deprecation")
	public String generateToken(String email, Set<Role> roles, Long userId) {
        return Jwts.builder()
            .setSubject(email)
            .claim("roles", roles)
            .claim("userId", userId)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + expiration))
            .signWith(getSigningKey())
            .compact();
    }

    public String getUsernameFromToken(String token) {
        @SuppressWarnings("deprecation")
		JwtParser jwtParser = Jwts.parser()
        		.setSigningKey(getSigningKey())
        		.build();

        @SuppressWarnings("deprecation")
		Jws<Claims> claimsJws = jwtParser
            .parseClaimsJws(token);

        @SuppressWarnings("deprecation")
		Claims claims = claimsJws.getBody();
        return claims.getSubject();
    }

    @SuppressWarnings("deprecation")
	public boolean validateToken(String token) {
        try {
            JwtParser jwtParser = Jwts.parser()
            		.setSigningKey(getSigningKey())
            		.build();

            jwtParser.parseClaimsJws(token);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getTokenFromRequest(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }
        return null;
    }
}
