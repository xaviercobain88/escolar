package ec.com.webcreativa.escolar.persistence.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.com.webcreativa.escolar.persistence.dao.GenericDao;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoBorradaException;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoGuardadaException;

/**
 * @author xavier
 * 
 * @param <T>
 * @param <PK>
 */
@SuppressWarnings("unchecked")
public abstract class GenericDaoImpl<T, PK extends Serializable> implements
		GenericDao<T, PK> {

	private Class<T> type;

	@PersistenceContext(unitName = "escolarPU")
	protected EntityManager entityManager;

	/**
	 * Contructor de GenericDaoImpl
	 * 
	 * @param type
	 */
	public GenericDaoImpl(final Class<T> type) {
		this.type = type;
	}

	/*
	 * Crea una entidad
	 * 
	 * @see
	 * ec.com.webcreativa.escolar.persistencia.dao.GenericDao#create(java.lang
	 * .Object)
	 */
	public T create(final T o) throws EntidadNoGuardadaException {
		try {
			getEntityManager().persist(o);
			getEntityManager().flush();
			getEntityManager().refresh(o);
			return o;
		} catch (Exception e) {
			throw new EntidadNoGuardadaException("Entidad no guardada", e);
		}
	}

	/*
	 * Actualiza una entidad
	 * 
	 * @see
	 * ec.com.webcreativa.escolar.persistencia.dao.GenericDao#update(java.lang
	 * .Object)
	 */
	public T update(final T o) throws EntidadNoGuardadaException {
		try {
			getEntityManager().merge(o);
			return o;
		} catch (Exception e) {
			throw new EntidadNoGuardadaException("Entidad no guardada", e);
		}
	}

	/*
	 * Elimina una entidad
	 * 
	 * @see
	 * ec.com.webcreativa.escolar.persistencia.dao.GenericDao#delete(java.lang
	 * .Object)
	 */
	public void delete(T o) throws EntidadNoBorradaException {
		try {
			o = getEntityManager().merge(o);
			getEntityManager().remove(o);

		} catch (Exception e) {
			throw new EntidadNoBorradaException("Entidad no eliminada" + e);
		}
	}

	/*
	 * Elimina una entidad por PK
	 * 
	 * @see
	 * ec.com.webcreativa.escolar.persistencia.dao.GenericDao#deleteByPK(java
	 * .io.Serializable)
	 */
	public void deleteByPK(final PK pk) throws EntidadNoBorradaException {
		try {
			// getEntityManager().merge(o);
			Object ref = getEntityManager().getReference(type, pk);
			getEntityManager().remove(ref);

		} catch (Exception e) {
			throw new EntidadNoBorradaException("Entidad no eliminada" + e);
		}
	}

	/*
	 * Actualiza la entidad
	 * 
	 * @see
	 * ec.com.webcreativa.escolar.persistencia.dao.GenericDao#refresh(java.lang
	 * .Object)
	 */
	public void refresh(final T o) {
		getEntityManager().refresh(o);
	}

	/*
	 * Busca una entidad por PK
	 * 
	 * @see
	 * ec.com.webcreativa.escolar.persistencia.dao.GenericDao#findById(java.
	 * io.Serializable)
	 */
	public T findById(final PK id) throws EntidadNoEncontradaException {

		try {
			return getEntityManager().find(type, id);
		} catch (Exception e) {
			throw new EntidadNoEncontradaException();
		}
	}

	/*
	 * Busca todas las entidades, permite ordenar la busqueda
	 * 
	 * @see
	 * ec.com.webcreativa.escolar.persistencia.dao.GenericDao#findAll(java.lang
	 * .String[])
	 */
	public List<T> findAll(final String... order)
			throws EntidadNoEncontradaException {
		try {
			StringBuffer ordered = new StringBuffer("");
			ordered.append("from ").append(type.getSimpleName());
			if (order != null && order.length != 0) {
				ordered.append(" ORDER BY ");
				for (int i = 0; i < order.length; i++) {
					if (i < order.length - 1) {
						ordered.append(order[i]).append(", ");
					} else {
						ordered.append(order[i]);
					}
				}
			}

			return getEntityManager().createQuery(ordered.toString())
					.getResultList();
		} catch (Exception e) {
			throw new EntidadNoEncontradaException("Entidad no encontrada" + e);
		}
	}

	/*
	 * Busca por NamedQuery
	 * 
	 * @see
	 * ec.com.webcreativa.escolar.persistencia.dao.GenericDao#findByNamedQuery
	 * (java.lang.String)
	 */
	public List<T> findByNamedQuery(String namedQueryName)
			throws EntidadNoEncontradaException {
		try {
			return getEntityManager().createNamedQuery(namedQueryName)
					.getResultList();
		} catch (Exception e) {
			throw new EntidadNoEncontradaException("Entidad no encontrada" + e);
		}
	}

	/*
	 * Busca por NamedQuery
	 * 
	 * @see
	 * ec.com.webcreativa.escolar.persistencia.dao.GenericDao#findByNamedQuery
	 * (java.lang.String, java.util.Map)
	 */
	public List<T> findByNamedQuery(String namedQueryName,
			Map<String, Object> parameters) throws EntidadNoEncontradaException {
		try {
			return findByNamedQuery(namedQueryName, parameters, 0);
		} catch (Exception e) {
			throw new EntidadNoEncontradaException("Entidad no encontrada" + e);
		}
	}

	/*
	 * Busca por NamedQuery
	 * 
	 * @see
	 * ec.com.webcreativa.escolar.persistencia.dao.GenericDao#findByNamedQuery
	 * (java.lang.String, int)
	 */
	public List<T> findByNamedQuery(String queryName, int resultLimit)
			throws EntidadNoEncontradaException {
		try {
			return getEntityManager().createNamedQuery(queryName)
					.setMaxResults(resultLimit).getResultList();
		} catch (Exception e) {
			throw new EntidadNoEncontradaException("Entidad no encontrada" + e);
		}
	}

	/*
	 * (Busca por NamedQuery
	 * 
	 * @see
	 * ec.com.webcreativa.escolar.persistencia.dao.GenericDao#findByNamedQuery
	 * (java.lang.String, java.util.Map, int)
	 */
	public List<T> findByNamedQuery(String namedQueryName,
			Map<String, Object> parameters, int resultLimit)
			throws EntidadNoEncontradaException {
		try {
			Set<Entry<String, Object>> rawParameters = parameters.entrySet();
			Query query = getEntityManager().createNamedQuery(namedQueryName);
			if (resultLimit > 0)
				query.setMaxResults(resultLimit);
			for (Entry<String, Object> entry : rawParameters) {
				query.setParameter(entry.getKey(), entry.getValue());
			}
			return query.getResultList();
		} catch (Exception e) {
			throw new EntidadNoEncontradaException("Entidad no encontrada" + e);
		}
	}

	/**
	 * @return
	 */
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	/*
	 * Busca por NativeQuery
	 * 
	 * @see
	 * ec.com.webcreativa.escolar.persistencia.dao.GenericDao#findByNativeQuery
	 * (java.lang.String)
	 */
	public List<T> findByNativeQuery(String sql) {
		return getEntityManager().createNativeQuery(sql, type).getResultList();
	}
}