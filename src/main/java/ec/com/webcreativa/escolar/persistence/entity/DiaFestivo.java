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
@Table(name = "dia_festivo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_dia_fest"})})
@NamedQueries({
    @NamedQuery(name = "DiaFestivo.findAll", query = "SELECT d FROM DiaFestivo d"),
    @NamedQuery(name = "DiaFestivo.findByIdDiaFest", query = "SELECT d FROM DiaFestivo d WHERE d.idDiaFest = :idDiaFest"),
    @NamedQuery(name = "DiaFestivo.findByNombre", query = "SELECT d FROM DiaFestivo d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DiaFestivo.findByDescripcion", query = "SELECT d FROM DiaFestivo d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "DiaFestivo.findByFecha", query = "SELECT d FROM DiaFestivo d WHERE d.fecha = :fecha")})
public class DiaFestivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="DIA_FESTIVO_IDDIAFEST_GENERATOR", sequenceName="SEQ_DIA_FESTIVO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DIA_FESTIVO_IDDIAFEST_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_dia_fest", nullable = false)
    private Integer idDiaFest;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "nombre", nullable = false, length = 64)
    private String nombre;
    @Size(max = 256)
    @Column(name = "descripcion", length = 256)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "id_per", referencedColumnName = "id_per", nullable = false)
    @ManyToOne(optional = false)
    private Periodo periodo;

    public DiaFestivo() {
    }

    public DiaFestivo(Integer idDiaFest) {
        this.idDiaFest = idDiaFest;
    }

    public DiaFestivo(Integer idDiaFest, String nombre, Date fecha) {
        this.idDiaFest = idDiaFest;
        this.nombre = nombre;
        this.fecha = fecha;
    }

    public Integer getIdDiaFest() {
        return idDiaFest;
    }

    public void setIdDiaFest(Integer idDiaFest) {
        this.idDiaFest = idDiaFest;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDiaFest != null ? idDiaFest.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DiaFestivo)) {
            return false;
        }
        DiaFestivo other = (DiaFestivo) object;
        if ((this.idDiaFest == null && other.idDiaFest != null) || (this.idDiaFest != null && !this.idDiaFest.equals(other.idDiaFest))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.DiaFestivo[ idDiaFest=" + idDiaFest + " ]";
    }
    
}
