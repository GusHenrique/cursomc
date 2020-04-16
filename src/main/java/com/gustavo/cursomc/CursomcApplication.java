package com.gustavo.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gustavo.cursomc.domain.Categoria;
import com.gustavo.cursomc.domain.Produto;
import com.gustavo.cursomc.repositories.CategoriaRepository;
import com.gustavo.cursomc.repositories.ProdutoRepository;

//ComandLineRunner implementa método necessário para instanciação e associação de Objetos

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	//Instanciação das interfaces Repositories
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	//Método herdade da interface CommandLineRunner para Associações de Tabelas
	@Override
	public void run(String... args) throws Exception {
		
		//Criação de Categorias
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		//Criação de Produtos
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		//Adicionando Produtos às suas respectivas Categorias (Associação)
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		//Adicionando Categoris aos seus respectivos Produtos (Associação)
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		//Subindo objetos para Banco de Dados através de suas Repositories
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
	}

}
