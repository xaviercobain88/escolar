/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.DatosRepresentanteDao;
import ec.com.webcreativa.escolar.persistence.entity.DatosRepresentante;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class DatosRepresentanteDaoImpl extends
		GenericDaoImpl<DatosRepresentante, Integer> implements
		DatosRepresentanteDao {

	/**
	 * 
	 */
	public DatosRepresentanteDaoImpl() {
		super(DatosRepresentante.class);

	}

}
