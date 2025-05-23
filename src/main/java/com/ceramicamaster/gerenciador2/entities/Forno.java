package com.ceramicamaster.gerenciador2.entities;

import java.io.Serializable;
import java.time.Instant;

import java.util.Objects;

public class Forno implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Integer numeroDoForno;
	private Instant dataDeEntrada;
	private Instant dataDeSaida;
	private String equipeForno;

	public Forno() {

	}

	public Forno(Long id, Integer numeroDoForno, Instant dataDeEntrada, Instant dataDeSaida, String equipeForno) {
		super();
		this.id = id;
		this.numeroDoForno = numeroDoForno;
		this.dataDeEntrada = dataDeEntrada;
		this.dataDeSaida = dataDeSaida;
		this.equipeForno = equipeForno;
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

	public Instant getDataDeEntrada() {
		return dataDeEntrada;
	}

	public void setDataDeEntrada(Instant dataDeEntrada) {
		this.dataDeEntrada = dataDeEntrada;
	}

	public Instant getDataDeSaida() {
		return dataDeSaida;
	}

	public void setDataDeSaida(Instant dataDeSaida) {
		this.dataDeSaida = dataDeSaida;
	}

	public String getEquipeForno() {
		return equipeForno;
	}

	public void setEquipeForno(String equipeForno) {
		this.equipeForno = equipeForno;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataDeEntrada, dataDeSaida, equipeForno, id, numeroDoForno);
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
				&& Objects.equals(equipeForno, other.equipeForno) && Objects.equals(id, other.id)
				&& Objects.equals(numeroDoForno, other.numeroDoForno);
	}

	@Override
	public String toString() {
		return "Forno [id=" + id + ", numeroDoForno=" + numeroDoForno + ", dataDeEntrada=" + dataDeEntrada
				+ ", dataDeSaida=" + dataDeSaida + ", equipeForno=" + equipeForno + "]";
	}

}
