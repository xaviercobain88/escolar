/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import static ec.com.webcreativa.escolar.util.QueryParameter.with;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.ClaseDao;
import ec.com.webcreativa.escolar.persistence.entity.Clase;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
/**
 * @author xavier
 *
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class ClaseDaoImpl extends GenericDaoImpl<Clase, Integer> implements
		ClaseDao {

	/**
	 * 
	 */
	public ClaseDaoImpl() {
		super(Clase.class);

	}

	/* Buscar por Periodo y Profesor
	 * @see ec.com.webcreativa.escolar.persistence.dao.ClaseDao#buscarXPeriodoProfesor(ec.com.webcreativa.escolar.persistence.entity.Persona, ec.com.webcreativa.escolar.persistence.entity.Periodo)
	 */
	public List<Clase> buscarXPeriodoProfesor(Integer idProfesor, Integer idPeriodo) throws EntidadNoEncontradaException {
		return findByNamedQuery("Clase.findByPeriodoProfesor", with("idPeriodo", idPeriodo).and("idPersona", idProfesor).parameters());
	}

}
