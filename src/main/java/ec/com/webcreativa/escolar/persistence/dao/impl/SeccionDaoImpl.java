/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import static ec.com.webcreativa.escolar.util.QueryParameter.with;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.SeccionDao;
import ec.com.webcreativa.escolar.persistence.entity.Seccion;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class SeccionDaoImpl extends GenericDaoImpl<Seccion, Integer> implements
		SeccionDao {

	/**
	 * 
	 */
	public SeccionDaoImpl() {
		super(Seccion.class);

	}

	public List<Seccion> buscarPorIdUnidadEducativa_IdSeccionPadre(
			Integer idUe, Integer idSeccion, Boolean activo)
			throws EntidadNoEncontradaException {
		System.out.println("*******paramnetros"+idUe+"-"+idSeccion+"-"+activo);
		String namedQuery;
		List<Seccion> resultado;
		if (idSeccion != null) {
			namedQuery = "Seccion.findByIdUe_idSeccionPadre_Activo";
			resultado = findByNamedQuery(
					namedQuery,
					with("idUe", idUe).and("idSeccion", idSeccion)
							.and("activo", activo).parameters());
		} else {
			namedQuery = "Seccion.findByIdUe_idSeccionPadreNull_Activo";
			resultado = findByNamedQuery(namedQuery,
					with("idUe", idUe).and("activo", activo).parameters());
		}
		if (resultado != null && !resultado.isEmpty()) {
			return resultado;
		}
		throw new EntidadNoEncontradaException();
	}

}
