/*
 */
package ec.com.webcreativa.escolar.business.facade;

import java.util.List;

import javax.ejb.Local;

import ec.com.webcreativa.escolar.persistence.entity.Persona;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoGuardadaException;

@Local
public interface PersonaFacade {
	Persona guardar(Persona persona) throws EntidadNoGuardadaException,
			EntidadNoEncontradaException;

	Persona obtenerPorUsuario(String usuario)
			throws EntidadNoEncontradaException;

	Boolean usuarioValido(String usuarioNuevo, Integer idUsuarioAntiguo);

	List<Persona> obtenerPorCriterios(String apellidos, String ciPasaporte,
			String usuario, Integer idRol, Integer idUe, Boolean conRolesString)
			throws EntidadNoEncontradaException;

	List<Persona> obtenerTodos() throws EntidadNoEncontradaException;
	
	String guardarConSeguridad(Persona persona,
			String contrasenaAntigua, String contrasenaNueva, String contrasenaRetype)
			throws EntidadNoGuardadaException, EntidadNoEncontradaException;
}
