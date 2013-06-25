/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.HerramientaClaseDao;
import ec.com.webcreativa.escolar.persistence.entity.HerramientaClase;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class HerramientaClaseDaoImpl extends
		GenericDaoImpl<HerramientaClase, Integer> implements
		HerramientaClaseDao {

	/**
	 * 
	 */
	public HerramientaClaseDaoImpl() {
		super(HerramientaClase.class);

	}

}
