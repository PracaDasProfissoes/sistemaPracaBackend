package br.edu.ufcg.pracadasprofissoes.locais.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.pracadasprofissoes.locais.models.Cidade;
import br.edu.ufcg.pracadasprofissoes.locais.models.Estado;
import br.edu.ufcg.pracadasprofissoes.locais.repositories.CidadeRepository;

@Service
public class CidadeService {
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
	public List<Cidade> getCidadesByEstado(Long Estado) {
		return this.cidadeRepository.findByEstadoCod(Estado);
	}
	
	
	
}
