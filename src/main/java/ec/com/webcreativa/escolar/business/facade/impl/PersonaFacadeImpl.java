/*
 */
package ec.com.webcreativa.escolar.business.facade.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import ec.com.webcreativa.escolar.business.facade.PersonaFacade;
import ec.com.webcreativa.escolar.persistence.dao.PersonaDao;
import ec.com.webcreativa.escolar.persistence.dao.RolDao;
import ec.com.webcreativa.escolar.persistence.entity.Persona;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoGuardadaException;
import ec.com.webcreativa.escolar.util.BaseUtils;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class PersonaFacadeImpl extends BaseUtils implements PersonaFacade {

	@EJB
	PersonaDao personaDao;
	@EJB
	RolDao rolDao;
	ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder(256);

	public Persona guardar(Persona persona) throws EntidadNoGuardadaException,
			EntidadNoEncontradaException {

		passwordEncoder.setEncodeHashAsBase64(true);
		if (persona.getIdPersona() == null) {

			if (persona.getCiPasaporte() != null
					&& !persona.getCiPasaporte().isEmpty()) {

				persona.setUsuario(persona.getCiPasaporte());
			} else {
				persona.setUsuario(persona.getApellidos().split(" ", 1)[0]
						+ "." + persona.getNombres().split(" ", 1)[0]
						+ persona.getTercerIdentificador());
			}
			if (usuarioValido(persona.getUsuario(), null)) {
				persona.setContrasena(passwordEncoder.encodePassword(
						persona.getUsuario(), null));
				persona.setActivo(true);
				return personaDao.create(persona);
			} else {
				throw new EntidadNoGuardadaException();
			}

		} else {
			if (usuarioValido(persona.getUsuario(), persona.getIdPersona())) {
				return personaDao.update(persona);
			}
			throw new EntidadNoGuardadaException();
		}

	}

	@Override
	public Persona obtenerPorUsuario(String usuario)
			throws EntidadNoEncontradaException {
		return personaDao.buscarPorUsuario(usuario);
	}

	@Override
	public Boolean usuarioValido(String usuarioNuevo, Integer idUsuarioAntiguo) {

		try {
			Persona persona = personaDao.buscarPorUsuario(usuarioNuevo);
			if (idUsuarioAntiguo != null
					&& persona.getIdPersona().equals(idUsuarioAntiguo)) {
				return true;
			}
			return false;
		} catch (EntidadNoEncontradaException e) {
			return true;
		}

	}

	@Override
	public List<Persona> obtenerPorCriterios(String apellidos,
			String ciPasaporte, String usuario, Integer idRol, Integer idUe,
			Boolean conRolesString) throws EntidadNoEncontradaException {
		if (idUe != null) {
			List<Persona> personaList = personaDao.buscarPorCriterios(
					apellidos, ciPasaporte, usuario, idRol, idUe);
			if (conRolesString) {
				// TODO traer los roles en un string para mostrar en la tabla de
				// perfiles
			}
			return personaList;
		} else {
			throw new EntidadNoEncontradaException();
		}

	}

	// TODO hacer un paginador
	@Override
	public List<Persona> obtenerTodos() throws EntidadNoEncontradaException {
		List<Persona> personaList = personaDao.findAll("apellidos", "nombres");
		if (listaLLena(personaList)) {
			return personaList;
		} else {
			throw new EntidadNoEncontradaException();
		}
	}

	public String guardarConSeguridad(Persona persona,
			String contrasenaAntigua, String contrasenaNueva,
			String contrasenaRetype) throws EntidadNoGuardadaException,
			EntidadNoEncontradaException {
		passwordEncoder.setEncodeHashAsBase64(true);
		Persona personaAntigua = personaDao.findById(persona.getIdPersona());
		if (personaAntigua != null) {
			String mensaje = cambioContrasena(contrasenaAntigua,
					personaAntigua.getContrasena(), contrasenaNueva,
					contrasenaRetype);
			if (mensaje == null) {
				System.out.println(contrasenaNueva);
				System.out.println(passwordEncoder.encodePassword(
						contrasenaNueva, null));
				persona.setContrasena(passwordEncoder.encodePassword(
						contrasenaNueva, null));
				guardar(persona);
			}
			return mensaje;
		}
		throw new EntidadNoGuardadaException();

	}

	public String cambioContrasena(String contrasenaAntigua,
			String contrasenaCifrada, String contrasenaNueva,
			String contrasenaRetype) {
		if ((contrasenaNueva != null && !contrasenaNueva.isEmpty())
				|| ((contrasenaRetype != null && !contrasenaRetype.isEmpty()))) {
			if (contrasenaAntigua != null && !contrasenaAntigua.isEmpty()) {
				if (contrasenaNueva != null && contrasenaRetype != null
						&& contrasenaNueva.equals(contrasenaRetype)) {
					passwordEncoder.setEncodeHashAsBase64(true);
					if (passwordEncoder.isPasswordValid(contrasenaCifrada,
							contrasenaAntigua, null)) {

						return null;
					} else {
						return "La contraseña anterior no coincide";
					}
				} else {
					return "La contraseña nueva no coincide";
				}
			} else {
				return "Por favor ingrese su contreseña anterior";
			}
		}
		return null;
	}
}
