/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.OpcionPreguntaDao;
import ec.com.webcreativa.escolar.persistence.entity.OpcionPregunta;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class OpcionPreguntaDaoImpl extends
		GenericDaoImpl<OpcionPregunta, Integer> implements OpcionPreguntaDao {

	/**
	 * 
	 */
	public OpcionPreguntaDaoImpl() {
		super(OpcionPregunta.class);

	}

}
