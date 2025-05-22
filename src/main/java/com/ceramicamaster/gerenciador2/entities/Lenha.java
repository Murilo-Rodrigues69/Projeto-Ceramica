package com.ceramicamaster.gerenciador2.entities;

import java.io.Serializable;
import java.util.Objects;

import com.ceramicamaster.gerenciador2.entities.enums.EnumLenha;




public class Lenha implements Serializable{
	private static final long serialVersionUID = 1L;

	
	private Long id;
	private String Fornecedor;
	private String Tipo;
	private String lenha;
	private Double medidaLenha;
	private Double total;
	private EnumLenha responsavel;
	
	public Lenha() {
		
	}

	public Lenha(Long id,String fornecedor, String tipo, String lenha, Double medidaLenha, Double total, EnumLenha responsavel) {
		super();
		this.id =id;
		this.Fornecedor = fornecedor;
		this.Tipo = tipo;
		this.lenha = lenha;
		this.medidaLenha = medidaLenha;
		this.total = total;
		this.responsavel = responsavel;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFornecedor() {
		return Fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		Fornecedor = fornecedor;
	}

	public String getTipo() {
		return Tipo;
	}

	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	public String getLenha() {
		return lenha;
	}

	public void setLenha(String lenha) {
		this.lenha = lenha;
	}

	public Double getMedidaLenha() {
		return medidaLenha;
	}

	public void setMedidaLenha(Double medidaLenha) {
		this.medidaLenha = medidaLenha;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}
	

	public EnumLenha getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(EnumLenha responsavel) {
		this.responsavel = responsavel;
	}

	

	@Override
	public String toString() {
		return "Lenha [id=" + id + ", Fornecedor=" + Fornecedor + ", Tipo=" + Tipo + ", lenha=" + lenha
				+ ", medidaLenha=" + medidaLenha + ", total=" + total + ", responsavel=" + responsavel + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Fornecedor, Tipo, id, lenha, medidaLenha, total);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lenha other = (Lenha) obj;
		return Objects.equals(Fornecedor, other.Fornecedor) && Objects.equals(Tipo, other.Tipo)
				&& Objects.equals(id, other.id) && Objects.equals(lenha, other.lenha)
				&& Objects.equals(medidaLenha, other.medidaLenha) && Objects.equals(total, other.total);
	}
	
}
