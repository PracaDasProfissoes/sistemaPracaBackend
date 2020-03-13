package br.edu.ufcg.pracadasprofissoes.escola;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.pracadasprofissoes.diretor.Diretor;
import br.edu.ufcg.pracadasprofissoes.diretor.DiretorRepository;
import br.edu.ufcg.pracadasprofissoes.usuarios.Usuario;
import br.edu.ufcg.pracadasprofissoes.usuarios.UsuarioService;

@Service
public class EscolaService {
	
	@Autowired
	private EscolaRepository escolaRepository;
	
	@Autowired
	private DiretorRepository diretorRepository;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EnderecoRepository enderecoRepository;

	public Escola criarEscola(Map<String, String> escola) {
		Usuario usuario = usuarioService.criarUsuario(escola.get("email"), escola.get("senha"));
		Endereco endereco = new Endereco(escola.get("rua"), escola.get("numero"), escola.get("bairro"), escola.get("cidade"), escola.get("estado"), escola.get("cep"));
		enderecoRepository.save(endereco);
		Diretor diretor = new Diretor(escola.get("diretor"), escola.get("cpf"));
		diretorRepository.save(diretor);
		Escola newEscola = new Escola(escola.get("nome"), escola.get("sigla"), escola.get("cnpj"), escola.get("telefone"), diretor, usuario, endereco);
		escolaRepository.save(newEscola);
		return newEscola;
	}
	
	public Escola buscarEscola(Long idEscola) {
		Escola escola = escolaRepository.findById(idEscola).get();
		return escola;
	}
}