package br.com.razzotto.services;

import java.io.IOException;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Collection;

import com.google.gson.Gson;

import br.com.razzotto.DTO.AirportGsonDTO;
import br.com.razzotto.DTO.FlightsOfAirportDTO;
import br.com.razzotto.DTO.registryAircraftDTO;

public class requestHTTPfromAPI {
	Gson gson;
	public  requestHTTPfromAPI() {
		gson = new Gson();
	}
	
	public AirportGsonDTO requestAirport(String airport) throws IOException, InterruptedException
	{
		String parameters= "/airports/";	
		HttpResponse<String> response = requestApiGet(parameters + airport);
		String objetoJson = response.body();
		System.out.println();
		AirportGsonDTO airportReturn = gson.fromJson(objetoJson, AirportGsonDTO.class);
		System.out.println(objetoJson);
		System.out.println("-----");
		System.out.println(airportReturn.getName());
		System.out.println("-----");
		return airportReturn;		
	}
	public ArrayList<FlightsOfAirportDTO> requestFromArrivalsbyAirport (String codeURL ,String codeIcao, long UnixTimeInitial, long UnixTimeFinal) throws IOException, InterruptedException {
		Type listType = new TypeToken<ArrayList<FlightsOfAirportDTO>>(){}.getType();
		String pametrosURL = String.format("/flights/%s?airport=%s&begin=%s&end=%s", codeURL,codeIcao,UnixTimeInitial,UnixTimeFinal);//		//	String parameters= "/flights/arrival?airport=EDDF&begin=1517227200&end=1517230800"; ///flights/all?begin=1617660000&end=1617663000
		HttpResponse<String> response = requestApiGetOpenSky(pametrosURL);
		String objetoJson = response.body();
		System.out.println("-----");
		System.out.println("objetoJson");
		ArrayList<FlightsOfAirportDTO> flightsOfAirport = gson.fromJson(objetoJson, listType);
		return flightsOfAirport;

	}
	public registryAircraftDTO requestFromAPIgetAircraftReg(String codeIcao) throws IOException, InterruptedException{
		String pametrosURL = String.format("/icao24/%s", codeIcao);
		System.out.println("-----MATRICULA: " + codeIcao);
		HttpResponse<String> response = requestApiGETfromAircraft(pametrosURL);
		String objetoJson = response.body();
		System.out.println("-----");
		System.out.println(objetoJson);
		registryAircraftDTO Aircraft = gson.fromJson(objetoJson, registryAircraftDTO.class);	
		return Aircraft;
		
	}
	
	public HttpResponse<String> requestApiGet(String parameters) throws IOException, InterruptedException {
		String URLhost = "https://aviation-reference-data.p.rapidapi.com";
		String urlRequest = URLhost + parameters;
		System.out.println(urlRequest);
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(urlRequest))
				.header("x-rapidapi-key", "d338480c6dmsh528e4b81f0c0fb1p192f51jsn07ed034d777d")
				.header("x-rapidapi-host", "aviation-reference-data.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response;
		
	}
	public HttpResponse<String> requestApiGetOpenSky(String parameters) throws IOException, InterruptedException {
		String URLhost = "https://opensky-network.org/api"; //
		String urlRequest = URLhost + parameters;
		System.out.println(urlRequest);
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(urlRequest))
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response;
		
	}
	public HttpResponse<String> requestApiGETfromAircraft (String parameterAircraft) throws IOException, InterruptedException
	{
		String URLhost = "https://aerodatabox.p.rapidapi.com/aircrafts";
		String urlRequest = URLhost + parameterAircraft;
		System.out.println(urlRequest);
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create(urlRequest))
				.header("x-rapidapi-key", "d338480c6dmsh528e4b81f0c0fb1p192f51jsn07ed034d777d")
				.header("x-rapidapi-host", "aerodatabox.p.rapidapi.com")
				.method("GET", HttpRequest.BodyPublishers.noBody())
				.build();
		HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
		return response;
		
	}
	


}
