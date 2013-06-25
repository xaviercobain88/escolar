/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.ParaleloDao;
import ec.com.webcreativa.escolar.persistence.entity.Paralelo;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class ParaleloDaoImpl extends GenericDaoImpl<Paralelo, Integer>
		implements ParaleloDao {

	/**
	 * 
	 */
	public ParaleloDaoImpl() {
		super(Paralelo.class);

	}

}
