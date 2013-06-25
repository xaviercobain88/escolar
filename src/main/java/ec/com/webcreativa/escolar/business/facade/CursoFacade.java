/*
 */
package ec.com.webcreativa.escolar.business.facade;

import java.util.List;

import javax.ejb.Local;

import ec.com.webcreativa.escolar.persistence.entity.Curso;
import ec.com.webcreativa.escolar.persistence.entity.Materia;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoGuardadaException;

@Local
public interface CursoFacade {
	List<Curso> obtenerPorIdSeccion(Integer idSeccion)
			throws EntidadNoEncontradaException;

	Curso guardarConMaterias(List<Materia> materiasList, Integer idCurso) throws EntidadNoGuardadaException, EntidadNoEncontradaException;
}
