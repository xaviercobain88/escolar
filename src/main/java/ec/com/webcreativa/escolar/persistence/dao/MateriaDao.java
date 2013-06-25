package ec.com.webcreativa.escolar.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.webcreativa.escolar.persistence.entity.Materia;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

@Local
public interface MateriaDao extends GenericDao<Materia, Integer> {

	List<Materia> buscarPorIdUe_IdCurso_Activo(Integer idUe, Integer idCurso,
			Boolean activo) throws EntidadNoEncontradaException;

	List<Materia> buscarPorIdUe_IdCursoNot_Activo(Integer idUe,
			Integer idCurso, Boolean activo)
			throws EntidadNoEncontradaException;

	List<Materia> buscarNoSugeridasNoEspecialesPorIdCurso_IdUe_Activo(
			Integer idCurso, Integer idUe, Boolean activo)
			;
	List<Materia> buscarSugeridasPorIdCurso_Activo(Integer idCurso,
			Boolean activo);
	List<Materia> buscarEspecialesPorIdCurso_IdUe_Activo(
			Integer idCurso, Integer idUe, Boolean activo) ;
}
