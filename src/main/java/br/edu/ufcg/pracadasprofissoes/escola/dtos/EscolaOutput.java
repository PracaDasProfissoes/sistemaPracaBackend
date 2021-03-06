package br.edu.ufcg.pracadasprofissoes.escola.dtos;

import javax.validation.constraints.NotEmpty;

import br.edu.ufcg.pracadasprofissoes.diretor.Diretor;
import br.edu.ufcg.pracadasprofissoes.escola.Endereco;
import br.edu.ufcg.pracadasprofissoes.usuarios.Usuario;

public class EscolaOutput {

	@NotEmpty
	private Long id;
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String sigla;

	@NotEmpty
	private String cnpj;
	
	@NotEmpty
	private String telefone;
	
	@NotEmpty
	private Diretor diretor;
	
	@NotEmpty
	private Endereco endereco;

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

	public Diretor getDiretor() {
		return diretor;
	}

	public void setDiretor(Diretor diretor) {
		this.diretor = diretor;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	
	
}
