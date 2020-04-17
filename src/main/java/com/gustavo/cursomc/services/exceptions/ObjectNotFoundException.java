package com.gustavo.cursomc.services.exceptions;

//Erro que será instanciado pelas services em caso de objeto não encontrado.

public class ObjectNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	//Exibe mensagem
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	// Mensagem e Causa de erro serão exibidas
	public ObjectNotFoundException(String msg, Throwable cause) {
		
	}

}
