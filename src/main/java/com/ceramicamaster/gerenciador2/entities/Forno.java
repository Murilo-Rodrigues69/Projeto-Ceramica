package com.ceramicamaster.gerenciador2.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Forno implements Serializable {
	private static final long serialVersionUID = 1L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer numeroDoForno;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataDeEntrada;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate dataDeSaida;
	
	private String equipeForno;

	public Forno() {

	}

	public Forno(Long id, Integer numeroDoForno, LocalDate dataDeEntrada, LocalDate dataDeSaida, String equipeForno) {
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

	public LocalDate getDataDeEntrada() {
		return dataDeEntrada;
	}

	public void setDataDeEntrada(LocalDate dataDeEntrada) {
		this.dataDeEntrada = dataDeEntrada;
	}

	public LocalDate getDataDeSaida() {
		return dataDeSaida;
	}

	public void setDataDeSaida(LocalDate dataDeSaida) {
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
