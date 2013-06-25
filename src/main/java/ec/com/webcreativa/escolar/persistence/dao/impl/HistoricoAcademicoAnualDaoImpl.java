/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.HistoricoAcademicoAnualDao;
import ec.com.webcreativa.escolar.persistence.entity.HistoricoAcademicoAnual;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class HistoricoAcademicoAnualDaoImpl extends
		GenericDaoImpl<HistoricoAcademicoAnual, Integer> implements
		HistoricoAcademicoAnualDao {

	/**
	 * 
	 */
	public HistoricoAcademicoAnualDaoImpl() {
		super(HistoricoAcademicoAnual.class);

	}

}
