package ec.com.webcreativa.escolar.mock;

import java.math.BigDecimal;
import java.math.MathContext;

public class PersonasMock implements Cloneable {

	private String nombre;
	private Integer orden;
	private BigDecimal n1, n2, n3, n4, n5, b1, b2, x1, q1, r1, q2, s1,
			remedial1, g1, a, m1, m2, m3, m4, m5, x2, f, td;
	private Boolean completo = false;
	private String pendiente = "";
	private String estilo1, estilo2, estilo3, estilodb1, estilodb2, estilodq1,
			estilodb3, estilodb4, estilodb, estilodb6, estilodq2, estiloda;
	private Boolean permitirR, permitirS, permitirRemedia, permitirGracia;
	private String db1, db2, db3, db4, db5, db6, dq1, dq2, da;
	private Integer d1,d2,d3,d4,d5,d6,d7,d8, d1j,d2j,d3j,d4j,d5j,d6j,d7j,d8j,dt,it;

	public PersonasMock() {
		super();
	}

	public Integer getIt() {
		return it;
	}

	public void setIt(Integer it) {
		this.it = it;
	}

	public Integer getD1j() {
		return d1j;
	}

	public void setD1j(Integer d1j) {
		this.d1j = d1j;
	}

	public Integer getD2j() {
		return d2j;
	}

	public void setD2j(Integer d2j) {
		this.d2j = d2j;
	}

	public Integer getD3j() {
		return d3j;
	}

	public void setD3j(Integer d3j) {
		this.d3j = d3j;
	}

	public Integer getD4j() {
		return d4j;
	}

	public void setD4j(Integer d4j) {
		this.d4j = d4j;
	}

	public Integer getD5j() {
		return d5j;
	}

	public void setD5j(Integer d5j) {
		this.d5j = d5j;
	}

	public Integer getD6j() {
		return d6j;
	}

	public void setD6j(Integer d6j) {
		this.d6j = d6j;
	}

	public Integer getD7j() {
		return d7j;
	}

	public void setD7j(Integer d7j) {
		this.d7j = d7j;
	}

	public Integer getD8j() {
		return d8j;
	}

	public void setD8j(Integer d8j) {
		this.d8j = d8j;
	}

	public BigDecimal getTd() {
		return td;
	}

	public void setTd(BigDecimal td) {
		this.td = td;
	}

	public Integer getDt() {
		return dt;
	}

	public void setDt(Integer dt) {
		this.dt = dt;
	}

	public Integer getD1() {
		return d1;
	}

	public void setD1(Integer d1) {
		this.d1 = d1;
	}

	public Integer getD2() {
		return d2;
	}

	public void setD2(Integer d2) {
		this.d2 = d2;
	}

	public Integer getD3() {
		return d3;
	}

	public void setD3(Integer d3) {
		this.d3 = d3;
	}

	public Integer getD4() {
		return d4;
	}

	public void setD4(Integer d4) {
		this.d4 = d4;
	}

	public Integer getD5() {
		return d5;
	}

	public void setD5(Integer d5) {
		this.d5 = d5;
	}

	public Integer getD6() {
		return d6;
	}

	public void setD6(Integer d6) {
		this.d6 = d6;
	}

	public Integer getD7() {
		return d7;
	}

	public void setD7(Integer d7) {
		this.d7 = d7;
	}

	public Integer getD8() {
		return d8;
	}

	public void setD8(Integer d8) {
		this.d8 = d8;
	}

	public PersonasMock clonar() {
		try {
			PersonasMock personasMock = (PersonasMock) this.clone();
			return personasMock;
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}

	}

	public Boolean getPermitirR() {
		return permitirR;
	}

	public void setPermitirR(Boolean permitirR) {
		this.permitirR = permitirR;
	}

	public BigDecimal getN4() {
		return n4;
	}

	public void setN4(BigDecimal n4) {
		this.n4 = n4;
	}

	public BigDecimal getN5() {
		return n5;
	}

	public void setN5(BigDecimal n5) {
		this.n5 = n5;
	}

	public BigDecimal getM4() {
		return m4;
	}

	public void setM4(BigDecimal m4) {
		this.m4 = m4;
	}

	public BigDecimal getM5() {
		return m5;
	}

	public void setM5(BigDecimal m5) {
		this.m5 = m5;
	}

	public Boolean getPermitirS() {
		return permitirS;
	}

	public void setPermitirS(Boolean permitirS) {
		this.permitirS = permitirS;
	}

	public String getEstilo1() {
		return estilo1;
	}

	public void setEstilo1(String estilo1) {
		this.estilo1 = estilo1;
	}

	public String getEstilo2() {
		return estilo2;
	}

	public void setEstilo2(String estilo2) {
		this.estilo2 = estilo2;
	}

	public String getEstilo3() {
		return estilo3;
	}

	public void setEstilo3(String estilo3) {
		this.estilo3 = estilo3;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getOrden() {
		return orden;
	}

	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	public BigDecimal getN1() {
		return n1 != null ? n1.round(new MathContext(2)) : null;
	}

	public void setN1(BigDecimal n1) {
		this.n1 = n1;
	}

	public BigDecimal getN2() {
		return n2 != null ? n2.round(new MathContext(2)) : null;
	}

	public void setN2(BigDecimal n2) {
		this.n2 = n2;
	}

	public BigDecimal getN3() {
		return n3 != null ? n3.round(new MathContext(2)) : null;
	}

	public void setN3(BigDecimal n3) {
		this.n3 = n3;
	}

	public BigDecimal getB1() {
		return b1 != null ? b1.round(new MathContext(2)) : null;
	}

	public void setB1(BigDecimal b1) {
		this.b1 = b1;
	}

	public BigDecimal getB2() {
		return b2 != null ? b2.round(new MathContext(2)) : null;
	}

	public void setB2(BigDecimal b2) {
		this.b2 = b2;
	}

	public BigDecimal getX1() {
		return x1 != null ? x1.round(new MathContext(2)) : null;
	}

	public void setX1(BigDecimal x1) {
		this.x1 = x1;
	}

	public BigDecimal getQ1() {
		return q1 != null ? q1.round(new MathContext(2)) : null;
	}

	public void setQ1(BigDecimal q1) {
		this.q1 = q1;
	}

	public BigDecimal getR1() {
		return r1 != null ? r1.round(new MathContext(2)) : null;
	}

	public void setR1(BigDecimal r1) {
		this.r1 = r1;
	}

	public BigDecimal getQ2() {
		return q2 != null ? q2.round(new MathContext(2)) : null;
	}

	public void setQ2(BigDecimal q2) {
		this.q2 = q2;
	}

	public BigDecimal getS1() {
		return s1 != null ? s1.round(new MathContext(2)) : null;
	}

	public void setS1(BigDecimal s1) {
		this.s1 = s1;
	}

	public BigDecimal getRemedial1() {
		return remedial1 != null ? remedial1.round(new MathContext(2)) : null;
	}

	public void setRemedial1(BigDecimal remedial1) {
		this.remedial1 = remedial1;
	}

	public BigDecimal getG1() {
		return g1 != null ? g1.round(new MathContext(2)) : null;
	}

	public void setG1(BigDecimal g1) {
		this.g1 = g1;
	}

	public BigDecimal getA() {
		return a != null ? a.round(new MathContext(2)) : null;
	}

	public void setA(BigDecimal a) {
		this.a = a;
	}

	public BigDecimal getM1() {
		return m1 != null ? m1.round(new MathContext(2)) : null;
	}

	public void setM1(BigDecimal m1) {
		this.m1 = m1;
	}

	public BigDecimal getM2() {
		return m2 != null ? m2.round(new MathContext(2)) : null;
	}

	public void setM2(BigDecimal m2) {
		this.m2 = m2;
	}

	public BigDecimal getM3() {
		return m3 != null ? m3.round(new MathContext(2)) : null;
	}

	public void setM3(BigDecimal m3) {
		this.m3 = m3;
	}

	public Boolean getCompleto() {
		return completo;
	}

	public void setCompleto(Boolean completo) {
		this.completo = completo;
	}

	public BigDecimal getF() {
		return f != null ? f.round(new MathContext(2)) : null;
	}

	public void setF(BigDecimal f) {
		this.f = f;
	}

	public String getPendiente() {
		return pendiente;
	}

	public void setPendiente(String pendiente) {
		this.pendiente = pendiente;
	}

	public BigDecimal getX2() {
		return x2 != null ? x2.round(new MathContext(2)) : null;
	}

	public void setX2(BigDecimal x2) {
		this.x2 = x2;
	}

	public Boolean getPermitirRemedia() {
		return permitirRemedia;
	}

	public void setPermitirRemedia(Boolean permitirRemedia) {
		this.permitirRemedia = permitirRemedia;
	}

	public Boolean getPermitirGracia() {
		return permitirGracia;
	}

	public String getEstilodb1() {
		return estilodb1;
	}

	public void setEstilodb1(String estilodb1) {
		this.estilodb1 = estilodb1;
	}

	public String getEstilodb2() {
		return estilodb2;
	}

	public void setEstilodb2(String estilodb2) {
		this.estilodb2 = estilodb2;
	}

	public String getEstilodq1() {
		return estilodq1;
	}

	public void setEstilodq1(String estilodq1) {
		this.estilodq1 = estilodq1;
	}

	public String getEstilodq2() {
		return estilodq2;
	}

	public void setEstilodq2(String estilodq2) {
		this.estilodq2 = estilodq2;
	}

	public String getEstiloda() {
		return estiloda;
	}

	public void setEstiloda(String estiloda) {
		this.estiloda = estiloda;
	}

	public void setPermitirGracia(Boolean permitirGracia) {
		this.permitirGracia = permitirGracia;
	}

	public String getDb1() {
		return db1;
	}

	public void setDb1(String db1) {
		this.db1 = db1;
	}

	public String getDb2() {
		return db2;
	}

	public void setDb2(String db2) {
		this.db2 = db2;
	}

	public String getDb3() {
		return db3;
	}

	public void setDb3(String db3) {
		this.db3 = db3;
	}

	public String getDb4() {
		return db4;
	}

	public void setDb4(String db4) {
		this.db4 = db4;
	}

	public String getDq1() {
		return dq1;
	}

	public void setDq1(String dq1) {
		this.dq1 = dq1;
	}

	public String getDq2() {
		return dq2;
	}

	public void setDq2(String dq2) {
		this.dq2 = dq2;
	}

	public String getDa() {
		return da;
	}

	public void setDa(String da) {
		this.da = da;
	}

	public String getEstilodb3() {
		return estilodb3;
	}

	public void setEstilodb3(String estilodb3) {
		this.estilodb3 = estilodb3;
	}

	public String getEstilodb4() {
		return estilodb4;
	}

	public String getEstilodb() {
		return estilodb;
	}

	public void setEstilodb(String estilodb) {
		this.estilodb = estilodb;
	}

	public String getEstilodb6() {
		return estilodb6;
	}

	public void setEstilodb6(String estilodb6) {
		this.estilodb6 = estilodb6;
	}

	public String getDb5() {
		return db5;
	}

	public void setDb5(String db5) {
		this.db5 = db5;
	}

	public String getDb6() {
		return db6;
	}

	public void setDb6(String db6) {
		this.db6 = db6;
	}

	public void setEstilodb4(String estilodb4) {
		this.estilodb4 = estilodb4;
	}

}
