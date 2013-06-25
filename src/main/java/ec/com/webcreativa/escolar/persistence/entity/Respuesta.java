/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "respuesta", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_respuesta"})})
@NamedQueries({
    @NamedQuery(name = "Respuesta.findAll", query = "SELECT r FROM Respuesta r"),
    @NamedQuery(name = "Respuesta.findByIdRespuesta", query = "SELECT r FROM Respuesta r WHERE r.idRespuesta = :idRespuesta"),
    @NamedQuery(name = "Respuesta.findByRespuestaBool", query = "SELECT r FROM Respuesta r WHERE r.respuestaBool = :respuestaBool"),
    @NamedQuery(name = "Respuesta.findByRespuestaTexto", query = "SELECT r FROM Respuesta r WHERE r.respuestaTexto = :respuestaTexto"),
    @NamedQuery(name = "Respuesta.findByRespuestaNumero", query = "SELECT r FROM Respuesta r WHERE r.respuestaNumero = :respuestaNumero"),
    @NamedQuery(name = "Respuesta.findByRespuestaObservacion", query = "SELECT r FROM Respuesta r WHERE r.respuestaObservacion = :respuestaObservacion")})
public class Respuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="RESPUESTA_IDRESPUESTA_GENERATOR", sequenceName="SEQ_RESPUESTA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESPUESTA_IDRESPUESTA_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_respuesta", nullable = false)
    private Integer idRespuesta;
    @Column(name = "respuesta_bool")
    private Boolean respuestaBool;
    @Size(max = 128)
    @Column(name = "respuesta_texto", length = 128)
    private String respuestaTexto;
    @Column(name = "respuesta_numero")
    private BigInteger respuestaNumero;
    @Size(max = 1024)
    @Column(name = "respuesta_observacion", length = 1024)
    private String respuestaObservacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "respuesta")
    private List<OpcionRespuesta> opcionRespuestaList;
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id_pregunta", nullable = false)
    @ManyToOne(optional = false)
    private Pregunta pregunta;
    @JoinColumn(name = "id_nota", referencedColumnName = "id_nota", nullable = false)
    @ManyToOne(optional = false)
    private Nota nota;

    public Respuesta() {
    }

    public Respuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public Integer getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Integer idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public Boolean getRespuestaBool() {
        return respuestaBool;
    }

    public void setRespuestaBool(Boolean respuestaBool) {
        this.respuestaBool = respuestaBool;
    }

    public String getRespuestaTexto() {
        return respuestaTexto;
    }

    public void setRespuestaTexto(String respuestaTexto) {
        this.respuestaTexto = respuestaTexto;
    }

    public BigInteger getRespuestaNumero() {
        return respuestaNumero;
    }

    public void setRespuestaNumero(BigInteger respuestaNumero) {
        this.respuestaNumero = respuestaNumero;
    }

    public String getRespuestaObservacion() {
        return respuestaObservacion;
    }

    public void setRespuestaObservacion(String respuestaObservacion) {
        this.respuestaObservacion = respuestaObservacion;
    }

    public List<OpcionRespuesta> getOpcionRespuestaList() {
        return opcionRespuestaList;
    }

    public void setOpcionRespuestaList(List<OpcionRespuesta> opcionRespuestaList) {
        this.opcionRespuestaList = opcionRespuestaList;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idRespuesta != null ? idRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Respuesta)) {
            return false;
        }
        Respuesta other = (Respuesta) object;
        if ((this.idRespuesta == null && other.idRespuesta != null) || (this.idRespuesta != null && !this.idRespuesta.equals(other.idRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.Respuesta[ idRespuesta=" + idRespuesta + " ]";
    }
    
}
