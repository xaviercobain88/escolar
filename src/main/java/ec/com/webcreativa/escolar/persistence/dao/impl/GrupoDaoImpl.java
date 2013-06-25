/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.GrupoDao;
import ec.com.webcreativa.escolar.persistence.entity.Grupo;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class GrupoDaoImpl extends GenericDaoImpl<Grupo, Integer> implements
		GrupoDao {

	/**
	 * 
	 */
	public GrupoDaoImpl() {
		super(Grupo.class);

	}

}
