package es.indra.formacion.pr.muro.dao;

import es.indra.formacion.pr.muro.model.Usuario;

public interface IUsuarioDao extends IDao<Usuario, Integer> {
	public Usuario obtener(String usuario, String clave);
}
