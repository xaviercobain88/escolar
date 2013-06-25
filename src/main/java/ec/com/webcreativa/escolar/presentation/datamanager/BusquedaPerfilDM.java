package ec.com.webcreativa.escolar.presentation.datamanager;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import ec.com.webcreativa.escolar.persistence.entity.Persona;
import ec.com.webcreativa.escolar.persistence.entity.Rol;

@Named
@SessionScoped
public class BusquedaPerfilDM extends BaseControllerDM implements Serializable {
	private static final long serialVersionUID = 1L;

	private String apellidos;
	private String ci;
	private String usuario;
	private Integer idRolSeleccionado;
	private List<Rol> rolList;
	private List<SelectItem> rolSelectItemList;
	private List<Persona> personaList;
	private Boolean busqueda;
	private Boolean abierto = true;

	public List<Persona> getPersonaList() {
		return personaList;
	}

	public void setPersonaList(List<Persona> personaList) {
		this.personaList = personaList;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Integer getIdRolSeleccionado() {
		return idRolSeleccionado;
	}

	public void setIdRolSeleccionado(Integer idRolSeleccionado) {
		this.idRolSeleccionado = idRolSeleccionado;
	}

	public List<Rol> getRolList() {
		return rolList;
	}

	public void setRolList(List<Rol> rolList) {
		this.rolList = rolList;
	}

	public List<SelectItem> getRolSelectItemList() {
		return rolSelectItemList;
	}

	public void setRolSelectItemList(List<SelectItem> rolSelectItemList) {
		this.rolSelectItemList = rolSelectItemList;
	}

	public Boolean getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(Boolean busqueda) {
		this.busqueda = busqueda;
	}

	public Boolean getAbierto() {
		return abierto;
	}

	public void setAbierto(Boolean abierto) {
		this.abierto = abierto;
	}

}
