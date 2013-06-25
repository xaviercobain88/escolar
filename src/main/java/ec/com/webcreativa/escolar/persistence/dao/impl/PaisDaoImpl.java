/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.PaisDao;
import ec.com.webcreativa.escolar.persistence.entity.Pais;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class PaisDaoImpl extends GenericDaoImpl<Pais, Integer> implements
		PaisDao {

	/**
	 * 
	 */
	public PaisDaoImpl() {
		super(Pais.class);

	}

}
