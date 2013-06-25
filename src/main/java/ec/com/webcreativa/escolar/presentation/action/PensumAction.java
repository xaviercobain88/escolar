package ec.com.webcreativa.escolar.presentation.action;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.com.webcreativa.escolar.business.facade.CursoFacade;
import ec.com.webcreativa.escolar.business.facade.MateriaFacade;
import ec.com.webcreativa.escolar.persistence.entity.Materia;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoGuardadaException;
import ec.com.webcreativa.escolar.presentation.datamanager.BusquedaCursoDM;
import ec.com.webcreativa.escolar.presentation.datamanager.MenuDM;
import ec.com.webcreativa.escolar.presentation.datamanager.PensumDM;
import ec.com.webcreativa.escolar.presentation.utils.MateriaDataModel;

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
public class PensumAction extends BaseController {

	@Inject
	BusquedaCursoDM busquedaCursoDM;
	@Inject
	PensumDM pensumDM;
	@Inject
	MenuDM menuDM;
	@Inject
	MateriaFacade materiaFacade;
	@Inject
	CursoFacade cursoFacade;

	public String getInit() {

		quitarPermisos(pensumDM);
		if (menuDM.getOpcionHijaSeleccionada() != null) {
			switch (menuDM.getOpcionHijaSeleccionada().getTipo()) {

			case ADMIN_INSTITUCION:
				pensumDM.setPermitirPantalla(true);
				pensumDM.setAdministradorInstitucionAllow(true);
				if (busquedaCursoDM.getIdCurso() != null) {
					try {
						if (pensumDM.getLeftRgth() == null
								|| !pensumDM.getLeftRgth()) {
							pensumDM.setMateriasUe(materiaFacade
									.obtenerSugeridas(menuDM
											.getOpcionHijaSeleccionada()
											.getRol().getUnidadEducativa()
											.getIdUe(),
											busquedaCursoDM.getIdCurso()));
							pensumDM.setMateriasCurso(materiaFacade
									.obtenerPorIdUe_IdCurso(menuDM
											.getOpcionHijaSeleccionada()
											.getRol().getUnidadEducativa()
											.getIdUe(),
											busquedaCursoDM.getIdCurso()));
						}
						pensumDM.setMateriasUeSeleccionadas(null);
						pensumDM.setMateriasCursoSeleccionadas(null);
						pensumDM.setMateriaUeDataModel(new MateriaDataModel(
								pensumDM.getMateriasUe()));
						pensumDM.setMateriaCursoDataModel(new MateriaDataModel(
								pensumDM.getMateriasCurso()));
						pensumDM.setLeftRgth(false);

					} catch (EntidadNoEncontradaException e) {
						e.printStackTrace();
						addErrorMessage("No se ha podido obtener la información");
					}
				}
				break;
			default:
				pensumDM.setPermitirPantalla(false);
				return null;
			}
		} else {
			pensumDM.setPermitirPantalla(false);
		}
		return null;
	}

	public String cambiarLeft() {
		if (pensumDM.getMateriasUe() != null) {
			for (Materia materia : pensumDM.getMateriasCursoSeleccionadas()) {
				if (materia.getCambiada() != null && materia.getCambiada()) {
					materia.setCambiada(false);
				} else {
					materia.setCambiada(true);
				}
				pensumDM.getMateriasUe().add(materia);
			}
		}
		if (listaLLena(pensumDM.getMateriasCurso())) {
			for (Materia materia : pensumDM.getMateriasCursoSeleccionadas()) {
				pensumDM.getMateriasCurso().remove(materia);
			}
		}
		pensumDM.setMateriasCursoSeleccionadas(null);
		return null;

	}

	public String cambiarRight() {
		if (pensumDM.getMateriasCurso() != null) {
			for (Materia materia : pensumDM.getMateriasUeSeleccionadas()) {
				if (materia.getCambiada() != null && materia.getCambiada()) {
					materia.setCambiada(false);
				} else {
					materia.setCambiada(true);
				}
				pensumDM.getMateriasCurso().add(materia);
			}
		}
		if (listaLLena(pensumDM.getMateriasUe())) {
			for (Materia materia : pensumDM.getMateriasUeSeleccionadas()) {
				pensumDM.getMateriasUe().remove(materia);
			}
		}
		pensumDM.setMateriasUeSeleccionadas(null);
		return null;
	}

	public String guardar() {
		try {
			if (busquedaCursoDM.getIdCurso() != null) {
				cursoFacade.guardarConMaterias(pensumDM.getMateriasCurso(),
						busquedaCursoDM.getIdCurso());
				addInfoMessage("Se ha guardado correctamente");
			} else {
				addInfoMessage("No se ha seleccionado el curso");
			}
		} catch (EntidadNoEncontradaException e) {
			e.printStackTrace();
			addErrorMessage("No se ha podido guardar");
			return null;
		} catch (EntidadNoGuardadaException e) {
			e.printStackTrace();
			addErrorMessage("No se ha podido guardar");
			return null;
		}
		return null;
	}

	public String cancelar() {
		return "dashboard";
	}

}
