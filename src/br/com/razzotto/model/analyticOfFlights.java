package br.com.razzotto.model;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;

import br.com.razzotto.DTO.FlightsOfAirportDTO;
import br.com.razzotto.DTO.analyticOfFlights_DTO;
import br.com.razzotto.DTO.registryAircraftDTO;
import br.com.razzotto.entity.Airline;
import br.com.razzotto.entity.Airport;
import br.com.razzotto.entity.Flight;
import br.com.razzotto.entity.modelAircraft;
import br.com.razzotto.entity.registryAircraft;
import br.com.razzotto.services.requestHTTPfromAPI;

public class analyticOfFlights {
	
	requestHTTPfromAPI requestHTTP;
	public analyticOfFlights_DTO analytic;
	public analyticOfFlights(Airport airport ) {
		requestHTTP = new requestHTTPfromAPI();
		analytic = new analyticOfFlights_DTO();
		analytic.airportSelect = airport;		
	}
	
	
	public analyticOfFlights_DTO IniciarAnalise(ArrayList<FlightsOfAirportDTO> listFligths, boolean destino) throws IOException, InterruptedException {
		for (FlightsOfAirportDTO flight: listFligths)
		{			
			obterDadosdeAeronaveVoo(flight,destino);
		}
		return analytic;		
	}

	public void obterDadosdeAeronaveVoo(FlightsOfAirportDTO flight,boolean ArrivalorDeparture) throws IOException, InterruptedException {
		Airline airline = null;
		registryAircraft regAircraft = null;
		modelAircraft modAircraft = null;
		Flight flightActual = null;
		if (flight.getIcao24()!=null)
		{

			flightActual = obterDefinirDadosVoo(flight,ArrivalorDeparture);	
			System.out.println("---" + flight.getIcao24());
			registryAircraftDTO aircraft = requestHTTP.requestFromAPIgetAircraftReg(flight.getIcao24());

			if (aircraft != null) {
				
				if (aircraft.getAirlineId()==null)
				{
					 airline = analytic.searchAirline("00");
					if (airline == null)
					{
						airline = createAirline("00", "Aviação Privada");
					}				
				}
				else
				{
					airline = analytic.searchAirline(aircraft.getAirlineId());
					if (airline == null)
					{
						airline =  createAirline(aircraft.getAirlineId(), aircraft.getAirlineName());
					}
				}
				System.out.println("get iata");
				if (aircraft.getIataCodeLong()!=null)
				{
					modAircraft = analytic.searchModelAicraft(aircraft.getIataCodeLong());
					if (modAircraft == null)
					{
						modAircraft = createRegisterModel(aircraft);					
						analytic.atualizarRegistroModelos(modAircraft);
					}	
				}
	
				regAircraft = createRegisterAircraft(aircraft,airline,modAircraft);
				flightActual.setAeronaveFrota(regAircraft);
				airline.atualizarVoos(flightActual);
				analytic.atualizarCompanhias(airline);
			}
		}
	}

	public Flight obterDefinirDadosVoo(FlightsOfAirportDTO Fligths,boolean ArrivalorDeparture) {
		return new Flight(Fligths.getIcao24(), ArrivalorDeparture, Fligths.getFirstSeen(), Fligths.getEstDepartureAirport(),
				Fligths.getLastSeen(), Fligths.getEstArrivalAirport(), Fligths.getCallsign(), Fligths.getEstDepartureAirportHorizDistance(),
				Fligths.getEstDepartureAirportVertDistance(), Fligths.getEstArrivalAirportHorizDistance(), Fligths.getEstDepartureAirportVertDistance(),
				Fligths.getDepartureAirportCandidatesCount(), Fligths.getArrivalAirportCandidatesCount());
		
			
	}
	public Airline createAirline(String AirlineId, String AirlineName)
	{
		return new Airline(AirlineId, AirlineName);
		
	}
	public modelAircraft createRegisterModel(registryAircraftDTO aircraft) {
		
		return new modelAircraft(aircraft.getIataCodeShort(), aircraft.getIataCodeLong(), aircraft.getModel(),
				aircraft.getModelCode(), aircraft.getProductionLine(), aircraft.getTypeName(), aircraft.getNumEngines(), 
				aircraft.getEngineType(), aircraft.getRolloutDate());
	}
	public registryAircraft createRegisterAircraft(registryAircraftDTO aircraft, Airline airline, modelAircraft modAircraft) {
		
		return new registryAircraft(aircraft.getSerial(), aircraft.getReg(), aircraft.getHexIcao(),
				aircraft.isActive(), aircraft.getNumSeats(), aircraft.getAgeYears(),
				aircraft.isVerified(), aircraft.isFreighter(), aircraft.getFirstFlightDate(), 
				aircraft.getDeliveryDate(), aircraft.getRegistrationDate(), airline, modAircraft);
	}
	
	
	

}
