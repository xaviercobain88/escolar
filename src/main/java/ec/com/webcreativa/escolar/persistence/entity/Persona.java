/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 
 * @author xavier
 */
@Entity
@Table(name = "persona", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_persona" }) })
@NamedQueries({
		@NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
		@NamedQuery(name = "Persona.findByIdPersona", query = "SELECT p FROM Persona p WHERE p.idPersona = :idPersona"),
		@NamedQuery(name = "Persona.findByNombres", query = "SELECT p FROM Persona p WHERE p.nombres = :nombres"),
		@NamedQuery(name = "Persona.findByApellidos", query = "SELECT p FROM Persona p WHERE p.apellidos = :apellidos"),
		@NamedQuery(name = "Persona.findByCiPasaporte", query = "SELECT p FROM Persona p WHERE p.ciPasaporte = :ciPasaporte"),
		@NamedQuery(name = "Persona.findByFechaNacimiento", query = "SELECT p FROM Persona p WHERE p.fechaNacimiento = :fechaNacimiento"),
		@NamedQuery(name = "Persona.findByUsuario", query = "SELECT p FROM Persona p WHERE p.usuario = :usuario and p.activo=true"),
		@NamedQuery(name = "Persona.findByContrasena", query = "SELECT p FROM Persona p WHERE p.contrasena = :contrasena"),
		@NamedQuery(name = "Persona.findByActivo", query = "SELECT p FROM Persona p WHERE p.activo = :activo"),
		@NamedQuery(name = "Persona.findByPerfil", query = "SELECT p FROM Persona p WHERE p.perfil = :perfil"),
		@NamedQuery(name = "Persona.findByTelefonoContacto1", query = "SELECT p FROM Persona p WHERE p.telefonoContacto1 = :telefonoContacto1"),
		@NamedQuery(name = "Persona.findByTelefonoContacto2", query = "SELECT p FROM Persona p WHERE p.telefonoContacto2 = :telefonoContacto2"),
		@NamedQuery(name = "Persona.findByEMailPersonal", query = "SELECT p FROM Persona p WHERE p.eMailPersonal = :eMailPersonal") })
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "PERSONA_IDPERSONA_GENERATOR", sequenceName = "SEQ_PERSONA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONA_IDPERSONA_GENERATOR")
	@Basic(optional = false)
	@NotNull
	@Column(name = "id_persona", nullable = false)
	private Integer idPersona;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 128)
	@Column(name = "nombres", nullable = false, length = 128)
	private String nombres;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 128)
	@Column(name = "apellidos", nullable = false, length = 128)
	private String apellidos;
	@Size(max = 10)
	@Column(name = "ci_pasaporte", length = 10)
	private String ciPasaporte;
	@Column(name = "fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 64)
	@Column(name = "usuario", nullable = false, length = 64)
	private String usuario;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 64)
	@Column(name = "contrasena", nullable = false, length = 64)
	private String contrasena;
	@Basic(optional = false)
	@NotNull
	@Column(name = "activo", nullable = false)
	private boolean activo;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 32)
	@Column(name = "perfil", nullable = false, length = 32)
	private String perfil;
	@Size(max = 12)
	@Column(name = "telefono_contacto_1", length = 12)
	private String telefonoContacto1;
	@Size(max = 12)
	@Column(name = "telefono_contacto_2", length = 12)
	private String telefonoContacto2;
	@Size(max = 64)
	@Column(name = "e_mail_personal", length = 64)
	private String eMailPersonal;
	@ManyToMany(mappedBy = "personaList")
	private List<Grupo> grupoList;
	@JoinTable(name = "rol_persona", joinColumns = { @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false) })
	@ManyToMany
	private List<Rol> rolList;
	@OneToMany(mappedBy = "persona")
	private List<HistoricoAcademicoMensual> historicoAcademicoMensualList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "persona1")
	private List<HistoricoAcademicoMensual> historicoAcademicoMensualList1;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
	private DatosRepresentante datosRepresentante;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
	private List<HistoricoMateria> historicoMateriaList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
	private List<Grupo> grupoList1;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
	private DatosEstudiante datosEstudiante;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
	private List<DatosEmpleadoUe> datosEmpleadoUeList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
	private List<Matricula> matriculaList;
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "persona")
	private ConfiguracionSistema configuracionSistema;
	@OneToMany(mappedBy = "persona")
	private List<HistoricoAcademicoAnual> historicoAcademicoAnualList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "persona1")
	private List<HistoricoAcademicoAnual> historicoAcademicoAnualList1;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
	private List<Clase> claseList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "persona")
	private List<EstudianteRepresentante> estudianteRepresentanteList;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "persona1")
	private List<EstudianteRepresentante> estudianteRepresentanteList1;
	@JoinColumn(name = "id_det_cat", referencedColumnName = "id_det_cat", nullable = false)
	@ManyToOne(optional = false)
	private DetalleCatalogo detalleCatalogo;
	@Transient
	private String Roles;
	@Transient
	private String tercerIdentificador;

	public Persona() {
	}

	public Persona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public Persona(Integer idPersona, String nombres, String apellidos,
			String usuario, String contrasena, boolean activo, String perfil) {
		this.idPersona = idPersona;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.activo = activo;
		this.perfil = perfil;
	}

	public Integer getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCiPasaporte() {
		return ciPasaporte;
	}

	public void setCiPasaporte(String ciPasaporte) {
		this.ciPasaporte = ciPasaporte;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public boolean getActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getTelefonoContacto1() {
		return telefonoContacto1;
	}

	public void setTelefonoContacto1(String telefonoContacto1) {
		this.telefonoContacto1 = telefonoContacto1;
	}

	public String getTelefonoContacto2() {
		return telefonoContacto2;
	}

	public void setTelefonoContacto2(String telefonoContacto2) {
		this.telefonoContacto2 = telefonoContacto2;
	}

	public String getEmailPersonal() {
		return eMailPersonal;
	}

	public void setEmailPersonal(String eMailPersonal) {
		this.eMailPersonal = eMailPersonal;
	}

	public List<Grupo> getGrupoList() {
		return grupoList;
	}

	public void setGrupoList(List<Grupo> grupoList) {
		this.grupoList = grupoList;
	}

	public List<Rol> getRolList() {
		return rolList;
	}

	public void setRolList(List<Rol> rolList) {
		this.rolList = rolList;
	}

	public List<HistoricoAcademicoMensual> getHistoricoAcademicoMensualList() {
		return historicoAcademicoMensualList;
	}

	public void setHistoricoAcademicoMensualList(
			List<HistoricoAcademicoMensual> historicoAcademicoMensualList) {
		this.historicoAcademicoMensualList = historicoAcademicoMensualList;
	}

	public List<HistoricoAcademicoMensual> getHistoricoAcademicoMensualList1() {
		return historicoAcademicoMensualList1;
	}

	public void setHistoricoAcademicoMensualList1(
			List<HistoricoAcademicoMensual> historicoAcademicoMensualList1) {
		this.historicoAcademicoMensualList1 = historicoAcademicoMensualList1;
	}

	public DatosRepresentante getDatosRepresentante() {
		return datosRepresentante;
	}

	public void setDatosRepresentante(DatosRepresentante datosRepresentante) {
		this.datosRepresentante = datosRepresentante;
	}

	public List<HistoricoMateria> getHistoricoMateriaList() {
		return historicoMateriaList;
	}

	public void setHistoricoMateriaList(
			List<HistoricoMateria> historicoMateriaList) {
		this.historicoMateriaList = historicoMateriaList;
	}

	public List<Grupo> getGrupoList1() {
		return grupoList1;
	}

	public void setGrupoList1(List<Grupo> grupoList1) {
		this.grupoList1 = grupoList1;
	}

	public DatosEstudiante getDatosEstudiante() {
		return datosEstudiante;
	}

	public void setDatosEstudiante(DatosEstudiante datosEstudiante) {
		this.datosEstudiante = datosEstudiante;
	}

	public List<DatosEmpleadoUe> getDatosEmpleadoUeList() {
		return datosEmpleadoUeList;
	}

	public void setDatosEmpleadoUeList(List<DatosEmpleadoUe> datosEmpleadoUeList) {
		this.datosEmpleadoUeList = datosEmpleadoUeList;
	}

	public List<Matricula> getMatriculaList() {
		return matriculaList;
	}

	public void setMatriculaList(List<Matricula> matriculaList) {
		this.matriculaList = matriculaList;
	}

	public ConfiguracionSistema getConfiguracionSistema() {
		return configuracionSistema;
	}

	public void setConfiguracionSistema(
			ConfiguracionSistema configuracionSistema) {
		this.configuracionSistema = configuracionSistema;
	}

	public List<HistoricoAcademicoAnual> getHistoricoAcademicoAnualList() {
		return historicoAcademicoAnualList;
	}

	public void setHistoricoAcademicoAnualList(
			List<HistoricoAcademicoAnual> historicoAcademicoAnualList) {
		this.historicoAcademicoAnualList = historicoAcademicoAnualList;
	}

	public List<HistoricoAcademicoAnual> getHistoricoAcademicoAnualList1() {
		return historicoAcademicoAnualList1;
	}

	public void setHistoricoAcademicoAnualList1(
			List<HistoricoAcademicoAnual> historicoAcademicoAnualList1) {
		this.historicoAcademicoAnualList1 = historicoAcademicoAnualList1;
	}

	public List<Clase> getClaseList() {
		return claseList;
	}

	public void setClaseList(List<Clase> claseList) {
		this.claseList = claseList;
	}

	public List<EstudianteRepresentante> getEstudianteRepresentanteList() {
		return estudianteRepresentanteList;
	}

	public void setEstudianteRepresentanteList(
			List<EstudianteRepresentante> estudianteRepresentanteList) {
		this.estudianteRepresentanteList = estudianteRepresentanteList;
	}

	public List<EstudianteRepresentante> getEstudianteRepresentanteList1() {
		return estudianteRepresentanteList1;
	}

	public void setEstudianteRepresentanteList1(
			List<EstudianteRepresentante> estudianteRepresentanteList1) {
		this.estudianteRepresentanteList1 = estudianteRepresentanteList1;
	}

	public DetalleCatalogo getDetalleCatalogo() {
		return detalleCatalogo;
	}

	public void setDetalleCatalogo(DetalleCatalogo detalleCatalogo) {
		this.detalleCatalogo = detalleCatalogo;
	}

	public String getRoles() {
		return Roles;
	}

	public void setRoles(String roles) {
		Roles = roles;
	}
	

	public String getTercerIdentificador() {
		return tercerIdentificador;
	}

	public void setTercerIdentificador(String tercerIdentificador) {
		this.tercerIdentificador = tercerIdentificador;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idPersona != null ? idPersona.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Persona)) {
			return false;
		}
		Persona other = (Persona) object;
		if ((this.idPersona == null && other.idPersona != null)
				|| (this.idPersona != null && !this.idPersona
						.equals(other.idPersona))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "webcreativa.escolar_login.model.Persona[ idPersona="
				+ idPersona + " ]";
	}

}
