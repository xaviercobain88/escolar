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
@Table(name = "pais", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_pai"})})
@NamedQueries({
    @NamedQuery(name = "Pais.findAll", query = "SELECT p FROM Pais p"),
    @NamedQuery(name = "Pais.findByIdPai", query = "SELECT p FROM Pais p WHERE p.idPai = :idPai"),
    @NamedQuery(name = "Pais.findByNombre", query = "SELECT p FROM Pais p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Pais.findByDescripcion", query = "SELECT p FROM Pais p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Pais.findByObservacion", query = "SELECT p FROM Pais p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "Pais.findByNemonico", query = "SELECT p FROM Pais p WHERE p.nemonico = :nemonico"),
    @NamedQuery(name = "Pais.findByActivo", query = "SELECT p FROM Pais p WHERE p.activo = :activo")})
public class Pais implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="PAIS_IDPAI_GENERATOR", sequenceName="SEQ_PAIS")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PAIS_IDPAI_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pai", nullable = false)
    private Integer idPai;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pais")
    private List<Region> regionList;

    public Pais() {
    }

    public Pais(Integer idPai) {
        this.idPai = idPai;
    }

    public Pais(Integer idPai, String nombre, boolean activo) {
        this.idPai = idPai;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Integer getIdPai() {
        return idPai;
    }

    public void setIdPai(Integer idPai) {
        this.idPai = idPai;
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

    public List<Region> getRegionList() {
        return regionList;
    }

    public void setRegionList(List<Region> regionList) {
        this.regionList = regionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPai != null ? idPai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pais)) {
            return false;
        }
        Pais other = (Pais) object;
        if ((this.idPai == null && other.idPai != null) || (this.idPai != null && !this.idPai.equals(other.idPai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.Pais[ idPai=" + idPai + " ]";
    }
    
}
