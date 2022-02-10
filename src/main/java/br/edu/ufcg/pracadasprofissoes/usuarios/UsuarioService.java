package br.edu.ufcg.pracadasprofissoes.usuarios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import br.edu.ufcg.pracadasprofissoes.security.JWTUtil;
import br.edu.ufcg.pracadasprofissoes.util.CryptUtil;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private CryptUtil cryptUtil;
	
	@Autowired
	private JWTUtil jwt;
	
	public Usuario login(String email, String credentials) {
		Usuario usuario = usuarioRepository.findByEmail(email);
		if (usuario != null && cryptUtil.matches(credentials, usuario.getSenha())) {
			usuario.setSenha(null);
			return usuario;
		}
		return null;
	}
	
	public String generateToken(Usuario usuario) throws JsonProcessingException {

		return jwt.generateToken(usuario.getPerfisString());
	}
	
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