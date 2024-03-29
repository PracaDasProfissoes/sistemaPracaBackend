package br.edu.ufcg.pracadasprofissoes.util;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CryptUtil {
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public CryptUtil() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder();
	}
	
	public String hashPassword(String password) {
		return bCryptPasswordEncoder.encode(password);
	}

	public boolean matches(String password, String hash) {
		return bCryptPasswordEncoder.matches(password, hash);
	}
}
