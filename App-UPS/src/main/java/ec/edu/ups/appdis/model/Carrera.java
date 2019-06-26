package ec.edu.ups.appdis.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="TBL_CARRERA")
public class Carrera {
	
	@Id
	@GeneratedValue
	@Column(name = "car_codigo")
	private Integer codigo;
	
	@NotNull
	@Column(name = "car_nombre")
	@Size(min = 4, max = 20)
	private String nombre;
	
	@NotNull
	@Column(name = "car_descripcion")
	private String descripcion;
	
	private String imagen;

	@OneToMany(cascade = {CascadeType.ALL}, mappedBy="carrId")
	//@JoinColumn(name="fk_carrera_id")
	private List<Evento>evento;
	
	
	public Carrera() {
	}


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

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	
	@XmlTransient
	public List<Evento> getEvento() {
		return evento;
	}

	public void setEvento(List<Evento> evento) {
		this.evento = evento;
	}


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO Auto-generated method stub
        if (!(object instanceof Carrera)) {
            return false;
        }
        Carrera other = (Carrera) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }
	
	
	@Override
	public String toString() {
		return  nombre;
	}

	
	
	

}
