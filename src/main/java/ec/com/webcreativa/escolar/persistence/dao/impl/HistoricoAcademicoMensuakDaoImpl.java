/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.HistoricoAcademicoMensualDao;
import ec.com.webcreativa.escolar.persistence.entity.HistoricoAcademicoMensual;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class HistoricoAcademicoMensuakDaoImpl extends
		GenericDaoImpl<HistoricoAcademicoMensual, Integer> implements
		HistoricoAcademicoMensualDao {

	/**
	 * 
	 */
	public HistoricoAcademicoMensuakDaoImpl() {
		super(HistoricoAcademicoMensual.class);

	}

}
