package ec.com.webcreativa.escolar.presentation.action;

import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import ec.com.webcreativa.escolar.business.facade.PersonaFacade;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoGuardadaException;
import ec.com.webcreativa.escolar.presentation.datamanager.MenuDM;
import ec.com.webcreativa.escolar.presentation.datamanager.PerfilDM;

/*
 * 0	Todos---------------*
 * 1	Alumno
 * 2	Padre
 * 3	Profesor
 * 4	Inspector
 * 5	Jefe de Area
 * 6	Inspector General
 * 7	Sicologo
 * 8	Secretaria
 * 9	Rector
 * 10	Admin UE------------*
 * 20	Admin App			
 */
@Named
@ViewScoped
public class PerfilAction extends BaseController {
	@Inject
	PerfilDM perfilDM;
	@Inject
	MenuDM menuDM;
	@Inject
	PersonaFacade personaFacade;
	ShaPasswordEncoder passwordEncoder = new ShaPasswordEncoder(256);

	public String getInit() {

		quitarPermisos(perfilDM);
		if (menuDM.getOpcionHijaSeleccionada() != null) {
			switch (menuDM.getOpcionHijaSeleccionada().getTipo()) {

			case TODOS:
				try {
					perfilDM.setPermitirPantalla(true);
					perfilDM.setTodosAllow(true);
					perfilDM.setPersona(personaFacade
							.obtenerPorUsuario(getUsuario()));
				} catch (EntidadNoEncontradaException e) {
					perfilDM.setPermitirPantalla(false);
					e.printStackTrace();
					addErrorMessage("No se ha podido obtener la información");
				}
				break;
			case ADMIN_INSTITUCION:
				if (perfilDM.getPersona() != null) {
					perfilDM.setPermitirPantalla(true);
					perfilDM.setAdministradorInstitucionAllow(true);
				} else {
					perfilDM.setPermitirPantalla(false);
					addErrorMessage("No se ha podido obtener la información");
				}
				break;
			default:
				perfilDM.setPermitirPantalla(false);
				return null;
			}
		} else {
			perfilDM.setPermitirPantalla(false);
		}
		return null;
	}

	public String cancelar() {
		return "dashboard";
	}

	public void validarUsuario() {
		if (!personaFacade.usuarioValido(perfilDM.getPersona().getUsuario(),
				perfilDM.getPersona().getIdPersona())) {
			addErrorMessage("Ya existe ese usuario");
		}

	}

	public void asignarUsuarioCI(AjaxBehaviorEvent event) {
		perfilDM.getPersona()
				.setUsuario(perfilDM.getPersona().getCiPasaporte());

	}

	public String guardar() {
		try {
			personaFacade.guardar(perfilDM.getPersona());
			addInfoMessage("Se ha guardado correctamente");
			return "null";
		} catch (EntidadNoGuardadaException e) {
			e.printStackTrace();
			addErrorMessage("No se ha podido guardar");
			return null;
		} catch (EntidadNoEncontradaException e) {
			e.printStackTrace();
			addErrorMessage("No se ha podido guardar");
			return null;
		}
	}

	public String guardarSeguridad() {
		try {
			String mensaje = personaFacade.guardarConSeguridad(
					perfilDM.getPersona(), perfilDM.getContrasenaAntigua(),
					perfilDM.getContrasenaNueva(),
					perfilDM.getContrasenaRetype());
			if (mensaje != null) {
				addErrorMessage(mensaje);
			} else {
				addInfoMessage("Se ha guardado correctamente");
			}
			return "null";
		} catch (EntidadNoGuardadaException e) {
			e.printStackTrace();
			addErrorMessage("No se ha podido guardar");
			return null;
		} catch (EntidadNoEncontradaException e) {
			e.printStackTrace();
			addErrorMessage("No se ha podido guardar");
			return null;
		}
	}
}
