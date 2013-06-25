/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.DiaFestivoDao;
import ec.com.webcreativa.escolar.persistence.entity.DiaFestivo;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class DiaFestivoDaoImpl extends GenericDaoImpl<DiaFestivo, Integer>
		implements DiaFestivoDao {

	/**
	 * 
	 */
	public DiaFestivoDaoImpl() {
		super(DiaFestivo.class);

	}

}
