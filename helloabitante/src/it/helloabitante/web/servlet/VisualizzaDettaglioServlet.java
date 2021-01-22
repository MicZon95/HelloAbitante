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

@WebServlet("/VisualizzaDettaglioServlet")
public class VisualizzaDettaglioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public VisualizzaDettaglioServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String parametroIdDellAbitanteDiCuiVoglioIlDettaglio = request.getParameter("idDaInviareComeParametro");
		
		
//		AbitanteService abitanteServiceInstance = MyService.... 
//		
//		Abitante result = abitanteServiceInstance.caricaSingolo(Integer.parseInt(parametroIdDellAbitanteDiCuiVoglioIlDettaglio);
//		
//		request.setAttribute("abitanteDaInviareAPaginaDettalio", result);
		
		AbitanteService abitanteService = MyServiceFactory.getAbitanteServiceInstance();
		
		Long idAbitanteScelto = Long.parseLong(request.getParameter("idDaInviareComeParametro"));
		
		try {
			Abitante abitante = abitanteService.caricaSingoloElemento(idAbitanteScelto);
			request.setAttribute("abitanteDaInviareAPaginaDettaglio", abitante);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("visualizzaDettaglioAbitante.jsp");
		requestDispatcher.forward(request, response);
		
		
		
		
		//response.getWriter().append("Volevi visualizzare abitante con id: "+parametroIdDellAbitanteDiCuiVoglioIlDettaglio).append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
