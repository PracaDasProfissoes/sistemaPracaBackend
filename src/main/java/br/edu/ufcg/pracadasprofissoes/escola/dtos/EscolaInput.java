package br.edu.ufcg.pracadasprofissoes.escola.dtos;

import javax.validation.constraints.NotEmpty;

import br.edu.ufcg.pracadasprofissoes.diretor.Diretor;
import br.edu.ufcg.pracadasprofissoes.escola.Endereco;
import br.edu.ufcg.pracadasprofissoes.usuarios.Usuario;

public class EscolaInput {
	
	@NotEmpty
	private String nome;
	
	@NotEmpty
	private String sigla;

	@NotEmpty
	private String cnpj;
	
	@NotEmpty
	private String telefone;
	
	private Diretor diretor;
	
	private Endereco endereco;
	
	private Usuario usuario;
	
	public EscolaInput() {
	}
	

	public EscolaInput( String nome, String sigla, String cnpj, String telefone,
			 Diretor diretor, Endereco endereco, Usuario usuario) {
		super();
		this.nome = nome;
		this.sigla = sigla;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.diretor = diretor;
		this.endereco = endereco;
		this.usuario = usuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
