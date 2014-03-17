package es.indra.formacion.pr.muro.service;

import es.indra.formacion.pr.muro.model.Usuario;

public interface IUsuarioService {
	public Usuario autenticar(String usuario, String clave);
}
