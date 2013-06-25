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
@Table(name = "opcion_pregunta", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_opcion_pregunta"})})
@NamedQueries({
    @NamedQuery(name = "OpcionPregunta.findAll", query = "SELECT o FROM OpcionPregunta o"),
    @NamedQuery(name = "OpcionPregunta.findByIdOpcionPregunta", query = "SELECT o FROM OpcionPregunta o WHERE o.idOpcionPregunta = :idOpcionPregunta"),
    @NamedQuery(name = "OpcionPregunta.findByEtiqueta", query = "SELECT o FROM OpcionPregunta o WHERE o.etiqueta = :etiqueta"),
    @NamedQuery(name = "OpcionPregunta.findByCorrectoBool", query = "SELECT o FROM OpcionPregunta o WHERE o.correctoBool = :correctoBool"),
    @NamedQuery(name = "OpcionPregunta.findByCorrectoNumero", query = "SELECT o FROM OpcionPregunta o WHERE o.correctoNumero = :correctoNumero"),
    @NamedQuery(name = "OpcionPregunta.findByCorrectoTexto", query = "SELECT o FROM OpcionPregunta o WHERE o.correctoTexto = :correctoTexto")})
public class OpcionPregunta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="OPCION_PREGUNTA_IDOPCIONPREGUNTA_GENERATOR", sequenceName="SEQ_OPCION_PREGUNTA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="OPCION_PREGUNTA_IDOPCIONPREGUNTA_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_opcion_pregunta", nullable = false)
    private Integer idOpcionPregunta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "etiqueta", nullable = false, length = 128)
    private String etiqueta;
    @Column(name = "correcto_bool")
    private Boolean correctoBool;
    @Column(name = "correcto_numero")
    private BigInteger correctoNumero;
    @Size(max = 128)
    @Column(name = "correcto_texto", length = 128)
    private String correctoTexto;
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id_pregunta", nullable = false)
    @ManyToOne(optional = false)
    private Pregunta pregunta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "opcionPregunta")
    private List<OpcionRespuesta> opcionRespuestaList;

    public OpcionPregunta() {
    }

    public OpcionPregunta(Integer idOpcionPregunta) {
        this.idOpcionPregunta = idOpcionPregunta;
    }

    public OpcionPregunta(Integer idOpcionPregunta, String etiqueta) {
        this.idOpcionPregunta = idOpcionPregunta;
        this.etiqueta = etiqueta;
    }

    public Integer getIdOpcionPregunta() {
        return idOpcionPregunta;
    }

    public void setIdOpcionPregunta(Integer idOpcionPregunta) {
        this.idOpcionPregunta = idOpcionPregunta;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public Boolean getCorrectoBool() {
        return correctoBool;
    }

    public void setCorrectoBool(Boolean correctoBool) {
        this.correctoBool = correctoBool;
    }

    public BigInteger getCorrectoNumero() {
        return correctoNumero;
    }

    public void setCorrectoNumero(BigInteger correctoNumero) {
        this.correctoNumero = correctoNumero;
    }

    public String getCorrectoTexto() {
        return correctoTexto;
    }

    public void setCorrectoTexto(String correctoTexto) {
        this.correctoTexto = correctoTexto;
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    public List<OpcionRespuesta> getOpcionRespuestaList() {
        return opcionRespuestaList;
    }

    public void setOpcionRespuestaList(List<OpcionRespuesta> opcionRespuestaList) {
        this.opcionRespuestaList = opcionRespuestaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOpcionPregunta != null ? idOpcionPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OpcionPregunta)) {
            return false;
        }
        OpcionPregunta other = (OpcionPregunta) object;
        if ((this.idOpcionPregunta == null && other.idOpcionPregunta != null) || (this.idOpcionPregunta != null && !this.idOpcionPregunta.equals(other.idOpcionPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.OpcionPregunta[ idOpcionPregunta=" + idOpcionPregunta + " ]";
    }
    
}
