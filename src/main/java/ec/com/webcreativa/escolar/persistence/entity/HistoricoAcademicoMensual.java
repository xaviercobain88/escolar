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
@Table(name = "historico_academico_mensual", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"id_ham"})})
@NamedQueries({
    @NamedQuery(name = "HistoricoAcademicoMensual.findAll", query = "SELECT h FROM HistoricoAcademicoMensual h"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByIdHam", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.idHam = :idHam"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByNotaGeneral", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.notaGeneral = :notaGeneral"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByRankingClase", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.rankingClase = :rankingClase"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByRankingCurso", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.rankingCurso = :rankingCurso"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByCatidadParciales", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.catidadParciales = :catidadParciales"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByActivo", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.activo = :activo"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByPorcentajeParcial1", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.porcentajeParcial1 = :porcentajeParcial1"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByPorcentajeParcial2", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.porcentajeParcial2 = :porcentajeParcial2"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByPorcentajeParcial3", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.porcentajeParcial3 = :porcentajeParcial3"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByPorcentajeParcial4", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.porcentajeParcial4 = :porcentajeParcial4"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByPorcentajeParcial5", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.porcentajeParcial5 = :porcentajeParcial5"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByPorcentajeParcial6", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.porcentajeParcial6 = :porcentajeParcial6"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByPorcentajeParcial7", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.porcentajeParcial7 = :porcentajeParcial7"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByPorcentajeParcial8", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.porcentajeParcial8 = :porcentajeParcial8"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByPorcentajeParcial9", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.porcentajeParcial9 = :porcentajeParcial9"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByPorcentajeParcial10", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.porcentajeParcial10 = :porcentajeParcial10"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByNotaParcial1", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.notaParcial1 = :notaParcial1"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByNotaParcial2", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.notaParcial2 = :notaParcial2"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByNotaParcial3", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.notaParcial3 = :notaParcial3"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByNotaParcial4", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.notaParcial4 = :notaParcial4"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByNotaParcial5", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.notaParcial5 = :notaParcial5"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByNotaParcial6", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.notaParcial6 = :notaParcial6"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByNotaParcial7", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.notaParcial7 = :notaParcial7"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByNotaParcial8", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.notaParcial8 = :notaParcial8"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByNotaParcial9", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.notaParcial9 = :notaParcial9"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByNotaParcial10", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.notaParcial10 = :notaParcial10"),
    @NamedQuery(name = "HistoricoAcademicoMensual.findByProfesor", query = "SELECT h FROM HistoricoAcademicoMensual h WHERE h.profesor = :profesor")})
public class HistoricoAcademicoMensual implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name="HISTORICO_ACADEMICO_MENSUAL_IDHAM_GENERATOR", sequenceName="SEQ_HISTORICO_ACADEMICO_MENSUAL")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="HISTORICO_ACADEMICO_MENSUAL_IDHAM_GENERATOR")
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_ham", nullable = false)
    private Integer idHam;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nota_general", nullable = false)
    private BigInteger notaGeneral;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ranking_clase", nullable = false)
    private short rankingClase;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ranking_curso", nullable = false)
    private short rankingCurso;
    @Column(name = "catidad_parciales")
    private Short catidadParciales;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "porcentaje_parcial1")
    private BigInteger porcentajeParcial1;
    @Column(name = "porcentaje_parcial2")
    private BigInteger porcentajeParcial2;
    @Column(name = "porcentaje_parcial3")
    private BigInteger porcentajeParcial3;
    @Column(name = "porcentaje_parcial4")
    private BigInteger porcentajeParcial4;
    @Column(name = "porcentaje_parcial5")
    private BigInteger porcentajeParcial5;
    @Column(name = "porcentaje_parcial6")
    private BigInteger porcentajeParcial6;
    @Column(name = "porcentaje_parcial7")
    private BigInteger porcentajeParcial7;
    @Column(name = "porcentaje_parcial8")
    private BigInteger porcentajeParcial8;
    @Column(name = "porcentaje_parcial9")
    private BigInteger porcentajeParcial9;
    @Column(name = "porcentaje_parcial10")
    private BigInteger porcentajeParcial10;
    @Column(name = "nota_parcial1")
    private BigInteger notaParcial1;
    @Column(name = "nota_parcial2")
    private BigInteger notaParcial2;
    @Column(name = "nota_parcial3")
    private BigInteger notaParcial3;
    @Column(name = "nota_parcial4")
    private BigInteger notaParcial4;
    @Column(name = "nota_parcial5")
    private BigInteger notaParcial5;
    @Column(name = "nota_parcial6")
    private BigInteger notaParcial6;
    @Column(name = "nota_parcial7")
    private BigInteger notaParcial7;
    @Column(name = "nota_parcial8")
    private BigInteger notaParcial8;
    @Column(name = "nota_parcial9")
    private BigInteger notaParcial9;
    @Column(name = "nota_parcial10")
    private BigInteger notaParcial10;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 256)
    @Column(name = "profesor", nullable = false, length = 256)
    private String profesor;
    @JoinColumn(name = "per_id_persona", referencedColumnName = "id_persona")
    @ManyToOne
    private Persona persona;
    @JoinColumn(name = "id_persona", referencedColumnName = "id_persona", nullable = false)
    @ManyToOne(optional = false)
    private Persona persona1;
    @JoinColumn(name = "id_per", referencedColumnName = "id_per", nullable = false)
    @ManyToOne(optional = false)
    private Periodo periodo;
    @JoinColumn(name = "id_mes_setup", referencedColumnName = "id_mes_setup", nullable = false)
    @ManyToOne(optional = false)
    private MesSetup mesSetup;
    @JoinColumn(name = "id_materia", referencedColumnName = "id_materia", nullable = false)
    @ManyToOne(optional = false)
    private Materia materia;

    public HistoricoAcademicoMensual() {
    }

    public HistoricoAcademicoMensual(Integer idHam) {
        this.idHam = idHam;
    }

    public HistoricoAcademicoMensual(Integer idHam, BigInteger notaGeneral, short rankingClase, short rankingCurso, String profesor) {
        this.idHam = idHam;
        this.notaGeneral = notaGeneral;
        this.rankingClase = rankingClase;
        this.rankingCurso = rankingCurso;
        this.profesor = profesor;
    }

    public Integer getIdHam() {
        return idHam;
    }

    public void setIdHam(Integer idHam) {
        this.idHam = idHam;
    }

    public BigInteger getNotaGeneral() {
        return notaGeneral;
    }

    public void setNotaGeneral(BigInteger notaGeneral) {
        this.notaGeneral = notaGeneral;
    }

    public short getRankingClase() {
        return rankingClase;
    }

    public void setRankingClase(short rankingClase) {
        this.rankingClase = rankingClase;
    }

    public short getRankingCurso() {
        return rankingCurso;
    }

    public void setRankingCurso(short rankingCurso) {
        this.rankingCurso = rankingCurso;
    }

    public Short getCatidadParciales() {
        return catidadParciales;
    }

    public void setCatidadParciales(Short catidadParciales) {
        this.catidadParciales = catidadParciales;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public BigInteger getPorcentajeParcial1() {
        return porcentajeParcial1;
    }

    public void setPorcentajeParcial1(BigInteger porcentajeParcial1) {
        this.porcentajeParcial1 = porcentajeParcial1;
    }

    public BigInteger getPorcentajeParcial2() {
        return porcentajeParcial2;
    }

    public void setPorcentajeParcial2(BigInteger porcentajeParcial2) {
        this.porcentajeParcial2 = porcentajeParcial2;
    }

    public BigInteger getPorcentajeParcial3() {
        return porcentajeParcial3;
    }

    public void setPorcentajeParcial3(BigInteger porcentajeParcial3) {
        this.porcentajeParcial3 = porcentajeParcial3;
    }

    public BigInteger getPorcentajeParcial4() {
        return porcentajeParcial4;
    }

    public void setPorcentajeParcial4(BigInteger porcentajeParcial4) {
        this.porcentajeParcial4 = porcentajeParcial4;
    }

    public BigInteger getPorcentajeParcial5() {
        return porcentajeParcial5;
    }

    public void setPorcentajeParcial5(BigInteger porcentajeParcial5) {
        this.porcentajeParcial5 = porcentajeParcial5;
    }

    public BigInteger getPorcentajeParcial6() {
        return porcentajeParcial6;
    }

    public void setPorcentajeParcial6(BigInteger porcentajeParcial6) {
        this.porcentajeParcial6 = porcentajeParcial6;
    }

    public BigInteger getPorcentajeParcial7() {
        return porcentajeParcial7;
    }

    public void setPorcentajeParcial7(BigInteger porcentajeParcial7) {
        this.porcentajeParcial7 = porcentajeParcial7;
    }

    public BigInteger getPorcentajeParcial8() {
        return porcentajeParcial8;
    }

    public void setPorcentajeParcial8(BigInteger porcentajeParcial8) {
        this.porcentajeParcial8 = porcentajeParcial8;
    }

    public BigInteger getPorcentajeParcial9() {
        return porcentajeParcial9;
    }

    public void setPorcentajeParcial9(BigInteger porcentajeParcial9) {
        this.porcentajeParcial9 = porcentajeParcial9;
    }

    public BigInteger getPorcentajeParcial10() {
        return porcentajeParcial10;
    }

    public void setPorcentajeParcial10(BigInteger porcentajeParcial10) {
        this.porcentajeParcial10 = porcentajeParcial10;
    }

    public BigInteger getNotaParcial1() {
        return notaParcial1;
    }

    public void setNotaParcial1(BigInteger notaParcial1) {
        this.notaParcial1 = notaParcial1;
    }

    public BigInteger getNotaParcial2() {
        return notaParcial2;
    }

    public void setNotaParcial2(BigInteger notaParcial2) {
        this.notaParcial2 = notaParcial2;
    }

    public BigInteger getNotaParcial3() {
        return notaParcial3;
    }

    public void setNotaParcial3(BigInteger notaParcial3) {
        this.notaParcial3 = notaParcial3;
    }

    public BigInteger getNotaParcial4() {
        return notaParcial4;
    }

    public void setNotaParcial4(BigInteger notaParcial4) {
        this.notaParcial4 = notaParcial4;
    }

    public BigInteger getNotaParcial5() {
        return notaParcial5;
    }

    public void setNotaParcial5(BigInteger notaParcial5) {
        this.notaParcial5 = notaParcial5;
    }

    public BigInteger getNotaParcial6() {
        return notaParcial6;
    }

    public void setNotaParcial6(BigInteger notaParcial6) {
        this.notaParcial6 = notaParcial6;
    }

    public BigInteger getNotaParcial7() {
        return notaParcial7;
    }

    public void setNotaParcial7(BigInteger notaParcial7) {
        this.notaParcial7 = notaParcial7;
    }

    public BigInteger getNotaParcial8() {
        return notaParcial8;
    }

    public void setNotaParcial8(BigInteger notaParcial8) {
        this.notaParcial8 = notaParcial8;
    }

    public BigInteger getNotaParcial9() {
        return notaParcial9;
    }

    public void setNotaParcial9(BigInteger notaParcial9) {
        this.notaParcial9 = notaParcial9;
    }

    public BigInteger getNotaParcial10() {
        return notaParcial10;
    }

    public void setNotaParcial10(BigInteger notaParcial10) {
        this.notaParcial10 = notaParcial10;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Persona getPersona1() {
        return persona1;
    }

    public void setPersona1(Persona persona1) {
        this.persona1 = persona1;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public MesSetup getMesSetup() {
        return mesSetup;
    }

    public void setMesSetup(MesSetup mesSetup) {
        this.mesSetup = mesSetup;
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
        hash += (idHam != null ? idHam.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoAcademicoMensual)) {
            return false;
        }
        HistoricoAcademicoMensual other = (HistoricoAcademicoMensual) object;
        if ((this.idHam == null && other.idHam != null) || (this.idHam != null && !this.idHam.equals(other.idHam))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "webcreativa.escolar_login.model.HistoricoAcademicoMensual[ idHam=" + idHam + " ]";
    }
    
}
