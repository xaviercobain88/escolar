package ec.com.webcreativa.escolar.presentation.datamanager;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.primefaces.model.MenuModel;

import ec.com.webcreativa.escolar.persistence.entity.Opcion;

@Named
@SessionScoped
public class MenuDM extends BaseControllerDM implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Opcion> menusPadre;
	private List<Opcion> menuHijos;
	private MenuModel menuHijosPrimeFaces;
	private Opcion opcionPadreSeleccionada;
	private Opcion opcionHijaSeleccionada;
	protected final static String ACTIVATED_STYLE_CLASS = "submenu-activado";

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Opcion> getMenusPadre() {
		return menusPadre;
	}

	public void setMenusPadre(List<Opcion> menusPadre) {
		this.menusPadre = menusPadre;
	}

	public List<Opcion> getMenuHijos() {
		return menuHijos;
	}

	public void setMenuHijos(List<Opcion> menuHijos) {
		this.menuHijos = menuHijos;
	}

	public Opcion getOpcionPadreSeleccionada() {
		return opcionPadreSeleccionada;
	}

	public void setOpcionPadreSeleccionada(Opcion opcionPadreSeleccionada) {
		this.opcionPadreSeleccionada = opcionPadreSeleccionada;
	}

	public Opcion getOpcionHijaSeleccionada() {
		return opcionHijaSeleccionada;
	}

	public void setOpcionHijaSeleccionada(Opcion opcionHijaSeleccionada) {
		this.opcionHijaSeleccionada = opcionHijaSeleccionada;
	}

	public MenuModel getMenuHijosPrimeFaces() {
		return menuHijosPrimeFaces;
	}

	public void setMenuHijosPrimeFaces(MenuModel menuHijosPrimeFaces) {
		this.menuHijosPrimeFaces = menuHijosPrimeFaces;
	}

	public static String getActivatedStyleClass() {
		return ACTIVATED_STYLE_CLASS;
	}

}
