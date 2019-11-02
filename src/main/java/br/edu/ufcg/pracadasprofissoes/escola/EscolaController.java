package br.edu.ufcg.pracadasprofissoes.escola;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufcg.pracadasprofissoes.util.RestConstants;

@RestController
@RequestMapping(RestConstants.ESCOLA_URI)
public class EscolaController {
	
	@Autowired
	private EscolaService escolaService;
	
	@PostMapping({"/", ""})
	public ResponseEntity<?> cadastrarEscola(@Valid @RequestBody Map<String, String> escola, BindingResult result){
		if(result.hasErrors()) {
			return ResponseEntity.badRequest().body("Dados Invalidos");
		}
		Escola newEscola = escolaService.criarEscola(escola);
		HttpHeaders responseHeaders = new HttpHeaders();
		return new ResponseEntity<>(newEscola, responseHeaders, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUsuario(@PathVariable("id") long idEscola){
		Escola escola = escolaService.buscarEscola(idEscola);
		return ResponseEntity.ok().body(escola);
	}
}
