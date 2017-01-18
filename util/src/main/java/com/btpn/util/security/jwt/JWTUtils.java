package com.btpn.util.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.xml.bind.DatatypeConverter;

public class JWTUtils {
	
	public static String createJWT(String issuer, String subject, long ttlMillis, Map<String, String> claims, String keyEncription) {
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(keyEncription);

		JwtBuilder builder = Jwts.builder()
								.setId(UUID.randomUUID().toString())
								.setIssuedAt(now)
								.setSubject(subject)
								.setIssuer(issuer)
								.signWith(SignatureAlgorithm.HS512, apiKeySecretBytes);
		claims.forEach((k,v) -> builder.claim(k, v));
		
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		return builder.compact();
	}

	public static Claims parseJWT(String jwt, String keyEncription) {
		Claims claims = Jwts.parser()
							.setSigningKey(DatatypeConverter.parseBase64Binary(keyEncription))
							.parseClaimsJws(jwt)
							.getBody();
		return claims;
	}

	public static void main(String[] args) {
		String KEY = "jwtKeyEncription";
		
		HashMap<String, String> map = new HashMap<String, String>();
		
		
		map.put("userId", "46403");
		map.put("branch", "branch");
		map.put("userRole", "JWT_ADMIN");
		map.put("spvRole", "2014");
		
		String jwt = JWTUtils.createJWT("BTPNIssuer", "fes04", 1000000000, map, KEY);
		System.out.println("jwt : " + jwt);
		Claims claims = JWTUtils.parseJWT(jwt, KEY);
		claims.forEach((k,v) -> System.out.println(k + " : " + v));		
	}

}
