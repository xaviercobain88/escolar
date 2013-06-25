package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import ec.com.webcreativa.escolar.persistence.enums.RolesFuncionalesEnum;

/**
 * The persistent class for the opcion database table.
 * 
 */
@Entity
@Table(name = "opcion")
@NamedQueries({
		@NamedQuery(name = "Opcion.buscarPadresPorRoles", query = "SELECT DISTINCT o "
				+ "FROM Opcion o inner join o.rolList r "
				+ "WHERE r.idRol in (:idRolList) " + "AND o.opcion is null"),
		@NamedQuery(name = "Opcion.buscarPorRoles_Padre", query = "SELECT o "
				+ "FROM Opcion o inner join o.rolList r "
				+ "WHERE r.idRol in (:idRolList) "
				+ "AND o.opcion.idOpcion = :idOpcionPadre") })
public class Opcion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "OPCION_IDOPCION_GENERATOR", sequenceName = "SEQ_OPCION")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "OPCION_IDOPCION_GENERATOR")
	@Column(name = "id_opcion")
	private Integer idOpcion;
	@Column(name = "descripcion")
	private String descripcion;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "url")
	private String url;
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "tipo")
	private RolesFuncionalesEnum tipo;
	@Column(name = "tipo_desc")
	private String tipoDesc;

	// bi-directional many-to-one association to RolOpcion
	@ManyToMany(mappedBy = "opcionList")
	private List<Rol> rolList;

	// bi-directional many-to-one association to Opcion
	@ManyToOne
	@JoinColumn(name = "id_opcion_padre")
	private Opcion opcion;

	// bi-directional many-to-one association to Opcion
	@OneToMany(mappedBy = "opcion")
	private List<Opcion> opcions;
	@Transient
	private Rol rol;
	@Transient
	private String styleClase;

	public Opcion() {
	}

	public Integer getIdOpcion() {
		return this.idOpcion;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public void setIdOpcion(Integer idOpcion) {
		this.idOpcion = idOpcion;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return this.url;
	}

	public Opcion getOpcion() {
		return opcion;
	}

	public void setOpcion(Opcion opcion) {
		this.opcion = opcion;
	}

	public List<Opcion> getOpcions() {
		return opcions;
	}

	public void setOpcions(List<Opcion> opcions) {
		this.opcions = opcions;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Rol> getRolList() {
		return rolList;
	}

	public void setRolList(List<Rol> rolList) {
		this.rolList = rolList;
	}

	public RolesFuncionalesEnum getTipo() {
		return tipo;
	}

	public void setTipo(RolesFuncionalesEnum tipo) {
		this.tipo = tipo;
	}

	public String getTipoDesc() {
		return tipoDesc;
	}

	public void setTipoDesc(String tipoDesc) {
		this.tipoDesc = tipoDesc;
	}

	public String getStyleClase() {
		return styleClase;
	}

	public void setStyleClase(String styleClase) {
		this.styleClase = styleClase;
	}

}