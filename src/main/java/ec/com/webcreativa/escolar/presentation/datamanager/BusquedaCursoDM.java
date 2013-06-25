package ec.com.webcreativa.escolar.presentation.datamanager;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import ec.com.webcreativa.escolar.persistence.entity.Curso;
import ec.com.webcreativa.escolar.persistence.entity.Seccion;

@Named
@SessionScoped
public class BusquedaCursoDM extends BaseControllerDM implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Seccion> secciones;
	private List<Seccion> subSecciones;
	private List<Seccion> especialidades;
	private Integer idSeccion;
	private Integer idSubSeccion;
	private Integer idEspecialidad;
	private List<Curso> cursos;
	private Integer idCurso;
	private List<SelectItem> seccionesSelectItems;
	private List<SelectItem> subSeccionesSelectItems;
	private List<SelectItem> especialidadesSelectItems;
	private List<SelectItem> cursosSelectItems;
	private Boolean omitirInit;

	public List<Seccion> getSecciones() {
		return secciones;
	}

	public void setSecciones(List<Seccion> secciones) {
		this.secciones = secciones;
	}

	public List<Seccion> getSubSecciones() {
		return subSecciones;
	}

	public void setSubSecciones(List<Seccion> subSecciones) {
		this.subSecciones = subSecciones;
	}

	public List<Seccion> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Seccion> especialidades) {
		this.especialidades = especialidades;
	}

	public Integer getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(Integer idSeccion) {
		this.idSeccion = idSeccion;
	}

	public Integer getIdSubSeccion() {
		return idSubSeccion;
	}

	public void setIdSubSeccion(Integer idSubSeccion) {
		this.idSubSeccion = idSubSeccion;
	}

	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public List<SelectItem> getSeccionesSelectItems() {
		return seccionesSelectItems;
	}

	public void setSeccionesSelectItems(List<SelectItem> seccionesSelectItems) {
		this.seccionesSelectItems = seccionesSelectItems;
	}

	public List<SelectItem> getSubSeccionesSelectItems() {
		return subSeccionesSelectItems;
	}

	public void setSubSeccionesSelectItems(
			List<SelectItem> subSeccionesSelectItems) {
		this.subSeccionesSelectItems = subSeccionesSelectItems;
	}

	public List<SelectItem> getEspecialidadesSelectItems() {
		return especialidadesSelectItems;
	}

	public void setEspecialidadesSelectItems(
			List<SelectItem> especialidadesSelectItems) {
		this.especialidadesSelectItems = especialidadesSelectItems;
	}

	public List<SelectItem> getCursosSelectItems() {
		return cursosSelectItems;
	}

	public void setCursosSelectItems(List<SelectItem> cursosSelectItems) {
		this.cursosSelectItems = cursosSelectItems;
	}

	public Boolean getOmitirInit() {
		return omitirInit;
	}

	public void setOmitirInit(Boolean omitirInit) {
		this.omitirInit = omitirInit;
	}

	
	

}
