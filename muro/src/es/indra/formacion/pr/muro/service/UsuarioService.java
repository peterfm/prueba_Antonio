package es.indra.formacion.pr.muro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import es.indra.formacion.pr.muro.dao.IUsuarioDao;
import es.indra.formacion.pr.muro.model.Usuario;

@Transactional
public class UsuarioService implements IUsuarioService {
	@Autowired
	private IUsuarioDao userDao;

	@Override
	public Usuario autenticar(String usuario, String clave) {
		return userDao.obtener(usuario, clave);
	}

}
