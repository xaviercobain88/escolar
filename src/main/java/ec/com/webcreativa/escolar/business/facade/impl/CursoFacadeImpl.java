/*
 */
package ec.com.webcreativa.escolar.business.facade.impl;

import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.business.facade.CursoFacade;
import ec.com.webcreativa.escolar.persistence.dao.CursoDao;
import ec.com.webcreativa.escolar.persistence.entity.Curso;
import ec.com.webcreativa.escolar.persistence.entity.Materia;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoGuardadaException;
import ec.com.webcreativa.escolar.util.BaseUtils;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class CursoFacadeImpl extends BaseUtils implements CursoFacade {

	@EJB
	CursoDao cursoDao;

	public List<Curso> obtenerPorIdSeccion(Integer idSeccion)
			throws EntidadNoEncontradaException {
		List<Curso> resultList = cursoDao.buscarPorIdSeccion_Activo(idSeccion,
				true);
		if (listaLLena(resultList)) {
			Collections.sort(resultList);
		}
		return resultList;
	}

	public Curso guardarConMaterias(List<Materia> materiasList, Integer idCurso)
			throws EntidadNoGuardadaException, EntidadNoEncontradaException {
		Curso curso = cursoDao.findById(idCurso);
		curso.setMateriaList(materiasList);
		return cursoDao.update(curso);

	}
}
