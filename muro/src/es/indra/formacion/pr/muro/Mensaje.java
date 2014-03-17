package es.indra.formacion.pr.muro;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MENSAJES database table.
 * 
 */
@Entity
@Table(name="MENSAJES")
@NamedQuery(name="Mensaje.findAll", query="SELECT m FROM Mensaje m")
public class Mensaje implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=1024)
	private String contenido;

	@Temporal(TemporalType.DATE)
	@Column(name="FECHA_PUBLICACION")
	private Date fechaPublicacion;

	//bi-directional many-to-one association to Comentario
	@OneToMany(mappedBy="mensaje")
	private List<Comentario> comentarios;

	//bi-directional many-to-one association to UsuarioII
	@ManyToOne
	@JoinColumn(name="USUARIO_ID", nullable=false)
	private UsuarioII usuarioII;

	public Mensaje() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContenido() {
		return this.contenido;
	}

	public void setContenido(String contenido) {
		this.contenido = contenido;
	}

	public Date getFechaPublicacion() {
		return this.fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public List<Comentario> getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public Comentario addComentario(Comentario comentario) {
		getComentarios().add(comentario);
		comentario.setMensaje(this);

		return comentario;
	}

	public Comentario removeComentario(Comentario comentario) {
		getComentarios().remove(comentario);
		comentario.setMensaje(null);

		return comentario;
	}

	public UsuarioII getUsuario() {
		return this.usuarioII;
	}

	public void setUsuario(UsuarioII usuarioII) {
		this.usuarioII = usuarioII;
	}

}