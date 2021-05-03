package br.com.razzotto.DTO;

public class AirportGsonDTO {
	
	String iataCode;
	String icaoCode;
	String name; 
	String alpha2countryCode;
	double latitude;
	double longitude;
	
	public AirportGsonDTO(String iataCode, String icaoCode, String name, String alpha2countryCode,
						double latitude, double longitude) {
		super();
		this.iataCode = iataCode;
		this.icaoCode = icaoCode;
		this.name = name;
		this.alpha2countryCode = alpha2countryCode;
		this.latitude = latitude;
		this.longitude = longitude;		
		
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

	public String getcountryCode() {
		return alpha2countryCode;
	}

	public void setcountryCode(String alpha2countryCode) {
		this.alpha2countryCode = alpha2countryCode;
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
	
	

}
