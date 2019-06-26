package ec.edu.ups.appdis.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.dao.UsuarioDao;
import ec.edu.ups.appdis.model.Usuario;

@Stateless
public class UsuarioBussines {

	
	@Inject
	private UsuarioDao udao;
	
	public void save(Usuario usuario) {
		udao.insertar(usuario);
	}
	
	public void delete(Usuario usuario) {
		udao.delete(usuario);		
	}
	
	public void deleteid(int id) throws Exception{
		Usuario aux= udao.read(id);
		if(aux==null) 
			throw new Exception("Registro no existe");
		else	
		udao.deleteid(id);	
	}
	
	
	public void update(Usuario usuario) throws Exception {
		Usuario aux= udao.read(usuario.getCodigo());
		if(aux==null) 
			throw new Exception("Registro no existe");
		else	
			
		udao.update(usuario);		
	}
	
	
	public List<Usuario>getUsuarios(){
		return udao.getUsuarios();
	}
	
	public List<Usuario>getUsuariosL(String correol, String clavel){
		return udao.getUsuariosL(correol, clavel);
	}

	
	
	
	//GETTERS AND SETTER
	

	
	
}
