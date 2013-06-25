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

/**
 *
 * @author xavier
 */
@Entity
@Table(name = "clase", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_clase"})})
@NamedQueries({
    @NamedQuery(name = "Clase.findAll", query = "SELECT c FROM Clase c"),
    @NamedQuery(name = "Clase.findByPeriodoProfesor", query = "SELECT c FROM Clase c WHERE c.periodo.idPer=:idPeriodo and c.persona.idPersona=:idPersona"),
    @NamedQuery(name = "Clase.findByIdClase", query = "SELECT c FROM Clase c WHERE c.idClase = :idClase")})
public class Clase implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="CLASE_IDCLASE_GENERATOR", sequenceName="SEQ_CLASE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CLASE_IDCLASE_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_clase", nullable = false)
    private Integer idClase;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clase")
    private List<MesClase> mesClaseList;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    @ManyToOne(optional = false)
    //Profesor
    private Persona persona;
    @JoinColumn(name = "id_per", referencedColumnName = "id_per", nullable = false)
    @ManyToOne(optional = false)
    private Periodo periodo;
    @JoinColumn(name = "id_paralelo", referencedColumnName = "id_paralelo")
    @ManyToOne
    private Paralelo paralelo;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia", nullable = false)
    @ManyToOne(optional = false)
    private Materia materia;

    public Clase() {
    }

    public Clase(Integer idClase) {
        this.idClase = idClase;
    }

    public Integer getIdClase() {
        return idClase;
    }

    public void setIdClase(Integer idClase) {
        this.idClase = idClase;
    }

    public List<MesClase> getMesClaseList() {
        return mesClaseList;
    }

    public void setMesClaseList(List<MesClase> mesClaseList) {
        this.mesClaseList = mesClaseList;
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

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idClase != null ? idClase.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clase)) {
            return false;
        }
        Clase other = (Clase) object;
        if ((this.idClase == null && other.idClase != null) || (this.idClase != null && !this.idClase.equals(other.idClase))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.Clase[ idClase=" + idClase + " ]";
    }
    
}
