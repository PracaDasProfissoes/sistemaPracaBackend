package br.edu.ufcg.pracadasprofissoes.locais.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.pracadasprofissoes.locais.models.Estado;
import br.edu.ufcg.pracadasprofissoes.locais.services.EstadoService;
import br.edu.ufcg.pracadasprofissoes.util.RestConstants;

@RestController
@RequestMapping(RestConstants.ESTADO_URI)
public class EstadoController {

	@Autowired
	private EstadoService estadoService;
	

	
	@GetMapping({"/", ""})
	public List<Estado> getEstados(){
		return estadoService.getEstados();
	}
}
