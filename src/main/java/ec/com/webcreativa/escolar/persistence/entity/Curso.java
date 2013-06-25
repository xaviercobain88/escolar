/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author xavier
 */
@Entity
@Table(name = "curso", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_curso" }) })
@NamedQueries({
		@NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
		@NamedQuery(name = "Curso.findByIdCurso", query = "SELECT c FROM Curso c WHERE c.idCurso = :idCurso"),
		@NamedQuery(name = "Curso.findByNombre", query = "SELECT c FROM Curso c WHERE c.nombre = :nombre"),
		@NamedQuery(name = "Curso.findByDescripcion", query = "SELECT c FROM Curso c WHERE c.descripcion = :descripcion"),
		@NamedQuery(name = "Curso.findByActivo", query = "SELECT c FROM Curso c WHERE c.activo = :activo"),
		@NamedQuery(name = "Curso.findByIdSeccion_Activo", query = "SELECT c FROM Curso c WHERE c.seccion.idSeccion = :idSeccion and c.activo = :activo"),
		@NamedQuery(name = "Curso.findByCupo", query = "SELECT c FROM Curso c WHERE c.cupo = :cupo"),
		@NamedQuery(name = "Curso.findByEstudiantesPorParalelo", query = "SELECT c FROM Curso c WHERE c.estudiantesPorParalelo = :estudiantesPorParalelo") })
public class Curso implements Serializable, ComboBoxModel, Comparable<Curso> {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "CURSO_IDCURSO_GENERATOR", sequenceName = "SEQ_CURSO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CURSO_IDCURSO_GENERATOR")
	@Basic(optional = false)
	@NotNull
	@Column(name = "id_curso", nullable = false)
	private Integer idCurso;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 64)
	@Column(name = "nombre", nullable = false, length = 64)
	private String nombre;
	@Size(max = 256)
	@Column(name = "descripcion", length = 256)
	private String descripcion;
	@Basic(optional = false)
	@NotNull
	@Column(name = "activo", nullable = false)
	private boolean activo;
	@Basic(optional = false)
	@NotNull
	@Column(name = "cupo", nullable = false)
	private short cupo;
	@Column(name = "estudiantes_por_paralelo")
	private Short estudiantesPorParalelo;
	@JoinTable(name = "curso_materia", joinColumns = { @JoinColumn(name = "id_curso", referencedColumnName = "id_curso", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_materia", referencedColumnName = "id_materia", nullable = false) })
	@ManyToMany
	private List<Materia> materiaList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
	private List<HistoricoMateria> historicoMateriaList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
	private List<Paralelo> paraleloList;
	@JoinColumn(name = "id_seccion", referencedColumnName = "id_seccion", nullable = false)
	@ManyToOne(optional = false)
	private Seccion seccion;
	@OneToMany(mappedBy = "cursoAnterior")
	private List<Curso> cursosSiguientesList;// Solo debe tener 1
	@JoinColumn(name = "id_curso_ante", referencedColumnName = "id_curso")
	@ManyToOne
	private Curso cursoAnterior;

	@OneToMany(mappedBy = "cursoBase")
	private List<Curso> cursosExtendidosList;
	@JoinColumn(name = "id_curso_base", referencedColumnName = "id_curso")
	@ManyToOne
	private Curso cursoBase;

	public Curso() {
	}

	public Curso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public Curso(Integer idCurso, String nombre, boolean activo, short cupo) {
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.activo = activo;
		this.cupo = cupo;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public short getCupo() {
		return cupo;
	}

	public void setCupo(short cupo) {
		this.cupo = cupo;
	}

	public Short getEstudiantesPorParalelo() {
		return estudiantesPorParalelo;
	}

	public void setEstudiantesPorParalelo(Short estudiantesPorParalelo) {
		this.estudiantesPorParalelo = estudiantesPorParalelo;
	}

	public List<Materia> getMateriaList() {
		return materiaList;
	}

	public void setMateriaList(List<Materia> materiaList) {
		this.materiaList = materiaList;
	}

	public List<HistoricoMateria> getHistoricoMateriaList() {
		return historicoMateriaList;
	}

	public void setHistoricoMateriaList(
			List<HistoricoMateria> historicoMateriaList) {
		this.historicoMateriaList = historicoMateriaList;
	}

	public List<Paralelo> getParaleloList() {
		return paraleloList;
	}

	public void setParaleloList(List<Paralelo> paraleloList) {
		this.paraleloList = paraleloList;
	}

	public Seccion getSeccion() {
		return seccion;
	}

	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}

	public List<Curso> getCursosSiguientesList() {
		return cursosSiguientesList;
	}

	public void setCursosSiguientesList(List<Curso> cursosSiguientesList) {
		this.cursosSiguientesList = cursosSiguientesList;
	}

	public Curso getCursoAnterior() {
		return cursoAnterior;
	}

	public void setCursoAnterior(Curso cursoAnterior) {
		this.cursoAnterior = cursoAnterior;
	}

	public List<Curso> getCursosExtendidosList() {
		return cursosExtendidosList;
	}

	public void setCursosExtendidosList(List<Curso> cursosExtendidosList) {
		this.cursosExtendidosList = cursosExtendidosList;
	}

	public Curso getCursoBase() {
		return cursoBase;
	}

	public void setCursoBase(Curso cursoBase) {
		this.cursoBase = cursoBase;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idCurso != null ? idCurso.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Curso)) {
			return false;
		}
		Curso other = (Curso) object;
		if ((this.idCurso == null && other.idCurso != null)
				|| (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "webcreativa.escolar_login.model.Curso[ idCurso=" + idCurso
				+ " ]";
	}

	@Override
	public Integer getComboBoxValue() {
		return idCurso;
	}

	@Override
	public String getComboBoxLabel() {
		return nombre;
	}

	@Override
	public int compareTo(Curso arg0) {
		if (arg0 != null && arg0.idCurso != null) {
			return idCurso>=arg0.idCurso?1:0;
		} else {
			return 100;
		}
	}

}
