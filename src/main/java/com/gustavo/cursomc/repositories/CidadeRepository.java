package com.gustavo.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gustavo.cursomc.domain.Cidade;

/*
 Repositories são interfaces responsáveis por realizar operações de acesso a dados
 em determinadas tabelas do Banco de Dados 
 */


/*
 Essas interfaces herdam a classe JpaRepository, lhe passando como atributos
 a classe de objetos e o tipo de seu identificador
 */

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Integer>{

}
