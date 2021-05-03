<%@page import="br.com.razzotto.entity.modelAircraft"%>
<%@page import="br.com.razzotto.DTO.analyticOfFlights_DTO"%>
<%@page import="br.com.razzotto.entity.registryAircraft"%>
<%@page import="br.com.razzotto.entity.Airline"%>
<%@page import="br.com.razzotto.entity.Flight"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- CSS only -->
		<link rel="stylesheet" type="text/css" href="styles/style.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
 		<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.js"></script>
	    <script src="./scripts/flightmonitor.js"></script>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
		<script src="https://polyfill.io/v3/polyfill.min.js?features=default"></script>
		
</head>
<body>
	<%
		String listCompanhias = "";
		analyticOfFlights_DTO analise = null;
		analise = (analyticOfFlights_DTO) request.getAttribute("respostaAnalytic");

	%>
	<div style="background-color: black;">
		<h1>Flight Monitor</h1>
	</div>

		<form id="myform" action="monitorRadar" method="get">
			<div style="width: 100%;">
					 <div class="divPrimary" >			 
					 <label for="codigo_IataIcao" class="form-label">Consulte um Determinado Aeroporto pelo Codigo ICAO E IATA</label>
						<div class="input-group mb-3">
						  <input id="inputCodigo"type="text" class="form-control" name="codigo_IataIcao" placeholder="Insira o código do Aeroporto Desejado" >
						  <div class="input-group-append">
							<input id="btnConsulta" type="submit" class="btn btn-primary"  style="display: inline-block;" value="Consultar">
						  </div>
					 </div>
					  <label for="codigo_DateInicio" class="form-label" >Insira uma Data de Inicio</label>
				  	  <input type="text" id="inputDateI" class="form-label" name="codigo_DateInicio">
  					  <label for="codigo_DateInicio" class="form-label">Insira uma Data de Fim</label>
				  	  <input type="text" id="inputDateF" class="form-label" name="codigo_DateFim">

					</div>
				</div>
		</form>
	</div>
	<div>

   	<div id="loading" style="display: none;">
		<h4>Carregando...</h4>
		 <img src="http://cdnjs.cloudflare.com/ajax/libs/semantic-ui/0.16.1/images/loader-large.gif" alt="processing..." />
	</div>
    
    <div id="Description">
 
    <%
    	if ((analise != null))
    	{
    		if(analise.airportSelect != null){
	%>
			<table style="margin: 0 auto;">
				<tr>
					<td>Nome do Aerodromo: </td>
					<td><%=analise.airportSelect.getName()%></td>
				</tr>
				<tr>
					<td>Código ICAO: </td>
					<td><%=analise.airportSelect.getIcaoCode() %></td>
				</tr>
				<tr>
					<td>Código IATA: </td>
					<td><%=analise.airportSelect.getIataCode() %></td>
				</tr>
				<tr>
					<td>Sigla do Pais: </td>
					<td><%=analise.airportSelect.getCountryCode() %></td>
				</tr>
				<tr>
					<td>Latitude: </td>
					<td><%=analise.airportSelect.getLatitude() %></td>
				</tr>
				<tr>
					<td>Longitude: </td>
					<td><%=analise.airportSelect.getLongitude() %></td>
				</tr>
				<tr>
					<td>PeriodoInicial: </td>
					<td><%=analise.airportSelect.getPeriodoInicial()%></td>
				</tr>
				<tr>
					<td>Periodo Final: </td>
					<td><%=analise.airportSelect.getPeriodoFinal()%></td>
				</tr>
				
			</table>
	<%    			
    		}    		
	%>
	</div>

    <div id="Content"> 

    	<div>   	
			<label class="subtitulo">
				Durante o Período Especificado, <%=analise.companhiasAereas.size() %> companhias realizaram vôos para este aeroporto,
				e um total de, <%=analise.modelosAeronaves.size() %> modelos de aeronaves.
			</label>
		</div>
		<div>
    		<%
    			for(Airline airline : analise.companhiasAereas){
  			%>		
			<div class="divComponente">
				<table class="ComponentePai">
					<tr>
						<td style="width: 15%">
						<label class="indicativoAirline"><%= airline.getAirlineName()%></label>
							</br>
							</br>
							<%="Arrival:" + (airline.searchVoosGeneroArrival()) %>
							<%="Departure:" + (airline.searchVoosGeneroDeparture()) %>
						</td>
						<td>
							<%
  								ArrayList<Flight> listaVoos = airline.getVoosCompanhia();
  			    				for(Flight flightList : listaVoos)
  			    				{
  			    					//modelAircraft modelo = aircraftFrota.getModeloAircraft();
		    				%>	
		    					<table class="ComponenteMatricula">
   										<tr>
											<th>INDICATIVO DE VÔO</th>
											<th>DESCRIÇÃO DE VÔO</th>
											<th>REGISTRO DE AERONAVE</th>
											<th>MODELO DE AERONAVE</th>
										</tr>
			    						<tr>
			    							<td style="width: 15%">
			    								<label class="indicativo"><%=(flightList.getEstDepartureAirport()!=null)?flightList.getEstDepartureAirport():"N/A"%></label>
			    								>>>
			    								<label class="indicativo"><%=(flightList.getEstArrivalAirport()!=null)?flightList.getEstArrivalAirport():"N/A"%></label>
			    							</td>
			    							<td style="width: 25%">
				    							<ul>
					    							<li>Código ICAO: <%=(flightList.getIcao24()!=null)?flightList.getIcao24(): "N/A" %></li>
					    							<li>Código Callsing:<%=(flightList.getCallsign()!=null)?flightList.getCallsign(): "N/A"%></li>
					    							<li>Acionamento (Estimado): <%=(flightList.getFirstSeen()!=null)?flightList.getformatFirstSeen(): "N/A"%></li>
													<li>Chegada (Estimado): <%=(flightList.getLastSeen()!=null)?flightList.getFormatLastSeen(): "N/A"%></li>
													<li>Tempo Total (Estimado): <%=(flightList.setTempoDecorrido()==true)?flightList.getTempoDecorrido(): "N/A"%></li>	
 													<li>Distância do p. Partida: <%=(flightList.getEstDepartureAirportHorizDistance()!=0)?flightList.getEstDepartureAirportHorizDistance(): "N/A"%></li>	
												</ul>
			    							</td>			    			
			    							<td style="width: 20%">
   											<%
		    								if(flightList.getAeronaveFrota()!=null)
		    								{
		    									registryAircraft registro = flightList.getAeronaveFrota();
			    							%>
			    								<ul>
					    							<li>Código Registro: <%=(registro.getReg()!=null)?registro.getReg(): "N/A"%></li>
					    							<li>Código Icao(hex): <%=(registro.getHexIcao()!=null)? registro.getHexIcao():"N/A"%></li>
					    							<li>Código Serial: <%=(registro.getSerial()!=0)? registro.getSerial():"N/A" %></li>
					    							<li> Anos de Operação: <%=(registro.getAgeYears()!=null)? registro.getAgeYears():"N/A" %></li>
					    							<li> Numero de Assentos: <%=(registro.getNumSeats()!=0)? registro.getNumSeats():"N/A" %></li>
					    							<li> Cargueiro: <%=registro.isFreighter() %></li>
					    							<li> Em Atividade: <%=registro.isActive() %></li>	 
					    							<li> Data da entrega: <%=(registro.getDeliveryDate()!=null)? registro.getDeliveryDate():"N/A" %></li>
					    							<li> Data do Registro: <%=(registro.getRegistrationDate()!=null)? registro.getRegistrationDate():"N/A"%></li>
					    							   								
												</ul>
											<%
		    								}
											%>
			    							</td>
			    							<td style="width: 20%">
			    							<%		    						
			    							if(flightList.getAeronaveFrota().getModeloAircraft()!=null)
		    								{
		    									modelAircraft modelo = flightList.getAeronaveFrota().getModeloAircraft();
			    							
			    							%>
				    							<ul>
					    							<li>Modelo: <%=(modelo.getModel()!=null)?modelo.getModel():""%></li>
					    							<li>Código Modelo: <%=(modelo.getModelCode()!=null)?modelo.getModelCode():""%></li>
					    							<li>Linha de Produção: <%=(modelo.getProductionLine()!=null)?modelo.getProductionLine():""%></li>
					    							<li>Nome: <%=(modelo.getTypeName()!=null)?modelo.getTypeName():"" %></li>
					    							<li>Codigo IATA:<%=(modelo.getIataCodeLong()!=null)?modelo.getIataCodeLong():""%></li>
					    							<li>Codigo IATA(short): <%=(modelo.getIataCodeShort()!=null)? modelo.getIataCodeShort():""%></li>	
					    							<li>Motores: <%=(modelo.getEngineType()!=null)?modelo.getEngineType():""%></li>		   								
													<li>Quantidade de Motores:<%=modelo.getNumEngines()%></li>
												</ul>
											<%
			    							}
											%>
											</td>

											
		    							</tr>
		    					</table> 		
		    					<%
  			    				}
		    					%>
						</td>
 			    	</tr>
				</table>
    		</div> 
	    		<%
				}   							
				%>
		</div>	
    </div>
	<%
    	}
	%>
</body>
</html>