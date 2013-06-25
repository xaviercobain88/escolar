/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.HistoricoMateriaDao;
import ec.com.webcreativa.escolar.persistence.entity.HistoricoMateria;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class HistoricoMateriaDaoImpl extends
		GenericDaoImpl<HistoricoMateria, Integer> implements
		HistoricoMateriaDao {

	/**
	 * 
	 */
	public HistoricoMateriaDaoImpl() {
		super(HistoricoMateria.class);

	}

}
