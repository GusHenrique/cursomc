package com.gustavo.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gustavo.cursomc.domain.Categoria;
import com.gustavo.cursomc.domain.Cidade;
import com.gustavo.cursomc.domain.Cliente;
import com.gustavo.cursomc.domain.Endereco;
import com.gustavo.cursomc.domain.Estado;
import com.gustavo.cursomc.domain.Produto;
import com.gustavo.cursomc.domain.enums.TipoCliente;
import com.gustavo.cursomc.repositories.CategoriaRepository;
import com.gustavo.cursomc.repositories.CidadeRepository;
import com.gustavo.cursomc.repositories.ClienteRepository;
import com.gustavo.cursomc.repositories.EnderecoRepository;
import com.gustavo.cursomc.repositories.EstadoRepository;
import com.gustavo.cursomc.repositories.ProdutoRepository;

//ComandLineRunner implementa método necessário para instanciação e associação de Objetos

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner{

	//Instanciação das interfaces Repositories
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}
	
	//Método herdado da interface CommandLineRunner para Associações de Tabelas
	@Override
	public void run(String... args) throws Exception {
		
		//Criação de Categorias
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		//Criação de Produtos
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		//Criação de Estados
		Estado est1 = new Estado(null, "Minas-Gerais");
		Estado est2 = new Estado(null, "São-Paulo");
		
		//Criação de Cidades e Associação com seus Estados
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		//Criação de Clientes 
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "47462483890", TipoCliente.PESSOAFISICA);
		
		//Criação de Endereços
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 03", "Jardim", "23094502945", cli1, c1);
		Endereco e2 = new Endereco(null, "Av.Mattos", "105", "Sala 800", "Centro", "kajdaksdfn", cli1, c2);
		
		//Adicionando Produtos às suas respectivas Categorias (Associação)
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		//Adicionando Categorias aos seus respectivos Produtos (Associação)
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		//Adicionando Cidades aos seus respectivos Estados (Associação)
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		//Adicionando Telefones aos Clientes 
		cli1.getTelefones().addAll(Arrays.asList("00000", "111111"));
		
		//Adicionando Endereços aos Clientes
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		//Subindo objetos para Banco de Dados através de suas Repositories
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}

}
