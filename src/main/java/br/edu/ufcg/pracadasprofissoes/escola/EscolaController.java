package br.edu.ufcg.pracadasprofissoes.escola;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
}
