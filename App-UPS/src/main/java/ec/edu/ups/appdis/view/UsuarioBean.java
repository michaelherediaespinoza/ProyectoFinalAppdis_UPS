package ec.edu.ups.appdis.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.appdis.bussines.UsuarioBussines;
import ec.edu.ups.appdis.model.Usuario;

@ManagedBean
public class UsuarioBean {
	@Inject
	private UsuarioBussines ubussines;
	
	@Inject
	private FacesContext facesContext;
	
	private Usuario newUsuario;
	
	private List<Usuario> usuarios;
	
	private boolean edit =false;

	
	@PostConstruct
	public void init () {
		usuarios=ubussines.getUsuarios();
		
	}
	
public String guardar() {
		
		System.out.println(edit);
		
		try {
			if(edit==true)
				ubussines.update(newUsuario);
			else
				ubussines.save(newUsuario);
			System.out.println("registro guardado");
			return "list-usuarios?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(
            		FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            facesContext.addMessage(null, m);
            
            
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	public String borrar(int id) {
		try {
			ubussines.deleteid(id);
			System.out.println("registro eliminado");
			return "list-usuarios?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(
            		FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
            facesContext.addMessage(null, m);
            
            
			e.printStackTrace();
		}
		
		return null;
	}
	
	public String editar(Usuario u) {
		newUsuario = u;
		edit = true;
		return "create-persona";
	}
	
	
	
	
	
	public Usuario getNewUsuario() {
		return newUsuario;
	}

	public void setNewUsuario(Usuario newUsuario) {
		this.newUsuario = newUsuario;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}
	
	
	

	
	
}
