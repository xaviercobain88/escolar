/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.PreguntaDao;
import ec.com.webcreativa.escolar.persistence.entity.Pregunta;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class PreguntaDaoImpl extends GenericDaoImpl<Pregunta, Integer>
		implements PreguntaDao {

	/**
	 * 
	 */
	public PreguntaDaoImpl() {
		super(Pregunta.class);

	}

}
