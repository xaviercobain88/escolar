/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "seccion", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_seccion" }) })
@NamedQueries({
		@NamedQuery(name = "Seccion.findAll", query = "SELECT s FROM Seccion s"),
		@NamedQuery(name = "Seccion.findByIdSeccion", query = "SELECT s FROM Seccion s WHERE s.idSeccion = :idSeccion"),
		@NamedQuery(name = "Seccion.findByNombre", query = "SELECT s FROM Seccion s WHERE s.nombre = :nombre"),
		@NamedQuery(name = "Seccion.findByDescripcion", query = "SELECT s FROM Seccion s WHERE s.descripcion = :descripcion"),
		@NamedQuery(name = "Seccion.findByActivo", query = "SELECT s FROM Seccion s WHERE s.activo = :activo"),
		@NamedQuery(name = "Seccion.findByMinimoAprobacion", query = "SELECT s FROM Seccion s WHERE s.minimoAprobacion = :minimoAprobacion"),
		@NamedQuery(name = "Seccion.findByNombreDivision", query = "SELECT s FROM Seccion s WHERE s.nombreDivision = :nombreDivision"),
		@NamedQuery(name = "Seccion.findByCantidadDivision", query = "SELECT s FROM Seccion s WHERE s.cantidadDivision = :cantidadDivision"),
		@NamedQuery(name = "Seccion.findByNombreSubdivision", query = "SELECT s FROM Seccion s WHERE s.nombreSubdivision = :nombreSubdivision"),
		@NamedQuery(name = "Seccion.findByCantidadSubdivision", query = "SELECT s FROM Seccion s WHERE s.cantidadSubdivision = :cantidadSubdivision"),
		@NamedQuery(name = "Seccion.findByIdUe_idSeccionPadre_Activo", query = "SELECT s FROM Seccion s WHERE s.unidadEducativa.idUe= :idUe and s.seccionPadre.idSeccion = :idSeccion and s.activo = :activo"),
		@NamedQuery(name = "Seccion.findByIdUe_idSeccionPadreNull_Activo", query = "SELECT s FROM Seccion s WHERE s.unidadEducativa.idUe= :idUe and s.seccionPadre is null and s.activo = :activo"),
		@NamedQuery(name = "Seccion.findByEstudiantesPorCurso", query = "SELECT s FROM Seccion s WHERE s.estudiantesPorCurso = :estudiantesPorCurso") })
public class Seccion implements Serializable, ComboBoxModel, Comparable<Seccion> {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "SECCION_IDSECCION_GENERATOR", sequenceName = "SEQ_SECCION")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SECCION_IDSECCION_GENERATOR")
	@Basic(optional = false)
	@NotNull
	@Column(name = "id_seccion", nullable = false)
	private Integer idSeccion;
	@Size(max = 64)
	@Column(name = "nombre", length = 64)
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
	@Column(name = "minimo_aprobacion", nullable = false)
	private BigInteger minimoAprobacion;
	@Size(min = 1, max = 64)
	@Column(name = "nombre_division", length = 64)
	private String nombreDivision;
	@Column(name = "cantidad_division")
	private Short cantidadDivision;
	@Size(max = 64)
	@Column(name = "nombre_subdivision", length = 64)
	private String nombreSubdivision;
	@Column(name = "implementacion")
	private Boolean implementacion;
	@Column(name = "cantidad_subdivision")
	private Short cantidadSubdivision;
	@Column(name = "estudiantes_por_curso")
	private Short estudiantesPorCurso;
	@JoinTable(name = "continuidad_seccion", joinColumns = { @JoinColumn(name = "id_seccion", referencedColumnName = "id_seccion", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "sec_id_seccion", referencedColumnName = "id_seccion", nullable = false) })
	@ManyToMany
	private List<Seccion> seccionesAnterioresList;
	@ManyToMany(mappedBy = "seccionesAnterioresList")
	private List<Seccion> seccionesSiguientesList;
	@JoinColumn(name = "id_ue", referencedColumnName = "id_ue", nullable = false)
	@ManyToOne(optional = false)
	private UnidadEducativa unidadEducativa;
	@OneToMany(mappedBy = "seccion")
	private List<MesSetup> mesSetupList;
	@OneToMany(mappedBy = "seccion")
	private List<HerramientaClaseAgrupacion> herramientaClaseAgrupacionList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "seccion")
	private List<Curso> cursoList;
	@ManyToOne
	@JoinColumn(name = "id_seccion_padre")
	private Seccion seccionPadre;
	@ManyToOne
	@JoinColumn(name = "id_seccion_base")
	private Seccion seccionBase;

	@OneToMany(mappedBy = "seccionPadre")
	private List<Seccion> seccionesHijas;
	@OneToMany(mappedBy = "seccionBase")
	private List<Seccion> seccionesExtendidas;

	public Seccion() {
	}

	public Seccion(Integer idSeccion) {
		this.idSeccion = idSeccion;
	}

	public Seccion(Integer idSeccion, boolean activo,
			BigInteger minimoAprobacion, String nombreDivision,
			Short cantidadDivision) {
		this.idSeccion = idSeccion;
		this.activo = activo;
		this.minimoAprobacion = minimoAprobacion;
		this.nombreDivision = nombreDivision;
		this.cantidadDivision = cantidadDivision;
	}

	public Integer getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(Integer idSeccion) {
		this.idSeccion = idSeccion;
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

	public BigInteger getMinimoAprobacion() {
		return minimoAprobacion;
	}

	public void setMinimoAprobacion(BigInteger minimoAprobacion) {
		this.minimoAprobacion = minimoAprobacion;
	}

	public String getNombreDivision() {
		return nombreDivision;
	}

	public void setNombreDivision(String nombreDivision) {
		this.nombreDivision = nombreDivision;
	}

	

	public Short getCantidadDivision() {
		return cantidadDivision;
	}

	public void setCantidadDivision(Short cantidadDivision) {
		this.cantidadDivision = cantidadDivision;
	}

	public String getNombreSubdivision() {
		return nombreSubdivision;
	}

	public void setNombreSubdivision(String nombreSubdivision) {
		this.nombreSubdivision = nombreSubdivision;
	}

	public Short getCantidadSubdivision() {
		return cantidadSubdivision;
	}

	public void setCantidadSubdivision(Short cantidadSubdivision) {
		this.cantidadSubdivision = cantidadSubdivision;
	}

	public Short getEstudiantesPorCurso() {
		return estudiantesPorCurso;
	}

	public void setEstudiantesPorCurso(Short estudiantesPorCurso) {
		this.estudiantesPorCurso = estudiantesPorCurso;
	}

	public List<Seccion> getSeccionesAnterioresList() {
		return seccionesAnterioresList;
	}

	public void setSeccionesAnterioresList(List<Seccion> seccionesAnterioresList) {
		this.seccionesAnterioresList = seccionesAnterioresList;
	}

	public List<Seccion> getSeccionesSiguientesList() {
		return seccionesSiguientesList;
	}

	public void setSeccionesSiguientesList(List<Seccion> seccionesSiguientesList) {
		this.seccionesSiguientesList = seccionesSiguientesList;
	}

	public UnidadEducativa getUnidadEducativa() {
		return unidadEducativa;
	}

	public void setUnidadEducativa(UnidadEducativa unidadEducativa) {
		this.unidadEducativa = unidadEducativa;
	}

	public List<MesSetup> getMesSetupList() {
		return mesSetupList;
	}

	public void setMesSetupList(List<MesSetup> mesSetupList) {
		this.mesSetupList = mesSetupList;
	}

	public List<HerramientaClaseAgrupacion> getHerramientaClaseAgrupacionList() {
		return herramientaClaseAgrupacionList;
	}

	public void setHerramientaClaseAgrupacionList(
			List<HerramientaClaseAgrupacion> herramientaClaseAgrupacionList) {
		this.herramientaClaseAgrupacionList = herramientaClaseAgrupacionList;
	}

	public List<Curso> getCursoList() {
		return cursoList;
	}

	public void setCursoList(List<Curso> cursoList) {
		this.cursoList = cursoList;
	}

	public Seccion getSeccionPadre() {
		return seccionPadre;
	}

	public void setSeccionPadre(Seccion seccionPadre) {
		this.seccionPadre = seccionPadre;
	}

	public Seccion getSeccionBase() {
		return seccionBase;
	}

	public void setSeccionBase(Seccion seccionBase) {
		this.seccionBase = seccionBase;
	}

	public List<Seccion> getSeccionesHijas() {
		return seccionesHijas;
	}

	public void setSeccionesHijas(List<Seccion> seccionesHijas) {
		this.seccionesHijas = seccionesHijas;
	}

	public List<Seccion> getSeccionesExtendidas() {
		return seccionesExtendidas;
	}

	public void setSeccionesExtendidas(List<Seccion> seccionesExtendidas) {
		this.seccionesExtendidas = seccionesExtendidas;
	}

	public Boolean getImplementacion() {
		return implementacion;
	}

	public void setImplementacion(Boolean implementacion) {
		this.implementacion = implementacion;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idSeccion != null ? idSeccion.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Seccion)) {
			return false;
		}
		Seccion other = (Seccion) object;
		if ((this.idSeccion == null && other.idSeccion != null)
				|| (this.idSeccion != null && !this.idSeccion
						.equals(other.idSeccion))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "webcreativa.escolar_login.model.Seccion[ idSeccion="
				+ idSeccion + " ]";
	}

	@Override
	public Integer getComboBoxValue() {
		return idSeccion;
	}

	@Override
	public String getComboBoxLabel() {
		return nombre;
	}

	@Override
	public int compareTo(Seccion o) {
		if (o != null && o.idSeccion!= null) {
			return idSeccion>=o.idSeccion?1:0;
		} else {
			return 100;
		}
	}

}
