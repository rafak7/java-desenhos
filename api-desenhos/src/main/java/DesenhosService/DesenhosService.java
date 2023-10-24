package DesenhosService;

import java.util.List;

import data.DesenhosDao;
import model.Desenhos;

public class DesenhosService {
		
	DesenhosDao dao = new DesenhosDao();
	
	public List<Desenhos> FindAll() {
		
		
		return dao.FindAll();
	}

	public Desenhos FindById(Long id) {
		return dao.findById(id);
	}

	public void delete(Desenhos desenhos) {
		// apagar no BD
		
	}

	public boolean save(Desenhos desenhos) {
		//validação
		if (desenhos.id() == null) return false;
		if (desenhos.titulo().length() < 5) return false;
		if (desenhos.sinopse().length() < 10) return false;
		
		//Inserir no BD
		return true;
		
	}

	public boolean update(Desenhos desenhos) {
		// TODO Auto-generated method stub
		return true;
	}


		

}



