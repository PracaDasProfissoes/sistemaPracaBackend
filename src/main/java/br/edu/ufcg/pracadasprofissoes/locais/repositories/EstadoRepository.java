package br.edu.ufcg.pracadasprofissoes.locais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufcg.pracadasprofissoes.locais.models.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{

}
