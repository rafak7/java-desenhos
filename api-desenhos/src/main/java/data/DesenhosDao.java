package data;

import java.util.ArrayList;
import java.util.List;

import model.Desenhos;

public class DesenhosDao {
	
	List <Desenhos> desenhos = new ArrayList<>();
		
	public DesenhosDao() {
		desenhos.add(
			new Desenhos(
					1L,
					"Super Choque",
					"Mano que ficou em choque",
					"http://"
					)	
				);
	}
		public List<Desenhos> FindAll(){
			return desenhos;
	}

		public Desenhos findById(Long id) {
			//SELECT *FROM DESENHOS WHERE ID=?*
			return desenhos
							.stream()
							.filter(desenho -> desenho.id() == id )  
							.findFirst()
							.orElse(null);
		}
	
}