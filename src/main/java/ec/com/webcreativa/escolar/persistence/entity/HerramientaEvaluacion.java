/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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
@Table(name = "herramienta_evaluacion", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_her_eva"})})
@NamedQueries({
    @NamedQuery(name = "HerramientaEvaluacion.findAll", query = "SELECT h FROM HerramientaEvaluacion h"),
    @NamedQuery(name = "HerramientaEvaluacion.findByIdHerEva", query = "SELECT h FROM HerramientaEvaluacion h WHERE h.idHerEva = :idHerEva"),
    @NamedQuery(name = "HerramientaEvaluacion.findByActivo", query = "SELECT h FROM HerramientaEvaluacion h WHERE h.activo = :activo"),
    @NamedQuery(name = "HerramientaEvaluacion.findByFechaCreacion", query = "SELECT h FROM HerramientaEvaluacion h WHERE h.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "HerramientaEvaluacion.findByTipoHerEva", query = "SELECT h FROM HerramientaEvaluacion h WHERE h.tipoHerEva = :tipoHerEva"),
    @NamedQuery(name = "HerramientaEvaluacion.findByNombre", query = "SELECT h FROM HerramientaEvaluacion h WHERE h.nombre = :nombre"),
    @NamedQuery(name = "HerramientaEvaluacion.findByDescripcion", query = "SELECT h FROM HerramientaEvaluacion h WHERE h.descripcion = :descripcion"),
    @NamedQuery(name = "HerramientaEvaluacion.findByExplicacion", query = "SELECT h FROM HerramientaEvaluacion h WHERE h.explicacion = :explicacion")})
public class HerramientaEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="HERRAMIENTA_EVALUACION_IDHEREVA_GENERATOR", sequenceName="SEQ_HERRAMIENTA_EVALUACION")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HERRAMIENTA_EVALUACION_IDHEREVA_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_her_eva", nullable = false)
    private Integer idHerEva;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "tipo_her_eva", nullable = false, length = 12)
    private String tipoHerEva;
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
    @Size(min = 1, max = 2048)
    @Column(name = "explicacion", nullable = false, length = 2048)
    private String explicacion;
    @JoinTable(name = "recurso_herramienta_evaluacion", joinColumns = {
        @JoinColumn(name = "id_her_eva", referencedColumnName = "id_her_eva", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_recurso", referencedColumnName = "id_recurso", nullable = false)})
    @ManyToMany
    private List<Recurso> recursoList;
    @OneToMany(mappedBy = "herramientaEvaluacion")
    private List<Recurso> recursoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "herramientaEvaluacion")
    private List<Pregunta> preguntaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "herramientaEvaluacion")
    private List<HerramientaClase> herramientaClaseList;

    public HerramientaEvaluacion() {
    }

    public HerramientaEvaluacion(Integer idHerEva) {
        this.idHerEva = idHerEva;
    }

    public HerramientaEvaluacion(Integer idHerEva, boolean activo, Date fechaCreacion, String tipoHerEva, String nombre, String explicacion) {
        this.idHerEva = idHerEva;
        this.activo = activo;
        this.fechaCreacion = fechaCreacion;
        this.tipoHerEva = tipoHerEva;
        this.nombre = nombre;
        this.explicacion = explicacion;
    }

    public Integer getIdHerEva() {
        return idHerEva;
    }

    public void setIdHerEva(Integer idHerEva) {
        this.idHerEva = idHerEva;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTipoHerEva() {
        return tipoHerEva;
    }

    public void setTipoHerEva(String tipoHerEva) {
        this.tipoHerEva = tipoHerEva;
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

    public String getExplicacion() {
        return explicacion;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    public List<Recurso> getRecursoList() {
        return recursoList;
    }

    public void setRecursoList(List<Recurso> recursoList) {
        this.recursoList = recursoList;
    }

    public List<Recurso> getRecursoList1() {
        return recursoList1;
    }

    public void setRecursoList1(List<Recurso> recursoList1) {
        this.recursoList1 = recursoList1;
    }

    public List<Pregunta> getPreguntaList() {
        return preguntaList;
    }

    public void setPreguntaList(List<Pregunta> preguntaList) {
        this.preguntaList = preguntaList;
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
        hash += (idHerEva != null ? idHerEva.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HerramientaEvaluacion)) {
            return false;
        }
        HerramientaEvaluacion other = (HerramientaEvaluacion) object;
        if ((this.idHerEva == null && other.idHerEva != null) || (this.idHerEva != null && !this.idHerEva.equals(other.idHerEva))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.HerramientaEvaluacion[ idHerEva=" + idHerEva + " ]";
    }
    
}
