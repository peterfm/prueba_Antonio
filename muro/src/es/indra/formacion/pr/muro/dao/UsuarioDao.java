package es.indra.formacion.pr.muro.dao;

import java.util.List;

import javax.persistence.Query;

import es.indra.formacion.pr.muro.model.Usuario;

public class UsuarioDao extends BaseDao<Usuario, Integer> implements
		IUsuarioDao {

	@SuppressWarnings("unchecked")
	@Override
	public Usuario obtener(String usuario, String clave) {
		Usuario result = null;
		
		Query q = em.createQuery("SELECT u FROM Usuario u WHERE u.nombreUsuario = :usuario AND u.clave = :clave");
		q.setParameter("usuario", usuario);
		q.setParameter("clave", clave);
		
		List<Usuario> usuarios =  q.getResultList();
		if (usuarios != null && 
				usuarios.size() > 0)
			result = usuarios.get(0);
		
		return result;
	}

}
