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
public class DatosEmpleadoUePK implements Serializable {
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
    @Column(name = "id_ue", nullable = false)
    private int idUe;

    public DatosEmpleadoUePK() {
    }

    public DatosEmpleadoUePK(int idPersona, int idUe) {
        this.idPersona = idPersona;
        this.idUe = idUe;
    }

    public int getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(int idPersona) {
        this.idPersona = idPersona;
    }

    public int getIdUe() {
        return idUe;
    }

    public void setIdUe(int idUe) {
        this.idUe = idUe;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idPersona;
        hash += (int) idUe;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosEmpleadoUePK)) {
            return false;
        }
        DatosEmpleadoUePK other = (DatosEmpleadoUePK) object;
        if (this.idPersona != other.idPersona) {
            return false;
        }
        if (this.idUe != other.idUe) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.DatosEmpleadoUePK[ idPersona=" + idPersona + ", idUe=" + idUe + " ]";
    }
    
}
