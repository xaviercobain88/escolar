/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author xavier
 */
@Entity
@Table(name = "estudiante_representante", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_persona", "per_id_persona"})})
@NamedQueries({
    @NamedQuery(name = "EstudianteRepresentante.findAll", query = "SELECT e FROM EstudianteRepresentante e"),
    @NamedQuery(name = "EstudianteRepresentante.findByIdPersona", query = "SELECT e FROM EstudianteRepresentante e WHERE e.estudianteRepresentantePK.idPersona = :idPersona"),
    @NamedQuery(name = "EstudianteRepresentante.findByPerIdPersona", query = "SELECT e FROM EstudianteRepresentante e WHERE e.estudianteRepresentantePK.perIdPersona = :perIdPersona"),
    @NamedQuery(name = "EstudianteRepresentante.findByActivo", query = "SELECT e FROM EstudianteRepresentante e WHERE e.activo = :activo")})
public class EstudianteRepresentante implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EstudianteRepresentantePK estudianteRepresentantePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "per_id_persona", referencedColumnName = "id_persona", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona1;
    @JoinColumn(name = "id_det_cat", referencedColumnName = "id_det_cat", nullable = false)
    @ManyToOne(optional = false)
    private DetalleCatalogo detalleCatalogo;

    public EstudianteRepresentante() {
    }

    public EstudianteRepresentante(EstudianteRepresentantePK estudianteRepresentantePK) {
        this.estudianteRepresentantePK = estudianteRepresentantePK;
    }

    public EstudianteRepresentante(EstudianteRepresentantePK estudianteRepresentantePK, boolean activo) {
        this.estudianteRepresentantePK = estudianteRepresentantePK;
        this.activo = activo;
    }

    public EstudianteRepresentante(int idPersona, int perIdPersona) {
        this.estudianteRepresentantePK = new EstudianteRepresentantePK(idPersona, perIdPersona);
    }

    public EstudianteRepresentantePK getEstudianteRepresentantePK() {
        return estudianteRepresentantePK;
    }

    public void setEstudianteRepresentantePK(EstudianteRepresentantePK estudianteRepresentantePK) {
        this.estudianteRepresentantePK = estudianteRepresentantePK;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona1() {
        return persona1;
    }

    public void setPersona1(Persona persona1) {
        this.persona1 = persona1;
    }

    public DetalleCatalogo getDetalleCatalogo() {
        return detalleCatalogo;
    }

    public void setDetalleCatalogo(DetalleCatalogo detalleCatalogo) {
        this.detalleCatalogo = detalleCatalogo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estudianteRepresentantePK != null ? estudianteRepresentantePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstudianteRepresentante)) {
            return false;
        }
        EstudianteRepresentante other = (EstudianteRepresentante) object;
        if ((this.estudianteRepresentantePK == null && other.estudianteRepresentantePK != null) || (this.estudianteRepresentantePK != null && !this.estudianteRepresentantePK.equals(other.estudianteRepresentantePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.EstudianteRepresentante[ estudianteRepresentantePK=" + estudianteRepresentantePK + " ]";
    }
    
}
