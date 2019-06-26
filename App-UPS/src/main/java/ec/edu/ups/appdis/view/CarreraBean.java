package ec.edu.ups.appdis.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.appdis.bussines.CarreraBussines;
import ec.edu.ups.appdis.model.Carrera;



@ManagedBean
public class CarreraBean {
@Inject
private CarreraBussines cbussines;

@Inject
private FacesContext facesContext;

private Carrera newCarrera;
private List<Carrera> carreras;
private boolean edit=false;


@PostConstruct
public void init() {
	newCarrera=new Carrera();
	carreras=cbussines.getCarreras();
}

public String guardar() {
	
	System.out.println(edit);
	
	try {
		if(edit==true)
			cbussines.update(newCarrera);
		else
			cbussines.save(newCarrera);
		System.out.println("registro guardado");
		return "list-carreras?faces-redirect=true";
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
		cbussines.deleteid(id);
		System.out.println("registro eliminado");
		return "list-carreras?faces-redirect=true";
	} catch (Exception e) {
		// TODO Auto-generated catch block
		FacesMessage m = new FacesMessage(
        		FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
        facesContext.addMessage(null, m);
        
        
		e.printStackTrace();
	}
	
	return null;
}

public String editar(Carrera c) {
	newCarrera = c;
	edit = true;
	return "create-carreras";
}






public Carrera getNewCarrera() {
	return newCarrera;
}


public void setNewCarrera(Carrera newCarrera) {
	this.newCarrera = newCarrera;
}


public List<Carrera> getCarreras() {
	return carreras;
}


public void setCarreras(List<Carrera> carreras) {
	this.carreras = carreras;
}

public boolean isEdit() {
	return edit;
}

public void setEdit(boolean edit) {
	this.edit = edit;
}
	



}
