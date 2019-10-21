package br.edu.ufcg.pracadasprofissoes.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario criarUsuario(String email, String senha) {
		Usuario newUsuario = new Usuario(email, senha);
		usuarioRepository.save(newUsuario);
		return newUsuario;
	}
	
	public Usuario buscarUsuario(Long idUsuario) {
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		return usuario;
	}
}