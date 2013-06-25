/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import static ec.com.webcreativa.escolar.util.QueryParameter.with;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.RolDao;
import ec.com.webcreativa.escolar.persistence.entity.Rol;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class RolDaoImpl extends GenericDaoImpl<Rol, Integer> implements RolDao {

	/**
	 * 
	 */
	public RolDaoImpl() {
		super(Rol.class);

	}

	public List<Rol> buscarPorIdUnidadEducativa(Integer idUe)
			throws EntidadNoEncontradaException {
		List<Rol> resultado = findByNamedQuery("Rol.findByIdUnidadEducativa",
				with("idUe", idUe).parameters());
		if (resultado != null && !resultado.isEmpty()) {
			return resultado;
		}
		throw new EntidadNoEncontradaException();
	}
	
	public List<Rol> buscarPorIdUnidadEducativa_IdPersona(Integer idUe, Integer idPersona)
			throws EntidadNoEncontradaException {
		List<Rol> resultado = findByNamedQuery("Rol.findByIdUnidadEducativa_IdPersona",
				with("idUe", idUe).and("idPersona", idPersona).parameters());
		if (resultado != null && !resultado.isEmpty()) {
			return resultado;
		}
		throw new EntidadNoEncontradaException();
	}
	

}
