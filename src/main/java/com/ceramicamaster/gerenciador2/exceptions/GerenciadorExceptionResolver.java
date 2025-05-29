package com.ceramicamaster.gerenciador2.exceptions;

public class GerenciadorExceptionResolver extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public GerenciadorExceptionResolver(String msg) {
		super(msg);
	}
	
}
