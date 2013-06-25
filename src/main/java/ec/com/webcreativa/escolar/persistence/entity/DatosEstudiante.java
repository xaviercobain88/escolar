/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author xavier
 */
@Entity
@Table(name = "datos_estudiante", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_persona"})})
@NamedQueries({
    @NamedQuery(name = "DatosEstudiante.findAll", query = "SELECT d FROM DatosEstudiante d"),
    @NamedQuery(name = "DatosEstudiante.findByIdPersona", query = "SELECT d FROM DatosEstudiante d WHERE d.idPersona = :idPersona"),
    @NamedQuery(name = "DatosEstudiante.findByObservacionMedica", query = "SELECT d FROM DatosEstudiante d WHERE d.observacionMedica = :observacionMedica"),
    @NamedQuery(name = "DatosEstudiante.findByOtraInstiProce", query = "SELECT d FROM DatosEstudiante d WHERE d.otraInstiProce = :otraInstiProce")})
public class DatosEstudiante implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_persona", nullable = false)
    private Integer idPersona;
    @Size(max = 512)
    @Column(name = "observacion_medica", length = 512)
    private String observacionMedica;
    @Size(max = 64)
    @Column(name = "otra_insti_proce", length = 64)
    private String otraInstiProce;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;

    public DatosEstudiante() {
    }

    public DatosEstudiante(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getObservacionMedica() {
        return observacionMedica;
    }

    public void setObservacionMedica(String observacionMedica) {
        this.observacionMedica = observacionMedica;
    }

    public String getOtraInstiProce() {
        return otraInstiProce;
    }

    public void setOtraInstiProce(String otraInstiProce) {
        this.otraInstiProce = otraInstiProce;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersona != null ? idPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosEstudiante)) {
            return false;
        }
        DatosEstudiante other = (DatosEstudiante) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.DatosEstudiante[ idPersona=" + idPersona + " ]";
    }
    
}
