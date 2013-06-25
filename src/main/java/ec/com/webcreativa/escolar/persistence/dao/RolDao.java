package ec.com.webcreativa.escolar.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.webcreativa.escolar.persistence.entity.Rol;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

@Local
public interface RolDao extends GenericDao<Rol, Integer> {

	List<Rol> buscarPorIdUnidadEducativa(Integer idUe)
			throws EntidadNoEncontradaException;

	List<Rol> buscarPorIdUnidadEducativa_IdPersona(Integer idUe,
			Integer idPersona) throws EntidadNoEncontradaException;
}
