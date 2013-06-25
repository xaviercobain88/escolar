/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.OpcionRespuestaDao;
import ec.com.webcreativa.escolar.persistence.entity.OpcionRespuesta;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class OpcionRespuestaDaoImpl extends
		GenericDaoImpl<OpcionRespuesta, Integer> implements OpcionRespuestaDao {

	/**
	 * 
	 */
	public OpcionRespuestaDaoImpl() {
		super(OpcionRespuesta.class);

	}

}
