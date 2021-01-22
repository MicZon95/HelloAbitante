package it.helloabitante.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;
import it.helloabitante.service.abitante.AbitanteService;


@WebServlet("/ModificaAbitanteServlet")
public class ModificaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ModificaAbitanteServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AbitanteService abitanteService = MyServiceFactory.getAbitanteServiceInstance();
		
		try {
			
			Abitante abitanteModificato = abitanteService.caricaSingoloElemento(Long.parseLong(request.getParameter("idAbitante")));
			if (request.getParameter("nomeModificato").equals(abitanteModificato.getNome()) && request.getParameter("cognomeModificato").equals(abitanteModificato.getCognome())
				&&	request.getParameter("codiceFiscaleModificato").equals(abitanteModificato.getCodiceFiscale()) && request.getParameter("mottoModificato").equals(abitanteModificato.getMottoDiVita())
				&& Integer.parseInt(request.getParameter("etaModificata")) == (abitanteModificato.getEta())) {
				
				String messaggioDaInviareAPagina = "Attenzione! E' necessario cambiare almeno un campo";
				request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
				request.setAttribute("abitanteDaInviareAPaginaPreparaModifica", abitanteModificato);
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("preparaModifica.jsp");
				requestDispatcher.forward(request, response);
				
			} else {
				abitanteModificato.setCodiceFiscale(request.getParameter("codiceFiscaleModificato"));;
				abitanteModificato.setNome(request.getParameter("nomeModificato"));
				abitanteModificato.setCognome(request.getParameter("cognomeModificato"));
				abitanteModificato.setMottoDiVita(request.getParameter("mottoModificato"));
				abitanteModificato.setEta(Integer.parseInt(request.getParameter("etaModificata")));
				
				abitanteService.aggiorna(abitanteModificato);
				
				List<Abitante> listAbitantiAttributeName = abitanteService.listAll();
				
				request.setAttribute("listAbitantiAttributeName", listAbitantiAttributeName);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("results.jsp");
				requestDispatcher.forward(request, response);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
