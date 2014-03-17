package es.indra.formacion.pr.muro;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the USUARIOS database table.
 * 
 */
@Entity
@Table(name="USUARIOS")
@NamedQuery(name="UsuarioII.findAll", query="SELECT u FROM UsuarioII u")
public class UsuarioII implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=24)
	private String clave;

	@Column(name="NOMBRE_MOSTRADO", length=100)
	private String nombreMostrado;

	@Column(nullable=false, length=64)
	private String usuario;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="usuario")
	private List<Comentario> comentarios;

	//bi-directional many-to-one association to Mensaje
	@OneToMany(mappedBy="usuario")
	private List<Mensaje> mensajes;

	//bi-directional many-to-many association to UsuarioII
	@ManyToMany
	@JoinTable(
		name="RELACIONES"
		, joinColumns={
			@JoinColumn(name="USUARIO_ID", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="AMIGO_ID", nullable=false)
			}
		)
	private List<UsuarioII> amigos1;

	//bi-directional many-to-many association to UsuarioII
	@ManyToMany(mappedBy="amigos1")
	private List<UsuarioII> amigos2;

	public UsuarioII() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClave() {
		return this.clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getNombreMostrado() {
		return this.nombreMostrado;
	}

	public void setNombreMostrado(String nombreMostrado) {
		this.nombreMostrado = nombreMostrado;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario addComentario(Comentario comentario) {
		getComentarios().add(comentario);
		comentario.setUsuario(this);

		return comentario;
	}

	public Comentario removeComentario(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setUsuario(null);

		return comentario;
	}

	public List<Mensaje> getMensajes() {
		return this.mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	public Mensaje addMensaje(Mensaje mensaje) {
		getMensajes().add(mensaje);
		mensaje.setUsuario(this);

		return mensaje;
	}

	public Mensaje removeMensaje(Mensaje mensaje) {
		getMensajes().remove(mensaje);
		mensaje.setUsuario(null);

		return mensaje;
	}

	public List<UsuarioII> getAmigos1() {
		return this.amigos1;
	}

	public void setAmigos1(List<UsuarioII> amigos1) {
		this.amigos1 = amigos1;
	}

	public List<UsuarioII> getAmigos2() {
		return this.amigos2;
	}

	public void setAmigos2(List<UsuarioII> amigos2) {
		this.amigos2 = amigos2;
	}

}