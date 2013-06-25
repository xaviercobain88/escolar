/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
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
@Table(name = "grupo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_grupo"})})
@NamedQueries({
    @NamedQuery(name = "Grupo.findAll", query = "SELECT g FROM Grupo g"),
    @NamedQuery(name = "Grupo.findByIdGrupo", query = "SELECT g FROM Grupo g WHERE g.idGrupo = :idGrupo"),
    @NamedQuery(name = "Grupo.findByNombre", query = "SELECT g FROM Grupo g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "Grupo.findByDescripcion", query = "SELECT g FROM Grupo g WHERE g.descripcion = :descripcion"),
    @NamedQuery(name = "Grupo.findByFechaCreacion", query = "SELECT g FROM Grupo g WHERE g.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Grupo.findByActivo", query = "SELECT g FROM Grupo g WHERE g.activo = :activo")})
public class Grupo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="GRUPO_IDGRUPO_GENERATOR", sequenceName="SEQ_GRUPO")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRUPO_IDGRUPO_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_grupo", nullable = false)
    private Integer idGrupo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "nombre", nullable = false, length = 64)
    private String nombre;
    @Size(max = 256)
    @Column(name = "descripcion", length = 256)
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "activo", nullable = false)
    private boolean activo;
    @JoinTable(name = "persona_grupo", joinColumns = {
        @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)})
    @ManyToMany
    private List<Persona> personaList;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    @ManyToOne(optional = false)
    private Persona persona;
    @JoinColumn(name = "id_her_cla", referencedColumnName = "id_her_cla")
    @ManyToOne
    private HerramientaClase herramientaClase;

    public Grupo() {
    }

    public Grupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public Grupo(Integer idGrupo, String nombre, Date fechaCreacion, boolean activo) {
        this.idGrupo = idGrupo;
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.activo = activo;
    }

    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public HerramientaClase getHerramientaClase() {
        return herramientaClase;
    }

    public void setHerramientaClase(HerramientaClase herramientaClase) {
        this.herramientaClase = herramientaClase;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGrupo != null ? idGrupo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupo)) {
            return false;
        }
        Grupo other = (Grupo) object;
        if ((this.idGrupo == null && other.idGrupo != null) || (this.idGrupo != null && !this.idGrupo.equals(other.idGrupo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.Grupo[ idGrupo=" + idGrupo + " ]";
    }
    
}
