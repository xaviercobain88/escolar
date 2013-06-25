package ec.com.webcreativa.escolar.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.webcreativa.escolar.persistence.entity.Persona;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

@Local
public interface PersonaDao extends GenericDao<Persona, Integer> {

	/**
	 * Busca la persona por usuario
	 * 
	 * @param usuario
	 * @return
	 */
	public Persona buscarPorUsuario(String usuario)
			throws EntidadNoEncontradaException;

	List<Persona> buscarPorCriterios(String apellidos, String ciPasaporte,
			String usuario, Integer idRol, Integer idUe)
			throws EntidadNoEncontradaException;
}
