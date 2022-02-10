package br.edu.ufcg.pracadasprofissoes.locais.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.edu.ufcg.pracadasprofissoes.locais.models.Cidade;
import br.edu.ufcg.pracadasprofissoes.locais.models.Estado;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long>{
	
	List<Cidade> findByEstadoCod(long estado);

}
