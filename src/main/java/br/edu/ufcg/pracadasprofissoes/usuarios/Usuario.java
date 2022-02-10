package br.edu.ufcg.pracadasprofissoes.usuarios;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.edu.ufcg.pracadasprofissoes.enums.Perfil;

@Entity
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@NotEmpty
	@Column(unique=true)
	private String email;
	
	@NotNull
	@NotEmpty
	private String senha;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();

	public Usuario() {
		addPerfil(Perfil.USUARIO);
	}
	
	public Usuario(String email, String senha) {
		this.email = email;
		this.senha = senha;
		addPerfil(Perfil.USUARIO);
	}

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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public Set<Perfil> getPerfis(){
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}
	
	public String getPerfisString() throws JsonProcessingException {
		Payload payload = new Payload();
		payload.setEmail(this.email);
		payload.setPerfil(perfis.stream().map(x -> Perfil.getPerfil(x)).collect(Collectors.toList()));
		String retorno = new ObjectMapper().writeValueAsString(payload);
		return retorno;
	}
}