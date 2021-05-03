package br.com.razzotto.DTO;

public class registryAircraftDTO {
	int id;
	String reg;
	boolean active;
	int serial;
	String hexIcao;
	//
	String airlineId;
	String airlineName;
	//
	String iataCodeShort;
	String iataCodeLong;
	String model;
	String modelCode;
	int numSeats;
	String rolloutDate;
	String firstFlightDate;
	String deliveryDate;
	String registrationDate;
	String typeName;
	int numEngines; 
	String engineType;
	boolean isFreighter;
	String productionLine;
	Double ageYears;
	boolean verified;
	
	
	
	public registryAircraftDTO(int id, String reg, boolean active, int serial, String hexIcao, String airlineId,
			String airlineName, String iataCodeShort, String iataCodeLong, String model, String modelCode, int numSeats,
			String rolloutDate, String firstFlightDate, String deliveryDate, String registrationDate, String typeName,
			int numEngines, String engineType, boolean isFreighter, String productionLine, Double ageYears,
			boolean verified) {
		super();
		this.id = id;
		this.reg = reg;
		this.active = active;
		this.serial = serial;
		this.hexIcao = hexIcao;
		this.airlineId = airlineId;
		this.airlineName = airlineName;
		this.iataCodeShort = iataCodeShort;
		this.iataCodeLong = iataCodeLong;
		this.model = model;
		this.modelCode = modelCode;
		this.numSeats = numSeats;
		this.rolloutDate = rolloutDate;
		this.firstFlightDate = firstFlightDate;
		this.deliveryDate = deliveryDate;
		this.registrationDate = registrationDate;
		this.typeName = typeName;
		this.numEngines = numEngines;
		this.engineType = engineType;
		this.isFreighter = isFreighter;
		this.productionLine = productionLine;
		this.ageYears = ageYears;
		this.verified = verified;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getReg() {
		return reg;
	}



	public void setReg(String reg) {
		this.reg = reg;
	}



	public boolean isActive() {
		return active;
	}



	public void setActive(boolean active) {
		this.active = active;
	}



	public int getSerial() {
		return serial;
	}



	public void setSerial(int serial) {
		this.serial = serial;
	}



	public String getHexIcao() {
		return hexIcao;
	}



	public void setHexIcao(String hexIcao) {
		this.hexIcao = hexIcao;
	}



	public String getAirlineId() {
		return airlineId;
	}



	public void setAirlineId(String airlineId) {
		this.airlineId = airlineId;
	}



	public String getAirlineName() {
		return airlineName;
	}



	public void setAirlineName(String airlineName) {
		this.airlineName = airlineName;
	}



	public String getIataCodeShort() {
		return iataCodeShort;
	}



	public void setIataCodeShort(String iataCodeShort) {
		this.iataCodeShort = iataCodeShort;
	}



	public String getIataCodeLong() {
		return iataCodeLong;
	}



	public void setIataCodeLong(String iataCodeLong) {
		this.iataCodeLong = iataCodeLong;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}



	public String getModelCode() {
		return modelCode;
	}



	public void setModelCode(String modelCode) {
		this.modelCode = modelCode;
	}



	public int getNumSeats() {
		return numSeats;
	}



	public void setNumSeats(int numSeats) {
		this.numSeats = numSeats;
	}



	public String getRolloutDate() {
		return rolloutDate;
	}



	public void setRolloutDate(String rolloutDate) {
		this.rolloutDate = rolloutDate;
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



	public String getTypeName() {
		return typeName;
	}



	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}



	public int getNumEngines() {
		return numEngines;
	}



	public void setNumEngines(int numEngines) {
		this.numEngines = numEngines;
	}



	public String getEngineType() {
		return engineType;
	}



	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}



	public boolean isFreighter() {
		return isFreighter;
	}



	public void setFreighter(boolean isFreighter) {
		this.isFreighter = isFreighter;
	}

	public String getProductionLine() {
		return productionLine;
	}
	
	public void setProductionLine(String productionLine) {
		this.productionLine = productionLine;
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
	
	
	
	
	
	
	
	
	

}
