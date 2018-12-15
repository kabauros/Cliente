package com.teste.cliente.exception;

public class ClienteInputException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ClienteInputException(String message) {
		super(message);
	}
}
