/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author xavier
 */
@Embeddable
public class EstudianteRepresentantePK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "id_persona", nullable = false)
    private int idPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "per_id_persona", nullable = false)
    private int perIdPersona;

    public EstudianteRepresentantePK() {
    }

    public EstudianteRepresentantePK(int idPersona, int perIdPersona) {
        this.idPersona = idPersona;
        this.perIdPersona = perIdPersona;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getPerIdPersona() {
        return perIdPersona;
    }

    public void setPerIdPersona(int perIdPersona) {
        this.perIdPersona = perIdPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPersona;
        hash += (int) perIdPersona;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudianteRepresentantePK)) {
            return false;
        }
        EstudianteRepresentantePK other = (EstudianteRepresentantePK) object;
        if (this.idPersona != other.idPersona) {
            return false;
        }
        if (this.perIdPersona != other.perIdPersona) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.EstudianteRepresentantePK[ idPersona=" + idPersona + ", perIdPersona=" + perIdPersona + " ]";
    }
    
}
