package br.edu.ufcg.pracadasprofissoes.usuarios;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Payload {
	
	private String email;
	private List<String> perfil;
}
