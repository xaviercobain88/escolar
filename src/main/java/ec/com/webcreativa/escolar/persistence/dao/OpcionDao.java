package ec.com.webcreativa.escolar.persistence.dao;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import ec.com.webcreativa.escolar.persistence.entity.Opcion;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

@Local
public interface OpcionDao extends GenericDao<Opcion, Integer> {

	List<Opcion> buscarPadresPorRoles(List<Integer> idRol)
			throws EntidadNoEncontradaException;

	Map<Integer, List<Opcion>> buscarPorRoles_Padre(List<Integer> idRolList,
			Integer idOpcionPadre) throws EntidadNoEncontradaException;
}
