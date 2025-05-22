package com.ceramicamaster.gerenciador2.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.ceramicamaster.gerenciador2.entities.enums.EnumCarregamento;


public class Carregamento implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;
	private String motorista;
	private Integer quantidade;
	private String medidaDoTijolo;
	private Date data;
	private EnumCarregamento responsavel;
	
	public Carregamento() {
		
	}

	public Carregamento(Long id,String motorista, Integer quantidade, String medidaDoTijolo, Date data, EnumCarregamento responsavel) {
		super();
		this.id = id;
		this.motorista = motorista;
		this.quantidade = quantidade;
		this.medidaDoTijolo = medidaDoTijolo;
		this.data = data;
		this.responsavel = responsavel;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMotorista() {
		return motorista;
	}

	public void setMotorista(String motorista) {
		this.motorista = motorista;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String getMedidaDoTijolo() {
		return medidaDoTijolo;
	}

	public void setMedidaDoTijolo(String medidaDoTijolo) {
		this.medidaDoTijolo = medidaDoTijolo;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public EnumCarregamento getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(EnumCarregamento responsavel) {
		this.responsavel = responsavel;
	}

	@Override
	public String toString() {
		return "Carregamento [motorista=" + motorista + ", quantidade=" + quantidade + ", medidaDoTijolo="
				+ medidaDoTijolo + ", data=" + data + ", responsavel=" + responsavel + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(data, id, medidaDoTijolo, motorista, quantidade, responsavel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carregamento other = (Carregamento) obj;
		return Objects.equals(data, other.data) && Objects.equals(id, other.id)
				&& Objects.equals(medidaDoTijolo, other.medidaDoTijolo) && Objects.equals(motorista, other.motorista)
				&& Objects.equals(quantidade, other.quantidade) && responsavel == other.responsavel;
	}
	
	
}
