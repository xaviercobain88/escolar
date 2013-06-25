/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.TipoMateriaDao;
import ec.com.webcreativa.escolar.persistence.entity.TipoMateria;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class TipoMateriaDaoImpl extends GenericDaoImpl<TipoMateria, Integer>
		implements TipoMateriaDao {

	/**
	 * 
	 */
	public TipoMateriaDaoImpl() {
		super(TipoMateria.class);

	}

}
