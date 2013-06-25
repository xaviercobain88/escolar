/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.ContenidoDao;
import ec.com.webcreativa.escolar.persistence.entity.Contenido;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class ContenidoDaoImpl extends GenericDaoImpl<Contenido, Integer>
		implements ContenidoDao {

	/**
	 * 
	 */
	public ContenidoDaoImpl() {
		super(Contenido.class);

	}

}
