package br.edu.ufcg.pracadasprofissoes.escola;

import java.util.HashMap;
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

import br.edu.ufcg.pracadasprofissoes.escola.dtos.*;
import br.edu.ufcg.pracadasprofissoes.util.RestConstants;

@RestController
@RequestMapping(RestConstants.ESCOLA_URI)
public class EscolaController {
	
	@Autowired
	private EscolaService escolaService;
	
	@Autowired
	private EscolaIO escolaIO;
	
	@PostMapping("/")
	public ResponseEntity<?> cadastrarEscola(@Valid @RequestBody EscolaInput escolaInput, BindingResult result){
		if(result.hasErrors()) {
			return ResponseEntity.badRequest().body("Dados Invalidos");
		}
		
		Escola escola = escolaIO.mapTo(escolaInput);
		Escola newEscola = escolaService.criarEscola(escola);
		EscolaOutput escolaOutput = escolaIO.mapTo(newEscola);
		return new ResponseEntity<>(escolaOutput, HttpStatus.CREATED);
	}
	
	@GetMapping("/{usuario_id}")
	public ResponseEntity<?> getEscola(@PathVariable("usuario_id") long idUsuario){
		Escola escola = escolaService.buscaEscolaPorUsuario(idUsuario);
//		Map<String, String> escolaResponse = new HashMap<>();
//		escolaResponse.put("nome", escola.getNome());
		return ResponseEntity.ok(escola);
		
	}
}
