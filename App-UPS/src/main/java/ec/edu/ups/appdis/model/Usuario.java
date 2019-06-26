package ec.edu.ups.appdis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="TBL_USUARIO")
public class Usuario {
	
	@Id
	@GeneratedValue
	@Column(name = "usu_codigo")
	private int codigo;
	
	@NotNull
	@Column(name = "usu_nombre")
	@Size(min = 4, max = 20)
	private String nombre;
	
    @NotNull
    @Size(min = 4, max = 20)
    @Column(name = "usu_apellido")
	private String apellido;
	
	@Email
	@Column(name = "per_email")
	private String correo;
	
    @NotNull
    @Size(min = 4, max = 20)
    @Column(name = "usu_password")
	private String contrasenia;

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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}
