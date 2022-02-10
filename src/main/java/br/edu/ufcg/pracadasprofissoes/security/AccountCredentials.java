package br.edu.ufcg.pracadasprofissoes.security;

import javax.validation.constraints.NotEmpty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCredentials {
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String senha;
}
