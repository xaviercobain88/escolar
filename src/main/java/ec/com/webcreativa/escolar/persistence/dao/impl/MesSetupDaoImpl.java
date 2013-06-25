/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.MesSetupDao;
import ec.com.webcreativa.escolar.persistence.entity.MesSetup;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class MesSetupDaoImpl extends GenericDaoImpl<MesSetup, Integer>
		implements MesSetupDao {

	/**
	 * 
	 */
	public MesSetupDaoImpl() {
		super(MesSetup.class);

	}

}
