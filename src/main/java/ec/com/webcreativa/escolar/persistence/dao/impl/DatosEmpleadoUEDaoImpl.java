/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.DatosEmpleadoUEDao;
import ec.com.webcreativa.escolar.persistence.entity.DatosEmpleadoUe;
import ec.com.webcreativa.escolar.persistence.entity.DatosEmpleadoUePK;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class DatosEmpleadoUEDaoImpl extends
		GenericDaoImpl<DatosEmpleadoUe, DatosEmpleadoUePK> implements
		DatosEmpleadoUEDao {

	/**
	 * 
	 */
	public DatosEmpleadoUEDaoImpl() {
		super(DatosEmpleadoUe.class);

	}

}
