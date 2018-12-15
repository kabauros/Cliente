package com.teste.cliente.vo;

import java.math.BigDecimal;

public class Clima {

	public String id;

	private String clienteId;

	private String dataInclusao;

	private BigDecimal temperaturaMinima;

	private BigDecimal temperaturaMaxima;

	private String ipRequest;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClienteId() {
		return clienteId;
	}

	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	public String getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(String dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public BigDecimal getTemperaturaMinima() {
		return temperaturaMinima;
	}

	public void setTemperaturaMinima(BigDecimal temperaturaMinima) {
		this.temperaturaMinima = temperaturaMinima;
	}

	public BigDecimal getTemperaturaMaxima() {
		return temperaturaMaxima;
	}

	public void setTemperaturaMaxima(BigDecimal temperaturaMaxima) {
		this.temperaturaMaxima = temperaturaMaxima;
	}

	public String getIpRequest() {
		return ipRequest;
	}

	public void setIpRequest(String ipRequest) {
		this.ipRequest = ipRequest;
	}


}
