/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.com.webcreativa.escolar.persistence.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author xavier
 */
@Entity
@Table(name = "mes_clase", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_mes_setup", "id_clase"})})
@NamedQueries({
    @NamedQuery(name = "MesClase.findAll", query = "SELECT m FROM MesClase m"),
    @NamedQuery(name = "MesClase.findByIdMesSetup", query = "SELECT m FROM MesClase m WHERE m.mesClasePK.idMesSetup = :idMesSetup"),
    @NamedQuery(name = "MesClase.findByIdClase", query = "SELECT m FROM MesClase m WHERE m.mesClasePK.idClase = :idClase")})
public class MesClase implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MesClasePK mesClasePK;
    @JoinColumn(name = "id_mes_setup", referencedColumnName = "id_mes_setup", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MesSetup mesSetup;
    @JoinColumn(name = "id_clase", referencedColumnName = "id_clase", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clase clase;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mesClase")
    private List<HerramientaClase> herramientaClaseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mesClase")
    private List<Registro> registroList;

    public MesClase() {
    }

    public MesClase(MesClasePK mesClasePK) {
        this.mesClasePK = mesClasePK;
    }

    public MesClase(int idMesSetup, int idClase) {
        this.mesClasePK = new MesClasePK(idMesSetup, idClase);
    }

    public MesClasePK getMesClasePK() {
        return mesClasePK;
    }

    public void setMesClasePK(MesClasePK mesClasePK) {
        this.mesClasePK = mesClasePK;
    }

    public MesSetup getMesSetup() {
        return mesSetup;
    }

    public void setMesSetup(MesSetup mesSetup) {
        this.mesSetup = mesSetup;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public List<HerramientaClase> getHerramientaClaseList() {
        return herramientaClaseList;
    }

    public void setHerramientaClaseList(List<HerramientaClase> herramientaClaseList) {
        this.herramientaClaseList = herramientaClaseList;
    }

    public List<Registro> getRegistroList() {
        return registroList;
    }

    public void setRegistroList(List<Registro> registroList) {
        this.registroList = registroList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mesClasePK != null ? mesClasePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MesClase)) {
            return false;
        }
        MesClase other = (MesClase) object;
        if ((this.mesClasePK == null && other.mesClasePK != null) || (this.mesClasePK != null && !this.mesClasePK.equals(other.mesClasePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.MesClase[ mesClasePK=" + mesClasePK + " ]";
    }
    
}
