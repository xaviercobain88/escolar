package ec.com.webcreativa.escolar.presentation.datamanager;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import ec.com.webcreativa.escolar.persistence.entity.Materia;
import ec.com.webcreativa.escolar.presentation.utils.MateriaDataModel;

@Named
@SessionScoped
public class PensumDM extends BaseControllerDM implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Materia> materiasUe;
	private List<Materia> materiasCurso;
	private Materia[] materiasUeSeleccionadas;
	private Materia[] materiasCursoSeleccionadas;
	private MateriaDataModel materiaUeDataModel;
	private MateriaDataModel materiaCursoDataModel;
	private Boolean leftRgth;

	public List<Materia> getMateriasUe() {
		return materiasUe;
	}

	public void setMateriasUe(List<Materia> materiasUe) {
		this.materiasUe = materiasUe;
	}

	public List<Materia> getMateriasCurso() {
		return materiasCurso;
	}

	public void setMateriasCurso(List<Materia> materiasCurso) {
		this.materiasCurso = materiasCurso;
	}

	public Materia[] getMateriasUeSeleccionadas() {
		return materiasUeSeleccionadas;
	}

	public void setMateriasUeSeleccionadas(Materia[] materiasUeSeleccionadas) {
		this.materiasUeSeleccionadas = materiasUeSeleccionadas;
	}

	public Materia[] getMateriasCursoSeleccionadas() {
		return materiasCursoSeleccionadas;
	}

	public void setMateriasCursoSeleccionadas(
			Materia[] materiasCursoSeleccionadas) {
		this.materiasCursoSeleccionadas = materiasCursoSeleccionadas;
	}

	public MateriaDataModel getMateriaUeDataModel() {
		return materiaUeDataModel;
	}

	public void setMateriaUeDataModel(MateriaDataModel materiaUeDataModel) {
		this.materiaUeDataModel = materiaUeDataModel;
	}

	public MateriaDataModel getMateriaCursoDataModel() {
		return materiaCursoDataModel;
	}

	public void setMateriaCursoDataModel(MateriaDataModel materiaCursoDataModel) {
		this.materiaCursoDataModel = materiaCursoDataModel;
	}

	public Boolean getLeftRgth() {
		return leftRgth;
	}

	public void setLeftRgth(Boolean leftRgth) {
		this.leftRgth = leftRgth;
	}

}
