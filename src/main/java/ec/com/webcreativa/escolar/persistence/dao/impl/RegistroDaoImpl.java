/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.RegistroDao;
import ec.com.webcreativa.escolar.persistence.entity.Registro;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class RegistroDaoImpl extends GenericDaoImpl<Registro, Integer>
		implements RegistroDao {

	/**
	 * 
	 */
	public RegistroDaoImpl() {
		super(Registro.class);

	}

}
