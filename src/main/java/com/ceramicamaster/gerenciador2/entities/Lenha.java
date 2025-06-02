package com.ceramicamaster.gerenciador2.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.ceramicamaster.gerenciador2.entities.enums.EnumLenha;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Lenha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String fornecedor;
	private String Tipo;
	private String lenha;
	private Double medidaLenha;
	private Double total;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate data;

	@Enumerated(EnumType.STRING)
	private EnumLenha responsavel;

	public Lenha() {

	}

	public Lenha(Long id, String fornecedor, String tipo, String lenha, Double medidaLenha, Double total,
			EnumLenha responsavel, LocalDate data) {
		super();
		this.id = id;
		this.fornecedor = fornecedor;
		this.Tipo = tipo;
		this.lenha = lenha;
		this.medidaLenha = medidaLenha;
		this.total = total;
		setResponsavel(responsavel);
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getfornecedor() {
		return fornecedor;
	}

	public void setfornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public EnumLenha getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(EnumLenha responsavel) {
		this.responsavel = responsavel;
	}

	@Override
	public String toString() {
		return "Lenha [id=" + id + ", fornecedor=" + fornecedor + ", Tipo=" + Tipo + ", lenha=" + lenha
				+ ", medidaLenha=" + medidaLenha + ", total=" + total + ", data=" + data + ", responsavel="
				+ responsavel + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(fornecedor, Tipo, data, id, lenha, medidaLenha, responsavel, total);
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
		return Objects.equals(fornecedor, other.fornecedor) && Objects.equals(Tipo, other.Tipo)
				&& Objects.equals(data, other.data) && Objects.equals(id, other.id)
				&& Objects.equals(lenha, other.lenha) && Objects.equals(medidaLenha, other.medidaLenha)
				&& responsavel == other.responsavel && Objects.equals(total, other.total);
	}

}
