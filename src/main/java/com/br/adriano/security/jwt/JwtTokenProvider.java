package com.br.adriano.security.jwt;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class JwtTokenProvider {

	
	@Value()
	private String secretKey = "secret";
	
	private long validityInMilliseconds = 3600000;
}
