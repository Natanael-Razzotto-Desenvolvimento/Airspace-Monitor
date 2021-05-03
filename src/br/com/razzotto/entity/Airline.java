package br.com.razzotto.entity;

import java.util.ArrayList;

public class Airline {
	
	private String airlineId;
	private String airlineName;
//	private ArrayList<modelAircraft> modelosFrota;
	private ArrayList<Flight> voosCompanhia;	
	
	public Airline() {
		super();
	}

	public Airline(String airlineId, String airlineName) {
		super();
		this.airlineId = airlineId;
		this.airlineName = airlineName;
		this.voosCompanhia= new ArrayList<Flight>();
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
	
	public ArrayList<Flight> getVoosCompanhia() {
		return voosCompanhia;
	}

	public void setVoosCompanhia(ArrayList<Flight> voosCompanhia) {
		this.voosCompanhia = voosCompanhia;
	}

	public void atualizarVoos (Flight voo) {
		if (voo!=null)
		{
			voosCompanhia.add(voo);	
		}
	}
	public Flight searchVoos(String idVoo) {
		for (Flight flight : voosCompanhia) 
		{
			if(flight.getIcao24().equals(idVoo))
			{
				return flight;
				
			}
		}
		return null;
	}
	public int searchVoosGeneroArrival() {
		int arrival = 0;
		for (Flight flight : voosCompanhia) 
		{
			if(flight.isArrivalorDeparture() == true)
			{
				arrival++;
				
			}
		}
		return arrival;
	}
	public int searchVoosGeneroDeparture() {
		int Departure = 0;
		for (Flight flight : voosCompanhia) 
		{
			if(flight.isArrivalorDeparture() == false)
			{
				Departure++;
				
			}
		}
		return Departure;
	}
	
	
/*	public void atualizarVoos (Flight voo) {
		boolean encontrado = false;
		for (int i = 0; i < voosCompanhia.size(); i++) {
			if (voosCompanhia.get(i).getIcao24().equals(voo.getIcao24()))
			{
				voosCompanhia.set(i, voo);
				encontrado = true;				
			}	
		}
		if(!encontrado) {
			voosCompanhia.add(voo);			
		}
	}*/

	
	
	

}
