package es.indra.formacion.pr.muro.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseDao<T, K> implements IDao<T, K> {
	@Autowired
	@PersistenceContext // Le dice a Spring que gestione el EntityManager
	protected EntityManager em;
	protected Class<T> clase;
	
	@SuppressWarnings("unchecked")
	public BaseDao() {
		Type type = this.getClass().getGenericSuperclass();

	    if (type instanceof ParameterizedType) {
	        ParameterizedType pt = (ParameterizedType) type;
	        Type[] fieldArgTypes = pt.getActualTypeArguments();
	        clase = (Class<T>) fieldArgTypes[0];
	    }
	}
	
	@Override
	public void agregar(T obj) {
		em.persist(obj);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> obtenerTodos() {
		Query q = em.createNamedQuery(clase.getSimpleName() + ".findAll");
		return q.getResultList();
	}

	@Override
	public void modificar(T obj) {
		em.merge(obj);
	}

	@Override
	public void eliminar(K clave) {
		Query q = em.createQuery("delete from " + clase.getSimpleName() + " where id = :id");
		q.setParameter("id", clave);
		q.executeUpdate();
	}

	@Override
	public T obtener(K clave) {
		return em.find(clase, clave);
	}
	
}

