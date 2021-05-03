package br.com.razzotto.entity;

public class Airport {
	String iataCode;
	String icaoCode;
	String name; 
	String countryCode;
	long periodoInicial;
	long PeriodoFinal;
	double latitude;
	double longitude;
	public long getPeriodoInicial() {
		return periodoInicial;
	}
	public void setPeriodoInicial(long periodoInicial) {
		this.periodoInicial = periodoInicial;
	}
	public long getPeriodoFinal() {
		return PeriodoFinal;
	}
	public void setPeriodoFinal(long periodoFinal) {
		PeriodoFinal = periodoFinal;
	}
	public String getIataCode() {
		return iataCode;
	}
	public void setIataCode(String iataCode) {
		this.iataCode = iataCode;
	}
	public String getIcaoCode() {
		return icaoCode;
	}
	public void setIcaoCode(String icaoCode) {
		this.icaoCode = icaoCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Airport(String iataCode, String icaoCode, String name, String countryCode, double latitude,
			double longitude) {
		super();
		this.iataCode = iataCode;
		this.icaoCode = icaoCode;
		this.name = name;
		this.countryCode = countryCode;
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	
}
