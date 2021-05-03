package br.com.razzotto.entity;

import java.util.Date;

public class registryAircraft {
	
	private int serial;
	private String reg;
	private String hexIcao;
	private boolean active;
	private int numSeats;
	Double ageYears;
	boolean verified;
	boolean isFreighter;
	private String firstFlightDate;
	private String deliveryDate;
	private String registrationDate;
	private Airline airlineCompany;
	private modelAircraft modeloAircraft;
	

	public registryAircraft(int serial, String reg, String hexIcao, boolean active, int numSeats, Double ageYears,
			boolean verified, boolean isFreighter, String firstFlightDate, String deliveryDate, String registrationDate,
			Airline airlineCompany, modelAircraft modeloAircraft) {
		super();
		this.serial = serial;
		this.reg = reg;
		this.hexIcao = hexIcao;
		this.active = active;
		this.numSeats = numSeats;
		this.ageYears = ageYears;
		this.verified = verified;
		this.isFreighter = isFreighter;
		this.firstFlightDate = firstFlightDate;
		this.deliveryDate = deliveryDate;
		this.registrationDate = registrationDate;
		this.airlineCompany = airlineCompany;
		this.modeloAircraft = modeloAircraft;
	}

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public String getReg() {
		return reg;
	}

	public void setReg(String reg) {
		this.reg = reg;
	}

	public String getHexIcao() {
		return hexIcao;
	}

	public void setHexIcao(String hexIcao) {
		this.hexIcao = hexIcao;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}

	public Double getAgeYears() {
		return ageYears;
	}

	public void setAgeYears(Double ageYears) {
		this.ageYears = ageYears;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public boolean isFreighter() {
		return isFreighter;
	}

	public void setFreighter(boolean isFreighter) {
		this.isFreighter = isFreighter;
	}

	public String getFirstFlightDate() {
		return firstFlightDate;
	}

	public void setFirstFlightDate(String firstFlightDate) {
		this.firstFlightDate = firstFlightDate;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public Airline getAirlineCompany() {
		return airlineCompany;
	}

	public void setAirlineCompany(Airline airlineCompany) {
		this.airlineCompany = airlineCompany;
	}

	public modelAircraft getModeloAircraft() {
		return modeloAircraft;
	}
	
	public void setModeloAircraft(modelAircraft modeloAircraft) {
		this.modeloAircraft = modeloAircraft;
	}

	

	
	
	
	
	
}
	
