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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "detalle_catalogo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_det_cat"})})
@NamedQueries({
    @NamedQuery(name = "DetalleCatalogo.findAll", query = "SELECT d FROM DetalleCatalogo d"),
    @NamedQuery(name = "DetalleCatalogo.findByIdDetCat", query = "SELECT d FROM DetalleCatalogo d WHERE d.idDetCat = :idDetCat"),
    @NamedQuery(name = "DetalleCatalogo.findByNemonico", query = "SELECT d FROM DetalleCatalogo d WHERE d.nemonico = :nemonico"),
    @NamedQuery(name = "DetalleCatalogo.findByNombre", query = "SELECT d FROM DetalleCatalogo d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DetalleCatalogo.findByDescripcion", query = "SELECT d FROM DetalleCatalogo d WHERE d.descripcion = :descripcion"),
    @NamedQuery(name = "DetalleCatalogo.findByActivo", query = "SELECT d FROM DetalleCatalogo d WHERE d.activo = :activo")})
public class DetalleCatalogo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="DETALLE_CATALOGO_IDDETCAT_GENERATOR", sequenceName="SEQ_DETALLE_CATALOGO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DETALLE_CATALOGO_IDDETCAT_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_det_cat", nullable = false)
    private Integer idDetCat;
    @Size(max = 6)
    @Column(name = "nemonico", length = 6)
    private String nemonico;
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
    @JoinTable(name = "recurso_keyword", joinColumns = {
        @JoinColumn(name = "id_det_cat", referencedColumnName = "id_det_cat", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_recurso", referencedColumnName = "id_recurso", nullable = false)})
    @ManyToMany
    private List<Recurso> recursoList;
    @JoinColumn(name = "id_cat_tip", referencedColumnName = "id_cat_tip", nullable = false)
    @ManyToOne(optional = false)
    private CatalogoTipo catalogoTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleCatalogo")
    private List<Recurso> recursoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleCatalogo")
    private List<EstudianteRepresentante> estudianteRepresentanteList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleCatalogo")
    private List<Persona> personaList;

    public DetalleCatalogo() {
    }

    public DetalleCatalogo(Integer idDetCat) {
        this.idDetCat = idDetCat;
    }

    public DetalleCatalogo(Integer idDetCat, String nombre, boolean activo) {
        this.idDetCat = idDetCat;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Integer getIdDetCat() {
        return idDetCat;
    }

    public void setIdDetCat(Integer idDetCat) {
        this.idDetCat = idDetCat;
    }

    public String getNemonico() {
        return nemonico;
    }

    public void setNemonico(String nemonico) {
        this.nemonico = nemonico;
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

    public List<Recurso> getRecursoList() {
        return recursoList;
    }

    public void setRecursoList(List<Recurso> recursoList) {
        this.recursoList = recursoList;
    }

    public CatalogoTipo getCatalogoTipo() {
        return catalogoTipo;
    }

    public void setCatalogoTipo(CatalogoTipo catalogoTipo) {
        this.catalogoTipo = catalogoTipo;
    }

    public List<Recurso> getRecursoList1() {
        return recursoList1;
    }

    public void setRecursoList1(List<Recurso> recursoList1) {
        this.recursoList1 = recursoList1;
    }

    public List<EstudianteRepresentante> getEstudianteRepresentanteList() {
        return estudianteRepresentanteList;
    }

    public void setEstudianteRepresentanteList(List<EstudianteRepresentante> estudianteRepresentanteList) {
        this.estudianteRepresentanteList = estudianteRepresentanteList;
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetCat != null ? idDetCat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCatalogo)) {
            return false;
        }
        DetalleCatalogo other = (DetalleCatalogo) object;
        if ((this.idDetCat == null && other.idDetCat != null) || (this.idDetCat != null && !this.idDetCat.equals(other.idDetCat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.DetalleCatalogo[ idDetCat=" + idDetCat + " ]";
    }
    
}
