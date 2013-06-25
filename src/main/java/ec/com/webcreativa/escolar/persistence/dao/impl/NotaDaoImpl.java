/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.NotaDao;
import ec.com.webcreativa.escolar.persistence.entity.Nota;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class NotaDaoImpl extends GenericDaoImpl<Nota, Integer> implements
		NotaDao {

	/**
	 * 
	 */
	public NotaDaoImpl() {
		super(Nota.class);

	}

}
