/*
 */
package ec.com.webcreativa.escolar.business.facade;

import javax.ejb.Local;

import ec.com.webcreativa.escolar.persistence.entity.UnidadEducativa;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoGuardadaException;

@Local
public interface UnidadEducativaFacade {
	UnidadEducativa guardar(UnidadEducativa unidadEducativa)
			throws EntidadNoGuardadaException, EntidadNoEncontradaException;
}
