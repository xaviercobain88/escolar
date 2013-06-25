/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.RecursoDao;
import ec.com.webcreativa.escolar.persistence.entity.Recurso;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class RecursoDaoImpl extends GenericDaoImpl<Recurso, Integer> implements
		RecursoDao {

	/**
	 * 
	 */
	public RecursoDaoImpl() {
		super(Recurso.class);

	}

}
