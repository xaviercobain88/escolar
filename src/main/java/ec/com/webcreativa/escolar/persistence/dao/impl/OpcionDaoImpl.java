/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import static ec.com.webcreativa.escolar.util.QueryParameter.with;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.OpcionDao;
import ec.com.webcreativa.escolar.persistence.entity.Opcion;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class OpcionDaoImpl extends GenericDaoImpl<Opcion, Integer> implements
		OpcionDao {

	/**
	 * 
	 */
	public OpcionDaoImpl() {
		super(Opcion.class);

	}

	public List<Opcion> buscarPadresPorRoles(List<Integer> idRolList)
			throws EntidadNoEncontradaException {
		List<Opcion> resultado = findByNamedQuery(
				"Opcion.buscarPadresPorRoles", with("idRolList", idRolList)
						.parameters());
		if (resultado != null && !resultado.isEmpty()) {
			return resultado;
		}
		throw new EntidadNoEncontradaException();
	}

	public Map<Integer, List<Opcion>> buscarPorRoles_Padre(
			List<Integer> idRolList, Integer idOpcionPadre)
			throws EntidadNoEncontradaException {
		Map<Integer, List<Opcion>> menuHijoMap = new TreeMap<Integer, List<Opcion>>();
		for (Integer idRol : idRolList) {
			List<Opcion> resultado = findByNamedQuery(
					"Opcion.buscarPorRoles_Padre", with("idRolList", idRol)
							.and("idOpcionPadre", idOpcionPadre).parameters());
			if (resultado != null && !resultado.isEmpty()) {
				menuHijoMap.put(idRol, resultado);
			}
		}
		return menuHijoMap;
	}

}
