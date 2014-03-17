package es.indra.formacion.pr.muro.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
		@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM UsuarioII u"),
		@NamedQuery(name = "Usuario.findAllXX", query = "SELECT u FROM UsuarioII u") })
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Integer id;

	private String nombreUsuario;

	private String clave;

	private String nombreMostrado;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombreMostrado() {
		return nombreMostrado;
	}

	public void setNombreMostrado(String nombreMostrado) {
		this.nombreMostrado = nombreMostrado;
	}



}
