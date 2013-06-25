package ec.com.webcreativa.escolar.presentation.action;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.com.webcreativa.escolar.business.facade.OpcionFacade;
import ec.com.webcreativa.escolar.business.facade.RolFacade;
import ec.com.webcreativa.escolar.persistence.entity.Opcion;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.presentation.datamanager.MenuDM;
import java.io.Serializable;

@Named
@SessionScoped
public class MenuAction extends BaseController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	OpcionFacade opcionFacade;
	@EJB
	RolFacade rolFacade;
	@Inject
	MenuDM menuDM;

	@PostConstruct
	public void init() {
		try {
			menuDM.setMenusPadre(opcionFacade
					.obtenerPadresPorUsuario(getUsuario()));
			if (menuDM.getIdRolList() == null) {
				menuDM.setIdRolList(rolFacade.obtenerIdPorUsuario(getUsuario()));
			}
			menuDM.setOpcionPadreSeleccionada(menuDM.getMenusPadre().get(0));

			redireccionarPrimerLink();
		} catch (EntidadNoEncontradaException e) {
			e.printStackTrace();
			addErrorMessage("El usuario no tiene asigados accesos");
			// TODO
		}

	}

	public String getInit() {
		return "";
	}

	public String redireccionarPrimerLink() {
		List<Opcion> menuHijosList = getMenuHijos();
		if (listaLLena(menuHijosList)) {
			menuDM.setOpcionHijaSeleccionada(menuHijosList.get(0));
			return menuDM.getOpcionHijaSeleccionada().getUrl();
		}
		return null;
	}

	public List<Opcion> getMenuHijos() {
		try {
			menuDM.setMenuHijos(opcionFacade.obtenerPorRoles_Padre(menuDM
					.getIdRolList(), menuDM.getOpcionPadreSeleccionada()
					.getIdOpcion()));
			
			if (menuDM.getOpcionHijaSeleccionada() != null) {
				for (Opcion opcion : menuDM.getMenuHijos()) {
					if (opcion.getIdOpcion().equals(
							menuDM.getOpcionHijaSeleccionada().getIdOpcion())) {
						opcion.setStyleClase(MenuDM.getActivatedStyleClass());
					} else {
						opcion.setStyleClase("");
					}
				}
			}
			return menuDM.getMenuHijos();
		} catch (EntidadNoEncontradaException e) {
			e.printStackTrace();
			// TODO
			return null;
		}
	}
}
