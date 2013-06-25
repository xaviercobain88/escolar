/*
 */
package ec.com.webcreativa.escolar.business.facade.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.business.facade.OpcionFacade;
import ec.com.webcreativa.escolar.business.facade.RolFacade;
import ec.com.webcreativa.escolar.persistence.dao.OpcionDao;
import ec.com.webcreativa.escolar.persistence.dao.RolDao;
import ec.com.webcreativa.escolar.persistence.entity.Opcion;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.util.BaseUtils;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class OpcionFacadeImpl extends BaseUtils implements OpcionFacade {

	@EJB
	RolFacade rolFacade;
	@EJB
	OpcionDao opcionDao;
	@EJB
	RolDao rolDao;

	// TODO por roles guardados en sesion
	public List<Opcion> obtenerPadresPorUsuario(String usuario)
			throws EntidadNoEncontradaException {
		List<Opcion> listaMenuPadre = new ArrayList<Opcion>();
		listaMenuPadre = opcionDao.buscarPadresPorRoles(rolFacade
				.obtenerIdPorUsuario(usuario));
		return listaMenuPadre;
	}

	// TODO buscar por rol_opcion para no hacer tanta query
	public List<Opcion> obtenerPorRoles_Padre(List<Integer> idRolList,
			Integer idOpcion) throws EntidadNoEncontradaException {
		Map<Integer, List<Opcion>> menuHijosMap = opcionDao
				.buscarPorRoles_Padre(idRolList, idOpcion);
		List<Opcion> menuHijosList = new ArrayList<Opcion>();
		for (Map.Entry<Integer, List<Opcion>> entry : menuHijosMap.entrySet()) {
			for (Opcion opcion : entry.getValue()) {
				opcion.setRol(rolDao.findById(entry.getKey()));
				menuHijosList.add(opcion);
			}
		}
		if (idRolList.size() > 1) {
			for (Opcion opcion : menuHijosList) {
				opcion.setNombre(opcion.getNombre() + " - "
						+ opcion.getRol().getRol());
			}
		}
		if (listaLLena(menuHijosList)) {
			return menuHijosList;
		}
		throw new EntidadNoEncontradaException();
	}
}
