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
@Table(name = "paralelo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_paralelo"})})
@NamedQueries({
    @NamedQuery(name = "Paralelo.findAll", query = "SELECT p FROM Paralelo p"),
    @NamedQuery(name = "Paralelo.findByIdParalelo", query = "SELECT p FROM Paralelo p WHERE p.idParalelo = :idParalelo"),
    @NamedQuery(name = "Paralelo.findByActivo", query = "SELECT p FROM Paralelo p WHERE p.activo = :activo"),
    @NamedQuery(name = "Paralelo.findByObservacion", query = "SELECT p FROM Paralelo p WHERE p.observacion = :observacion"),
    @NamedQuery(name = "Paralelo.findByEstudiantesPorParalelo", query = "SELECT p FROM Paralelo p WHERE p.estudiantesPorParalelo = :estudiantesPorParalelo")})
public class Paralelo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="PARALELO_IDPARALELO_GENERATOR", sequenceName="SEQ_PARALELO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PARALELO_IDPARALELO_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_paralelo", nullable = false)
    private Integer idParalelo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @Size(max = 512)
    @Column(name = "observacion", length = 512)
    private String observacion;
    @Column(name = "estudiantes_por_paralelo")
    private Short estudiantesPorParalelo;
    @JoinColumn(name = "id_curso", referencedColumnName = "id_curso", nullable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paralelo")
    private List<Matricula> matriculaList;
    @OneToMany(mappedBy = "paralelo")
    private List<Clase> claseList;

    public Paralelo() {
    }

    public Paralelo(Integer idParalelo) {
        this.idParalelo = idParalelo;
    }

    public Paralelo(Integer idParalelo, boolean activo) {
        this.idParalelo = idParalelo;
        this.activo = activo;
    }

    public Integer getIdParalelo() {
        return idParalelo;
    }

    public void setIdParalelo(Integer idParalelo) {
        this.idParalelo = idParalelo;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Short getEstudiantesPorParalelo() {
        return estudiantesPorParalelo;
    }

    public void setEstudiantesPorParalelo(Short estudiantesPorParalelo) {
        this.estudiantesPorParalelo = estudiantesPorParalelo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
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
        hash += (idParalelo != null ? idParalelo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paralelo)) {
            return false;
        }
        Paralelo other = (Paralelo) object;
        if ((this.idParalelo == null && other.idParalelo != null) || (this.idParalelo != null && !this.idParalelo.equals(other.idParalelo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.Paralelo[ idParalelo=" + idParalelo + " ]";
    }
    
}
