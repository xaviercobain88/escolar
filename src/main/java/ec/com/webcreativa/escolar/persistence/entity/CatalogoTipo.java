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
@Table(name = "catalogo_tipo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_cat_tip"})})
@NamedQueries({
    @NamedQuery(name = "CatalogoTipo.findAll", query = "SELECT c FROM CatalogoTipo c"),
    @NamedQuery(name = "CatalogoTipo.findByIdCatTip", query = "SELECT c FROM CatalogoTipo c WHERE c.idCatTip = :idCatTip"),
    @NamedQuery(name = "CatalogoTipo.findByNombre", query = "SELECT c FROM CatalogoTipo c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "CatalogoTipo.findByDescripcion", query = "SELECT c FROM CatalogoTipo c WHERE c.descripcion = :descripcion")})
public class CatalogoTipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="CATALOGO_TIPO_IDCATTIP_GENERATOR", sequenceName="SEQ_CATALOGO_TIPO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATALOGO_TIPO_IDCATTIP_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_cat_tip", nullable = false)
    private Integer idCatTip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "nombre", nullable = false, length = 64)
    private String nombre;
    @Size(max = 256)
    @Column(name = "descripcion", length = 256)
    private String descripcion;
    @OneToMany(mappedBy = "catalogoTipo")
    private List<CatalogoTipo> catalogoTipoList;
    @JoinColumn(name = "cat_id_cat_tip", referencedColumnName = "id_cat_tip")
    @ManyToOne
    private CatalogoTipo catalogoTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catalogoTipo")
    private List<DetalleCatalogo> detalleCatalogoList;

    public CatalogoTipo() {
    }

    public CatalogoTipo(Integer idCatTip) {
        this.idCatTip = idCatTip;
    }

    public CatalogoTipo(Integer idCatTip, String nombre) {
        this.idCatTip = idCatTip;
        this.nombre = nombre;
    }

    public Integer getIdCatTip() {
        return idCatTip;
    }

    public void setIdCatTip(Integer idCatTip) {
        this.idCatTip = idCatTip;
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

    public List<CatalogoTipo> getCatalogoTipoList() {
        return catalogoTipoList;
    }

    public void setCatalogoTipoList(List<CatalogoTipo> catalogoTipoList) {
        this.catalogoTipoList = catalogoTipoList;
    }

    public CatalogoTipo getCatalogoTipo() {
        return catalogoTipo;
    }

    public void setCatalogoTipo(CatalogoTipo catalogoTipo) {
        this.catalogoTipo = catalogoTipo;
    }

    public List<DetalleCatalogo> getDetalleCatalogoList() {
        return detalleCatalogoList;
    }

    public void setDetalleCatalogoList(List<DetalleCatalogo> detalleCatalogoList) {
        this.detalleCatalogoList = detalleCatalogoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCatTip != null ? idCatTip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CatalogoTipo)) {
            return false;
        }
        CatalogoTipo other = (CatalogoTipo) object;
        if ((this.idCatTip == null && other.idCatTip != null) || (this.idCatTip != null && !this.idCatTip.equals(other.idCatTip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.CatalogoTipo[ idCatTip=" + idCatTip + " ]";
    }
    
}
