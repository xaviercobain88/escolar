/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.HerramientaClaseAgrupacionDao;
import ec.com.webcreativa.escolar.persistence.entity.HerramientaClaseAgrupacion;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class HerramientaClaseAgrupacionDaoImpl extends
		GenericDaoImpl<HerramientaClaseAgrupacion, Integer> implements
		HerramientaClaseAgrupacionDao {

	/**
	 * 
	 */
	public HerramientaClaseAgrupacionDaoImpl() {
		super(HerramientaClaseAgrupacion.class);

	}

}
