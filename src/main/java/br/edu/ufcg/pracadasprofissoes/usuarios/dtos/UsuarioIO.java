package br.edu.ufcg.pracadasprofissoes.usuarios.dtos;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

import br.edu.ufcg.pracadasprofissoes.enums.Perfil;
import br.edu.ufcg.pracadasprofissoes.usuarios.Usuario;

@Component("usuarioIO")
public class UsuarioIO {
	
	private ModelMapper modelmapper;
	
	final Converter<UsuarioInput, Usuario> usuarioInputConverter = new Converter<UsuarioInput, Usuario>() {
		
		@Override
		public Usuario convert(MappingContext<UsuarioInput, Usuario> context) {
			UsuarioInput usuarioInput = context.getSource();
			Usuario usuario = new Usuario();
			usuario.setEmail(usuarioInput.getEmail());
			usuario.setSenha(usuarioInput.getSenha());
			
			return usuario;
		}
		
	};
	
	final Converter<Usuario, UsuarioOutput> usuarioOutputConverter = new Converter<Usuario, UsuarioOutput>() {
		
		@Override
		public UsuarioOutput convert(MappingContext<Usuario, UsuarioOutput> context) {
			Usuario usuario = context.getSource();
			UsuarioOutput usuarioOutput = new UsuarioOutput();
			usuarioOutput.setId(usuario.getId());
			usuarioOutput.setEmail(usuario.getEmail());
			for (Perfil perfil : usuario.getPerfis()) {
				usuarioOutput.addPerfil(perfil);
			}
			return usuarioOutput;
			
		}
	};
	
	
	public UsuarioIO() {
		this.modelmapper = new ModelMapper();
		this.modelmapper.addConverter(usuarioInputConverter);
		this.modelmapper.addConverter(usuarioOutputConverter);
	}
	
	public Usuario mapTo(UsuarioInput usuarioInput) {
		return this.modelmapper.map(usuarioInput, Usuario.class);
	}
	
	public UsuarioOutput mapTo(Usuario usuario) {
		return this.modelmapper.map(usuario, UsuarioOutput.class);
	}

}
