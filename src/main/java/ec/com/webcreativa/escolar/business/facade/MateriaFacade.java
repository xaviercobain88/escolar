/*
 */
package ec.com.webcreativa.escolar.business.facade;

import java.util.List;

import javax.ejb.Local;

import ec.com.webcreativa.escolar.persistence.entity.Materia;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

@Local
public interface MateriaFacade {
	List<Materia> obtenerSugeridas(Integer idUe, Integer idCurso)
			throws EntidadNoEncontradaException;

	List<Materia> obtenerPorIdUe_IdCurso(Integer idUe, Integer idCurso)
			throws EntidadNoEncontradaException;
}
