/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author xavier
 */
@Entity
@Table(name = "herramienta_clase", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_her_cla"})})
@NamedQueries({
    @NamedQuery(name = "HerramientaClase.findAll", query = "SELECT h FROM HerramientaClase h"),
    @NamedQuery(name = "HerramientaClase.findByIdHerCla", query = "SELECT h FROM HerramientaClase h WHERE h.idHerCla = :idHerCla"),
    @NamedQuery(name = "HerramientaClase.findByFechaPresentacion", query = "SELECT h FROM HerramientaClase h WHERE h.fechaPresentacion = :fechaPresentacion"),
    @NamedQuery(name = "HerramientaClase.findByGenerico", query = "SELECT h FROM HerramientaClase h WHERE h.generico = :generico"),
    @NamedQuery(name = "HerramientaClase.findByPorcentaje", query = "SELECT h FROM HerramientaClase h WHERE h.porcentaje = :porcentaje")})
public class HerramientaClase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="HERRAMIENTA_CLASE_IDHERCLA_GENERATOR", sequenceName="SEQ_HERRAMIENTA_CLASE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HERRAMIENTA_CLASE_IDHERCLA_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_her_cla", nullable = false)
    private Integer idHerCla;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_presentacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaPresentacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "generico", nullable = false)
    private boolean generico;
    @Basic(optional = false)
    @NotNull
    @Column(name = "porcentaje", nullable = false)
    private BigInteger porcentaje;
    @JoinTable(name = "recurso_herramienta_clase", joinColumns = {
        @JoinColumn(name = "id_her_cla", referencedColumnName = "id_her_cla", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_recurso", referencedColumnName = "id_recurso", nullable = false)})
    @ManyToMany
    private List<Recurso> recursoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "herramientaClase")
    private List<Nota> notaList;
    @OneToMany(mappedBy = "herramientaClase")
    private List<Grupo> grupoList;
    @JoinColumns({
        @JoinColumn(name = "id_mes_setup", referencedColumnName = "id_mes_setup", nullable = false),
        @JoinColumn(name = "id_clase", referencedColumnName = "id_clase", nullable = false)})
    @ManyToOne(optional = false)
    private MesClase mesClase;
    @JoinColumn(name = "id_her_eva", referencedColumnName = "id_her_eva", nullable = false)
    @ManyToOne(optional = false)
    private HerramientaEvaluacion herramientaEvaluacion;
    @JoinColumn(name = "id_her_cla_agr", referencedColumnName = "id_her_cla_agr")
    @ManyToOne
    private HerramientaClaseAgrupacion herramientaClaseAgrupacion;

    public HerramientaClase() {
    }

    public HerramientaClase(Integer idHerCla) {
        this.idHerCla = idHerCla;
    }

    public HerramientaClase(Integer idHerCla, Date fechaPresentacion, boolean generico, BigInteger porcentaje) {
        this.idHerCla = idHerCla;
        this.fechaPresentacion = fechaPresentacion;
        this.generico = generico;
        this.porcentaje = porcentaje;
    }

    public Integer getIdHerCla() {
        return idHerCla;
    }

    public void setIdHerCla(Integer idHerCla) {
        this.idHerCla = idHerCla;
    }

    public Date getFechaPresentacion() {
        return fechaPresentacion;
    }

    public void setFechaPresentacion(Date fechaPresentacion) {
        this.fechaPresentacion = fechaPresentacion;
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

    public List<Recurso> getRecursoList() {
        return recursoList;
    }

    public void setRecursoList(List<Recurso> recursoList) {
        this.recursoList = recursoList;
    }

    public List<Nota> getNotaList() {
        return notaList;
    }

    public void setNotaList(List<Nota> notaList) {
        this.notaList = notaList;
    }

    public List<Grupo> getGrupoList() {
        return grupoList;
    }

    public void setGrupoList(List<Grupo> grupoList) {
        this.grupoList = grupoList;
    }

    public MesClase getMesClase() {
        return mesClase;
    }

    public void setMesClase(MesClase mesClase) {
        this.mesClase = mesClase;
    }

    public HerramientaEvaluacion getHerramientaEvaluacion() {
        return herramientaEvaluacion;
    }

    public void setHerramientaEvaluacion(HerramientaEvaluacion herramientaEvaluacion) {
        this.herramientaEvaluacion = herramientaEvaluacion;
    }

    public HerramientaClaseAgrupacion getHerramientaClaseAgrupacion() {
        return herramientaClaseAgrupacion;
    }

    public void setHerramientaClaseAgrupacion(HerramientaClaseAgrupacion herramientaClaseAgrupacion) {
        this.herramientaClaseAgrupacion = herramientaClaseAgrupacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHerCla != null ? idHerCla.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HerramientaClase)) {
            return false;
        }
        HerramientaClase other = (HerramientaClase) object;
        if ((this.idHerCla == null && other.idHerCla != null) || (this.idHerCla != null && !this.idHerCla.equals(other.idHerCla))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.HerramientaClase[ idHerCla=" + idHerCla + " ]";
    }
    
}
