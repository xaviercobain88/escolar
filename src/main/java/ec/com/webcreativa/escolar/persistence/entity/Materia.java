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
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ec.com.webcreativa.escolar.persistence.enums.TipoMateriaEnum;

/**
 * 
 * @author xavier
 */
@Entity
@Table(name = "materia", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_materia" }) })
@NamedQueries({
		@NamedQuery(name = "Materia.findAll", query = "SELECT m FROM Materia m"),
		@NamedQuery(name = "Materia.findByIdMateria", query = "SELECT m FROM Materia m WHERE m.idMateria = :idMateria"),
		@NamedQuery(name = "Materia.findByNombre", query = "SELECT m FROM Materia m WHERE m.nombre = :nombre"),
		@NamedQuery(name = "Materia.findByDescripcion", query = "SELECT m FROM Materia m WHERE m.descripcion = :descripcion"),
		@NamedQuery(name = "Materia.findByContenidos", query = "SELECT m FROM Materia m WHERE m.contenidos = :contenidos"),
		@NamedQuery(name = "Materia.findByidUe_idCurso", query = "SELECT m FROM Materia m inner join m.cursoList c WHERE m.unidadEducativa.idUe = :idUe and c.idCurso = :idCurso and m.activo= :activo"),
		@NamedQuery(name = "Materia.findByidUe_idCursoNot", query = "SELECT m FROM Materia m inner join m.cursoList c WHERE m.unidadEducativa.idUe = :idUe and c.idCurso != :idCurso and m.activo= :activo"),
		@NamedQuery(name = "Materia.findByActivo", query = "SELECT m FROM Materia m WHERE m.activo = :activo") })
public class Materia implements Serializable, Comparable<Materia> {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "MATERIA_IDMATERIA_GENERATOR", sequenceName = "SEQ_MATERIA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MATERIA_IDMATERIA_GENERATOR")
	@Basic(optional = false)
	@NotNull
	@Column(name = "id_materia", nullable = false)
	private Integer idMateria;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 64)
	@Column(name = "nombre", nullable = false, length = 64)
	private String nombre;
	@Size(max = 256)
	@Column(name = "descripcion", length = 256)
	private String descripcion;
	@Size(max = 2048)
	@Column(name = "contenidos", length = 2048)
	private String contenidos;
	@Basic(optional = false)
	@NotNull
	@Column(name = "activo", nullable = false)
	private boolean activo;
	@JoinTable(name = "recurso_materia", joinColumns = { @JoinColumn(name = "id_materia", referencedColumnName = "id_materia", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_recurso", referencedColumnName = "id_recurso", nullable = false) })
	@ManyToMany
	private List<Recurso> recursoList;
	@ManyToMany(mappedBy = "materiaList")
	private List<Curso> cursoList;
	@JoinColumn(name = "id_ue", referencedColumnName = "id_ue")
	@ManyToOne
	private UnidadEducativa unidadEducativa;
	@JoinColumn(name = "id_tip_materia", referencedColumnName = "id_tip_materia")
	@ManyToOne
	private TipoMateria tipoMateria;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
	private List<HistoricoAcademicoMensual> historicoAcademicoMensualList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
	private List<HistoricoMateria> historicoMateriaList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
	private List<Contenido> contenidoList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
	private List<HistoricoAcademicoAnual> historicoAcademicoAnualList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "materia")
	private List<Clase> claseList;
	@JoinTable(name = "continuidad_materia", joinColumns = { @JoinColumn(name = "id_materia_ante", referencedColumnName = "id_materia", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_materia_sig", referencedColumnName = "id_materia", nullable = false) })
	@ManyToMany
	private List<Materia> materiasAnterioresList;
	@ManyToMany(mappedBy = "materiasAnterioresList")
	private List<Materia> materiasSiguientesList;
	@Transient
	private TipoMateriaEnum tipoMateriaEnum;
	@Transient
	private Boolean cambiada;

	public Materia() {
	}

	public Materia(Integer idMateria) {
		this.idMateria = idMateria;
	}

	public Materia(Integer idMateria, String nombre, boolean activo) {
		this.idMateria = idMateria;
		this.nombre = nombre;
		this.activo = activo;
	}

	public Integer getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(Integer idMateria) {
		this.idMateria = idMateria;
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

	public String getContenidos() {
		return contenidos;
	}

	public void setContenidos(String contenidos) {
		this.contenidos = contenidos;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public List<Recurso> getRecursoList() {
		return recursoList;
	}

	public void setRecursoList(List<Recurso> recursoList) {
		this.recursoList = recursoList;
	}

	public List<Curso> getCursoList() {
		return cursoList;
	}

	public void setCursoList(List<Curso> cursoList) {
		this.cursoList = cursoList;
	}

	public UnidadEducativa getUnidadEducativa() {
		return unidadEducativa;
	}

	public void setUnidadEducativa(UnidadEducativa unidadEducativa) {
		this.unidadEducativa = unidadEducativa;
	}

	public TipoMateria getTipoMateria() {
		return tipoMateria;
	}

	public void setTipoMateria(TipoMateria tipoMateria) {
		this.tipoMateria = tipoMateria;
	}

	public List<HistoricoAcademicoMensual> getHistoricoAcademicoMensualList() {
		return historicoAcademicoMensualList;
	}

	public void setHistoricoAcademicoMensualList(
			List<HistoricoAcademicoMensual> historicoAcademicoMensualList) {
		this.historicoAcademicoMensualList = historicoAcademicoMensualList;
	}

	public List<HistoricoMateria> getHistoricoMateriaList() {
		return historicoMateriaList;
	}

	public void setHistoricoMateriaList(
			List<HistoricoMateria> historicoMateriaList) {
		this.historicoMateriaList = historicoMateriaList;
	}

	public List<Contenido> getContenidoList() {
		return contenidoList;
	}

	public void setContenidoList(List<Contenido> contenidoList) {
		this.contenidoList = contenidoList;
	}

	public List<HistoricoAcademicoAnual> getHistoricoAcademicoAnualList() {
		return historicoAcademicoAnualList;
	}

	public void setHistoricoAcademicoAnualList(
			List<HistoricoAcademicoAnual> historicoAcademicoAnualList) {
		this.historicoAcademicoAnualList = historicoAcademicoAnualList;
	}

	public List<Clase> getClaseList() {
		return claseList;
	}

	public void setClaseList(List<Clase> claseList) {
		this.claseList = claseList;
	}

	public List<Materia> getMateriasAnterioresList() {
		return materiasAnterioresList;
	}

	public void setMateriasAnterioresList(List<Materia> materiasAnterioresList) {
		this.materiasAnterioresList = materiasAnterioresList;
	}

	public List<Materia> getMateriasSiguientesList() {
		return materiasSiguientesList;
	}

	public void setMateriasSiguientesList(List<Materia> materiasSiguientesList) {
		this.materiasSiguientesList = materiasSiguientesList;
	}

	public TipoMateriaEnum getTipoMateriaEnum() {
		return tipoMateriaEnum;
	}

	public void setTipoMateriaEnum(TipoMateriaEnum tipoMateriaEnum) {
		this.tipoMateriaEnum = tipoMateriaEnum;
	}

	public Boolean getCambiada() {
		return cambiada;
	}

	public void setCambiada(Boolean cambiada) {
		this.cambiada = cambiada;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idMateria != null ? idMateria.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Materia)) {
			return false;
		}
		Materia other = (Materia) object;
		if ((this.idMateria == null && other.idMateria != null)
				|| (this.idMateria != null && !this.idMateria
						.equals(other.idMateria))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "webcreativa.escolar_login.model.Materia[ idMateria="
				+ idMateria + " ]";
	}

	@Override
	public int compareTo(Materia o) {
		if (o != null && o.nombre != null) {
			return nombre.compareTo(o.nombre);
		} else {
			return 100;
		}
	}

}
