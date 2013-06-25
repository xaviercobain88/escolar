package ec.com.webcreativa.escolar.presentation.action;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.com.webcreativa.escolar.business.facade.CursoFacade;
import ec.com.webcreativa.escolar.business.facade.SeccionFacade;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.presentation.datamanager.BusquedaCursoDM;
import ec.com.webcreativa.escolar.presentation.datamanager.MenuDM;

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
public class BusquedaCursoAction extends BaseController {
	@Inject
	MenuDM menuDM;
	@Inject
	SeccionFacade seccionFacade;
	@Inject
	CursoFacade cursoFacade;
	@Inject
	BusquedaCursoDM busquedaCursoDM;

	public String getInit() {

		quitarPermisos(busquedaCursoDM);
		if (menuDM.getOpcionHijaSeleccionada() != null) {
			switch (menuDM.getOpcionHijaSeleccionada().getTipo()) {

			case ADMIN_INSTITUCION:
				busquedaCursoDM.setPermitirPantalla(true);
				busquedaCursoDM.setAdministradorInstitucionAllow(true);
				break;
			default:
				busquedaCursoDM.setPermitirPantalla(false);
				return null;
			}

			try {
				if (busquedaCursoDM.getOmitirInit() == null) {
					borrarDatos();
					busquedaCursoDM.setSecciones(seccionFacade
							.obtenerPorIdUnidadEducativa_IdSeccionPadre(menuDM
									.getOpcionHijaSeleccionada().getRol()
									.getUnidadEducativa().getIdUe(), null));
					busquedaCursoDM.setSeccionesSelectItems(getSelectItems(
							busquedaCursoDM.getSecciones(), false));
					busquedaCursoDM.setOmitirInit(true);

				}
			} catch (EntidadNoEncontradaException e) {
				e.printStackTrace();
				addErrorMessage("No se ha podido obtener la información");
				return null;
			}
		} else {
			busquedaCursoDM.setPermitirPantalla(false);
			return null;
		}
		return null;
	}

	public String cancelar() {
		return "dashboard";
	}

	public void borrarDatos() {

		borrarDatosSeccion();
		borrarDatosSubseccion();
		borrarDatosEspecialidad();
		borrarDatosCurso();
	}

	public void borrarDatosSeccion() {
		busquedaCursoDM.setSecciones(null);
		busquedaCursoDM.setSeccionesSelectItems(null);
		busquedaCursoDM.setIdSeccion(null);
		borrarDatosSubseccion();
		borrarDatosEspecialidad();
		borrarDatosCurso();
	}

	public void borrarDatosSubseccion() {
		busquedaCursoDM.setSubSecciones(null);
		busquedaCursoDM.setSubSeccionesSelectItems(null);
		busquedaCursoDM.setIdSubSeccion(null);
		borrarDatosEspecialidad();
		borrarDatosCurso();
	}

	public void borrarDatosEspecialidad() {
		busquedaCursoDM.setEspecialidades(null);
		busquedaCursoDM.setEspecialidadesSelectItems(null);
		busquedaCursoDM.setIdEspecialidad(null);
		borrarDatosCurso();
	}

	public void borrarDatosCurso() {
		busquedaCursoDM.setCursos(null);
		busquedaCursoDM.setCursosSelectItems(null);
		busquedaCursoDM.setIdCurso(null);
	}

	public void seleccionarSeccion() {
		borrarDatosSubseccion();
		if (busquedaCursoDM.getIdSeccion() != null) {
			try {
				busquedaCursoDM.setSubSecciones(seccionFacade
						.obtenerPorIdUnidadEducativa_IdSeccionPadre(menuDM
								.getOpcionHijaSeleccionada().getRol()
								.getUnidadEducativa().getIdUe(),
								busquedaCursoDM.getIdSeccion()));
				busquedaCursoDM.setSubSeccionesSelectItems(getSelectItems(
						busquedaCursoDM.getSubSecciones(), false));
			} catch (EntidadNoEncontradaException e) {
				buscarCursos();
			}
		}
	}

	public void seleccionarSubSeccion() {
		borrarDatosEspecialidad();
		if (busquedaCursoDM.getIdSubSeccion() != null) {
			try {
				busquedaCursoDM.setEspecialidades(seccionFacade
						.obtenerPorIdUnidadEducativa_IdSeccionPadre(menuDM
								.getOpcionHijaSeleccionada().getRol()
								.getUnidadEducativa().getIdUe(),
								busquedaCursoDM.getIdSubSeccion()));
				busquedaCursoDM.setEspecialidadesSelectItems(getSelectItems(
						busquedaCursoDM.getEspecialidades(), false));
			} catch (EntidadNoEncontradaException e) {
				buscarCursos();
			}
		}
	}

	public void seleccionarEspecialidad() {
		borrarDatosCurso();
		buscarCursos();
	}

	public void buscarCursos() {

		if (busquedaCursoDM.getIdEspecialidad() != null) {
			try {
				busquedaCursoDM.setCursos(cursoFacade
						.obtenerPorIdSeccion(busquedaCursoDM
								.getIdEspecialidad()));
				busquedaCursoDM.setCursosSelectItems(getSelectItems(
						busquedaCursoDM.getCursos(), false));
			} catch (EntidadNoEncontradaException e) {
				e.printStackTrace();
				addWarnMessage("No se ha obtenido resultados");
			}
		} else if (busquedaCursoDM.getIdSubSeccion() != null) {
			try {
				busquedaCursoDM
						.setCursos(cursoFacade
								.obtenerPorIdSeccion(busquedaCursoDM
										.getIdSubSeccion()));
				busquedaCursoDM.setCursosSelectItems(getSelectItems(
						busquedaCursoDM.getCursos(), false));
			} catch (EntidadNoEncontradaException e) {
				e.printStackTrace();
				addWarnMessage("No se ha obtenido resultados");
			}
		} else if (busquedaCursoDM.getIdSeccion() != null) {
			try {
				busquedaCursoDM.setCursos(cursoFacade
						.obtenerPorIdSeccion(busquedaCursoDM.getIdSeccion()));
				busquedaCursoDM.setCursosSelectItems(getSelectItems(
						busquedaCursoDM.getCursos(), false));
			} catch (EntidadNoEncontradaException e) {
				e.printStackTrace();
				addWarnMessage("No se ha obtenido resultados");
			}
		}
	}

	public void buscar() {
	}

}
