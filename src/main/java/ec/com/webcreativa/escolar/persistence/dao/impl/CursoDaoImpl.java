/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import static ec.com.webcreativa.escolar.util.QueryParameter.with;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.CursoDao;
import ec.com.webcreativa.escolar.persistence.entity.Curso;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CursoDaoImpl extends GenericDaoImpl<Curso, Integer> implements
		CursoDao {

	/**
	 * 
	 */
	public CursoDaoImpl() {
		super(Curso.class);

	}

	public List<Curso> buscarPorIdSeccion_Activo(Integer idSeccion,
			Boolean activo) throws EntidadNoEncontradaException {
		List<Curso> resultado = findByNamedQuery(
				"Curso.findByIdSeccion_Activo", with("idSeccion", idSeccion)
						.and("activo", activo).parameters());
		if (resultado != null && !resultado.isEmpty()) {
			return resultado;
		}
		
		throw new EntidadNoEncontradaException();
	}
	

}
