/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.DatosEstudianteDao;
import ec.com.webcreativa.escolar.persistence.entity.DatosEstudiante;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class DatosEstudianteDaoImpl extends
		GenericDaoImpl<DatosEstudiante, Integer> implements DatosEstudianteDao {

	/**
	 * 
	 */
	public DatosEstudianteDaoImpl() {
		super(DatosEstudiante.class);

	}

}
