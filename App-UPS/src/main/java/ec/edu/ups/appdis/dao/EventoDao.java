package ec.edu.ups.appdis.dao;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
//import javax.servlet.http.Part;
import javax.servlet.http.Part;

import ec.edu.ups.appdis.model.Evento;


@Stateless
public class EventoDao {
	 private Part file;
	
	@Inject
	private EntityManager em;
	

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	
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
		System.out.println("LISTAAAAAAAAAAAAAAAAAAAA "+lista);
			return lista;
				
		}
	
		/*
		
		public List<String>getEventos1(){
			String jpql="Select e FROM Evento e";
			Query query=em.createQuery(jpql, Evento.class);
			List<Evento> lista=query.getResultList();	
			String nombre;
			for (int i = 0; i < lista.size(); i++) {
				nombre=lista.get(i).getNombre();
			}
		System.out.println("LISTAAAAAAAAAAAAAAAAAAAA "+lista);
			return nombre;
				
		}
		*/
		

		public void insertarImagen(Evento evento) throws IOException {
			System.out.println("entro 1");
			int fotoSize = (int)file.getSize();
        	System.out.println("tam     "+fotoSize);
        	byte[] foto;
        	if(fotoSize>0){
        		foto = new byte [fotoSize];
			file.getInputStream().read(foto);
			evento.setFoto(foto);
			insertar(evento);
			}
        	}
		

	

}
