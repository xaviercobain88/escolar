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
@Table(name = "configuracion_sistema", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_persona"})})
@NamedQueries({
    @NamedQuery(name = "ConfiguracionSistema.findAll", query = "SELECT c FROM ConfiguracionSistema c"),
    @NamedQuery(name = "ConfiguracionSistema.findByIdPersona", query = "SELECT c FROM ConfiguracionSistema c WHERE c.idPersona = :idPersona"),
    @NamedQuery(name = "ConfiguracionSistema.findByEMailSistema", query = "SELECT c FROM ConfiguracionSistema c WHERE c.eMailSistema = :eMailSistema")})
public class ConfiguracionSistema implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_persona", nullable = false)
    private Integer idPersona;
    @Size(max = 64)
    @Column(name = "e_mail_sistema", length = 64)
    private String eMailSistema;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false, insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Persona persona;

    public ConfiguracionSistema() {
    }

    public ConfiguracionSistema(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getEMailSistema() {
        return eMailSistema;
    }

    public void setEMailSistema(String eMailSistema) {
        this.eMailSistema = eMailSistema;
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
        if (!(object instanceof ConfiguracionSistema)) {
            return false;
        }
        ConfiguracionSistema other = (ConfiguracionSistema) object;
        if ((this.idPersona == null && other.idPersona != null) || (this.idPersona != null && !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.ConfiguracionSistema[ idPersona=" + idPersona + " ]";
    }
    
}
