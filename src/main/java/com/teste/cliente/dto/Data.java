package com.teste.cliente.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
	"ipv4",
	"hostname",
	"continent_code",
	"continent_name",
	"country_iso_code",
	"country_name",
	"subdivision_1_iso_code",
	"subdivision_1_name",
	"subdivision_2_iso_code",
	"subdivision_2_name",
	"city_name",
	"metro_code",
	"time_zone",
	"postal_code",
	"latitude",
	"longitude",
	"accuracy_radius"
})


public class Data {
	@JsonProperty(value = "ipv4")
	private String ipv4;
	
	@JsonProperty(value = "hostname")
	private String hostname;
	
	@JsonProperty(value = "continent_code")
	private String continentCode;
	
	@JsonProperty(value = "continent_name")
	private String continentName;
	
	@JsonProperty(value = "country_iso_code")
	private String countryIsoCode;
	
	@JsonProperty(value = "country_name")
	private String countryName;
	
	@JsonProperty(value = "subdivision_1_iso_code")
	private String subdivision1IsoCode;
	
	@JsonProperty(value = "subdivision_1_name")
	private String subdivision1Name;
	
	@JsonProperty(value = "subdivision_2_iso_code")
	private Object subdivision2IsoCode;
	
	@JsonProperty(value = "subdivision_2_name")
	private Object subdivision2Name;
	
	@JsonProperty(value = "city_name")
	private String cityName;
	
	@JsonProperty(value = "metro_code")
	private Object metroCode;
	
	@JsonProperty(value = "time_zone")
	private String timeZone;
	
	@JsonProperty(value = "postal_code")
	private Object postalCode;
	
	@JsonProperty(value = "latitude")
	private String latitude;
	
	@JsonProperty(value = "longitude")
	private String longitude;
	
	@JsonProperty(value = "accuracy_radius")
	private Integer accuracyRadius;

	public String getIpv4() {
		return ipv4;
	}

	public void setIpv4(String ipv4) {
		this.ipv4 = ipv4;
	}

	public String getHostname() {
		return hostname;
	}

	public void setHostname(String hostname) {
		this.hostname = hostname;
	}

	public String getContinentCode() {
		return continentCode;
	}

	public void setContinentCode(String continentCode) {
		this.continentCode = continentCode;
	}

	public String getContinentName() {
		return continentName;
	}

	public void setContinentName(String continentName) {
		this.continentName = continentName;
	}

	public String getCountryIsoCode() {
		return countryIsoCode;
	}

	public void setCountryIsoCode(String countryIsoCode) {
		this.countryIsoCode = countryIsoCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getSubdivision1IsoCode() {
		return subdivision1IsoCode;
	}

	public void setSubdivision1IsoCode(String subdivision1IsoCode) {
		this.subdivision1IsoCode = subdivision1IsoCode;
	}

	public String getSubdivision1Name() {
		return subdivision1Name;
	}

	public void setSubdivision1Name(String subdivision1Name) {
		this.subdivision1Name = subdivision1Name;
	}

	public Object getSubdivision2IsoCode() {
		return subdivision2IsoCode;
	}

	public void setSubdivision2IsoCode(Object subdivision2IsoCode) {
		this.subdivision2IsoCode = subdivision2IsoCode;
	}

	public Object getSubdivision2Name() {
		return subdivision2Name;
	}

	public void setSubdivision2Name(Object subdivision2Name) {
		this.subdivision2Name = subdivision2Name;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String city_name) {
		this.cityName = city_name;
	}

	public Object getMetroCode() {
		return metroCode;
	}

	public void setMetroCode(Object metroCode) {
		this.metroCode = metroCode;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public Object getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Object postalCode) {
		this.postalCode = postalCode;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public Integer getAccuracyRadius() {
		return accuracyRadius;
	}

	public void setAccuracyRadius(Integer accuracyRadius) {
		this.accuracyRadius = accuracyRadius;
	}
}
