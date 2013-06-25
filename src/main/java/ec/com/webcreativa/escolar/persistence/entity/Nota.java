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
@Table(name = "nota", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_nota"})})
@NamedQueries({
    @NamedQuery(name = "Nota.findAll", query = "SELECT n FROM Nota n"),
    @NamedQuery(name = "Nota.findByIdNota", query = "SELECT n FROM Nota n WHERE n.idNota = :idNota"),
    @NamedQuery(name = "Nota.findByNota", query = "SELECT n FROM Nota n WHERE n.nota = :nota"),
    @NamedQuery(name = "Nota.findByNotaBool", query = "SELECT n FROM Nota n WHERE n.notaBool = :notaBool"),
    @NamedQuery(name = "Nota.findByFechaCreacion", query = "SELECT n FROM Nota n WHERE n.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Nota.findByFechaModificacion", query = "SELECT n FROM Nota n WHERE n.fechaModificacion = :fechaModificacion")})
public class Nota implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="NOTA_IDNOTA_GENERATOR", sequenceName="SEQ_NOTA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="NOTA_IDNOTA_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_nota", nullable = false)
    private Integer idNota;
    @Column(name = "nota")
    private BigInteger nota;
    @Column(name = "nota_bool")
    private Boolean notaBool;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_modificacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @JoinColumn(name = "id_matricula", referencedColumnName = "id_matricula", nullable = false)
    @ManyToOne(optional = false)
    private Matricula matricula;
    @JoinColumn(name = "id_her_cla", referencedColumnName = "id_her_cla", nullable = false)
    @ManyToOne(optional = false)
    private HerramientaClase herramientaClase;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nota")
    private List<Respuesta> respuestaList;

    public Nota() {
    }

    public Nota(Integer idNota) {
        this.idNota = idNota;
    }

    public Nota(Integer idNota, Date fechaCreacion, Date fechaModificacion) {
        this.idNota = idNota;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
    }

    public Integer getIdNota() {
        return idNota;
    }

    public void setIdNota(Integer idNota) {
        this.idNota = idNota;
    }

    public BigInteger getNota() {
        return nota;
    }

    public void setNota(BigInteger nota) {
        this.nota = nota;
    }

    public Boolean getNotaBool() {
        return notaBool;
    }

    public void setNotaBool(Boolean notaBool) {
        this.notaBool = notaBool;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public HerramientaClase getHerramientaClase() {
        return herramientaClase;
    }

    public void setHerramientaClase(HerramientaClase herramientaClase) {
        this.herramientaClase = herramientaClase;
    }

    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNota != null ? idNota.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nota)) {
            return false;
        }
        Nota other = (Nota) object;
        if ((this.idNota == null && other.idNota != null) || (this.idNota != null && !this.idNota.equals(other.idNota))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.Nota[ idNota=" + idNota + " ]";
    }
    
}
