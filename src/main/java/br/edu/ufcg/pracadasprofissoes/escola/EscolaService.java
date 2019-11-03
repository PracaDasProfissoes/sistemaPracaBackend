package br.edu.ufcg.pracadasprofissoes.escola;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.pracadasprofissoes.usuarios.Usuario;
import br.edu.ufcg.pracadasprofissoes.usuarios.UsuarioService;

@Service
public class EscolaService {
	
	@Autowired
	private EscolaRepository escolaRepository;
	
	@Autowired
	private UsuarioService usuarioService;

	public Escola criarEscola(Map<String, String> escola) {
		Usuario usuario = usuarioService.criarUsuario(escola.get("email"), escola.get("senha"));
		Endereco endereco = new Endereco(escola.get("rua"), escola.get("numero"), escola.get("bairro"), escola.get("cidade"), escola.get("estado"), escola.get("cep"));
		Escola newEscola = new Escola(escola.get("nome"), escola.get("sigla"), escola.get("cnpj"), escola.get("telefone"), escola.get("diretor"), usuario, endereco);
		escolaRepository.save(newEscola);
		return newEscola;
	}
	
	public Escola buscarEscola(Long idEscola) {
		Escola escola = escolaRepository.findById(idEscola).get();
		return escola;
	}
}