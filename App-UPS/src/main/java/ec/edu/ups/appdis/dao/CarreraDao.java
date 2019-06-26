package ec.edu.ups.appdis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.model.Carrera;



@Stateless
public class CarreraDao {

	@Inject
	private EntityManager em;

	public void insertar(Carrera carrera) {
		em.persist(carrera);
		}

		public void delete(Carrera carrera) {
			em.remove(carrera);	
		}

		public void deleteid(int id) {
			em.remove(read(id));	
		}

		public Carrera read(int id) {
			Carrera aux=em.find(Carrera.class, id);
			return aux;
			
		}

		public void update(Carrera carrera) {
			em.merge(carrera);	
		}


		public List<Carrera>getCarreras(){
			String jpql="Select c FROM Carrera c";
			Query query=em.createQuery(jpql, Carrera.class);
			List<Carrera> lista=query.getResultList();
			return lista;
				
		}

	
	
}
