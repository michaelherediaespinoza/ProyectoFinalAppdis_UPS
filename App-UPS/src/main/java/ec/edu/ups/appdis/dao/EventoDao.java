package ec.edu.ups.appdis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
//import javax.servlet.http.Part;

import ec.edu.ups.appdis.model.Evento;


@Stateless
public class EventoDao {
	// private Part file;
	
	@Inject
	private EntityManager em;
	
	/*
	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	*/
	
	public void insertar(Evento evento) {
		em.persist(evento);
		}

		public void delete(Evento evento) {
			em.remove(evento);	
		}

		public void deleteid(int id) {
			em.remove(read(id));	
		}

		public Evento read(int id) {
			Evento aux=em.find(Evento.class, id);
			return aux;
			
		}

		public void update(Evento evento) {
			em.merge(evento);	
		}


		public List<Evento>getEventos(){
			String jpql="Select e FROM Evento e";
			Query query=em.createQuery(jpql, Evento.class);
			List<Evento> lista=query.getResultList();
			return lista;
				
		}


	

}
