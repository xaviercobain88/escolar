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
@Table(name = "pregunta", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_pregunta"})})
@NamedQueries({
    @NamedQuery(name = "Pregunta.findAll", query = "SELECT p FROM Pregunta p"),
    @NamedQuery(name = "Pregunta.findByIdPregunta", query = "SELECT p FROM Pregunta p WHERE p.idPregunta = :idPregunta"),
    @NamedQuery(name = "Pregunta.findByOrden", query = "SELECT p FROM Pregunta p WHERE p.orden = :orden"),
    @NamedQuery(name = "Pregunta.findByCantidadOpciones", query = "SELECT p FROM Pregunta p WHERE p.cantidadOpciones = :cantidadOpciones"),
    @NamedQuery(name = "Pregunta.findByTipoPregunta", query = "SELECT p FROM Pregunta p WHERE p.tipoPregunta = :tipoPregunta"),
    @NamedQuery(name = "Pregunta.findByDescripcion", query = "SELECT p FROM Pregunta p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Pregunta.findByExplicacion", query = "SELECT p FROM Pregunta p WHERE p.explicacion = :explicacion"),
    @NamedQuery(name = "Pregunta.findByCantidadRespuestas", query = "SELECT p FROM Pregunta p WHERE p.cantidadRespuestas = :cantidadRespuestas")})
public class Pregunta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="PREGUNTA_IDPREGUNTA_GENERATOR", sequenceName="SEQ_PREGUNTA")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PREGUNTA_IDPREGUNTA_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_pregunta", nullable = false)
    private Integer idPregunta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "orden", nullable = false)
    private short orden;
    @Column(name = "cantidad_opciones")
    private Short cantidadOpciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "tipo_pregunta", nullable = false, length = 12)
    private String tipoPregunta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "descripcion", nullable = false, length = 256)
    private String descripcion;
    @Size(max = 2048)
    @Column(name = "explicacion", length = 2048)
    private String explicacion;
    @Column(name = "cantidad_respuestas")
    private Short cantidadRespuestas;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pregunta")
    private List<OpcionPregunta> opcionPreguntaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pregunta")
    private List<Respuesta> respuestaList;
    @JoinColumn(name = "id_her_eva", referencedColumnName = "id_her_eva", nullable = false)
    @ManyToOne(optional = false)
    private HerramientaEvaluacion herramientaEvaluacion;

    public Pregunta() {
    }

    public Pregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public Pregunta(Integer idPregunta, short orden, String tipoPregunta, String descripcion) {
        this.idPregunta = idPregunta;
        this.orden = orden;
        this.tipoPregunta = tipoPregunta;
        this.descripcion = descripcion;
    }

    public Integer getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Integer idPregunta) {
        this.idPregunta = idPregunta;
    }

    public short getOrden() {
        return orden;
    }

    public void setOrden(short orden) {
        this.orden = orden;
    }

    public Short getCantidadOpciones() {
        return cantidadOpciones;
    }

    public void setCantidadOpciones(Short cantidadOpciones) {
        this.cantidadOpciones = cantidadOpciones;
    }

    public String getTipoPregunta() {
        return tipoPregunta;
    }

    public void setTipoPregunta(String tipoPregunta) {
        this.tipoPregunta = tipoPregunta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getExplicacion() {
        return explicacion;
    }

    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }

    public Short getCantidadRespuestas() {
        return cantidadRespuestas;
    }

    public void setCantidadRespuestas(Short cantidadRespuestas) {
        this.cantidadRespuestas = cantidadRespuestas;
    }

    public List<OpcionPregunta> getOpcionPreguntaList() {
        return opcionPreguntaList;
    }

    public void setOpcionPreguntaList(List<OpcionPregunta> opcionPreguntaList) {
        this.opcionPreguntaList = opcionPreguntaList;
    }

    public List<Respuesta> getRespuestaList() {
        return respuestaList;
    }

    public void setRespuestaList(List<Respuesta> respuestaList) {
        this.respuestaList = respuestaList;
    }

    public HerramientaEvaluacion getHerramientaEvaluacion() {
        return herramientaEvaluacion;
    }

    public void setHerramientaEvaluacion(HerramientaEvaluacion herramientaEvaluacion) {
        this.herramientaEvaluacion = herramientaEvaluacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPregunta != null ? idPregunta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pregunta)) {
            return false;
        }
        Pregunta other = (Pregunta) object;
        if ((this.idPregunta == null && other.idPregunta != null) || (this.idPregunta != null && !this.idPregunta.equals(other.idPregunta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.Pregunta[ idPregunta=" + idPregunta + " ]";
    }
    
}
