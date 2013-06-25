package ec.com.webcreativa.escolar.presentation.action;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.com.webcreativa.escolar.business.facade.PersonaFacade;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.presentation.datamanager.BusquedaPerfilDM;
import ec.com.webcreativa.escolar.presentation.datamanager.MenuDM;
import ec.com.webcreativa.escolar.presentation.datamanager.PerfilesDM;

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
public class PerfilesAction extends BaseController {
	@Inject
	PerfilesDM perfilesDM;
	@Inject
	BusquedaPerfilDM busquedaPerfilDM;
	@Inject
	MenuDM menuDM;
	@Inject
	PersonaFacade personaFacade;

	public String getInit() {

		quitarPermisos(perfilesDM);
		if (menuDM.getOpcionHijaSeleccionada() != null) {
			switch (menuDM.getOpcionHijaSeleccionada().getTipo()) {

			case ADMIN_INSTITUCION:
				perfilesDM.setPermitirPantalla(true);
				perfilesDM.setAdministradorInstitucionAllow(true);
				if (!listaLLena(busquedaPerfilDM.getPersonaList())&&(busquedaPerfilDM.getBusqueda()==null||!busquedaPerfilDM.getBusqueda())) {
					try {
						busquedaPerfilDM.setPersonaList(personaFacade
								.obtenerPorCriterios(null, null, null, null,
										menuDM.getOpcionHijaSeleccionada()
												.getRol().getUnidadEducativa()
												.getIdUe(), true));
					} catch (EntidadNoEncontradaException e) {
						e.printStackTrace();
						addErrorMessage("No se ha podido obtener la información");
					}
				}
				break;
			default:
				perfilesDM.setPermitirPantalla(false);
				return null;
			}
		} else {
			perfilesDM.setPermitirPantalla(false);
		}
		return null;
	}

	public String cancelar() {
		return "dashboard";
	}
	
	

	

}
