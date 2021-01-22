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

@WebServlet("/CancellazioneAbitanteServlet")
public class CancellazioneAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CancellazioneAbitanteServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AbitanteService abitanteService = MyServiceFactory.getAbitanteServiceInstance();
		
		try {
			Abitante abitanteCancellato = abitanteService.caricaSingoloElemento(Long.parseLong(request.getParameter("idAbitante")));
			
			abitanteService.rimuovi(abitanteCancellato);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("risultatoCancellazione.jsp");
		requestDispatcher.forward(request, response);
	}

}
