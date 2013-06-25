/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.RespuestaDao;
import ec.com.webcreativa.escolar.persistence.entity.Respuesta;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class RespuestaDaoImpl extends GenericDaoImpl<Respuesta, Integer>
		implements RespuestaDao {

	/**
	 * 
	 */
	public RespuestaDaoImpl() {
		super(Respuesta.class);

	}

}
