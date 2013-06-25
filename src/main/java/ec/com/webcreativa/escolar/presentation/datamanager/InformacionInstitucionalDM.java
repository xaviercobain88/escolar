package ec.com.webcreativa.escolar.presentation.datamanager;

import java.io.Serializable;

import javax.enterprise.inject.Model;

import ec.com.webcreativa.escolar.persistence.entity.UnidadEducativa;

@Model
public class InformacionInstitucionalDM extends BaseControllerDM implements
		Serializable {
	private static final long serialVersionUID = 1L;
	private UnidadEducativa unidadEducativa;

	public UnidadEducativa getUnidadEducativa() {
		return unidadEducativa;
	}

	public void setUnidadEducativa(UnidadEducativa unidadEducativa) {
		this.unidadEducativa = unidadEducativa;
	}

}
