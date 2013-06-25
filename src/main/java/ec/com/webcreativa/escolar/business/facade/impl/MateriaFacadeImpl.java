/*
 */
package ec.com.webcreativa.escolar.business.facade.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.business.facade.MateriaFacade;
import ec.com.webcreativa.escolar.persistence.dao.CursoDao;
import ec.com.webcreativa.escolar.persistence.dao.MateriaDao;
import ec.com.webcreativa.escolar.persistence.entity.Materia;
import ec.com.webcreativa.escolar.persistence.enums.TipoMateriaEnum;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.util.BaseUtils;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class MateriaFacadeImpl extends BaseUtils implements MateriaFacade {

	@EJB
	MateriaDao materiaDao;
	@EJB
	CursoDao cursoDao;

	public List<Materia> obtenerPorIdUe_IdCurso(Integer idUe, Integer idCurso)
			throws EntidadNoEncontradaException {
		List<Materia> resultadoList = materiaDao.buscarPorIdUe_IdCurso_Activo(
				idUe, idCurso, true);
		// Si no tiene materias asignadas al curso se retorna las materias
		// sugeridas

		if (listaLLena(resultadoList)) {
			Collections.sort(resultadoList);
			return resultadoList;
		} else {
			List<Materia> materiasSigeridasList = materiaDao
					.buscarSugeridasPorIdCurso_Activo(idCurso, true);
			if (listaLLena(materiasSigeridasList)) {
				for (Materia materia : materiasSigeridasList) {
					materia.setTipoMateriaEnum(TipoMateriaEnum.SUGERIDA);
				}
				Collections.sort(materiasSigeridasList);
				return materiasSigeridasList;
			}
			return null;

		}

	}

	public List<Materia> obtenerSugeridas(Integer idUe, Integer idCurso)
			throws EntidadNoEncontradaException {
		List<Materia> resultadoSugeridas = materiaDao
				.buscarPorIdUe_IdCurso_Activo(idUe, idCurso, true);
		// Si no tiene materias asignadas al curso no agrego materias sugeridas
		// puesto q se agrega en obtenerPorIdUe_IdCurso
		if (listaLLena(resultadoSugeridas)) {
			resultadoSugeridas = materiaDao.buscarSugeridasPorIdCurso_Activo(
					idCurso, true);
		} else {
			resultadoSugeridas = null;
		}
		List<Materia> resultadoEspeciales = materiaDao
				.buscarEspecialesPorIdCurso_IdUe_Activo(idCurso, idUe, true);

		List<Materia> resultadoOtras = materiaDao
				.buscarNoSugeridasNoEspecialesPorIdCurso_IdUe_Activo(idCurso,
						idUe, true);

		List<Materia> resultadoList = new ArrayList<Materia>();
		if (listaLLena(resultadoSugeridas)) {
			for (Materia materia : resultadoSugeridas) {
				materia.setTipoMateriaEnum(TipoMateriaEnum.SUGERIDA);
			}
			resultadoList.addAll(resultadoSugeridas);
		}
		if (listaLLena(resultadoEspeciales)) {
			for (Materia materia : resultadoEspeciales) {
				materia.setTipoMateriaEnum(TipoMateriaEnum.ESPECIAL);
			}
			resultadoList.addAll(resultadoEspeciales);
		}
		if (listaLLena(resultadoOtras)) {
			for (Materia materia : resultadoOtras) {
				materia.setTipoMateriaEnum(TipoMateriaEnum.OTRA);
			}
			resultadoList.addAll(resultadoOtras);
		}
		Collections.sort(resultadoList);
		return resultadoList;
	}

	public void guardarMateriasCurso(List<Materia> materiasList) {

	}

}
