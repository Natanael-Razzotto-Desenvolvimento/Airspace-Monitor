package br.com.razzotto.entrypoint;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/monitorAjax")
public class monitorAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public monitorAjax() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nome = request.getParameter("nome");
		if(request.getParameter("user").toString().equals(""))
		{
			nome="Hello User";
	    }
		  response.setContentType("text/plain");
		  response.setCharacterEncoding("UTF-8");
		  response.getWriter().write(nome);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
