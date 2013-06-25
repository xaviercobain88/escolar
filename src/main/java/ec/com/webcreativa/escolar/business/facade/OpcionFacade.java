/*
 */
package ec.com.webcreativa.escolar.business.facade;

import java.util.List;

import javax.ejb.Local;

import ec.com.webcreativa.escolar.persistence.entity.Opcion;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

@Local
public interface OpcionFacade {

	public List<Opcion> obtenerPadresPorUsuario(String usuario)
			throws EntidadNoEncontradaException;

	List<Opcion> obtenerPorRoles_Padre(List<Integer> idRolList, Integer idOpcion)
			throws EntidadNoEncontradaException;
}
