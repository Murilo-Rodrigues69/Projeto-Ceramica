package com.ceramicamaster.gerenciador2.entities;

import java.io.Serializable;

import java.util.Date;
import java.util.Objects;



public class Forno implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Long id;
	private Integer numeroDoForno;
	private Date dataDeEntrada;
	private Date dataDeSaida;
	private String equipeDeForno;
	
	public Forno() {
		
	}

	public Forno(Long id,Integer numeroDoForno, Date dataDeEntrada, Date dataDeSaida, String equipeDeForno) {
		super();
		this.id = id;
		this.numeroDoForno = numeroDoForno;
		this.dataDeEntrada = dataDeEntrada;
		this.dataDeSaida = dataDeSaida;
		this.equipeDeForno = equipeDeForno;
	}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumeroDoForno() {
		return numeroDoForno;
	}

	public void setNumeroDoForno(Integer numeroDoForno) {
		this.numeroDoForno = numeroDoForno;
	}

	public Date getDataDeEntrada() {
		return dataDeEntrada;
	}

	public void setDataDeEntrada(Date dataDeEntrada) {
		this.dataDeEntrada = dataDeEntrada;
	}

	public Date getDataDeSaida() {
		return dataDeSaida;
	}

	public void setDataDeSaida(Date dataDeSaida) {
		this.dataDeSaida = dataDeSaida;
	}

	public String getEquipeDeForno() {
		return equipeDeForno;
	}

	public void setEquipeDeForno(String equipeDeForno) {
		this.equipeDeForno = equipeDeForno;
	}

	@Override
	public String toString() {
		return "Forno [numeroDoForno=" + numeroDoForno + ", dataDeEntrada=" + dataDeEntrada + ", dataDeSaida="
				+ dataDeSaida + ", equipeDeForno=" + equipeDeForno + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataDeEntrada, dataDeSaida, equipeDeForno, id, numeroDoForno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Forno other = (Forno) obj;
		return Objects.equals(dataDeEntrada, other.dataDeEntrada) && Objects.equals(dataDeSaida, other.dataDeSaida)
				&& Objects.equals(equipeDeForno, other.equipeDeForno) && Objects.equals(id, other.id)
				&& Objects.equals(numeroDoForno, other.numeroDoForno);
	}
	
}
