package com.ceramicamaster.gerenciador2.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.ceramicamaster.gerenciador2.entities.enums.EnumCarregamento;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Carregamento implements Serializable{
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "motorista_id")
	private Funcionario motorista;
	
	private Integer quantidade;
	private String medidaDoTijolo;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate data;
	
	@Enumerated(EnumType.STRING)
	private EnumCarregamento responsavel;
	
	public Carregamento() {
		
	}

	public Carregamento(Long id,Integer quantidade, String medidaDoTijolo, LocalDate data, EnumCarregamento responsavel, Funcionario motorista) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.medidaDoTijolo = medidaDoTijolo;
		this.data = data;
		setResponsavel(responsavel);
		this.motorista = motorista;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Funcionario getMotorista() {
		return motorista;
	}

	public void setMotorista(Funcionario motorista) {
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	

	public EnumCarregamento getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(EnumCarregamento responsavel) {
		this.responsavel = responsavel;
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

	@Override
	public String toString() {
		return "Carregamento [id=" + id + ", motorista=" + motorista + ", quantidade=" + quantidade
				+ ", medidaDoTijolo=" + medidaDoTijolo + ", data=" + data + ", responsavel=" + responsavel + "]";
	}

	

	
}
