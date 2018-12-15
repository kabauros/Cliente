package com.teste.cliente.service;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.teste.cliente.dto.CidadesDTO;
import com.teste.cliente.dto.IPVigilanteDTO;
import com.teste.cliente.dto.TemperaturaDTO;
import com.teste.cliente.properties.ClimaProperties;
import com.teste.cliente.properties.IPVigilanteProperties;
import com.teste.cliente.vo.Clima;

@Component
public class LocalizaçãoService {

	@Autowired
	private IPVigilanteProperties ipvigilanteProperties;

	@Autowired
	private ClimaProperties climaProperties;

	public Clima getClimaByIp(String ip) {
		IPVigilanteDTO ipvigilanteProperties = localizaLatitudeLongitude(ip);
		CidadesDTO[] cidades = localizaCidades(ipvigilanteProperties);
		Integer idCidade = cidades[0].getWoeid();
		return localizaTemperaturaMinimaMaxima(idCidade);
	}

	public IPVigilanteDTO localizaLatitudeLongitude(String ip) {
		
		//Para teste evitando a falha do localhost
		if(ip.contains("192.168")) {
			ip = "177.188.130.133";
		}

		final String uri = ipvigilanteProperties.getUrlIPVigilante();

		Map<String, String> params = new HashMap<String, String>();
		params.put("ip", ip);

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(uri, IPVigilanteDTO.class, params);

	}

	public CidadesDTO[] localizaCidades(IPVigilanteDTO ipvigilanteProperties) {
		final String uri = climaProperties.getUrlCidadesDisponiveis();

		Map<String, String> params = new HashMap<String, String>();
		params.put("latitude", ipvigilanteProperties.getData().getLatitude());
		params.put("longitude", ipvigilanteProperties.getData().getLongitude());

		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(uri, CidadesDTO[].class, params);

	}

	public Clima localizaTemperaturaMinimaMaxima(Integer idCidade) {

		Clima clima = new Clima();

		Calendar dataHoje = Calendar.getInstance();

		Integer ano = dataHoje.get(Calendar.YEAR);
		Integer mes = dataHoje.get(Calendar.MONTH) + 1;
		Integer dia = dataHoje.get(Calendar.DAY_OF_MONTH);

		String uri = climaProperties.getUrlTemperaturaPorCidadeId();

		Map<String, String> params = new HashMap<String, String>();
		params.put("cidadeid", idCidade.toString());
		params.put("ano", ano.toString());
		params.put("mes", mes.toString());
		params.put("dia", dia.toString());

		RestTemplate restTemplate = new RestTemplate();
		TemperaturaDTO[] temps = restTemplate.getForObject(uri, TemperaturaDTO[].class, params);

		BigDecimal temperaturaMinima = new BigDecimal(Float.MAX_VALUE);
		BigDecimal temperaturaMaxima = new BigDecimal(Float.MIN_VALUE);
		for (TemperaturaDTO temperaturaDTO : temps) {
			if (temperaturaDTO.getApplicableDate() == null) {
				continue;
			}

			if (clima.getDataInclusao() == null) {
				clima.setDataInclusao(temperaturaDTO.getApplicableDate());
			}

			if (temperaturaDTO.getMinTemp().compareTo(temperaturaMinima) < 0) {
				temperaturaMinima = temperaturaDTO.getMinTemp();
			}

			if (temperaturaDTO.getMaxTemp().compareTo(temperaturaMaxima) > 0) {
				temperaturaMaxima = temperaturaDTO.getMaxTemp();
			}
		}

		clima.setTemperaturaMinima(temperaturaMinima);
		clima.setTemperaturaMaxima(temperaturaMaxima);

		return clima;

	}

}
