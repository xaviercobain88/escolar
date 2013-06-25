/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.HerramientaEvaluacionDao;
import ec.com.webcreativa.escolar.persistence.entity.HerramientaEvaluacion;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class HerramientaEvaluacionDaoImpl extends
		GenericDaoImpl<HerramientaEvaluacion, Integer> implements
		HerramientaEvaluacionDao {

	/**
	 * 
	 */
	public HerramientaEvaluacionDaoImpl() {
		super(HerramientaEvaluacion.class);

	}

}
