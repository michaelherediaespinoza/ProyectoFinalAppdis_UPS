package ec.edu.ups.appdis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="TBL_NOTICIA")
public class Noticia {
	
	@Id
	@GeneratedValue
	@Column(name = "not_codigo")
	private int codigo;
	
	@NotNull
	@Column(name = "not_titulo")
	private  String titulo;

	@NotNull
	@Column(name = "not_descripcion")
	private String descripcion;
	
	
	private int numeLike;
	
	private String imagen;
	

	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getNumeLike() {
		return numeLike;
	}

	public void setNumeLike(int numeLike) {
		this.numeLike = numeLike;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	

}
