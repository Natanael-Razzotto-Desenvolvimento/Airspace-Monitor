package br.com.razzotto.DTO;

import java.util.ArrayList;

import br.com.razzotto.entity.Airline;
import br.com.razzotto.entity.Airport;
import br.com.razzotto.entity.modelAircraft;
import br.com.razzotto.entity.registryAircraft;

public class analyticOfFlights_DTO {
	public Airport airportSelect;
	public ArrayList<Airline> companhiasAereas;
	public ArrayList<modelAircraft> modelosAeronaves;
	
	public analyticOfFlights_DTO() {
		companhiasAereas = new ArrayList<Airline>();
		modelosAeronaves = new ArrayList<modelAircraft>();
		
	}
	public void atualizarRegistroModelos (modelAircraft aircratReg) {
		boolean encontrado = false;
		for (int i = 0; i < modelosAeronaves.size(); i++) {
			if (modelosAeronaves.get(i).getIataCodeLong().equals(aircratReg.getIataCodeLong()))
			{
				modelosAeronaves.set(i, aircratReg);
				encontrado = true;				
			}	
		}
		if(!encontrado) {
			modelosAeronaves.add(aircratReg);			
		}
	}
	public void atualizarCompanhias (Airline airline) {
		boolean encontrado = false;
		for (int i = 0; i < companhiasAereas.size(); i++) {
			if (companhiasAereas.get(i).getAirlineId().equals(airline.getAirlineId()))
			{
				companhiasAereas.set(i, airline);
				encontrado = true;				
			}	
		}
		if(!encontrado) {
			companhiasAereas.add(airline);			
		}
	}
	public Airline searchAirline(String idAirline) {
		if (!companhiasAereas.equals(null)) {
			for (Airline airline : companhiasAereas) 
			{
				if(airline.getAirlineId().equals(idAirline))
				{
					return airline;				
				}
			}
			return null;
		}
		else {
			return null;
			
		}
	}
	public modelAircraft searchModelAicraft(String idAicraft) {
		for (modelAircraft aicraft : modelosAeronaves) 
		{
			if(aicraft.getTypeName().equals(idAicraft))
			{
				return aicraft;
				
			}
		}
		return null;
	}
	

}
