package br.edu.ufcg.pracadasprofissoes.escola;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.edu.ufcg.pracadasprofissoes.usuarios.Usuario;

@Entity
public class Escola implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String sigla;

	@Column(unique=true)
	private String cnpj;

	private String telefone;
	
	private String diretor;
	
	private Endereco endereco;
	
	@OneToOne
	private Usuario usuario;
	
	public Escola(){
		
	}
	
	public Escola(String nome, String sigla, String cnpj, String telefone, String diretor, Usuario usuario, Endereco endereco) {
		this.nome = nome;
		this.sigla = sigla;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.diretor = diretor;
		this.usuario = usuario;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}