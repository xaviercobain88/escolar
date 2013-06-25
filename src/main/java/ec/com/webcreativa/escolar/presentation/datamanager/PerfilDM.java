package ec.com.webcreativa.escolar.presentation.datamanager;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ec.com.webcreativa.escolar.persistence.entity.Persona;

@Named
@SessionScoped
public class PerfilDM extends BaseControllerDM implements Serializable {
	private static final long serialVersionUID = 1L;

	private Persona persona;
	private String contrasenaNueva, contrasenaAntigua, contrasenaRetype;

	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public String getContrasenaNueva() {
		return contrasenaNueva;
	}

	public void setContrasenaNueva(String contrasenaNueva) {
		this.contrasenaNueva = contrasenaNueva;
	}

	public String getContrasenaAntigua() {
		return contrasenaAntigua;
	}

	public void setContrasenaAntigua(String contrasenaAntigua) {
		this.contrasenaAntigua = contrasenaAntigua;
	}

	public String getContrasenaRetype() {
		return contrasenaRetype;
	}

	public void setContrasenaRetype(String contrasenaRetype) {
		this.contrasenaRetype = contrasenaRetype;
	}

}
