package com.ceramicamaster.gerenciador2.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;




public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	
	private Long id;
	private String nome;
	private Date dataDeEntrada;
	private String pix;
	private String whatsapp;
	private double salario;
	
	public Funcionario() {
		
	}

	public Funcionario(Long id, String nome, Date dataDeEntrada, String pix, String whatsapp, double salario) {
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

	public Date getDataDeEntrada() {
		return dataDeEntrada;
	}

	public void setDataDeEntrada(Date dataDeEntrada) {
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
