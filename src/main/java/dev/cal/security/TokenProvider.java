package dev.cal.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;


import dev.cal.domain.member.Member;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TokenProvider {
	
	private static final String SECRETE_KEY = "NMA8JPctFuna59f5";
	
	public String create(Member memberEntity) {
		
		Date expiryDate = Date.from(
				Instant.now()
				.plus(1, ChronoUnit.DAYS));
				
		
	
		return Jwts.builder()
				.signWith(SignatureAlgorithm.HS512, SECRETE_KEY)
				.setSubject(memberEntity.getId()) 
				.setIssuer("seoin")
				.setIssuedAt(new Date()) 
				.setExpiration(expiryDate) 
				.compact();
		
				
	}
	
	public String validateAndGetUserId(String token) {
		
		
		Claims claims = Jwts.parser()
				.setSigningKey(SECRETE_KEY)
				.parseClaimsJws(token)
				.getBody();
		
		
		return claims.getSubject();
	}

}
