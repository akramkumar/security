package com.demo.security.service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {
	
	private String secretKey="";
	public JWTService() throws NoSuchAlgorithmException {
		KeyGenerator key = KeyGenerator.getInstance("HmacSHA256");
		SecretKey sk = key.generateKey();
		secretKey=Base64.getEncoder().encodeToString(sk.getEncoded());
		
	}

	public String generate(String username) {
		// TODO Auto-generated method stub
		Map<String, Object> claim = new  HashMap<>();
		return Jwts
				.builder()
				.claims()
				.add(claim)
				.subject(username)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis()+60*60*30))
				.and()
				.signWith(getKey())
				.compact();
	}

	private Key getKey() {
		// TODO Auto-generated method stub
		byte[] key = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(key);
	}

	public String exactUsername(String token) {
		// TODO Auto-generated method stub
		
		return null;
	}

	public boolean validateToken(String token, UserDetails userDetails) {
		// TODO Auto-generated method stub
		return false;
	}

}
