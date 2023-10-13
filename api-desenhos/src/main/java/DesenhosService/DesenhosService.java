package DesenhosService;

import java.util.List;

import data.DesenhosDao;
import model.Desenhos;

public class DesenhosService {
		

	public List<Desenhos> FindAll() {
		
		DesenhosDao dao = new DesenhosDao();
		return dao.FindAll();
	}
	
	

}



