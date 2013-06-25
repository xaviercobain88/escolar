/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author xavier
 */
@Entity
@Table(name = "registro", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_registro"})})
@NamedQueries({
    @NamedQuery(name = "Registro.findAll", query = "SELECT r FROM Registro r"),
    @NamedQuery(name = "Registro.findByIdRegistro", query = "SELECT r FROM Registro r WHERE r.idRegistro = :idRegistro"),
    @NamedQuery(name = "Registro.findByFechaRegistro", query = "SELECT r FROM Registro r WHERE r.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Registro.findByDescripcionRegistro", query = "SELECT r FROM Registro r WHERE r.descripcionRegistro = :descripcionRegistro")})
public class Registro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="REGISTRO_IDREGISTRO_GENERATOR", sequenceName="SEQ_REGISTRO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REGISTRO_IDREGISTRO_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_registro", nullable = false)
    private Integer idRegistro;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_registro", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(name = "descripcion_registro", nullable = false, length = 1024)
    private String descripcionRegistro;
    @JoinColumns({
        @JoinColumn(name = "id_mes_setup", referencedColumnName = "id_mes_setup", nullable = false),
        @JoinColumn(name = "id_clase", referencedColumnName = "id_clase", nullable = false)})
    @ManyToOne(optional = false)
    private MesClase mesClase;

    public Registro() {
    }

    public Registro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Registro(Integer idRegistro, Date fechaRegistro, String descripcionRegistro) {
        this.idRegistro = idRegistro;
        this.fechaRegistro = fechaRegistro;
        this.descripcionRegistro = descripcionRegistro;
    }

    public Integer getIdRegistro() {
        return idRegistro;
    }

    public void setIdRegistro(Integer idRegistro) {
        this.idRegistro = idRegistro;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getDescripcionRegistro() {
        return descripcionRegistro;
    }

    public void setDescripcionRegistro(String descripcionRegistro) {
        this.descripcionRegistro = descripcionRegistro;
    }

    public MesClase getMesClase() {
        return mesClase;
    }

    public void setMesClase(MesClase mesClase) {
        this.mesClase = mesClase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRegistro != null ? idRegistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registro)) {
            return false;
        }
        Registro other = (Registro) object;
        if ((this.idRegistro == null && other.idRegistro != null) || (this.idRegistro != null && !this.idRegistro.equals(other.idRegistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.Registro[ idRegistro=" + idRegistro + " ]";
    }
    
}
