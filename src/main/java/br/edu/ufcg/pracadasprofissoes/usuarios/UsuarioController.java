package br.edu.ufcg.pracadasprofissoes.usuarios;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.pracadasprofissoes.usuarios.dtos.UsuarioIO;
import br.edu.ufcg.pracadasprofissoes.usuarios.dtos.UsuarioInput;
import br.edu.ufcg.pracadasprofissoes.usuarios.dtos.UsuarioOutput;
import br.edu.ufcg.pracadasprofissoes.util.RestConstants;

@RestController
@RequestMapping(RestConstants.USUARIO_URI)
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioIO usuarioIO;
	
	@PostMapping({"/", ""})
	public ResponseEntity<?> criarUsuario(@Valid @RequestBody UsuarioInput usuarioInput, BindingResult result){
		if(result.hasErrors()) {
			return ResponseEntity.badRequest().body("Dados Invalidos");
		}
		Usuario usuario = usuarioIO.mapTo(usuarioInput);
		Usuario usuarioCadastrado = usuarioService.criarUsuario(usuario);
		UsuarioOutput usuarioOutput = usuarioIO.mapTo(usuarioCadastrado);
		return new ResponseEntity<>(usuarioOutput, HttpStatus.CREATED);
	}

}
