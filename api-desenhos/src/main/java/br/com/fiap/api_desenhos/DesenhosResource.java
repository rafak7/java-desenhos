package br.com.fiap.api_desenhos;

import java.util.List;

import DesenhosService.DesenhosService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Desenhos;

@Path("desenhos")
public class De senhosResource {
	
	DesenhosService service = new DesenhosService();
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Desenhos> index() {
        return service.FindAll(); 
    }
}

