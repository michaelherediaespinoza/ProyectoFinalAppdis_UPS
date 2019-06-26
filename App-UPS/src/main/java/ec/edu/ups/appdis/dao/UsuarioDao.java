package ec.edu.ups.appdis.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.model.Usuario;

@Stateless
public class UsuarioDao {

@Inject
private EntityManager em;

public void insertar(Usuario usuario) {
em.persist(usuario);
}

public void delete(Usuario usuario) {
	em.remove(usuario);	
}

public void deleteid(int id) {
	em.remove(read(id));	
}

public Usuario read(int id) {
	Usuario aux=em.find(Usuario.class, id);
	return aux;
	
}

public void update(Usuario usuario) {
	em.merge(usuario);	
}


public List<Usuario>getUsuarios(){
	String jpql="Select u FROM Usuario u";
	Query query=em.createQuery(jpql, Usuario.class);
	List<Usuario> lista=query.getResultList();
	return lista;
		
}

public List<Usuario>getUsuariosL(String correo, String clave){
	String jpql="SELECT u FROM Usuario u WHERE u.correo = ?1 AND u.contrasenia = ?2 ";
	Query query1=em.createQuery(jpql, Usuario.class);
	query1.setParameter(1, correo);
	query1.setParameter(2, clave);
	List<Usuario> listaL=query1.getResultList();
	return listaL;
	
}


}
