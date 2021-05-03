package br.com.razzotto.entity;

import java.util.ArrayList;
import java.util.Date;

public class modelAircraft {
	private String iataCodeShort;
	private String iataCodeLong;
	private String model;
	private String modelCode;
	private String productionLine;
	private String typeName;
	private int numEngines; 
	private String engineType;
	private String rolloutDate;
//	ArrayList<registryAircraft> registroAeronaves;
	ArrayList<Airline> OperadorasDoModelo;
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
	public String getProductionLine() {
		return productionLine;
	}
	public void setProductionLine(String productionLine) {
		this.productionLine = productionLine;
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
	public String getRolloutDate() {
		return rolloutDate;
	}
	public void setRolloutDate(String rolloutDate) {
		this.rolloutDate = rolloutDate;
	}
/*	public ArrayList<registryAircraft> getRegistroAeronaves() {
		return registroAeronaves;
	}
	public void setRegistroAeronaves(ArrayList<registryAircraft> registroAeronaves) {
		this.registroAeronaves = registroAeronaves;
	}*/
	public modelAircraft(String iataCodeShort, String iataCodeLong, String model, String modelCode,
			String productionLine, String typeName, int numEngines, String engineType, String rolloutDate) {
		super();
		this.iataCodeShort = iataCodeShort;
		this.iataCodeLong = iataCodeLong;
		this.model = model;
		this.modelCode = modelCode;
		this.productionLine = productionLine;
		this.typeName = typeName;
		this.numEngines = numEngines;
		this.engineType = engineType;
		this.rolloutDate = rolloutDate;
	}
	
	

	
}
