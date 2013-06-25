/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;
import java.math.BigInteger;

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
@Table(name = "opcion_respuesta", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_opcion_respuesta"})})
@NamedQueries({
    @NamedQuery(name = "OpcionRespuesta.findAll", query = "SELECT o FROM OpcionRespuesta o"),
    @NamedQuery(name = "OpcionRespuesta.findByIdOpcionRespuesta", query = "SELECT o FROM OpcionRespuesta o WHERE o.idOpcionRespuesta = :idOpcionRespuesta"),
    @NamedQuery(name = "OpcionRespuesta.findByRespuestaBool", query = "SELECT o FROM OpcionRespuesta o WHERE o.respuestaBool = :respuestaBool"),
    @NamedQuery(name = "OpcionRespuesta.findByRespuestaNumero", query = "SELECT o FROM OpcionRespuesta o WHERE o.respuestaNumero = :respuestaNumero"),
    @NamedQuery(name = "OpcionRespuesta.findByRespuestaTexto", query = "SELECT o FROM OpcionRespuesta o WHERE o.respuestaTexto = :respuestaTexto"),
    @NamedQuery(name = "OpcionRespuesta.findByRespuestaObservacion", query = "SELECT o FROM OpcionRespuesta o WHERE o.respuestaObservacion = :respuestaObservacion")})
public class OpcionRespuesta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="OPCION_RESPUESTA_IDOPCIONRESPUESTA_GENERATOR", sequenceName="SEQ_OPCION_RESPUESTA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OPCION_RESPUESTA_IDOPCIONRESPUESTA_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_opcion_respuesta", nullable = false)
    private Integer idOpcionRespuesta;
    @Column(name = "respuesta_bool")
    private Boolean respuestaBool;
    @Column(name = "respuesta_numero")
    private BigInteger respuestaNumero;
    @Size(max = 128)
    @Column(name = "respuesta_texto", length = 128)
    private String respuestaTexto;
    @Size(max = 1024)
    @Column(name = "respuesta_observacion", length = 1024)
    private String respuestaObservacion;
    @JoinColumn(name = "id_respuesta", referencedColumnName = "id_respuesta", nullable = false)
    @ManyToOne(optional = false)
    private Respuesta respuesta;
    @JoinColumn(name = "id_opcion_pregunta", referencedColumnName = "id_opcion_pregunta", nullable = false)
    @ManyToOne(optional = false)
    private OpcionPregunta opcionPregunta;

    public OpcionRespuesta() {
    }

    public OpcionRespuesta(Integer idOpcionRespuesta) {
        this.idOpcionRespuesta = idOpcionRespuesta;
    }

    public Integer getIdOpcionRespuesta() {
        return idOpcionRespuesta;
    }

    public void setIdOpcionRespuesta(Integer idOpcionRespuesta) {
        this.idOpcionRespuesta = idOpcionRespuesta;
    }

    public Boolean getRespuestaBool() {
        return respuestaBool;
    }

    public void setRespuestaBool(Boolean respuestaBool) {
        this.respuestaBool = respuestaBool;
    }

    public BigInteger getRespuestaNumero() {
        return respuestaNumero;
    }

    public void setRespuestaNumero(BigInteger respuestaNumero) {
        this.respuestaNumero = respuestaNumero;
    }

    public String getRespuestaTexto() {
        return respuestaTexto;
    }

    public void setRespuestaTexto(String respuestaTexto) {
        this.respuestaTexto = respuestaTexto;
    }

    public String getRespuestaObservacion() {
        return respuestaObservacion;
    }

    public void setRespuestaObservacion(String respuestaObservacion) {
        this.respuestaObservacion = respuestaObservacion;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public OpcionPregunta getOpcionPregunta() {
        return opcionPregunta;
    }

    public void setOpcionPregunta(OpcionPregunta opcionPregunta) {
        this.opcionPregunta = opcionPregunta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOpcionRespuesta != null ? idOpcionRespuesta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionRespuesta)) {
            return false;
        }
        OpcionRespuesta other = (OpcionRespuesta) object;
        if ((this.idOpcionRespuesta == null && other.idOpcionRespuesta != null) || (this.idOpcionRespuesta != null && !this.idOpcionRespuesta.equals(other.idOpcionRespuesta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.OpcionRespuesta[ idOpcionRespuesta=" + idOpcionRespuesta + " ]";
    }
    
}
