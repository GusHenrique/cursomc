package com.gustavo.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gustavo.cursomc.domain.Categoria;

/*
 The classes in this directory are Controllers.
 They are responsible to make an interaction between Models(Entities)
 and Views(Resources).
 */

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResources {
	
	//Method HTTP
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		
		//Instantiation of two Category objects
		Categoria cat1 = new Categoria(1,"Informática");
		Categoria cat2 = new Categoria(2,"Escritório");
		
		//Creation of an ArrayList to store the two objects
		List<Categoria> lista = new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		
		//Return the ArrayList created
		return lista;
	}
}
