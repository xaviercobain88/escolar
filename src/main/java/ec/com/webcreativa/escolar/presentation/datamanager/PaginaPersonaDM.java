package ec.com.webcreativa.escolar.presentation.datamanager;


import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ec.com.webcreativa.escolar.persistence.entity.Clase;

@Named("paginaPersonaDM")
@SessionScoped
public class PaginaPersonaDM implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Clase> listaClaseProfesor;
	/**
	 * @return
	 */
	public List<Clase> getListaClaseProfesor() {
		return listaClaseProfesor;
	}
	/**
	 * @param listaClaseProfesor
	 */
	public void setListaClaseProfesor(List<Clase> listaClaseProfesor) {
		this.listaClaseProfesor = listaClaseProfesor;
	}
	
	
	
	
}
