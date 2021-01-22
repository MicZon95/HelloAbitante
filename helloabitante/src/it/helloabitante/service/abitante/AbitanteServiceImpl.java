package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public class AbitanteServiceImpl implements AbitanteService {

	private AbitanteDAO abitanteDAO;

	public void setAbitanteDAO(AbitanteDAO abitanteDAO) {
		this.abitanteDAO = abitanteDAO;
	}

	@Override
	public List<Abitante> cercaPerNomeECognome(String nome, String cognome) {
		// abitanteDAO.setConnection(MyConnection.getConnection());
		return abitanteDAO.findByNomeAndCognome(nome, cognome);
	}

	@Override
	public List<Abitante> listAll() throws Exception {
		return abitanteDAO.list();
	}

	@Override
	public Abitante caricaSingoloElemento(Long id) throws Exception {
		return abitanteDAO.get(id);
	}

	@Override
	public int aggiorna(Abitante abitanteInstance) throws Exception {
		return abitanteDAO.update(abitanteInstance);
		
	}

	@Override
	public int inserisciNuovo(Abitante abitanteInstance) throws Exception {
		return abitanteDAO.insert(abitanteInstance);
		
	}

	@Override
	public int rimuovi(Abitante abitanteInstance) throws Exception {
		return abitanteDAO.delete(abitanteInstance);
		
	}

}
