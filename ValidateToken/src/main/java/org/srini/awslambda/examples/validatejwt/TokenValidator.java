package org.srini.awslambda.examples.validatejwt;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.Date;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSVerifier;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.SignedJWT;

public class TokenValidator {
	
	public static final String EXPIRED_TOKEN_MESSAGE = "Expired Token";
	public static final String INVALID_TOKEN_MESSAGE = "Invalid Token";
	
	public static final String TOKEN_CANT_BE_EMPTY_MESSAGE = "Token cannot be empty";
	public static final String KEY_CANT_BE_EMPTY_MESSAGE = "Secret Key cannot be empty";
	
	public static final String VALID_TOKEN = "Valid Token";
	
	//Same secret key as in Token Generator
    private static String SECRET_KEY = "secretKeysecretKeysecretKeysecretKey";

	public static String validateToken(String token) throws ParseException, JOSEException, NoSuchAlgorithmException {
		
		if(token == null || "".equals(token)) {
    		throw new IllegalArgumentException(TOKEN_CANT_BE_EMPTY_MESSAGE);
    	}
		
		byte[] secret = SECRET_KEY.getBytes();

		SignedJWT signedJWT = SignedJWT.parse(token);
		JWSVerifier verifier = new MACVerifier(secret);

		boolean value = signedJWT.verify(verifier);
		
		if(value) {
			long now = new Date().getTime();
			long tokenValidTill = signedJWT.getJWTClaimsSet().getExpirationTime().getTime();
			if(tokenValidTill < now) {
				return EXPIRED_TOKEN_MESSAGE;
			}
			
			return VALID_TOKEN;
		} else {
			return INVALID_TOKEN_MESSAGE;
		}
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException, ParseException, JOSEException {
      System.out.println(validateToken("eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJzb21lIGF1ZGllbmNlIiwibWFuYWdlciI6ImZhbHNlIiwiaXNzIjoic3JpbmkiLCJleHAiOjE1MTUxOTk0MTgsInVzZXJJZCI6IjEwMCJ9.e2l3qac-vbyXu5XV_RkVsaqpVy3jrLxjxuCZ2xgcusc"));
    }

}
