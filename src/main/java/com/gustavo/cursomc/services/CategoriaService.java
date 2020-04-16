package com.gustavo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gustavo.cursomc.domain.Categoria;
import com.gustavo.cursomc.repositories.CategoriaRepository;

/*
 Services requisitarão aos repositories ações ligadas ao 
 Banco de Dados, como no exemplo da função abaixo "buscar"
 */


@Service
public class CategoriaService {

	//Preenche repo automaticamente, evitando possíveis erros
	@Autowired
	private CategoriaRepository repo;
	
	//Busca dados no Banco, por meio do Repository
	public Categoria buscar(Integer id){
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElse(null);
	}
}
