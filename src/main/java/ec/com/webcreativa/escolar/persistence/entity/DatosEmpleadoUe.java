/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author xavier
 */
@Entity
@Table(name = "datos_empleado_ue", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_persona", "id_ue"})})
@NamedQueries({
    @NamedQuery(name = "DatosEmpleadoUe.findAll", query = "SELECT d FROM DatosEmpleadoUe d"),
    @NamedQuery(name = "DatosEmpleadoUe.findByIdPersona", query = "SELECT d FROM DatosEmpleadoUe d WHERE d.datosEmpleadoUePK.idPersona = :idPersona"),
    @NamedQuery(name = "DatosEmpleadoUe.findByIdUe", query = "SELECT d FROM DatosEmpleadoUe d WHERE d.datosEmpleadoUePK.idUe = :idUe"),
    @NamedQuery(name = "DatosEmpleadoUe.findByInstitucionProcedencia", query = "SELECT d FROM DatosEmpleadoUe d WHERE d.institucionProcedencia = :institucionProcedencia"),
    @NamedQuery(name = "DatosEmpleadoUe.findByExperienciaPrevia", query = "SELECT d FROM DatosEmpleadoUe d WHERE d.experienciaPrevia = :experienciaPrevia"),
    @NamedQuery(name = "DatosEmpleadoUe.findByTiempo", query = "SELECT d FROM DatosEmpleadoUe d WHERE d.tiempo = :tiempo"),
    @NamedQuery(name = "DatosEmpleadoUe.findByTitulo", query = "SELECT d FROM DatosEmpleadoUe d WHERE d.titulo = :titulo"),
    @NamedQuery(name = "DatosEmpleadoUe.findByActivo", query = "SELECT d FROM DatosEmpleadoUe d WHERE d.activo = :activo"),
    @NamedQuery(name = "DatosEmpleadoUe.findByFechaIngreso", query = "SELECT d FROM DatosEmpleadoUe d WHERE d.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "DatosEmpleadoUe.findByFechaSalida", query = "SELECT d FROM DatosEmpleadoUe d WHERE d.fechaSalida = :fechaSalida")})
public class DatosEmpleadoUe implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DatosEmpleadoUePK datosEmpleadoUePK;
    @Size(max = 64)
    @Column(name = "institucion_procedencia", length = 64)
    private String institucionProcedencia;
    @Size(max = 512)
    @Column(name = "experiencia_previa", length = 512)
    private String experienciaPrevia;
    @Column(name = "tiempo_")
    private Integer tiempo;
    @Size(max = 64)
    @Column(name = "titulo", length = 64)
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_ingreso", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @JoinColumn(name = "id_ue", referencedColumnName = "id_ue", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UnidadEducativa unidadEducativa;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Persona persona;

    public DatosEmpleadoUe() {
    }

    public DatosEmpleadoUe(DatosEmpleadoUePK datosEmpleadoUePK) {
        this.datosEmpleadoUePK = datosEmpleadoUePK;
    }

    public DatosEmpleadoUe(DatosEmpleadoUePK datosEmpleadoUePK, boolean activo, Date fechaIngreso) {
        this.datosEmpleadoUePK = datosEmpleadoUePK;
        this.activo = activo;
        this.fechaIngreso = fechaIngreso;
    }

    public DatosEmpleadoUe(int idPersona, int idUe) {
        this.datosEmpleadoUePK = new DatosEmpleadoUePK(idPersona, idUe);
    }

    public DatosEmpleadoUePK getDatosEmpleadoUePK() {
        return datosEmpleadoUePK;
    }

    public void setDatosEmpleadoUePK(DatosEmpleadoUePK datosEmpleadoUePK) {
        this.datosEmpleadoUePK = datosEmpleadoUePK;
    }

    public String getInstitucionProcedencia() {
        return institucionProcedencia;
    }

    public void setInstitucionProcedencia(String institucionProcedencia) {
        this.institucionProcedencia = institucionProcedencia;
    }

    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public void setExperienciaPrevia(String experienciaPrevia) {
        this.experienciaPrevia = experienciaPrevia;
    }

    public Integer getTiempo() {
        return tiempo;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public UnidadEducativa getUnidadEducativa() {
        return unidadEducativa;
    }

    public void setUnidadEducativa(UnidadEducativa unidadEducativa) {
        this.unidadEducativa = unidadEducativa;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datosEmpleadoUePK != null ? datosEmpleadoUePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DatosEmpleadoUe)) {
            return false;
        }
        DatosEmpleadoUe other = (DatosEmpleadoUe) object;
        if ((this.datosEmpleadoUePK == null && other.datosEmpleadoUePK != null) || (this.datosEmpleadoUePK != null && !this.datosEmpleadoUePK.equals(other.datosEmpleadoUePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.DatosEmpleadoUe[ datosEmpleadoUePK=" + datosEmpleadoUePK + " ]";
    }
    
}
