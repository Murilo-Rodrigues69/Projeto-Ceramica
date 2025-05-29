package com.ceramicamaster.gerenciador2.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;




@Entity
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataDeEntrada;
	
	private String pix;
	private String whatsapp;
	private double salario;
	
	@JsonIgnore
	@OneToOne(mappedBy = "motorista")
	private Carregamento motorista;
	
	public Funcionario() {
		
	}

	public Funcionario(Long id, String nome, LocalDate dataDeEntrada, String pix, String whatsapp, double salario) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataDeEntrada = dataDeEntrada;
		this.pix = pix;
		this.whatsapp = whatsapp;
		this.salario = salario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataDeEntrada() {
		return dataDeEntrada;
	}

	public void setDataDeEntrada(LocalDate dataDeEntrada) {
		this.dataDeEntrada = dataDeEntrada;
	}

	public String getPix() {
		return pix;
	}

	public void setPix(String pix) {
		this.pix = pix;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}
	public Carregamento getMotorista() {
		return motorista;
	}

	public void setMotorista(Carregamento motorista) {
		this.motorista = motorista;
	}

	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", dataDeEntrada=" + dataDeEntrada + ", pix=" + pix
				+ ", whatsapp=" + whatsapp + ", salario=" + salario + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataDeEntrada, id, nome, pix, salario, whatsapp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		return Objects.equals(dataDeEntrada, other.dataDeEntrada) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(pix, other.pix)
				&& Double.doubleToLongBits(salario) == Double.doubleToLongBits(other.salario)
				&& Objects.equals(whatsapp, other.whatsapp);
	}

	

	
}
