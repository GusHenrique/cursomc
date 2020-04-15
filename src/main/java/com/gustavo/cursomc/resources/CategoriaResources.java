package com.gustavo.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.cursomc.domain.Categoria;
import com.gustavo.cursomc.services.CategoriaService;

/*
 The classes in this directory are Controllers.
 They are responsible to make an interaction between Models(Entities)
 and Views(Resources).
 */

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResources {
	
	//@Autowired instância automaticamente o objeto criado
	@Autowired
	private CategoriaService service;
	
	
	//Method HTTP
	@RequestMapping(value="{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
	//@PathVariable passa id de @RequestMapping como atributo para função "find"
	//o tipo ResponseEntity encapsula diversas informações HTTP para serviços REST	
		
		//Através da classe services, encontrar objeto pelo seu id
		Categoria obj = service.buscar(id);
		
		//Retornando ResponseEntity
		return ResponseEntity.ok().body(obj);

	}
}
