package ec.edu.ups.appdis.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import ec.edu.ups.appdis.bussines.CarreraBussines;
import ec.edu.ups.appdis.bussines.EventoBussines;
import ec.edu.ups.appdis.model.Carrera;
import ec.edu.ups.appdis.model.Evento;

@ManagedBean
public class EventoBean {
	

@Inject
private EventoBussines ebussines;

@Inject
private FacesContext facesContext;

private Evento newEvento;
private List<Evento> eventos;
private boolean edit=false;


@PostConstruct
public void init() {
	newEvento=new Evento();
	eventos=ebussines.getEventos();
}

public String guardar() {
	
	System.out.println(edit);
	
	try {
		if(edit==true)
			ebussines.update(newEvento);
		else
			ebussines.save(newEvento);
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
		ebussines.deleteid(id);
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

public String editar(Evento e) {
	newEvento = e;
	edit = true;
	return "create-evento";
}






public Evento getNewEvento() {
	return newEvento;
}


public void setNewEvento(Evento newEvento) {
	this.newEvento = newEvento;
}


public List<Evento> getEventos() {
	return eventos;
}


public void setEventos(List<Evento> eventos) {
	this.eventos = eventos;
}

public boolean isEdit() {
	return edit;
}

public void setEdit(boolean edit) {
	this.edit = edit;
}
	




}
