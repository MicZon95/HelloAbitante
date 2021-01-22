package it.helloabitante.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.dao.DB_Mock;
import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;
import it.helloabitante.service.abitante.AbitanteService;


@WebServlet("/InserisciAbitanteServlet")
public class InserisciAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public InserisciAbitanteServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AbitanteService abitanteService = MyServiceFactory.getAbitanteServiceInstance();
		
		if (request.getParameter("nomeDaInserire")== "" && request.getParameter("cognomeDaInserire")== "" && request.getParameter("codiceFiscaleDaInserire")== ""
				&& request.getParameter("etaDaInserire")== "" && request.getParameter("mottoDaInserire")== "") {
			String messaggioDaInviareAPagina = "Attenzione! E' necessario valorizzare almeno un campo";
			request.setAttribute("messaggioDiErrore", messaggioDaInviareAPagina);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("inserimentoAbitante.jsp");
			requestDispatcher.forward(request, response);
		} else {
			String nome = request.getParameter("nomeDaInserire");
			String cognome = request.getParameter("cognomeDaInserire");
			String codiceFiscale = request.getParameter("codiceFiscaleDaInserire");
			int eta = 1;
			if(request.getParameter("etaDaInserire")!= null && request.getParameter("etaDaInserire")!="") {
				eta = Integer.parseInt(request.getParameter("etaDaInserire"));
			} 
			String motto = request.getParameter("mottoDaInserire");
			Long id = Long.valueOf((DB_Mock.LISTA_ABITANTI.size())+1);
			Abitante abitanteDaInserire = new Abitante(id, nome, cognome, codiceFiscale, eta, motto);
			try {
				abitanteService.inserisciNuovo(abitanteDaInserire);
				
				List<Abitante> listAbitantiAttributeName = abitanteService.listAll();
				request.setAttribute("listAbitantiAttributeName", listAbitantiAttributeName);
				
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("results.jsp");
				requestDispatcher.forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
			
	}
	

}
