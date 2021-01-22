package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;
import it.helloabitante.service.abitante.AbitanteService;


@WebServlet("/PreparaCancellazioneServlet")
public class PreparaCancellazioneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public PreparaCancellazioneServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AbitanteService abitanteService = MyServiceFactory.getAbitanteServiceInstance();
		
		Long idAbitanteScelto = Long.parseLong(request.getParameter("idDaInviareComeParametro"));
		
		try {
			Abitante abitante = abitanteService.caricaSingoloElemento(idAbitanteScelto);
			request.setAttribute("abitanteDaCancellare", abitante);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("confermaEliminazione.jsp");
		requestDispatcher.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
