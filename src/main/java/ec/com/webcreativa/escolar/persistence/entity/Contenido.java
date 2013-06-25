/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "contenido", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_contenido"})})
@NamedQueries({
    @NamedQuery(name = "Contenido.findAll", query = "SELECT c FROM Contenido c"),
    @NamedQuery(name = "Contenido.findByIdContenido", query = "SELECT c FROM Contenido c WHERE c.idContenido = :idContenido"),
    @NamedQuery(name = "Contenido.findByContenido", query = "SELECT c FROM Contenido c WHERE c.contenido = :contenido"),
    @NamedQuery(name = "Contenido.findByActivo", query = "SELECT c FROM Contenido c WHERE c.activo = :activo")})
public class Contenido implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="CONTENIDO_IDCONTENIDO_GENERATOR", sequenceName="SEQ_CONTENIDO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CONTENIDO_IDCONTENIDO_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_contenido", nullable = false)
    private Integer idContenido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2048)
    @Column(name = "contenido", nullable = false, length = 2048)
    private String contenido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @JoinColumn(name = "id_mes_setup", referencedColumnName = "id_mes_setup", nullable = false)
    @ManyToOne(optional = false)
    private MesSetup mesSetup;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia", nullable = false)
    @ManyToOne(optional = false)
    private Materia materia;

    public Contenido() {
    }

    public Contenido(Integer idContenido) {
        this.idContenido = idContenido;
    }

    public Contenido(Integer idContenido, String contenido, boolean activo) {
        this.idContenido = idContenido;
        this.contenido = contenido;
        this.activo = activo;
    }

    public Integer getIdContenido() {
        return idContenido;
    }

    public void setIdContenido(Integer idContenido) {
        this.idContenido = idContenido;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public MesSetup getMesSetup() {
        return mesSetup;
    }

    public void setMesSetup(MesSetup mesSetup) {
        this.mesSetup = mesSetup;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContenido != null ? idContenido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Contenido)) {
            return false;
        }
        Contenido other = (Contenido) object;
        if ((this.idContenido == null && other.idContenido != null) || (this.idContenido != null && !this.idContenido.equals(other.idContenido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.Contenido[ idContenido=" + idContenido + " ]";
    }
    
}
