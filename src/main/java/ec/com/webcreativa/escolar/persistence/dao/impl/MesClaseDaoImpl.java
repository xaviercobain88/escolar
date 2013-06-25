/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.MesClaseDao;
import ec.com.webcreativa.escolar.persistence.entity.MesClase;
import ec.com.webcreativa.escolar.persistence.entity.MesClasePK;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class MesClaseDaoImpl extends GenericDaoImpl<MesClase, MesClasePK>
		implements MesClaseDao {

	/**
	 * 
	 */
	public MesClaseDaoImpl() {
		super(MesClase.class);

	}

}
