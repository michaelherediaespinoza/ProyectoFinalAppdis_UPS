package ec.edu.ups.appdis.ServiceRest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import ec.edu.ups.appdis.bussines.UsuarioBussines;
import ec.edu.ups.appdis.model.Usuario;

@Path("/usuarios")
public class UsuarioRest {
	@Inject
	private UsuarioBussines ubussines;
	
	
	
	@POST
	@Path("/registrar")
	@Consumes("application/json")
	@Produces("application/json")
public Response insertUsuario(Usuario usuario) {
	Response.ResponseBuilder builder=null;
	Map<String, String> data=new HashMap<>();
	
	try {
		ubussines.save(usuario);
		data.put("code", "1");
		data.put("message", "OK guardado");
		builder=Response.status(Response.Status.OK).entity(data);
		
	}
	catch(Exception e) {
		data.put("code", "99");
		data.put("message", e.getMessage());
		builder=Response.status(Response.Status.OK).entity(data);
		
		// TODO Auto-generated catch block
		e.printStackTrace();	
		
	}
	
	return builder.build();
	
	
}

@GET	
@Path("/listaru")	
@Produces("application/json")	
public List<Usuario> getUsuarios(){
	return ubussines.getUsuarios();
	
	
}


@GET	
@Path("/listarul")	
@Produces("application/json")	
public List<Usuario> getUsuariosL(@QueryParam("correo") String correo,@QueryParam("clave") String clave){
	return ubussines.getUsuariosL(correo, clave);
	
	
}
	


}
