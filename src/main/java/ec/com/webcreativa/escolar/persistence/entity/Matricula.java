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
@Table(name = "matricula", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_matricula"})})
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findByIdMatricula", query = "SELECT m FROM Matricula m WHERE m.idMatricula = :idMatricula"),
    @NamedQuery(name = "Matricula.findByFechaMatricula", query = "SELECT m FROM Matricula m WHERE m.fechaMatricula = :fechaMatricula")})
public class Matricula implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="MATRICULA_IDMATRICULA_GENERATOR", sequenceName="SEQ_MATRICULA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MATRICULA_IDMATRICULA_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_matricula", nullable = false)
    private Integer idMatricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_matricula", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaMatricula;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricula")
    private List<Nota> notaList;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "id_per", referencedColumnName = "id_per", nullable = false)
    @ManyToOne(optional = false)
    private Periodo periodo;
    @JoinColumn(name = "id_paralelo", referencedColumnName = "id_paralelo", nullable = false)
    @ManyToOne(optional = false)
    private Paralelo paralelo;

    public Matricula() {
    }

    public Matricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Matricula(Integer idMatricula, Date fechaMatricula) {
        this.idMatricula = idMatricula;
        this.fechaMatricula = fechaMatricula;
    }

    public Integer getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    public Date getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(Date fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    public List<Nota> getNotaList() {
        return notaList;
    }

    public void setNotaList(List<Nota> notaList) {
        this.notaList = notaList;
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

    public Paralelo getParalelo() {
        return paralelo;
    }

    public void setParalelo(Paralelo paralelo) {
        this.paralelo = paralelo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMatricula != null ? idMatricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.idMatricula == null && other.idMatricula != null) || (this.idMatricula != null && !this.idMatricula.equals(other.idMatricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.Matricula[ idMatricula=" + idMatricula + " ]";
    }
    
}
