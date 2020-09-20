package br.edu.ufcg.pracadasprofissoes.locais.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.pracadasprofissoes.locais.models.Cidade;
import br.edu.ufcg.pracadasprofissoes.locais.models.Estado;
import br.edu.ufcg.pracadasprofissoes.locais.services.CidadeService;
import br.edu.ufcg.pracadasprofissoes.locais.services.EstadoService;
import br.edu.ufcg.pracadasprofissoes.util.RestConstants;

@RestController
@RequestMapping(RestConstants.CIDADE_URI)
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	@Autowired
	private EstadoService estadoService;
	
	@GetMapping({"/{id}"})
	public List<Cidade> getCidades(@PathVariable("id") Long idEstado){
		return this.cidadeService.getCidadesByEstado(idEstado);
	}
	
}
