/*
 */
package ec.com.webcreativa.escolar.business.facade.impl;

import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.business.facade.SeccionFacade;
import ec.com.webcreativa.escolar.persistence.dao.SeccionDao;
import ec.com.webcreativa.escolar.persistence.entity.Seccion;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.util.BaseUtils;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class SeccionFacadeImpl extends BaseUtils implements SeccionFacade {

	@EJB
	SeccionDao seccionDao;

	// TODO por roles guardados en sesion
	public List<Seccion> obtenerPorIdUnidadEducativa_IdSeccionPadre(
			Integer idUe, Integer idSeccion)
			throws EntidadNoEncontradaException {
		List<Seccion> resultList = seccionDao
				.buscarPorIdUnidadEducativa_IdSeccionPadre(idUe, idSeccion,
						true);
		if (listaLLena(resultList)) {
			Collections.sort(resultList);
		}

		return resultList;
	}
}
