package com.senior.crudHotelBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="checkin")
public class Checkin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_checkin")
	private Long id;
	
	@Column(name="data_entrada")
	private String dataEntrada;
	
	@Column(name="data_saida")
	private String dataSaida;
	
	@Column(name="adicional_veiculo")
	private boolean adicionalVeiculo;
	
	@OneToOne(targetEntity=Hospede.class)
	Hospede hospede = new Hospede();
	
	@JsonProperty("id_person")
	@JoinColumn(name="id_person")
	private Long id_person = hospede.getId();
	
	@JsonProperty("nome")
	@JoinColumn(name="nome")
	private String nome = hospede.getNome();
	
	@JsonProperty("documento")
	@JoinColumn(name="documento")
	private String documento = hospede.getDocumento();
	
	@JsonProperty("telefone")
	@JoinColumn(name="telefone")
	private String telefone = hospede.getTelefone();
	
	public Checkin() {
		
	}
	
	public Checkin(Long id, String dataEntrada, String dataSaida, boolean adicionalVeiculo) {
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.adicionalVeiculo = adicionalVeiculo;
	}
	
	public Long getId() {
		return id;
	}

	public String getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(String dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(String dataSaida) {
		this.dataSaida = dataSaida;
	}

	public boolean isAdicionalVeiculo() {
		return adicionalVeiculo;
	}

	public void setAdicionalVeiculo(boolean adicionalVeiculo) {
		this.adicionalVeiculo = adicionalVeiculo;
	}

	

	
}