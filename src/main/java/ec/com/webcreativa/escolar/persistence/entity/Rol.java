/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
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
@Table(name = "rol", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_rol" }) })
@NamedQueries({
		@NamedQuery(name = "Rol.findAll", query = "SELECT r FROM Rol r"),
		@NamedQuery(name = "Rol.findByIdRol", query = "SELECT r FROM Rol r WHERE r.idRol = :idRol"),
		@NamedQuery(name = "Rol.findByIdUnidadEducativa", query = "SELECT r FROM Rol r WHERE r.unidadEducativa.idUe = :idUe"),
		@NamedQuery(name = "Rol.findByIdUnidadEducativa_IdPersona", query = "SELECT r FROM Rol r inner join r.personaList p WHERE r.unidadEducativa.idUe = :idUe and p.idPersona = :idPersona"),
		@NamedQuery(name = "Rol.findByRol", query = "SELECT r FROM Rol r WHERE r.rol = :rol") })
public class Rol implements Serializable, ComboBoxModel{
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "ROL_IDROL_GENERATOR", sequenceName = "SEQ_ROL")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROL_IDROL_GENERATOR")
	@Basic(optional = false)
	@NotNull
	@Column(name = "id_rol", nullable = false)
	private Integer idRol;
	@Basic(optional = false)
	@NotNull
	@Size(min = 1, max = 64)
	@Column(name = "rol", nullable = false, length = 64)
	private String rol;
	@ManyToMany(mappedBy = "rolList")
	private List<Persona> personaList;
	@JoinColumn(name = "id_ue", referencedColumnName = "id_ue")
	@ManyToOne
	private UnidadEducativa unidadEducativa;

	@JoinTable(name = "rol_opcion", joinColumns = { @JoinColumn(name = "id_rol", referencedColumnName = "id_rol", nullable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_opcion", referencedColumnName = "id_opcion", nullable = false) })
	@ManyToMany
	private List<Opcion> opcionList;

	public Rol() {
	}

	public Rol(Integer idRol) {
		this.idRol = idRol;
	}

	public UnidadEducativa getUnidadEducativa() {
		return unidadEducativa;
	}

	public void setUnidadEducativa(UnidadEducativa unidadEducativa) {
		this.unidadEducativa = unidadEducativa;
	}

	public Rol(Integer idRol, String rol) {
		this.idRol = idRol;
		this.rol = rol;
	}

	public List<Opcion> getOpcionList() {
		return opcionList;
	}

	public void setOpcionList(List<Opcion> opcionList) {
		this.opcionList = opcionList;
	}

	public Integer getIdRol() {
		return idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	public List<Persona> getPersonaList() {
		return personaList;
	}

	public void setPersonaList(List<Persona> personaList) {
		this.personaList = personaList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (idRol != null ? idRol.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Rol)) {
			return false;
		}
		Rol other = (Rol) object;
		if ((this.idRol == null && other.idRol != null)
				|| (this.idRol != null && !this.idRol.equals(other.idRol))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "webcreativa.escolar_login.model.Rol[ idRol=" + idRol + " ]";
	}

	@Override
	public Integer getComboBoxValue() {
		return idRol;
	}

	@Override
	public String getComboBoxLabel() {
		return rol;
	}

}
