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
public class MesClasePK implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @NotNull
    @Column(name = "id_mes_setup", nullable = false)
    private int idMesSetup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_clase", nullable = false)
    private int idClase;

    public MesClasePK() {
    }

    public MesClasePK(int idMesSetup, int idClase) {
        this.idMesSetup = idMesSetup;
        this.idClase = idClase;
    }

    public int getIdMesSetup() {
        return idMesSetup;
    }

    public void setIdMesSetup(int idMesSetup) {
        this.idMesSetup = idMesSetup;
    }

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idMesSetup;
        hash += (int) idClase;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MesClasePK)) {
            return false;
        }
        MesClasePK other = (MesClasePK) object;
        if (this.idMesSetup != other.idMesSetup) {
            return false;
        }
        if (this.idClase != other.idClase) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.MesClasePK[ idMesSetup=" + idMesSetup + ", idClase=" + idClase + " ]";
    }
    
}
