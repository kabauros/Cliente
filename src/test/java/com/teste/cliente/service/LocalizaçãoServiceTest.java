package com.teste.cliente.service;

import static br.com.six2six.fixturefactory.Fixture.from;
import static br.com.six2six.fixturefactory.loader.FixtureFactoryLoader.loadTemplates;
import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.teste.cliente.dto.CidadesDTO;
import com.teste.cliente.dto.Data;
import com.teste.cliente.dto.IPVigilanteDTO;
import com.teste.cliente.properties.ClimaProperties;
import com.teste.cliente.properties.IPVigilanteProperties;
import com.teste.cliente.vo.Clima;


@RunWith(MockitoJUnitRunner.class)
public class LocalizaçãoServiceTest {
	
	@InjectMocks
	private LocalizaçãoService service;
	
	@Mock
	private IPVigilanteProperties ipvigilanteProperties;
	
	@Mock
	private ClimaProperties climaProperties;

	
	@Mock
	private RestTemplate restTemplate;
	
	

	@BeforeClass
	public static void setUpClass() {
		loadTemplates("com.teste.cliente.template");
	}

	
	@Test
	public void testLocalizaLatitudeLongitude() {
				
		IPVigilanteDTO ipDTO = from(IPVigilanteDTO.class).gimme("ip-dto-1"); 
		Data data = from(Data.class).gimme("data-1"); 
		ipDTO.setData(data);
		
		Mockito.when(ipvigilanteProperties.getUrlIPVigilante()).thenReturn("https://ipvigilante.com/{ip}/full");
				
		IPVigilanteDTO ip = service.localizaLatitudeLongitude("192.168.1.5");
		
		assertNotNull(ip);
		
	}
	
	@Test
	public void testLocalizaCidades() {
				
		IPVigilanteDTO ipDTO = from(IPVigilanteDTO.class).gimme("ip-dto-1"); 
		Data data = from(Data.class).gimme("data-1"); 
		ipDTO.setData(data);
		
		Mockito.when(climaProperties.getUrlCidadesDisponiveis()).thenReturn("https://www.metaweather.com/api/location/search/?lattlong={latitude},{longitude}");
				
		CidadesDTO[] listaCidades = service.localizaCidades(ipDTO);
		
		assertNotNull(listaCidades);
		
	}
	
	@Test
	public void testLocalizaTemperaturaMinimaMaxima() {

		Mockito.when(climaProperties.getUrlTemperaturaPorCidadeId()).thenReturn("https://www.metaweather.com/api/location/{cidadeid}/{ano}/{mes}/{dia}");
		
		IPVigilanteDTO ipDTO = from(IPVigilanteDTO.class).gimme("ip-dto-1"); 
		Data data = from(Data.class).gimme("data-1"); 
		ipDTO.setData(data);
		
		Clima clima = service.localizaTemperaturaMinimaMaxima(455827);
		
		assertNotNull(clima);
		
	}
	
	@Test
	public void testGetClimaByIp() {
		Mockito.when(ipvigilanteProperties.getUrlIPVigilante()).thenReturn("https://ipvigilante.com/{ip}/full");
		Mockito.when(climaProperties.getUrlCidadesDisponiveis()).thenReturn("https://www.metaweather.com/api/location/search/?lattlong={latitude},{longitude}");
		Mockito.when(climaProperties.getUrlTemperaturaPorCidadeId()).thenReturn("https://www.metaweather.com/api/location/{cidadeid}/{ano}/{mes}/{dia}");
		
		
		Clima clima = service.getClimaByIp("192.168.1.5");
		
		assertNotNull(clima);
	}

}
