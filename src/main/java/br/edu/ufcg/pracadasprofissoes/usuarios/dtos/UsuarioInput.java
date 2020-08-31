package br.edu.ufcg.pracadasprofissoes.usuarios.dtos;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.NotEmpty;


public class UsuarioInput {
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private String senha;
	
	public UsuarioInput(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
