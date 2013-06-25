/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

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
import javax.persistence.OneToMany;
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
@Table(name = "herramienta_clase_agrupacion", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_her_cla_agr"})})
@NamedQueries({
    @NamedQuery(name = "HerramientaClaseAgrupacion.findAll", query = "SELECT h FROM HerramientaClaseAgrupacion h"),
    @NamedQuery(name = "HerramientaClaseAgrupacion.findByIdHerClaAgr", query = "SELECT h FROM HerramientaClaseAgrupacion h WHERE h.idHerClaAgr = :idHerClaAgr"),
    @NamedQuery(name = "HerramientaClaseAgrupacion.findByActivo", query = "SELECT h FROM HerramientaClaseAgrupacion h WHERE h.activo = :activo"),
    @NamedQuery(name = "HerramientaClaseAgrupacion.findByNombre", query = "SELECT h FROM HerramientaClaseAgrupacion h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "HerramientaClaseAgrupacion.findByDescripcion", query = "SELECT h FROM HerramientaClaseAgrupacion h WHERE h.descripcion = :descripcion"),
    @NamedQuery(name = "HerramientaClaseAgrupacion.findByGenerico", query = "SELECT h FROM HerramientaClaseAgrupacion h WHERE h.generico = :generico"),
    @NamedQuery(name = "HerramientaClaseAgrupacion.findByPorcentaje", query = "SELECT h FROM HerramientaClaseAgrupacion h WHERE h.porcentaje = :porcentaje")})
public class HerramientaClaseAgrupacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="HERRAMIENTA_CLASE_AGRUPACION_IDHERCLAAGR_GENERATOR", sequenceName="SEQ_HERRAMIENTA_CLASE_AGRUPACION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HERRAMIENTA_CLASE_AGRUPACION_IDHERCLAAGR_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_her_cla_agr", nullable = false)
    private Integer idHerClaAgr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
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
    @Column(name = "generico", nullable = false)
    private boolean generico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje", nullable = false)
    private BigInteger porcentaje;
    @JoinColumn(name = "id_seccion", referencedColumnName = "id_seccion")
    @ManyToOne
    private Seccion seccion;
    @OneToMany(mappedBy = "herramientaClaseAgrupacion")
    private List<HerramientaClase> herramientaClaseList;

    public HerramientaClaseAgrupacion() {
    }

    public HerramientaClaseAgrupacion(Integer idHerClaAgr) {
        this.idHerClaAgr = idHerClaAgr;
    }

    public HerramientaClaseAgrupacion(Integer idHerClaAgr, boolean activo, String nombre, boolean generico, BigInteger porcentaje) {
        this.idHerClaAgr = idHerClaAgr;
        this.activo = activo;
        this.nombre = nombre;
        this.generico = generico;
        this.porcentaje = porcentaje;
    }

    public Integer getIdHerClaAgr() {
        return idHerClaAgr;
    }

    public void setIdHerClaAgr(Integer idHerClaAgr) {
        this.idHerClaAgr = idHerClaAgr;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
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

    public boolean getGenerico() {
        return generico;
    }

    public void setGenerico(boolean generico) {
        this.generico = generico;
    }

    public BigInteger getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(BigInteger porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public List<HerramientaClase> getHerramientaClaseList() {
        return herramientaClaseList;
    }

    public void setHerramientaClaseList(List<HerramientaClase> herramientaClaseList) {
        this.herramientaClaseList = herramientaClaseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHerClaAgr != null ? idHerClaAgr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HerramientaClaseAgrupacion)) {
            return false;
        }
        HerramientaClaseAgrupacion other = (HerramientaClaseAgrupacion) object;
        if ((this.idHerClaAgr == null && other.idHerClaAgr != null) || (this.idHerClaAgr != null && !this.idHerClaAgr.equals(other.idHerClaAgr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.HerramientaClaseAgrupacion[ idHerClaAgr=" + idHerClaAgr + " ]";
    }
    
}
