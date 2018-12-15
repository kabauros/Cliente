package com.teste.cliente.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:clima.properties")
public class ClimaProperties {

	@Value("${cidades.disponiveis}")
	private String urlCidadesDisponiveis;

	@Value("${temperatura.por.cidadeid}")
	private String urlTemperaturaPorCidadeId;

	public String getUrlCidadesDisponiveis() {
		return urlCidadesDisponiveis;
	}

	public String getUrlTemperaturaPorCidadeId() {
		return urlTemperaturaPorCidadeId;
	}

}