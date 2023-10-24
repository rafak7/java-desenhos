package br.com.fiap.api_desenhos;

import java.util.List;

import DesenhosService.DesenhosService;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import model.Desenhos;

@Path("desenhos")
public class DesenhosResource {
	
	DesenhosService service = new DesenhosService();
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Desenhos> index() {
        return service.FindAll(); 
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByid(@PathParam("id") Long id) {
    	var desenhos = service.FindById(id);
    	    	
    	if (desenhos == null) {
    		return Response.status(404).build();
    	}
    	
    	return Response.ok(desenhos).build();
    	
    }
    
    @DELETE
	@Path("{id}")
	public Response delete(@PathParam("id") Long id) {
		var desenhos = service.FindById(id);
		
		if(desenhos == null)
			return Response.status(404).build();
		
		service.delete(desenhos);
		return Response.status(Response.Status.NO_CONTENT).build();
		
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrar(Desenhos desenhos) {
    	if (!service.save(desenhos)) {
    		return Response.status(Response.Status.BAD_REQUEST).build();
    }
    return Response.ok(desenhos).build();
    	
    }
    
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizar(@PathParam ("id") Long id, Desenhos desenhos) {
    	var desenhoEncontrado = service.FindById(id);
    	
    	if(desenhoEncontrado == null)
    		return Response.status(Response.Status.NOT_FOUND).build();
    	
    	if (!service.update(desenhos))
    		return Response.status(Response.Status.BAD_REQUEST).build();
    	
    	return Response.ok(desenhos).build();
    	
    }
    
}
