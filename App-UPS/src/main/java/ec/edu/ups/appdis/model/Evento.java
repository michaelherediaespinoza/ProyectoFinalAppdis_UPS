package ec.edu.ups.appdis.model;


import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="TBL_EVENTO")
public class Evento {
	
	@Id
	@GeneratedValue
	@Column(name = "eve_codigo")
	private int codigo;
	
	
	@Column(name = "eve_nombre")
	@Size(min = 2, max = 50)
	private String nombre;
	
	@Column(name = "eve_descripcion")
	private String descripcion;
	
	@Column(name = "eve_fechaevento")
	private String fechaEvento;

	@Column(name = "eve_image")
	private String Imagen;
	
	@Lob
	@Column(name = "eve_imagec")
	private byte[] foto;
	
	
	
	@JoinColumn(name="fk_idcarrera", referencedColumnName="car_codigo")
	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	private Carrera carrId;
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getFechaEvento() {
		return fechaEvento;
	}

	public void setFechaEvento(String fechaEvento) {
		this.fechaEvento = fechaEvento;
	}

	public String getImagen() {
		return Imagen;
	}

	public void setImagen(String imagen) {
		Imagen = imagen;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Carrera getCarrId() {
		return carrId;
	}

	public void setCarrId(Carrera carrId) {
		this.carrId = carrId;
	}

	@Override
	public String toString() {
		return "Evento [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", fechaEvento="
				+ fechaEvento + ", Imagen=" + Imagen + ", foto=" + Arrays.toString(foto) + ", carrId=" + carrId + "]";
	}
	
	
	
}
