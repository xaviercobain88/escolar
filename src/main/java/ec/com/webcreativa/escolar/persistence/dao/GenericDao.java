package ec.com.webcreativa.escolar.persistence.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import ec.com.webcreativa.escolar.persistence.exception.EntidadNoBorradaException;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoGuardadaException;


public interface GenericDao<T, PK extends Serializable> {

	T create(T o) throws EntidadNoGuardadaException;
	T update(T o) throws EntidadNoGuardadaException;
	void delete(T o) throws EntidadNoBorradaException;
	void deleteByPK(PK pk) throws EntidadNoBorradaException;
	void refresh(T o);
	T findById(PK id) throws EntidadNoEncontradaException;
	List<T> findAll(String... order)throws EntidadNoEncontradaException;
	List<T> findByNamedQuery(String queryName)throws EntidadNoEncontradaException;
    List<T> findByNamedQuery(String queryName,int resultLimit)throws EntidadNoEncontradaException;
    List<T> findByNamedQuery(String namedQueryName, Map<String,Object> parameters)throws EntidadNoEncontradaException;
    List<T> findByNamedQuery(String namedQueryName, Map<String,Object> parameters,int resultLimit)throws EntidadNoEncontradaException;
    List<T> findByNativeQuery(String sql) ;

}
