package ec.edu.ups.appdis.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ec.edu.ups.appdis.dao.EventoDao;
import ec.edu.ups.appdis.model.Evento;

@Stateless
public class EventoBussines {

	@Inject
	private EventoDao edao;
	
	
	public void save(Evento evento) throws Exception {
		//Carrera aux = cdao.read(carrera.getCodigo());
		//if(aux!=null)
			//throw new Exception("Carrera ya registrada");
		//else
			//edao.insertar(evento);
			edao.insertarImagen(evento);
	}
	
	public List<Evento>getEventos(){
		return edao.getEventos();
	}
	
	public void deleteid(int id) throws Exception {
		Evento aux = edao.read(id);
		if(aux==null)
			throw new Exception("Registro no existe");
		else
			edao.deleteid(id);
	}
	
	public void update(Evento evento) throws Exception {
	Evento aux = edao.read(evento.getCodigo());
		if(aux==null)
			throw new Exception("Registro no existe");
		else
			edao.update(evento);
	}

	public EventoDao getEdao() {
		return edao;
	}

	public void setEdao(EventoDao edao) {
		this.edao = edao;
	}
	

	
}
