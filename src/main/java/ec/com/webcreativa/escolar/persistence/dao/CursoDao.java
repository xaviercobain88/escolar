package ec.com.webcreativa.escolar.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.webcreativa.escolar.persistence.entity.Curso;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

@Local
public interface CursoDao extends GenericDao<Curso, Integer> {
	List<Curso> buscarPorIdSeccion_Activo(Integer idSeccion, Boolean activo)
			throws EntidadNoEncontradaException;

}
