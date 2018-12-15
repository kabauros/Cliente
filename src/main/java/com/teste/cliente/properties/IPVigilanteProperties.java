package com.teste.cliente.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:ipvigilante.properties")
public class IPVigilanteProperties {


	@Value("${url.ipvigilante}")
	private String urlIPVigilante;

	public String getUrlIPVigilante() {
		return urlIPVigilante;
	}


}
