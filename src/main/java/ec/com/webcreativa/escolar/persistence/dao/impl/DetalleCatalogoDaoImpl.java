/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.DetalleCatalogoDao;
import ec.com.webcreativa.escolar.persistence.entity.DetalleCatalogo;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class DetalleCatalogoDaoImpl extends
		GenericDaoImpl<DetalleCatalogo, Integer> implements DetalleCatalogoDao {

	/**
	 * 
	 */
	public DetalleCatalogoDaoImpl() {
		super(DetalleCatalogo.class);

	}

}
