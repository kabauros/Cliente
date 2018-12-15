package com.teste.cliente.template;

import java.math.BigDecimal;

import com.teste.cliente.dto.CidadesDTO;
import com.teste.cliente.dto.Data;
import com.teste.cliente.dto.IPVigilanteDTO;
import com.teste.cliente.vo.Cliente;
import com.teste.cliente.vo.Clima;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class Template implements TemplateLoader {

	public void load() {
		Fixture.of(Cliente.class).addTemplate("cliente-1", new Rule() {
			{
				add("id", 1L);
				add("nome", "Marcos");
				add("idade", 32L);
			}
		});
		
		Fixture.of(Cliente.class).addTemplate("cliente-2", new Rule() {
			{
				add("id", 2L);
				add("nome", "Eduardo");
				add("idade", 32L);
			}
		});
		
		Fixture.of(Clima.class).addTemplate("clima-1", new Rule() {
			{
				add("id", "1");
				add("clienteId", "1");
				add("dataInclusao", "2018-12-15");
				add("temperaturaMinima", BigDecimal.ONE);
				add("temperaturaMaxima", BigDecimal.ONE);
				add("ipRequest", "177.188.130.133");
			}
		});
		
		
		Fixture.of(Data.class).addTemplate("data-1", new Rule() {
			{
				add("ipv4", "177.188.130.133");
				add("hostname", "177-188-130-133.dsl.telesp.net.br");
				add("continentCode", "SA");
				add("continentName", "South America");
				add("countryIsoCode", "BR");
				add("countryName", "Brazil");
				add("subdivision1IsoCode", "SP");
				add("subdivision1Name", "Sao Paulo");
				add("subdivision2IsoCode", null);
				add("subdivision2Name", null);
				add("cityName", "Itapecerica da Serra");
				add("metroCode", null);
				add("timeZone", "America/Sao_Paulo");
				add("postalCode", null);
				add("latitude","-23.71620");
				add("longitude", "-46.84700");
				add("accuracyRadius", 20);
			}
		});
		
		Fixture.of(IPVigilanteDTO.class).addTemplate("ip-dto-1", new Rule() {
			{
				add("status", "success");
				add("data", null);
			}
		});
		
		Fixture.of(CidadesDTO.class).addTemplate("cidade-1", new Rule() {
			{
				
				add("distance", 25955);
				add("title", "São Paulo");
				add("locationType", "City");
				add("woeid", 455827);
				add("lattLong", "-23.562880,-46.654659");
			}
		});
		
		Fixture.of(CidadesDTO.class).addTemplate("cidade-2", new Rule() {
			{
				
				add("distance", 381533);
				add("title", "Rio de Janeiro");
				add("locationType", "City");
				add("woeid", 455825);
				add("lattLong", "-22.976730,-43.195080");
			}
		});
		
	}
}
