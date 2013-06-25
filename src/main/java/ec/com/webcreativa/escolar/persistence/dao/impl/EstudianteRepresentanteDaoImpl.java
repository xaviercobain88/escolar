/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.EstudianteRepresentanteDao;
import ec.com.webcreativa.escolar.persistence.entity.EstudianteRepresentante;
import ec.com.webcreativa.escolar.persistence.entity.EstudianteRepresentantePK;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class EstudianteRepresentanteDaoImpl extends
		GenericDaoImpl<EstudianteRepresentante, EstudianteRepresentantePK>
		implements EstudianteRepresentanteDao {

	/**
	 * 
	 */
	public EstudianteRepresentanteDaoImpl() {
		super(EstudianteRepresentante.class);

	}

}
