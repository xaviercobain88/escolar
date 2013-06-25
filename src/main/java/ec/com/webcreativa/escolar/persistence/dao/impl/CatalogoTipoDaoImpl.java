/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.CatalogoTipoDao;
import ec.com.webcreativa.escolar.persistence.entity.CatalogoTipo;

/**
 * @author xavier
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class CatalogoTipoDaoImpl extends GenericDaoImpl<CatalogoTipo, Integer>
		implements CatalogoTipoDao {

	/**
	 * 
	 */
	public CatalogoTipoDaoImpl() {
		super(CatalogoTipo.class);

	}

}
