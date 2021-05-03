package br.com.razzotto.usecase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.razzotto.DTO.analyticOfFlights_DTO;
import br.com.razzotto.model.Radar;
import br.com.razzotto.model.analyticOfFlights;

public class useCaseMonitorRadar {

	private HttpServletRequest request;
	private HttpServletResponse response;
	
	public useCaseMonitorRadar(HttpServletRequest request, HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}
	
	public void execute() throws ServletException, IOException{
	//	RequestDispatcher requestD = request.getRequestDispatcher("FlightMonitor.jsp");
			try {
				analyticOfFlights_DTO resultRadar= this.createRadar();
				System.out.println("-----selecionado : " + resultRadar.airportSelect.getName());
				request.setAttribute("respostaAnalytic", resultRadar);	
				request.getRequestDispatcher("FlightMonitor.jsp").forward(request, response);
				
			} catch (IOException | InterruptedException e) {
				request.setAttribute("respostadeErro", "Ocorreu uma inconssistencia e não foi possivel a continuidade de execução");
				request.getRequestDispatcher("FlightMonitor.jsp").forward(request, response);
				e.printStackTrace();
			} catch (Exception e) {
				request.setAttribute("respostadeErro", e);
				request.getRequestDispatcher("FlightMonitor.jsp").forward(request, response);
				e.printStackTrace();
			}

				
	}
	public analyticOfFlights_DTO createRadar() throws Exception, IOException, InterruptedException {
		String airport = request.getParameter("codigo_IataIcao");
		airport = airport.toUpperCase().trim();		
		String dataInicio = request.getParameter("codigo_DateInicio");
		String dataFim = request.getParameter("codigo_DateFim");
		if(!(airport.isEmpty())&&!(dataInicio.isEmpty())&&!(dataFim.isEmpty())) {
		Radar radar = new Radar();
		return radar.iniciarRelatorioAeroporto(airport,dataInicio,dataFim);		
		}
		else
		{
			throw new Exception("Voce deve informar o Aeroporto e os periodos para a pesquisa");			
		}
 
	}
	public void registerSession() {
		HttpSession sessao = request.getSession(false);
		if(sessao != null) {
			List<String> listaRespostas = (List<String>) sessao.getAttribute("listaRespostas");
			if(listaRespostas == null) {
				listaRespostas = new ArrayList<String>();
			}
			
			//listaRespostas.add(resposta);
			sessao.setAttribute("listaRespostas", listaRespostas);
		}
		
	}

	
	
}
