/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "region", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_reg"})})
@NamedQueries({
    @NamedQuery(name = "Region.findAll", query = "SELECT r FROM Region r"),
    @NamedQuery(name = "Region.findByIdReg", query = "SELECT r FROM Region r WHERE r.idReg = :idReg"),
    @NamedQuery(name = "Region.findByNombre", query = "SELECT r FROM Region r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Region.findByDescripcion", query = "SELECT r FROM Region r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Region.findByPais", query = "SELECT r FROM Region r WHERE r.pais.id = :idPais and r.activo=true"),
    @NamedQuery(name = "Region.findByObservacion", query = "SELECT r FROM Region r WHERE r.observacion = :observacion"),
    @NamedQuery(name = "Region.findByNemonico", query = "SELECT r FROM Region r WHERE r.nemonico = :nemonico"),
    @NamedQuery(name = "Region.findByActivo", query = "SELECT r FROM Region r WHERE r.activo = :activo")})
public class Region implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="REGION_IDREG_GENERATOR", sequenceName="SEQ_REGION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="REGION_IDREG_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_reg", nullable = false)
    private Integer idReg;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "nombre", nullable = false, length = 64)
    private String nombre;
    @Size(max = 256)
    @Column(name = "descripcion", length = 256)
    private String descripcion;
    @Size(max = 512)
    @Column(name = "observacion", length = 512)
    private String observacion;
    @Size(max = 6)
    @Column(name = "nemonico", length = 6)
    private String nemonico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @JoinColumn(name = "id_pai", referencedColumnName = "id_pai", nullable = false)
    @ManyToOne(optional = false)
    private Pais pais;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "region")
    private List<UnidadEducativa> unidadEducativaList;
    @OneToMany(mappedBy = "region")
    private List<Periodo> periodoList;

    public Region() {
    }

    public Region(Integer idReg) {
        this.idReg = idReg;
    }

    public Region(Integer idReg, String nombre, boolean activo) {
        this.idReg = idReg;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Integer getIdReg() {
        return idReg;
    }

    public void setIdReg(Integer idReg) {
        this.idReg = idReg;
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

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getNemonico() {
        return nemonico;
    }

    public void setNemonico(String nemonico) {
        this.nemonico = nemonico;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<UnidadEducativa> getUnidadEducativaList() {
        return unidadEducativaList;
    }

    public void setUnidadEducativaList(List<UnidadEducativa> unidadEducativaList) {
        this.unidadEducativaList = unidadEducativaList;
    }

    public List<Periodo> getPeriodoList() {
        return periodoList;
    }

    public void setPeriodoList(List<Periodo> periodoList) {
        this.periodoList = periodoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReg != null ? idReg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Region)) {
            return false;
        }
        Region other = (Region) object;
        if ((this.idReg == null && other.idReg != null) || (this.idReg != null && !this.idReg.equals(other.idReg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.Region[ idReg=" + idReg + " ]";
    }
    
}
