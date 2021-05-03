package br.com.razzotto.DTO;

public class FlightsOfAirportDTO {
	//https://opensky-network.org/apidoc/rest.html#arrivals-by-airport
	String icao24;
	long firstSeen;
	String estDepartureAirport;
	long lastSeen;
	String estArrivalAirport;
	String callsign;
	int estDepartureAirportHorizDistance;
	int estDepartureAirportVertDistance;
	int estArrivalAirportHorizDistance;
	int estArrivalAirportVertDistance;
	int departureAirportCandidatesCount;
	int arrivalAirportCandidatesCount;
	
	public String getIcao24() {
		return icao24;
	}

	public void setIcao24(String icao24) {
		this.icao24 = icao24;
	}

	public long getFirstSeen() {
		return firstSeen;
	}

	public void setFirstSeen(int firstSeen) {
		this.firstSeen = firstSeen;
	}

	public String getEstDepartureAirport() {
		return estDepartureAirport;
	}

	public void setEstDepartureAirport(String estDepartureAirport) {
		this.estDepartureAirport = estDepartureAirport;
	}

	public long getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(int lastSeen) {
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

	public void setArrivalAirportCandidatesCount(int arrivalAirportCandidatesCount) {
		this.arrivalAirportCandidatesCount = arrivalAirportCandidatesCount;
	}

	public FlightsOfAirportDTO(String icao24, int firstSeen, String estDepartureAirport, int lastSeen,
			String estArrivalAirport, String callsign, int estDepartureAirportHorizDistance,
			int estDepartureAirportVertDistance, int estArrivalAirportHorizDistance, int estArrivalAirportVertDistance,
			int departureAirportCandidatesCount, int arrivalAirportCandidatesCount) {
		super();
		this.icao24 = icao24;
		this.firstSeen = firstSeen;
		this.estDepartureAirport = estDepartureAirport;
		this.lastSeen = lastSeen;
		this.estArrivalAirport = estArrivalAirport;
		this.callsign = callsign;
		this.estDepartureAirportHorizDistance = estDepartureAirportHorizDistance;
		this.estDepartureAirportVertDistance = estDepartureAirportVertDistance;
		this.estArrivalAirportHorizDistance = estArrivalAirportHorizDistance;
		this.estArrivalAirportVertDistance = estArrivalAirportVertDistance;
		this.departureAirportCandidatesCount = departureAirportCandidatesCount;
		this.arrivalAirportCandidatesCount = arrivalAirportCandidatesCount;
	}
	
	

}
