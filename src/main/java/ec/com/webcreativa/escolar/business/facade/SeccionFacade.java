/*
 */
package ec.com.webcreativa.escolar.business.facade;

import java.util.List;

import javax.ejb.Local;

import ec.com.webcreativa.escolar.persistence.entity.Seccion;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

@Local
public interface SeccionFacade {
	List<Seccion> obtenerPorIdUnidadEducativa_IdSeccionPadre(Integer idUe,
			Integer idSeccion) throws EntidadNoEncontradaException;
}
