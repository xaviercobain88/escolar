/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.UnidadEducativaDao;
import ec.com.webcreativa.escolar.persistence.entity.UnidadEducativa;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class UnidadEducativaDaoImpl extends
		GenericDaoImpl<UnidadEducativa, Integer> implements UnidadEducativaDao {

	/**
	 * 
	 */
	public UnidadEducativaDaoImpl() {
		super(UnidadEducativa.class);

	}

}
