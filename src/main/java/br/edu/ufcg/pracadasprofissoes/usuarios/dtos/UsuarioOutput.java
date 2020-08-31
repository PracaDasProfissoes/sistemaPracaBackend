package br.edu.ufcg.pracadasprofissoes.usuarios.dtos;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;

import br.edu.ufcg.pracadasprofissoes.enums.Perfil;

public class UsuarioOutput {
	
	@NotEmpty
	private Long id;
	
	@NotEmpty
	private String email;
	
	@NotEmpty
	private Set<Integer> perfis = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}
	
}
