	package ec.edu.ups.appdis.util;

	import javax.ejb.Stateless;
	import javax.persistence.EntityManager;
	import javax.persistence.PersistenceContext;
	import ec.edu.ups.appdis.model.Carrera;;


	@Stateless
	public class CarreraFacade extends AbstractFacade<Carrera> {
	    
	    @PersistenceContext
	    private EntityManager em;

	    @Override
	    protected EntityManager getEntityManager() {
	        return em;
	    }

	    public  CarreraFacade() {
	        super(Carrera.class);
	    }

	}