package es.indra.formacion.pr.muro;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the COMENTARIOS database table.
 * 
 */
@Entity
@Table(name="COMENTARIOS")
@NamedQuery(name="Comentario.findAll", query="SELECT c FROM Comentario c")
public class Comentario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private Integer id;

	@Column(nullable=false, length=1024)
	private String contenido;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FECHA_PUBLICACION")
	private Date fechaPublicacion;

	//bi-directional many-to-one association to Mensaje
	@ManyToOne
	@JoinColumn(name="MENSAJE_ID", nullable=false)
	private Mensaje mensaje;

	//bi-directional many-to-one association to UsuarioII
	@ManyToOne
	@JoinColumn(name="USUARIO_ID", nullable=false)
	private UsuarioII usuarioII;

	public Comentario() {
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

	public Mensaje getMensaje() {
		return this.mensaje;
	}

	public void setMensaje(Mensaje mensaje) {
		this.mensaje = mensaje;
	}

	public UsuarioII getUsuario() {
		return this.usuarioII;
	}

	public void setUsuario(UsuarioII usuarioII) {
		this.usuarioII = usuarioII;
	}

}