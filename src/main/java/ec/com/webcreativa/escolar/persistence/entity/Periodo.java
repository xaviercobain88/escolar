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
@Table(name = "periodo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_per"})})
@NamedQueries({
    @NamedQuery(name = "Periodo.findAll", query = "SELECT p FROM Periodo p"),
    @NamedQuery(name = "Periodo.findByIdPer", query = "SELECT p FROM Periodo p WHERE p.idPer = :idPer"),
    @NamedQuery(name = "Periodo.findByNombre", query = "SELECT p FROM Periodo p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "Periodo.findByDescripcion", query = "SELECT p FROM Periodo p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Periodo.findByObservacion", query = "SELECT p FROM Periodo p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "Periodo.findByRegionActivo", query = "SELECT p FROM Periodo p WHERE p.region.idReg = :idReg and p.activo = :activo"),
    @NamedQuery(name = "Periodo.findByActivo", query = "SELECT p FROM Periodo p WHERE p.activo = :activo")})
public class Periodo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="PERIODO_IDPER_GENERATOR", sequenceName="SEQ_PERIODO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PERIODO_IDPER_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_per", nullable = false)
    private Integer idPer;
    @Size(max = 64)
    @Column(name = "nombre", length = 64)
    private String nombre;
    @Size(max = 256)
    @Column(name = "descripcion", length = 256)
    private String descripcion;
    @Size(max = 512)
    @Column(name = "observacion", length = 512)
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo")
    private List<HistoricoAcademicoMensual> historicoAcademicoMensualList;
    @JoinColumn(name = "id_reg", referencedColumnName = "id_reg")
    @ManyToOne
    private Region region;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo")
    private List<HistoricoMateria> historicoMateriaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo")
    private List<DiaFestivo> diaFestivoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo")
    private List<Matricula> matriculaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo")
    private List<HistoricoAcademicoAnual> historicoAcademicoAnualList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "periodo")
    private List<Clase> claseList;

    public Periodo() {
    }

    public Periodo(Integer idPer) {
        this.idPer = idPer;
    }

    public Periodo(Integer idPer, boolean activo) {
        this.idPer = idPer;
        this.activo = activo;
    }

    public Integer getIdPer() {
        return idPer;
    }

    public void setIdPer(Integer idPer) {
        this.idPer = idPer;
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public List<HistoricoMateria> getHistoricoMateriaList() {
        return historicoMateriaList;
    }

    public void setHistoricoMateriaList(List<HistoricoMateria> historicoMateriaList) {
        this.historicoMateriaList = historicoMateriaList;
    }

    public List<DiaFestivo> getDiaFestivoList() {
        return diaFestivoList;
    }

    public void setDiaFestivoList(List<DiaFestivo> diaFestivoList) {
        this.diaFestivoList = diaFestivoList;
    }

    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }

    public List<HistoricoAcademicoAnual> getHistoricoAcademicoAnualList() {
        return historicoAcademicoAnualList;
    }

    public void setHistoricoAcademicoAnualList(List<HistoricoAcademicoAnual> historicoAcademicoAnualList) {
        this.historicoAcademicoAnualList = historicoAcademicoAnualList;
    }

    public List<Clase> getClaseList() {
        return claseList;
    }

    public void setClaseList(List<Clase> claseList) {
        this.claseList = claseList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPer != null ? idPer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Periodo)) {
            return false;
        }
        Periodo other = (Periodo) object;
        if ((this.idPer == null && other.idPer != null) || (this.idPer != null && !this.idPer.equals(other.idPer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.Periodo[ idPer=" + idPer + " ]";
    }
    
}
