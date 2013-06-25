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
@Table(name = "tipo_materia", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_tip_materia"})})
@NamedQueries({
    @NamedQuery(name = "TipoMateria.findAll", query = "SELECT t FROM TipoMateria t"),
    @NamedQuery(name = "TipoMateria.findByIdTipMateria", query = "SELECT t FROM TipoMateria t WHERE t.idTipMateria = :idTipMateria"),
    @NamedQuery(name = "TipoMateria.findByNombre", query = "SELECT t FROM TipoMateria t WHERE t.nombre = :nombre"),
    @NamedQuery(name = "TipoMateria.findByDescripcion", query = "SELECT t FROM TipoMateria t WHERE t.descripcion = :descripcion"),
    @NamedQuery(name = "TipoMateria.findByActivo", query = "SELECT t FROM TipoMateria t WHERE t.activo = :activo")})
public class TipoMateria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="TIPO_MATERIA_IDTIPMATERIA_GENERATOR", sequenceName="SEQ_TIPO_MATERIA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TIPO_MATERIA_IDTIPMATERIA_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tip_materia", nullable = false)
    private Integer idTipMateria;
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
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoMateria")
    private List<Materia> materiaList;

    public TipoMateria() {
    }

    public TipoMateria(Integer idTipMateria) {
        this.idTipMateria = idTipMateria;
    }

    public TipoMateria(Integer idTipMateria, String nombre, boolean activo) {
        this.idTipMateria = idTipMateria;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Integer getIdTipMateria() {
        return idTipMateria;
    }

    public void setIdTipMateria(Integer idTipMateria) {
        this.idTipMateria = idTipMateria;
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

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Materia> getMateriaList() {
        return materiaList;
    }

    public void setMateriaList(List<Materia> materiaList) {
        this.materiaList = materiaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipMateria != null ? idTipMateria.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoMateria)) {
            return false;
        }
        TipoMateria other = (TipoMateria) object;
        if ((this.idTipMateria == null && other.idTipMateria != null) || (this.idTipMateria != null && !this.idTipMateria.equals(other.idTipMateria))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.TipoMateria[ idTipMateria=" + idTipMateria + " ]";
    }
    
}
