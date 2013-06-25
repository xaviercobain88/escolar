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
@Table(name = "mes_setup", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_mes_setup"})})
@NamedQueries({
    @NamedQuery(name = "MesSetup.findAll", query = "SELECT m FROM MesSetup m"),
    @NamedQuery(name = "MesSetup.findByIdMesSetup", query = "SELECT m FROM MesSetup m WHERE m.idMesSetup = :idMesSetup"),
    @NamedQuery(name = "MesSetup.findByFechaInicio", query = "SELECT m FROM MesSetup m WHERE m.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "MesSetup.findByFechaFin", query = "SELECT m FROM MesSetup m WHERE m.fechaFin = :fechaFin"),
    @NamedQuery(name = "MesSetup.findByFechaAperturaSis", query = "SELECT m FROM MesSetup m WHERE m.fechaAperturaSis = :fechaAperturaSis"),
    @NamedQuery(name = "MesSetup.findByFechaCierreSis", query = "SELECT m FROM MesSetup m WHERE m.fechaCierreSis = :fechaCierreSis"),
    @NamedQuery(name = "MesSetup.findByActivo", query = "SELECT m FROM MesSetup m WHERE m.activo = :activo")})
public class MesSetup implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="MES_SETUP_IDMESSETUP_GENERATOR", sequenceName="SEQ_MES_SETUP")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MES_SETUP_IDMESSETUP_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_mes_setup", nullable = false)
    private Integer idMesSetup;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_inicio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_fin", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_apertura_sis", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaAperturaSis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_cierre_sis", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCierreSis;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mesSetup")
    private List<HistoricoAcademicoMensual> historicoAcademicoMensualList;
    @JoinColumn(name = "id_seccion", referencedColumnName = "id_seccion")
    @ManyToOne
    private Seccion seccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mesSetup")
    private List<MesClase> mesClaseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mesSetup")
    private List<Contenido> contenidoList;

    public MesSetup() {
    }

    public MesSetup(Integer idMesSetup) {
        this.idMesSetup = idMesSetup;
    }

    public MesSetup(Integer idMesSetup, Date fechaInicio, Date fechaFin, Date fechaAperturaSis, Date fechaCierreSis, boolean activo) {
        this.idMesSetup = idMesSetup;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaAperturaSis = fechaAperturaSis;
        this.fechaCierreSis = fechaCierreSis;
        this.activo = activo;
    }

    public Integer getIdMesSetup() {
        return idMesSetup;
    }

    public void setIdMesSetup(Integer idMesSetup) {
        this.idMesSetup = idMesSetup;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Date getFechaAperturaSis() {
        return fechaAperturaSis;
    }

    public void setFechaAperturaSis(Date fechaAperturaSis) {
        this.fechaAperturaSis = fechaAperturaSis;
    }

    public Date getFechaCierreSis() {
        return fechaCierreSis;
    }

    public void setFechaCierreSis(Date fechaCierreSis) {
        this.fechaCierreSis = fechaCierreSis;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<HistoricoAcademicoMensual> getHistoricoAcademicoMensualList() {
        return historicoAcademicoMensualList;
    }

    public void setHistoricoAcademicoMensualList(List<HistoricoAcademicoMensual> historicoAcademicoMensualList) {
        this.historicoAcademicoMensualList = historicoAcademicoMensualList;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public List<MesClase> getMesClaseList() {
        return mesClaseList;
    }

    public void setMesClaseList(List<MesClase> mesClaseList) {
        this.mesClaseList = mesClaseList;
    }

    public List<Contenido> getContenidoList() {
        return contenidoList;
    }

    public void setContenidoList(List<Contenido> contenidoList) {
        this.contenidoList = contenidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMesSetup != null ? idMesSetup.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MesSetup)) {
            return false;
        }
        MesSetup other = (MesSetup) object;
        if ((this.idMesSetup == null && other.idMesSetup != null) || (this.idMesSetup != null && !this.idMesSetup.equals(other.idMesSetup))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.MesSetup[ idMesSetup=" + idMesSetup + " ]";
    }
    
}
