package com.ceramicamaster.gerenciador2.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;


public class CarregamentoDTO {
	private Long id;
	private Long motoristaId;
    private String medidaDoTijolo;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate data;

    private Integer quantidade;
    private Integer responsavel;

    public CarregamentoDTO() {}

    public Long getMotoristaId() {
        return motoristaId;
    }

    public void setMotoristaId(Long motoristaId) {
        this.motoristaId = motoristaId;
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

	public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Integer responsavel) {
        this.responsavel = responsavel;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
