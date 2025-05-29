package com.ceramicamaster.gerenciador2.entities.enums;

public enum EnumLenha {

	Pezinho(1),
	Marcio(3),
	Vilson(4);
private int code;
	
	private EnumLenha(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static EnumLenha valueOff(int code) {
		for (EnumLenha value: EnumLenha.values()) {
			if(value.getCode()==code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Responsavel invalido");
	}
	
}
