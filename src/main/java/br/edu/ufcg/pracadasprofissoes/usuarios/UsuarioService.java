package br.edu.ufcg.pracadasprofissoes.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public Usuario criarUsuario(Usuario usuario) {
		return this.criarUsuario(usuario.getEmail(), usuario.getSenha());
	}
	
	public Usuario criarUsuario(String email, String senha) {
		Usuario newUsuario = new Usuario(email, passwordEncoder.encode(senha));
		usuarioRepository.save(newUsuario);
		return newUsuario;
	}
	
	public Usuario buscarUsuario(Long idUsuario) {
		Usuario usuario = usuarioRepository.findById(idUsuario).get();
		return usuario;
	}
	
	public Usuario atualizarUsuario(Long id, Usuario usuario) {
		Usuario newUsuario = usuarioRepository.findById(id).get();
		newUsuario.setEmail(usuario.getEmail());
		newUsuario.setSenha(usuario.getSenha());
		usuarioRepository.save(newUsuario);
		return newUsuario;
	}
}