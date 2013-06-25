/*
 */
package ec.com.webcreativa.escolar.business.facade;

import java.util.List;

import javax.ejb.Local;

import ec.com.webcreativa.escolar.persistence.entity.Rol;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

@Local
public interface RolFacade {
	List<Integer> obtenerIdPorUsuario(String usuario)
			throws EntidadNoEncontradaException;

	List<Rol> obtenerPorIdUnidadEducativa(Integer idUe)
			throws EntidadNoEncontradaException;

	List<Rol> obtenerPorIdUnidadEducativa_IdPersona(Integer idUe,
			Integer idPersona) throws EntidadNoEncontradaException;
}
