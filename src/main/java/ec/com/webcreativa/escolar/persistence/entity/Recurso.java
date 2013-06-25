/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
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
@Table(name = "recurso", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_recurso"})})
@NamedQueries({
    @NamedQuery(name = "Recurso.findAll", query = "SELECT r FROM Recurso r"),
    @NamedQuery(name = "Recurso.findByIdRecurso", query = "SELECT r FROM Recurso r WHERE r.idRecurso = :idRecurso"),
    @NamedQuery(name = "Recurso.findByNombre", query = "SELECT r FROM Recurso r WHERE r.nombre = :nombre"),
    @NamedQuery(name = "Recurso.findByDescripcion", query = "SELECT r FROM Recurso r WHERE r.descripcion = :descripcion"),
    @NamedQuery(name = "Recurso.findByDescripcionLarga", query = "SELECT r FROM Recurso r WHERE r.descripcionLarga = :descripcionLarga"),
    @NamedQuery(name = "Recurso.findByActivo", query = "SELECT r FROM Recurso r WHERE r.activo = :activo"),
    @NamedQuery(name = "Recurso.findByUrl", query = "SELECT r FROM Recurso r WHERE r.url = :url")})
public class Recurso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="RECURSO_IDRECURSO_GENERATOR", sequenceName="SEQ_RECURSO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RECURSO_IDRECURSO_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_recurso", nullable = false)
    private Integer idRecurso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "nombre", nullable = false, length = 64)
    private String nombre;
    @Size(max = 256)
    @Column(name = "descripcion", length = 256)
    private String descripcion;
    @Size(max = 2048)
    @Column(name = "descripcion_larga", length = 2048)
    private String descripcionLarga;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @Size(max = 512)
    @Column(name = "url", length = 512)
    private String url;
    @ManyToMany(mappedBy = "recursoList")
    private List<HerramientaEvaluacion> herramientaEvaluacionList;
    @ManyToMany(mappedBy = "recursoList")
    private List<DetalleCatalogo> detalleCatalogoList;
    @ManyToMany(mappedBy = "recursoList")
    private List<Materia> materiaList;
    @ManyToMany(mappedBy = "recursoList")
    private List<HerramientaClase> herramientaClaseList;
    @JoinColumn(name = "id_her_eva", referencedColumnName = "id_her_eva")
    @ManyToOne
    private HerramientaEvaluacion herramientaEvaluacion;
    @JoinColumn(name = "id_det_cat", referencedColumnName = "id_det_cat", nullable = false)
    @ManyToOne(optional = false)
    private DetalleCatalogo detalleCatalogo;

    public Recurso() {
    }

    public Recurso(Integer idRecurso) {
        this.idRecurso = idRecurso;
    }

    public Recurso(Integer idRecurso, String nombre, boolean activo) {
        this.idRecurso = idRecurso;
        this.nombre = nombre;
        this.activo = activo;
    }

    public Integer getIdRecurso() {
        return idRecurso;
    }

    public void setIdRecurso(Integer idRecurso) {
        this.idRecurso = idRecurso;
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

    public String getDescripcionLarga() {
        return descripcionLarga;
    }

    public void setDescripcionLarga(String descripcionLarga) {
        this.descripcionLarga = descripcionLarga;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<HerramientaEvaluacion> getHerramientaEvaluacionList() {
        return herramientaEvaluacionList;
    }

    public void setHerramientaEvaluacionList(List<HerramientaEvaluacion> herramientaEvaluacionList) {
        this.herramientaEvaluacionList = herramientaEvaluacionList;
    }

    public List<DetalleCatalogo> getDetalleCatalogoList() {
        return detalleCatalogoList;
    }

    public void setDetalleCatalogoList(List<DetalleCatalogo> detalleCatalogoList) {
        this.detalleCatalogoList = detalleCatalogoList;
    }

    public List<Materia> getMateriaList() {
        return materiaList;
    }

    public void setMateriaList(List<Materia> materiaList) {
        this.materiaList = materiaList;
    }

    public List<HerramientaClase> getHerramientaClaseList() {
        return herramientaClaseList;
    }

    public void setHerramientaClaseList(List<HerramientaClase> herramientaClaseList) {
        this.herramientaClaseList = herramientaClaseList;
    }

    public HerramientaEvaluacion getHerramientaEvaluacion() {
        return herramientaEvaluacion;
    }

    public void setHerramientaEvaluacion(HerramientaEvaluacion herramientaEvaluacion) {
        this.herramientaEvaluacion = herramientaEvaluacion;
    }

    public DetalleCatalogo getDetalleCatalogo() {
        return detalleCatalogo;
    }

    public void setDetalleCatalogo(DetalleCatalogo detalleCatalogo) {
        this.detalleCatalogo = detalleCatalogo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRecurso != null ? idRecurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recurso)) {
            return false;
        }
        Recurso other = (Recurso) object;
        if ((this.idRecurso == null && other.idRecurso != null) || (this.idRecurso != null && !this.idRecurso.equals(other.idRecurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.Recurso[ idRecurso=" + idRecurso + " ]";
    }
    
}
