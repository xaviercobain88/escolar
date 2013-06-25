package ec.com.webcreativa.escolar.presentation.action;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.com.webcreativa.escolar.business.facade.UnidadEducativaFacade;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoGuardadaException;
import ec.com.webcreativa.escolar.presentation.datamanager.InformacionInstitucionalDM;
import ec.com.webcreativa.escolar.presentation.datamanager.MenuDM;

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
 * 20	Admin App			(Proximamente)
 */
@Named
@ViewScoped
public class InformacionInstitucionalAction extends BaseController {
	@Inject
	InformacionInstitucionalDM informacionUnidadEducativaDM;
	@Inject
	MenuDM menuDM;
	@Inject
	UnidadEducativaFacade unidadEducativaFacade;

	@PostConstruct
	public String getInit() {

		quitarPermisos(informacionUnidadEducativaDM);
		if (menuDM.getOpcionHijaSeleccionada() != null) {
			switch (menuDM.getOpcionHijaSeleccionada().getTipo()) {
			case TODOS:
				informacionUnidadEducativaDM.setPermitirPantalla(true);
				informacionUnidadEducativaDM.setTodosAllow(true);
				break;
			case ADMIN_INSTITUCION:
				informacionUnidadEducativaDM.setPermitirPantalla(true);
				informacionUnidadEducativaDM
						.setAdministradorInstitucionAllow(true);
				break;
			default:
				informacionUnidadEducativaDM.setPermitirPantalla(false);
				return null;
			}
			informacionUnidadEducativaDM.setUnidadEducativa(menuDM
					.getOpcionHijaSeleccionada().getRol().getUnidadEducativa());
		} else {
			informacionUnidadEducativaDM.setPermitirPantalla(false);
		}

		return null;
	}

	public String cancelar() {
		return "dashboard";
	}

	public String guardar() {
		try {
			unidadEducativaFacade.guardar(informacionUnidadEducativaDM
					.getUnidadEducativa());
			addInfoMessage("Se ha guardado correctamente");
			return null;
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
