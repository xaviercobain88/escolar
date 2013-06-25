/*
 */
package ec.com.webcreativa.escolar.business.facade.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.business.facade.RolFacade;
import ec.com.webcreativa.escolar.persistence.dao.PersonaDao;
import ec.com.webcreativa.escolar.persistence.dao.RolDao;
import ec.com.webcreativa.escolar.persistence.entity.Persona;
import ec.com.webcreativa.escolar.persistence.entity.Rol;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.util.BaseUtils;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class RolFacadeImpl extends BaseUtils implements RolFacade {

	@EJB
	PersonaDao personaDao;
	@EJB
	RolDao rolDao;

	@Override
	public List<Integer> obtenerIdPorUsuario(String usuario)
			throws EntidadNoEncontradaException {
		Persona persona = personaDao.buscarPorUsuario(usuario);
		List<Integer> idRolList = new ArrayList<Integer>();
		if (listaLLena(persona.getRolList())) {
			for (Rol rol : persona.getRolList()) {
				idRolList.add(rol.getIdRol());
			}
			return idRolList;
		}
		throw new EntidadNoEncontradaException();
	}

	@Override
	public List<Rol> obtenerPorIdUnidadEducativa(Integer idUe)
			throws EntidadNoEncontradaException {
		return rolDao.buscarPorIdUnidadEducativa(idUe);
	}

	@Override
	public List<Rol> obtenerPorIdUnidadEducativa_IdPersona(Integer idUe,
			Integer idPersona) throws EntidadNoEncontradaException {
		return rolDao.buscarPorIdUnidadEducativa_IdPersona(idUe, idPersona);
	}

}
