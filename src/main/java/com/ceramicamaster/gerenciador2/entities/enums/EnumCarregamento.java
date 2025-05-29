package com.ceramicamaster.gerenciador2.entities.enums;

public enum EnumCarregamento {

	Pezinho(1),
	Rodrigo(2);
	
	
	private int code;
	
	private EnumCarregamento(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	public static EnumCarregamento valueOff(int code) {
		for (EnumCarregamento value: EnumCarregamento.values()) {
			if(value.getCode()==code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Responsavel invalido");
	}
}
