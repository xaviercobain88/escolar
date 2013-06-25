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
@Table(name = "unidad_educativa", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_ue" }) })
@NamedQueries({
		@NamedQuery(name = "UnidadEducativa.findAll", query = "SELECT u FROM UnidadEducativa u"),
		@NamedQuery(name = "UnidadEducativa.findByIdUe", query = "SELECT u FROM UnidadEducativa u WHERE u.idUe = :idUe"),
		@NamedQuery(name = "UnidadEducativa.findByNombre", query = "SELECT u FROM UnidadEducativa u WHERE u.nombre = :nombre"),
		@NamedQuery(name = "UnidadEducativa.findBySlogan", query = "SELECT u FROM UnidadEducativa u WHERE u.slogan = :slogan"),
		@NamedQuery(name = "UnidadEducativa.findByMision", query = "SELECT u FROM UnidadEducativa u WHERE u.mision = :mision"),
		@NamedQuery(name = "UnidadEducativa.findByVision", query = "SELECT u FROM UnidadEducativa u WHERE u.vision = :vision"),
		@NamedQuery(name = "UnidadEducativa.findByDireccion", query = "SELECT u FROM UnidadEducativa u WHERE u.direccion = :direccion"),
		@NamedQuery(name = "UnidadEducativa.findByTelefono1", query = "SELECT u FROM UnidadEducativa u WHERE u.telefono1 = :telefono1"),
		@NamedQuery(name = "UnidadEducativa.findByTelefono3", query = "SELECT u FROM UnidadEducativa u WHERE u.telefono3 = :telefono3"),
		@NamedQuery(name = "UnidadEducativa.findByTelefono2", query = "SELECT u FROM UnidadEducativa u WHERE u.telefono2 = :telefono2"),
		@NamedQuery(name = "UnidadEducativa.findByNombreContactoAdm", query = "SELECT u FROM UnidadEducativa u WHERE u.nombreContactoAdm = :nombreContactoAdm"),
		@NamedQuery(name = "UnidadEducativa.findByTelefonoContactoAdm", query = "SELECT u FROM UnidadEducativa u WHERE u.telefonoContactoAdm = :telefonoContactoAdm"),
		@NamedQuery(name = "UnidadEducativa.findByEmailContactoAdm", query = "SELECT u FROM UnidadEducativa u WHERE u.emailContactoAdm = :emailContactoAdm"),
		@NamedQuery(name = "UnidadEducativa.findByDescripcion", query = "SELECT u FROM UnidadEducativa u WHERE u.descripcion = :descripcion"),
		@NamedQuery(name = "UnidadEducativa.findByActivo", query = "SELECT u FROM UnidadEducativa u WHERE u.activo = :activo") })
public class UnidadEducativa implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "UNIDAD_EDUCATIVA_IDUE_GENERATOR", sequenceName = "SEQ_UNIDAD_EDUCATIVA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "UNIDAD_EDUCATIVA_IDUE_GENERATOR")
	@Basic(optional = false)
	@NotNull
	@Column(name = "id_ue", nullable = false)
	private Integer idUe;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 64)
	@Column(name = "nombre", nullable = false, length = 64)
	private String nombre;
	@Size(max = 256)
	@Column(name = "slogan", length = 256)
	private String slogan;
	@Size(max = 256)
	@Column(name = "mision", length = 256)
	private String mision;
	@Size(max = 256)
	@Column(name = "vision", length = 256)
	private String vision;
	@Size(max = 256)
	@Column(name = "direccion", length = 256)
	private String direccion;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 12)
	@Column(name = "telefono_1", nullable = false, length = 12)
	private String telefono1;
	@Size(max = 12)
	@Column(name = "telefono_3", length = 12)
	private String telefono3;
	@Size(max = 12)
	@Column(name = "telefono_2", length = 12)
	private String telefono2;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 256)
	@Column(name = "nombre_contacto_adm", nullable = false, length = 256)
	private String nombreContactoAdm;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 12)
	@Column(name = "telefono_contacto_adm", nullable = false, length = 12)
	private String telefonoContactoAdm;
	@Size(max = 128)
	@Column(name = "e_mail_contacto_adm", length = 128)
	private String emailContactoAdm;
	@Size(max = 128)
	@Column(name = "director", length = 128)
	private String director;
	@Size(max = 256)
	@Column(name = "foto_escudo_dir", length = 256)
	private String fotoEscudoDir;
	@Size(max = 256)
	@Column(name = "foto_director_dir", length = 256)
	private String fotoDirectorDir;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 256)
	@Column(name = "provincia", nullable = false, length = 256)
	private String provincia;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 256)
	@Column(name = "canton", nullable = false, length = 256)
	private String canton;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 256)
	@Column(name = "parroquia", nullable = false, length = 256)
	private String parroquia;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 128)
	@Column(name = "tipo_institucion", nullable = false, length = 128)
	private String tipoInstitucion;
	@Size(max = 128)
	@Column(name = "e_mail", length = 128)
	private String email;
	@Size(max = 256)
	@Column(name = "website", length = 256)
	private String website;
	@Size(max = 256)
	@Column(name = "descripcion", length = 256)
	private String descripcion;
	@Basic(optional = false)
	@NotNull
	@Column(name = "activo", nullable = false)
	private boolean activo;
	@OneToMany(mappedBy = "unidadEducativa")
	private List<Materia> materiaList;
	@OneToMany(mappedBy = "unidadEducativa")
	private List<Rol> rolList;
	@JoinColumn(name = "id_reg", referencedColumnName = "id_reg", nullable = false)
	@ManyToOne(optional = false)
	private Region region;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadEducativa")
	private List<Seccion> seccionList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadEducativa")
	private List<DatosEmpleadoUe> datosEmpleadoUeList;

	public UnidadEducativa() {
	}

	public UnidadEducativa(Integer idUe) {
		this.idUe = idUe;
	}

	public UnidadEducativa(Integer idUe, String nombre, String telefono1,
			String nombreContactoAdm, String telefonoContactoAdm, boolean activo) {
		this.idUe = idUe;
		this.nombre = nombre;
		this.telefono1 = telefono1;
		this.nombreContactoAdm = nombreContactoAdm;
		this.telefonoContactoAdm = telefonoContactoAdm;
		this.activo = activo;
	}

	public List<Rol> getRolList() {
		return rolList;
	}

	public void setRolList(List<Rol> rolList) {
		this.rolList = rolList;
	}

	public Integer getIdUe() {
		return idUe;
	}

	public void setIdUe(Integer idUe) {
		this.idUe = idUe;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSlogan() {
		return slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	public String getMision() {
		return mision;
	}

	public void setMision(String mision) {
		this.mision = mision;
	}

	public String getVision() {
		return vision;
	}
	

	public void setVision(String vision) {
		this.vision = vision;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono3() {
		return telefono3;
	}

	public void setTelefono3(String telefono3) {
		this.telefono3 = telefono3;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}

	public String getNombreContactoAdm() {
		return nombreContactoAdm;
	}

	public void setNombreContactoAdm(String nombreContactoAdm) {
		this.nombreContactoAdm = nombreContactoAdm;
	}

	public String getTelefonoContactoAdm() {
		return telefonoContactoAdm;
	}

	public void setTelefonoContactoAdm(String telefonoContactoAdm) {
		this.telefonoContactoAdm = telefonoContactoAdm;
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

	public List<Materia> getMateriaList() {
		return materiaList;
	}

	public void setMateriaList(List<Materia> materiaList) {
		this.materiaList = materiaList;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	public List<Seccion> getSeccionList() {
		return seccionList;
	}

	public void setSeccionList(List<Seccion> seccionList) {
		this.seccionList = seccionList;
	}

	public List<DatosEmpleadoUe> getDatosEmpleadoUeList() {
		return datosEmpleadoUeList;
	}

	public void setDatosEmpleadoUeList(List<DatosEmpleadoUe> datosEmpleadoUeList) {
		this.datosEmpleadoUeList = datosEmpleadoUeList;
	}

	public String getEmailContactoAdm() {
		return emailContactoAdm;
	}

	public void setEmailContactoAdm(String emailContactoAdm) {
		this.emailContactoAdm = emailContactoAdm;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getFotoEscudoDir() {
		return fotoEscudoDir;
	}

	public void setFotoEscudoDir(String fotoEscudoDir) {
		this.fotoEscudoDir = fotoEscudoDir;
	}

	public String getFotoDirectorDir() {
		return fotoDirectorDir;
	}

	public void setFotoDirectorDir(String fotoDirectorDir) {
		this.fotoDirectorDir = fotoDirectorDir;
	}
	

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCanton() {
		return canton;
	}

	public void setCanton(String canton) {
		this.canton = canton;
	}

	public String getParroquia() {
		return parroquia;
	}

	public void setParroquia(String parroquia) {
		this.parroquia = parroquia;
	}

	public String getTipoInstitucion() {
		return tipoInstitucion;
	}

	public void setTipoInstitucion(String tipoInstitucion) {
		this.tipoInstitucion = tipoInstitucion;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idUe != null ? idUe.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof UnidadEducativa)) {
			return false;
		}
		UnidadEducativa other = (UnidadEducativa) object;
		if ((this.idUe == null && other.idUe != null)
				|| (this.idUe != null && !this.idUe.equals(other.idUe))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "webcreativa.escolar_login.model.UnidadEducativa[ idUe=" + idUe
				+ " ]";
	}

}
