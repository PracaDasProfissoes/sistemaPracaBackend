package br.edu.ufcg.pracadasprofissoes.locais.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufcg.pracadasprofissoes.escola.EscolaRepository;
import br.edu.ufcg.pracadasprofissoes.locais.models.Estado;
import br.edu.ufcg.pracadasprofissoes.locais.repositories.EstadoRepository;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	public List<Estado> getEstados() {
		return estadoRepository.findAll();
	}
	
	public Estado getEstado(Long id) {
		return estadoRepository.findById(id).get();
	}
}
