/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.MatriculaDao;
import ec.com.webcreativa.escolar.persistence.entity.Matricula;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class MatriculaDaoImpl extends GenericDaoImpl<Matricula, Integer>
		implements MatriculaDao {

	/**
	 * 
	 */
	public MatriculaDaoImpl() {
		super(Matricula.class);

	}

}
