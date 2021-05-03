package br.com.razzotto.entrypoint;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.razzotto.usecase.useCaseMonitorRadar;

@WebServlet("/monitorRadar")
public class monitorRadar extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public monitorRadar() {
 
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
				try {
					new useCaseMonitorRadar(request, response).execute();
				} catch (ServletException | IOException e) {
					e.printStackTrace();
				}

		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
