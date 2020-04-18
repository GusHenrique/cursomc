package com.gustavo.cursomc.domain.enums;

public enum TipoCliente {
	
	//Tipos presentes no Enum
	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	//Atributos usados pelos tipos do Enum
	private int cod;
	private String descricao;
	
	//Method para retornar um tipo através de seu código
	public static TipoCliente toEnum(Integer cod) {
		
		//Segurança. Caso código null, retorno também null 
		if (cod == null) {
			return null;
		}
		
		/*Percorre os tipos do Enum, comparando seu atributo "código" com o passado pelo método.
		 Caso idênticos os atributos, retorna o tipo correspondente.*/ 
		for(TipoCliente x : TipoCliente.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		//Caso nenhum correspondente, lança exceção
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
	
	//Constructor Using Fields
	private TipoCliente(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	//Getters & Setters 
	public int getCod() {
		return cod;
	}
	public String getDescricao() {
		return descricao;
	}
	
	
	
	
}
