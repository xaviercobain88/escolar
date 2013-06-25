/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "historico_materia", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_hm"})})
@NamedQueries({
    @NamedQuery(name = "HistoricoMateria.findAll", query = "SELECT h FROM HistoricoMateria h"),
    @NamedQuery(name = "HistoricoMateria.findByIdHm", query = "SELECT h FROM HistoricoMateria h WHERE h.idHm = :idHm"),
    @NamedQuery(name = "HistoricoMateria.findByNumeroEstudiantes", query = "SELECT h FROM HistoricoMateria h WHERE h.numeroEstudiantes = :numeroEstudiantes"),
    @NamedQuery(name = "HistoricoMateria.findByEvaluacionDirector", query = "SELECT h FROM HistoricoMateria h WHERE h.evaluacionDirector = :evaluacionDirector"),
    @NamedQuery(name = "HistoricoMateria.findByEvaluacionEstudiantes", query = "SELECT h FROM HistoricoMateria h WHERE h.evaluacionEstudiantes = :evaluacionEstudiantes"),
    @NamedQuery(name = "HistoricoMateria.findByTermino", query = "SELECT h FROM HistoricoMateria h WHERE h.termino = :termino"),
    @NamedQuery(name = "HistoricoMateria.findByEmpezo", query = "SELECT h FROM HistoricoMateria h WHERE h.empezo = :empezo")})
public class HistoricoMateria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="HISTORICO_MATERIA_IDHM_GENERATOR", sequenceName="SEQ_HISTORICO_MATERIA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HISTORICO_MATERIA_IDHM_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_hm", nullable = false)
    private Integer idHm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_estudiantes", nullable = false)
    private short numeroEstudiantes;
    @Size(max = 12)
    @Column(name = "evaluacion_director", length = 12)
    private String evaluacionDirector;
    @Size(max = 12)
    @Column(name = "evaluacion_estudiantes", length = 12)
    private String evaluacionEstudiantes;
    @Column(name = "termino")
    private Boolean termino;
    @Column(name = "empezo")
    private Boolean empezo;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "id_per", referencedColumnName = "id_per", nullable = false)
    @ManyToOne(optional = false)
    private Periodo periodo;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia", nullable = false)
    @ManyToOne(optional = false)
    private Materia materia;
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso", nullable = false)
    @ManyToOne(optional = false)
    private Curso curso;

    public HistoricoMateria() {
    }

    public HistoricoMateria(Integer idHm) {
        this.idHm = idHm;
    }

    public HistoricoMateria(Integer idHm, short numeroEstudiantes) {
        this.idHm = idHm;
        this.numeroEstudiantes = numeroEstudiantes;
    }

    public Integer getIdHm() {
        return idHm;
    }

    public void setIdHm(Integer idHm) {
        this.idHm = idHm;
    }

    public short getNumeroEstudiantes() {
        return numeroEstudiantes;
    }

    public void setNumeroEstudiantes(short numeroEstudiantes) {
        this.numeroEstudiantes = numeroEstudiantes;
    }

    public String getEvaluacionDirector() {
        return evaluacionDirector;
    }

    public void setEvaluacionDirector(String evaluacionDirector) {
        this.evaluacionDirector = evaluacionDirector;
    }

    public String getEvaluacionEstudiantes() {
        return evaluacionEstudiantes;
    }

    public void setEvaluacionEstudiantes(String evaluacionEstudiantes) {
        this.evaluacionEstudiantes = evaluacionEstudiantes;
    }

    public Boolean getTermino() {
        return termino;
    }

    public void setTermino(Boolean termino) {
        this.termino = termino;
    }

    public Boolean getEmpezo() {
        return empezo;
    }

    public void setEmpezo(Boolean empezo) {
        this.empezo = empezo;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHm != null ? idHm.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoMateria)) {
            return false;
        }
        HistoricoMateria other = (HistoricoMateria) object;
        if ((this.idHm == null && other.idHm != null) || (this.idHm != null && !this.idHm.equals(other.idHm))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.HistoricoMateria[ idHm=" + idHm + " ]";
    }
    
}
