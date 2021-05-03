package br.com.razzotto.entity;

import java.util.ArrayList;
import java.util.Date;
import br.com.razzotto.model.ConversionTime;

public class Flight {
	String icao24;
	boolean ArrivalorDeparture;
	Date firstSeen;
	String estDepartureAirport;
	Date lastSeen;
	String estArrivalAirport;
	String callsign;
	int estDepartureAirportHorizDistance;
	int estDepartureAirportVertDistance;
	int estArrivalAirportHorizDistance;
	int estArrivalAirportVertDistance;
	int departureAirportCandidatesCount;
	int arrivalAirportCandidatesCount;
	private registryAircraft aeronavesFrota;
	String TempoDecorrido;	
	
	
	public Flight(String icao24, boolean arrivalorDeparture, long firstSeen, String estDepartureAirport, long lastSeen,
			String estArrivalAirport, String callsign, int estDepartureAirportHorizDistance,
			int estDepartureAirportVertDistance, int estArrivalAirportHorizDistance, int estArrivalAirportVertDistance,
			int departureAirportCandidatesCount, int arrivalAirportCandidatesCount) {
		super();
		this.icao24 = icao24;
		ArrivalorDeparture = arrivalorDeparture;
		this.firstSeen = (firstSeen != 0)? new ConversionTime().ConvertUnixDate(firstSeen): null ;
		this.estDepartureAirport = estDepartureAirport;
		this.lastSeen = (lastSeen != 0)? new ConversionTime().ConvertUnixDate(lastSeen): null ;
		this.estArrivalAirport = estArrivalAirport;
		this.callsign = callsign;
		this.estDepartureAirportHorizDistance = estDepartureAirportHorizDistance;
		this.estDepartureAirportVertDistance = estDepartureAirportVertDistance;
		this.estArrivalAirportHorizDistance = estArrivalAirportHorizDistance;
		this.estArrivalAirportVertDistance = estArrivalAirportVertDistance;
		this.departureAirportCandidatesCount = departureAirportCandidatesCount;
		this.arrivalAirportCandidatesCount = arrivalAirportCandidatesCount;
	}


	public String getIcao24() {
		return icao24;
	}


	public void setIcao24(String icao24) {
		this.icao24 = icao24;
	}


	public boolean isArrivalorDeparture() {
		return ArrivalorDeparture;
	}


	public void setArrivalorDeparture(boolean arrivalorDeparture) {
		ArrivalorDeparture = arrivalorDeparture;
	}


	public String getformatFirstSeen() {
		return new ConversionTime().ConvertDatetoString(firstSeen);	
	}


	public Date getFirstSeen() {
		return firstSeen;
	}


	public Date getLastSeen() {
		return lastSeen;
	}


	public void setFirstSeen(Date firstSeen) {
		this.firstSeen = firstSeen;
	}


	public String getEstDepartureAirport() {
		return estDepartureAirport;
	}


	public void setEstDepartureAirport(String estDepartureAirport) {
		this.estDepartureAirport = estDepartureAirport;
	}


	public String getFormatLastSeen() {
		return new ConversionTime().ConvertDatetoString(lastSeen);		
	}


	public void setLastSeen(Date lastSeen) {
		this.lastSeen = lastSeen;
	}


	public String getEstArrivalAirport() {
		return estArrivalAirport;
	}


	public void setEstArrivalAirport(String estArrivalAirport) {
		this.estArrivalAirport = estArrivalAirport;
	}


	public String getCallsign() {
		return callsign;
	}


	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}


	public int getEstDepartureAirportHorizDistance() {
		return estDepartureAirportHorizDistance;
	}


	public void setEstDepartureAirportHorizDistance(int estDepartureAirportHorizDistance) {
		this.estDepartureAirportHorizDistance = estDepartureAirportHorizDistance;
	}


	public int getEstDepartureAirportVertDistance() {
		return estDepartureAirportVertDistance;
	}


	public void setEstDepartureAirportVertDistance(int estDepartureAirportVertDistance) {
		this.estDepartureAirportVertDistance = estDepartureAirportVertDistance;
	}


	public int getEstArrivalAirportHorizDistance() {
		return estArrivalAirportHorizDistance;
	}


	public void setEstArrivalAirportHorizDistance(int estArrivalAirportHorizDistance) {
		this.estArrivalAirportHorizDistance = estArrivalAirportHorizDistance;
	}


	public int getEstArrivalAirportVertDistance() {
		return estArrivalAirportVertDistance;
	}


	public void setEstArrivalAirportVertDistance(int estArrivalAirportVertDistance) {
		this.estArrivalAirportVertDistance = estArrivalAirportVertDistance;
	}


	public int getDepartureAirportCandidatesCount() {
		return departureAirportCandidatesCount;
	}


	public void setDepartureAirportCandidatesCount(int departureAirportCandidatesCount) {
		this.departureAirportCandidatesCount = departureAirportCandidatesCount;
	}


	public int getArrivalAirportCandidatesCount() {
		return arrivalAirportCandidatesCount;
	}
	
	public registryAircraft getAeronaveFrota() {
		return aeronavesFrota;
	}


	public void setAeronaveFrota(registryAircraft aeronavesFrota) {
		this.aeronavesFrota = aeronavesFrota;
	}


	public void setArrivalAirportCandidatesCount(int arrivalAirportCandidatesCount) {
		this.arrivalAirportCandidatesCount = arrivalAirportCandidatesCount;
	}


	public String getTempoDecorrido() {
		return TempoDecorrido;
	}

	public boolean setTempoDecorrido() {
		if((firstSeen !=null)&&(lastSeen != null))
		{
			long diferenca_em_Horas = Math.abs((firstSeen.getTime() - lastSeen.getTime()) / (1000*60*60));
			long diferenca_em_Minutos = Math.abs((firstSeen.getTime() - lastSeen.getTime()) / (1000*60));
			long diferenca_em_Segundos = Math.abs((firstSeen.getTime() - lastSeen.getTime()) / (1000));
			TempoDecorrido = String.format("%s:%s:%s ",diferenca_em_Horas,diferenca_em_Minutos,diferenca_em_Segundos);
			return true;
		}
		return false;
		
	}
	
	/*public void atualizarRegistros (registryAircraft aircratReg) {
		if (aircratReg!=null)
		{
			aeronavesFrota.add(aircratReg);	
		}

	}*/
	/*public void atualizarRegistros (registryAircraft aircratReg) {
		boolean encontrado = false;
		for (int i = 0; i < aeronavesFrota.size(); i++) {
			if (aeronavesFrota.get(i).getHexIcao().equals(aircratReg.getHexIcao()))
			{
				aeronavesFrota.set(i, aircratReg);
				encontrado = true;				
			}	
		}
		if(!encontrado) {
			aeronavesFrota.add(aircratReg);			
		}
	}*/
	
	
	
	
	

}
