package ec.com.webcreativa.escolar.presentation.action;

import java.util.ArrayList;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.com.webcreativa.escolar.business.facade.PersonaFacade;
import ec.com.webcreativa.escolar.business.facade.RolFacade;
import ec.com.webcreativa.escolar.persistence.entity.Persona;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.presentation.datamanager.BusquedaPerfilDM;
import ec.com.webcreativa.escolar.presentation.datamanager.MenuDM;
import ec.com.webcreativa.escolar.presentation.datamanager.PerfilesDM;

/*
 * 0	Todos
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
public class BusquedaPerfilAction extends BaseController {
	@Inject
	MenuDM menuDM;
	@Inject
	RolFacade rolFacade;
	@Inject
	PersonaFacade personaFacade;
	@Inject
	BusquedaPerfilDM busquedaPerfilDM;
	@Inject
	PerfilesDM perfilesDM;

	public String getInit() {

		quitarPermisos(busquedaPerfilDM);
		if (menuDM.getOpcionHijaSeleccionada() != null) {
			switch (menuDM.getOpcionHijaSeleccionada().getTipo()) {

			case ADMIN_INSTITUCION:
				busquedaPerfilDM.setPermitirPantalla(true);
				busquedaPerfilDM.setAdministradorInstitucionAllow(true);
				break;
			default:
				busquedaPerfilDM.setPermitirPantalla(false);
				return null;
			}
		} else {
			busquedaPerfilDM.setPermitirPantalla(false);
			return null;
		}
		generarRoles();
		return null;
	}

	public String cancelar() {
		return "dashboard";
	}

	public void generarRoles() {
		try {
			busquedaPerfilDM.setRolList(rolFacade
					.obtenerPorIdUnidadEducativa(menuDM
							.getOpcionHijaSeleccionada().getRol()
							.getUnidadEducativa().getIdUe()));
			busquedaPerfilDM.setRolSelectItemList(getSelectItems(
					busquedaPerfilDM.getRolList(), false));
		} catch (EntidadNoEncontradaException e) {
			e.printStackTrace();
			addErrorMessage("No se ha podido obtener la información");
		}
	}

	public void buscar() {
		try {
			busquedaPerfilDM.setPersonaList(personaFacade.obtenerPorCriterios(
					busquedaPerfilDM.getApellidos(), busquedaPerfilDM.getCi(),
					busquedaPerfilDM.getUsuario(),
					busquedaPerfilDM.getIdRolSeleccionado(), menuDM
							.getOpcionHijaSeleccionada().getRol()
							.getUnidadEducativa().getIdUe(), true));
			busquedaPerfilDM.setBusqueda(true);
		} catch (EntidadNoEncontradaException e) {
			e.printStackTrace();
			busquedaPerfilDM.setPersonaList(new ArrayList<Persona>());
			busquedaPerfilDM.setBusqueda(true);
			addWarnMessage("No se ha obtenido resultados");
		}
	}

}
