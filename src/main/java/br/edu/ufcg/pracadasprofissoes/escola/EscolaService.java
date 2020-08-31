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

	public Escola criarEscola(Escola escola) {
		Usuario usuario = usuarioService.criarUsuario(escola.getUsuario());
		Endereco endereco = enderecoRepository.save(escola.getEndereco());
		Diretor diretor = diretorRepository.save(escola.getDiretor());
		Escola newEscola = new Escola();
		newEscola.setNome(escola.getNome());
		newEscola.setSigla(escola.getSigla());
		newEscola.setCnpj(escola.getCnpj());
		newEscola.setTelefone(escola.getTelefone());
		newEscola.setDiretor(diretor);
		newEscola.setEndereco(endereco);
		newEscola.setUsuario(usuario);
		escolaRepository.save(newEscola);
		return newEscola;
	}
	
	public Escola buscarEscola(Long idEscola) {
		Escola escola = escolaRepository.findById(idEscola).get();
		return escola;
	}
	
	public Escola buscaEscolaPorUsuario(Long idUsuario) {
		Escola escola = escolaRepository.findByUsuarioId(idUsuario);
		return escola;
	}
}