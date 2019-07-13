package ec.edu.ups.appdis.bussines;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;


import ec.edu.ups.appdis.dao.NoticiaDao;
import ec.edu.ups.appdis.model.Noticia;

@Stateless
public class NoticiaBussines {
	
	@Inject
	private NoticiaDao ndao;
	
	
	public void save(Noticia Noticia) throws Exception {
		//Carrera aux = cdao.read(carrera.getCodigo());
		//if(aux!=null)
			//throw new Exception("Carrera ya registrada");
		//else
			//ndao.insertar(Noticia);
			ndao.insertarImagen(Noticia);
	}
	
	public List<Noticia>getNoticias(){
		return ndao.getNoticias();
	}
	
	public void deleteid(int id) throws Exception {
		Noticia aux = ndao.read(id);
		if(aux==null)
			throw new Exception("Registro no existe");
		else
			ndao.deleteid(id);
	}
	
	public void update(Noticia Noticia) throws Exception {
	Noticia aux = ndao.read(Noticia.getCodigo());
		if(aux==null)
			throw new Exception("Registro no existe");
		else
			ndao.update(Noticia);
	}

	public NoticiaDao getndao() {
		return ndao;
	}

	public void setndao(NoticiaDao ndao) {
		this.ndao = ndao;
	}
	

	
}
