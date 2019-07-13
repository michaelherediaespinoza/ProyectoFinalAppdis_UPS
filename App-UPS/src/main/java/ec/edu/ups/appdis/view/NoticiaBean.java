package ec.edu.ups.appdis.view;

import javax.faces.bean.ManagedBean;
import java.util.Base64;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

//import ec.edu.ups.appdis.bussines.CarreraBussines;
import ec.edu.ups.appdis.bussines.NoticiaBussines;
//import ec.edu.ups.appdis.model.Carrera;
import ec.edu.ups.appdis.model.Noticia;

@ManagedBean
public class NoticiaBean {
	@Inject
	private NoticiaBussines ebussines;

	@Inject
	private FacesContext facesContext;

	private Noticia newNoticia;
	private List<Noticia> Noticias;
	private boolean edit = false;

	@PostConstruct
	public void init() {
		newNoticia = new Noticia();
		Noticias = ebussines.getNoticias();
	}

	public String guardar() {

		System.out.println(edit);

		try {
			if (edit == true)
				ebussines.update(newNoticia);
			else
				ebussines.save(newNoticia);
			System.out.println("registro guardado");
			//return "list-Noticias?faces-redirect=true";
			return "create-noticias?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);

			e.printStackTrace();
		}

		return null;
	}

	public String borrar(int id) {
		try {
			ebussines.deleteid(id);
			System.out.println("registro eliminado");
			//return "list-Noticias?faces-redirect=true";
			return "create-noticias?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), e.getMessage());
			facesContext.addMessage(null, m);

			e.printStackTrace();
		}

		return null;
	}

	public String editar(Noticia e) {
		newNoticia = e;
		edit = true;
		return "create-Noticia";
	}

	public String convertir(byte[] foto) {
		String bphoto = Base64.getEncoder().encodeToString(foto);
		return bphoto;
	}

	public Noticia getNewNoticia() {
		return newNoticia;
	}

	public void setNewNoticia(Noticia newNoticia) {
		this.newNoticia = newNoticia;
	}

	public List<Noticia> getNoticias() {
		return Noticias;
	}

	public void setNoticias(List<Noticia> Noticias) {
		this.Noticias = Noticias;
	}

	public boolean isEdit() {
		return edit;
	}

	public void setEdit(boolean edit) {
		this.edit = edit;
	}

	public NoticiaBussines getEbussines() {
		return ebussines;
	}

	public void setEbussines(NoticiaBussines ebussines) {
		this.ebussines = ebussines;
	}

}

