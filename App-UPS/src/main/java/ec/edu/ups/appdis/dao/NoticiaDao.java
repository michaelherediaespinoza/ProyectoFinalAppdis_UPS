package ec.edu.ups.appdis.dao;

import javax.ejb.Stateless;
import java.io.IOException;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
//import javax.servlet.http.Part;
import javax.servlet.http.Part;

import ec.edu.ups.appdis.model.Noticia;

@Stateless
public class NoticiaDao {

	private Part file;

	@Inject
	private EntityManager em;

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public void insertar(Noticia Noticia) {
		em.persist(Noticia);
	}

	public void delete(Noticia Noticia) {
		em.remove(Noticia);
	}

	public void deleteid(int id) {
		em.remove(read(id));
	}

	public Noticia read(int id) {
		Noticia aux = em.find(Noticia.class, id);
		return aux;

	}

	public void update(Noticia Noticia) {
		em.merge(Noticia);
	}

	public List<Noticia> getNoticias() {
		String jpql = "Select n FROM Noticia n";
		Query query = em.createQuery(jpql, Noticia.class);
		List<Noticia> lista = query.getResultList();
		return lista;

	}

	public void insertarImagen(Noticia Noticia) throws IOException {
		System.out.println("entro 1");
		int fotoSize = (int) file.getSize();
		System.out.println("tam     " + fotoSize);
		byte[] foto;
		if (fotoSize > 0) {
			foto = new byte[fotoSize];
			file.getInputStream().read(foto);
			Noticia.setFoto(foto);
			insertar(Noticia);
		}
	}

}
