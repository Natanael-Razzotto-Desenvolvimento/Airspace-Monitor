package br.com.razzotto.model;

import java.io.IOException;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.razzotto.services.requestHTTPfromAPI;
import br.com.razzotto.DTO.AirportGsonDTO;
import br.com.razzotto.DTO.FlightsOfAirportDTO;
import br.com.razzotto.DTO.analyticOfFlights_DTO;
import br.com.razzotto.DTO.registryAircraftDTO;
import br.com.razzotto.entity.Airport;
import br.com.razzotto.services.httpConnection;

public class Radar {

	ConversionTime convertTime;
	requestHTTPfromAPI requestHTTP;
	long initial;
	long finalt;
	public Radar() {		
		requestHTTP =  new requestHTTPfromAPI();
	}
	public analyticOfFlights_DTO iniciarRelatorioAeroporto(String airport,String dataInicio,String dataFim) throws Exception, IOException, InterruptedException
	{
		Airport airportSelect = construirAirport(airport);
		if (airportSelect!=null) {
			if ((dataInicio!=null)&&(dataInicio!=dataFim))
			{
				ConversionTime convertTime = definedHoursSearch(dataInicio,dataFim);
				System.out.println("------------filtrarVoosAeroporto-------------");
				ArrayList<FlightsOfAirportDTO> flightsOfAirportAri = requestHTTP.requestFromArrivalsbyAirport("arrival",airportSelect.getIcaoCode(), convertTime.getUnixTimeInitial(), convertTime.getUnixTimeFinal());
				ArrayList<FlightsOfAirportDTO> flightsOfAirportDep = requestHTTP.requestFromArrivalsbyAirport("departure",airportSelect.getIcaoCode(), convertTime.getUnixTimeInitial(), convertTime.getUnixTimeFinal());
				analyticOfFlights_DTO dto = filtrarVoosAeroporto(airportSelect,flightsOfAirportAri,flightsOfAirportDep);
				dto.airportSelect.setPeriodoInicial(initial);
				dto.airportSelect.setPeriodoFinal(finalt);
				return dto;
			}
			else {
				return null;				
			}
		}
		else
		{
			return null;
			//throw new Exception("Não foi informado um Aeroporto Valido");			
		}

		
	}
	public Airport construirAirport(String airport) throws IOException, InterruptedException {
		AirportGsonDTO airportJson = requestHTTP.requestAirport(airport);
		return new Airport(airportJson.getIataCode(), airportJson.getIcaoCode(), airportJson.getName(),
				airportJson.getcountryCode(), airportJson.getLatitude(),airportJson.getLongitude());
	}

	public analyticOfFlights_DTO filtrarVoosAeroporto(Airport airport ,ArrayList<FlightsOfAirportDTO> listFligthsAri, ArrayList<FlightsOfAirportDTO> listFligthsDep) throws IOException, InterruptedException {
		
		System.out.println("------------filtrarVoosAeroporto-------------");
		System.out.println(listFligthsAri.size());
		System.out.println(listFligthsDep.size());
		analyticOfFlights analytic = new analyticOfFlights(airport);
		analytic.IniciarAnalise(listFligthsAri,true);
		analyticOfFlights_DTO dto = analytic.IniciarAnalise(listFligthsDep,false);
				
		System.out.println("------------filtrarConcluida-------------");
		return dto;
	}
	public void getAircraft(String icao24) throws IOException, InterruptedException {
		registryAircraftDTO aircraft = requestHTTP.requestFromAPIgetAircraftReg(icao24);	
		
	}
	public long definedHoursSearchI(String data) {
		String arrayHoraeData[] = new String[2];
		String arrayData[] = new String[3];
		String arrayHora[] = new String[3];
		arrayHoraeData = data.split(" ");
		arrayData = arrayHoraeData[0].split("/");
		arrayHora = arrayHoraeData[1].split(":");
		return definedInitial(arrayData[2],arrayData[1],arrayData[0],arrayHora[0],arrayHora[1],arrayHora[2]);		
	}
	public long definedHoursSearchF(String data) {
		String arrayHoraeData[] = new String[2];
		String arrayData[] = new String[3];
		String arrayHora[] = new String[3];
		arrayHoraeData = data.split(" ");
		arrayData = arrayHoraeData[0].split("/");
		arrayHora = arrayHoraeData[1].split(":");
		return definedFinal(arrayData[2],arrayData[1],arrayData[0],arrayHora[0],arrayHora[1],arrayHora[2]);		
	}
	
	public ConversionTime definedHoursSearch(String dataInicio,String dataFim) {
		convertTime = new ConversionTime();
		initial= definedHoursSearchI(dataInicio);
		finalt = definedHoursSearchF(dataFim);
		
		/*010 ==  8
		024 == 20*/
		/*definedInitial(2021,4,13,22,0,0);
		definedFinal(2021,4,15,13,0,0);*/
		//definedInitial(2021,4,13,0,0,0);
		//definedFinal(2021,4,13,13,0,0);
		
		/*definedInitial(2021,4,13,0,0,0);
		definedFinal(2021,4,13,02,0,0);*/
		
		System.out.println("--------------------------");
		System.out.println(convertTime.getUnixTimeInitial());
		System.out.println(convertTime.getUnixTimeFinal());		

		return convertTime;		
		
	}
	public Date constructHour(String ano, String mes, String dia, String hora, String minutos,String seconds) throws NumberFormatException 
	{
		Calendar calendario = Calendar.getInstance();
		calendario.set(Calendar.YEAR, Integer.parseInt(ano));
		calendario.set(Calendar.MONTH, Integer.parseInt(mes) - 1);
		calendario.set(Calendar.DATE, Integer.parseInt(dia));
		calendario.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hora));
		calendario.set(Calendar.MINUTE, Integer.parseInt(minutos));
		calendario.set(Calendar.SECOND, Integer.parseInt(seconds));
		Date dataIntervalo = calendario.getTime();
		return dataIntervalo;
	}
	public long definedInitial(String ano, String mes, String dia, String hora, String minutos,String seconds)
	{
		Date dataIntervalo = constructHour(ano, mes, dia, hora, minutos,seconds);
		return convertTime.setDateInitial(dataIntervalo);		
	}
	public long definedFinal(String ano, String mes, String dia, String hora, String minutos,String seconds)
	{
		Date dataIntervalo = constructHour(ano, mes, dia, hora, minutos,seconds);
		return convertTime.setDateFinal(dataIntervalo);		
	}

}
