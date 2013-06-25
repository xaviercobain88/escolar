package ec.com.webcreativa.escolar.mock;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import ec.com.webcreativa.escolar.persistence.entity.Materia;
import ec.com.webcreativa.escolar.presentation.action.BaseController;

@Named
@ApplicationScoped
public class MockController extends BaseController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<PersonasMock> personasList;
	private List<PersonasMock> materiasList;
	private List<String> columnas;
	private Integer numeroColumnas = 5;
	private Date q1IDate, q2IDate, supletorioIDate, remedialIDate, graciIDate,
			q1FDate, q2FDate, supletorioFDate, remedialFDate, graciFDate,
			r1IDate, r1FDate, r2IDate, r2FDate;

	private List<Materia> materiaList;
	private Materia materiaSeleccionada;
	private Integer fase = 0;
	private Integer faseD = 0;
	private Integer indexBimenestre;
	private Integer indexQuimenestre;
	private List<SelectItem> bimestreSelectItemList;
	private List<SelectItem> quimestreSelectItemList;
	private List<SelectItem> disciplinaSelectItemList;
	private Integer tabIndex, cantidadJ;
	private PersonasMock personasMockJ;
	private Integer indexTutor;
	private BigDecimal mediaParcial1, mediaParcial2, mediaQ1, mediaQ2, mediaA,
			mediaF;

	public BigDecimal getMediaParcial1() {
		return mediaParcial1;
	}

	public BigDecimal getMediaParcial2() {
		return mediaParcial2;
	}

	public BigDecimal getMediaQ1() {
		return mediaQ1;
	}

	public BigDecimal getMediaQ2() {
		return mediaQ2;
	}

	public Integer getIndexTutor() {
		return indexTutor;
	}

	public void setMediaParcial1(BigDecimal mediaParcial1) {
		this.mediaParcial1 = mediaParcial1;
	}

	public void setMediaParcial2(BigDecimal mediaParcial2) {
		this.mediaParcial2 = mediaParcial2;
	}

	public void setMediaQ1(BigDecimal mediaQ1) {
		this.mediaQ1 = mediaQ1;
	}

	public void setMediaQ2(BigDecimal mediaQ2) {
		this.mediaQ2 = mediaQ2;
	}

	public void setIndexTutor(Integer indexTutor) {
		this.indexTutor = indexTutor;
	}

	public MockController() {
		super();

		generarPersonas();
		generarColumnas();
		asignarFechas();
		generarMaterias();
		iniciarDisciplina();
		materiaSeleccionada = new Materia();

	}

	public void justificar() {
		switch (indexBimenestre) {
		case 0:
			if (personasMockJ.getD1() - cantidadJ >= 0) {
				personasMockJ.setD1(personasMockJ.getD1() - cantidadJ);
				personasMockJ.setD1j(personasMockJ.getD1j() + cantidadJ);
			} else {
				personasMockJ.setD1j(personasMockJ.getD1());
				personasMockJ.setD1(personasMockJ.getD1j() + cantidadJ);

			}
			break;
		case 1:
			if (personasMockJ.getD2() - cantidadJ >= 0) {
				personasMockJ.setD2(personasMockJ.getD2() - cantidadJ);
				personasMockJ.setD2j(personasMockJ.getD2j() + cantidadJ);
			} else {
				personasMockJ.setD2j(personasMockJ.getD2());
				personasMockJ.setD2(personasMockJ.getD2j() + cantidadJ);

			}
			break;
		case 2:
			if (personasMockJ.getD3() - cantidadJ >= 0) {
				personasMockJ.setD3(personasMockJ.getD3() - cantidadJ);
				personasMockJ.setD3j(personasMockJ.getD3j() + cantidadJ);
			} else {
				personasMockJ.setD3j(personasMockJ.getD3());
				personasMockJ.setD3(personasMockJ.getD3j() + cantidadJ);

			}
			break;
		case 3:
			if (personasMockJ.getD4() - cantidadJ >= 0) {
				personasMockJ.setD4(personasMockJ.getD4() - cantidadJ);
				personasMockJ.setD4j(personasMockJ.getD4j() + cantidadJ);
			} else {
				personasMockJ.setD4j(personasMockJ.getD4());
				personasMockJ.setD4(personasMockJ.getD4j() + cantidadJ);

			}
			break;
		case 4:
			if (personasMockJ.getD5() - cantidadJ >= 0) {
				personasMockJ.setD5(personasMockJ.getD5() - cantidadJ);
				personasMockJ.setD5j(personasMockJ.getD5j() + cantidadJ);
			} else {
				personasMockJ.setD5j(personasMockJ.getD5());
				personasMockJ.setD5(personasMockJ.getD5j() + cantidadJ);

			}
			break;
		case 5:
			if (personasMockJ.getD6() - cantidadJ >= 0) {
				personasMockJ.setD6(personasMockJ.getD6() - cantidadJ);
				personasMockJ.setD6j(personasMockJ.getD6j() + cantidadJ);
			} else {
				personasMockJ.setD6j(personasMockJ.getD6());
				personasMockJ.setD6(personasMockJ.getD6j() + cantidadJ);

			}
			break;
		case 6:
			if (personasMockJ.getD7() - cantidadJ >= 0) {
				personasMockJ.setD7(personasMockJ.getD7() - cantidadJ);
				personasMockJ.setD7j(personasMockJ.getD7j() + cantidadJ);
			} else {
				personasMockJ.setD7j(personasMockJ.getD7());
				personasMockJ.setD7(personasMockJ.getD7j() + cantidadJ);

			}
			break;
		case 7:
			if (personasMockJ.getD8() - cantidadJ >= 0) {
				personasMockJ.setD8(personasMockJ.getD8() - cantidadJ);
				personasMockJ.setD8j(personasMockJ.getD8j() + cantidadJ);
			} else {
				personasMockJ.setD8j(personasMockJ.getD8());
				personasMockJ.setD8(personasMockJ.getD8j() + cantidadJ);

			}
			break;
		}
		calcularDisciplina();
	}

	public PersonasMock getPersonasMockJ() {
		return personasMockJ;
	}

	public void setPersonasMockJ(PersonasMock personasMockJ) {
		this.personasMockJ = personasMockJ;
	}

	public Integer getCantidadJ() {
		return cantidadJ;
	}

	public void setCantidadJ(Integer cantidadJ) {
		this.cantidadJ = cantidadJ;
	}

	public void iniciarDisciplina() {
		for (PersonasMock personasMock : personasList) {
			personasMock.setD1(0);
			personasMock.setD2(0);
			personasMock.setD3(0);
			personasMock.setD4(0);
			personasMock.setD5(0);
			personasMock.setD6(0);
			personasMock.setD7(0);
			personasMock.setD8(0);
			personasMock.setD1j(0);
			personasMock.setD2j(0);
			personasMock.setD3j(0);
			personasMock.setD4j(0);
			personasMock.setD5j(0);
			personasMock.setD6j(0);
			personasMock.setD7j(0);
			personasMock.setD8j(0);
			personasMock.setTd(new BigDecimal(0));
			personasMock.setDt(0);
			personasMock.setIt(0);
		}
	}

	public List<String> getCursoString() {
		List<String> lista = new ArrayList<String>();
		lista.add("9no A");
		lista.add("9no B");
		lista.add("1ro Ciencias");
		lista.add("1ro Cultivo PMC");
		return lista;
	}

	public void calcularDisciplina() {
		for (PersonasMock personasMock : personasList) {
			personasMock.setDt(personasMock.getD1() + personasMock.getD2()
					+ personasMock.getD3() + personasMock.getD4()
					+ personasMock.getD5() + personasMock.getD6()
					+ personasMock.getD7() + personasMock.getD8());
			personasMock.setIt(personasMock.getD1j() + personasMock.getD2j()
					+ personasMock.getD3j() + personasMock.getD4j()
					+ personasMock.getD5j() + personasMock.getD6j()
					+ personasMock.getD7j() + personasMock.getD8j());
			personasMock.setTd(new BigDecimal(personasMock.getDt() * 100 / 200)
					.round(new MathContext(2)));
		}
	}

	public List<String> getAlumnoString() {
		List<String> lista = new ArrayList<String>();
		lista.add("Aguilar Cerda Bernardino");
		lista.add("Aguilar Hernández José A.");
		lista.add("Almaguer Aguirre Martha");
		lista.add("Álvarez Moncada Juana de Jesús");
		return lista;
	}

	public List<String> getMateriaString() {
		List<String> lista = new ArrayList<String>();
		lista.add("Matemáticas");
		return lista;
	}

	public List<Integer> getHorasString() {
		List<Integer> lista = new ArrayList<Integer>();
		for (int i = 0; i < 80; i++) {
			lista.add(i + 1);
		}
		return lista;
	}

	public String getCambiarFase() {
		fase += 1;
		switch (fase) {
		case 1:
			prepararFase1();
			break;
		case 2:
			prepararFase2();
			break;
		case 3:
			prepararFase3();
			break;
		case 4:
			prepararFase4();
			break;
		case 5:
			prepararFase5();
			break;
		case 6:
			prepararFase6();
			break;
		case 7:
			prepararFase7();
			break;
		}
		return null;
	}

	public String getCambiarFaseD() {
		faseD += 1;
		return null;
	}

	public String getPrepararRegistroAlumno() {
		materiasList = new ArrayList<PersonasMock>();
		PersonasMock personasMock;
		personasMock = personasList.get(0).clonar();
		personasMock.setNombre("Lengua y Literatura");
		materiasList.add(personasMock);
		personasMock = personasList.get(1).clonar();
		personasMock.setNombre("Matemáticas");
		materiasList.add(personasMock);
		personasMock = personasList.get(2).clonar();
		personasMock.setNombre("Ciencias Naturales");
		materiasList.add(personasMock);
		personasMock = personasList.get(3).clonar();
		personasMock.setNombre("Ciencias Sociales");
		materiasList.add(personasMock);
		personasMock = personasList.get(0).clonar();
		personasMock.setNombre("Educación Estética");
		personasMock.setOrden(5);
		materiasList.add(personasMock);
		personasMock = personasList.get(1).clonar();
		personasMock.setNombre("Educación Física");
		personasMock.setOrden(6);
		materiasList.add(personasMock);
		personasMock = personasList.get(2).clonar();
		personasMock.setNombre("Lengua Extranjera");
		personasMock.setOrden(7);
		materiasList.add(personasMock);
		personasMock = personasList.get(3).clonar();
		personasMock.setNombre("Informática");
		personasMock.setOrden(8);
		materiasList.add(personasMock);
		tabIndex = 0;
		return null;
	}

	public void listenerBimestre() {
		if (indexBimenestre == 1) {
			calcularFase2();
		} else {
			calcularFase1();
		}
	}

	public List<PersonasMock> getMateriasList() {
		return materiasList;
	}

	public void setMateriasList(List<PersonasMock> materiasList) {
		this.materiasList = materiasList;
	}

	public void listenerQuimestre() {
		if (indexQuimenestre == 1) {
			calcularFase4();
		} else {
			calcularFase3();
		}
	}

	public String getFase1() {
		if (indexBimenestre == 0) {
			calcularFase1();
		} else {
			calcularFase2();
		}
		return null;
	}

	public String getFase3() {
		if (indexBimenestre == 0) {
			calcularFase3();
		} else {
			calcularFase4();
		}
		return null;
	}

	public String getFase7() {
		calcularFase7();
		return null;
	}

	public void nuevaMateria() {
		materiaSeleccionada = new Materia();
	}

	public void prepararFase1() {
		SelectItem selectItem = new SelectItem(0, "Parcial 1");
		indexBimenestre = 0;
		bimestreSelectItemList = new ArrayList<SelectItem>();
		bimestreSelectItemList.add(selectItem);
		// for (PersonasMock personasMock : personasList) {
		// Random random = new Random();
		// personasMock.setN1(newRandomBigDecimal(random, 2));
		// personasMock.setN2(newRandomBigDecimal(random, 2));
		// }
		calcularFase1();
		fase = 1;
		tabIndex = 0;
	}

	public void calcularFase1() {
		for (PersonasMock personasMock : personasList) {

			if (personasMock.getN1() != null && personasMock.getN2() != null
					&& personasMock.getN3() != null
					&& personasMock.getN4() != null
					&& personasMock.getN5() != null) {
				personasMock.setB1((personasMock.getN1().add(personasMock
						.getN2().add(personasMock.getN3())
						.add(personasMock.getN4()).add(personasMock.getN5())))
						.divide(new BigDecimal(5), 2, RoundingMode.HALF_UP));
				personasMock.setCompleto(true);
			} else {
				personasMock.setB1(null);
				personasMock.setCompleto(false);
			}
			if (personasMock.getB1() == null) {
				personasMock.setEstilo1("blanco");
			} else if (personasMock.getB1().compareTo(new BigDecimal(5)) < 0) {
				personasMock.setEstilo1("rojo");
			} else if (personasMock.getB1().compareTo(new BigDecimal(7)) < 0) {
				personasMock.setEstilo1("naranja");
			} else {
				personasMock.setEstilo1("verde");
			}
			calcularMediaParcial1();
		}
	}

	public void prepararFase2() {
		SelectItem selectItem = new SelectItem(0, "Parcial 1");
		indexBimenestre = 1;
		bimestreSelectItemList = new ArrayList<SelectItem>();
		bimestreSelectItemList.add(selectItem);
		selectItem = new SelectItem(1, "Parcial 2");
		bimestreSelectItemList.add(selectItem);
		// for (PersonasMock personasMock : personasList) {
		// Random random = new Random();
		// personasMock.setM1(newRandomBigDecimal(random, 2));
		// personasMock.setM2(newRandomBigDecimal(random, 2));
		// personasMock.setM3(newRandomBigDecimal(random, 2));
		// }
		tabIndex = 0;
		calcularFase2();
		fase = 2;
	}

	public void calcularFase2() {
		for (PersonasMock personasMock : personasList) {

			if (personasMock.getM1() != null && personasMock.getM2() != null
					&& personasMock.getM3() != null) {
				personasMock.setB2((personasMock.getM1().add(personasMock
						.getM2().add(personasMock.getM3())
						.add(personasMock.getM4()).add(personasMock.getM5())))
						.divide(new BigDecimal(5), 2, RoundingMode.HALF_UP));
				personasMock.setCompleto(true);
			} else {
				personasMock.setB2(null);
				personasMock.setCompleto(false);
			}
			if (personasMock.getB2() == null) {
				personasMock.setEstilo1("blanco");
			} else if (personasMock.getB2().compareTo(new BigDecimal(5)) < 0) {
				personasMock.setEstilo1("rojo");
			} else if (personasMock.getB2().compareTo(new BigDecimal(7)) < 0) {
				personasMock.setEstilo1("naranja");
			} else {
				personasMock.setEstilo1("verde");
			}
			calcularMediaParcial2();
		}
	}

	public void prepararFase3() {
		indexBimenestre = 3;
		bimestreSelectItemList = new ArrayList<SelectItem>();
		SelectItem selectItem = new SelectItem(0, "Parcial 1");
		bimestreSelectItemList.add(selectItem);
		selectItem = new SelectItem(1, "Parcial 2");
		bimestreSelectItemList.add(selectItem);
		selectItem = new SelectItem(2, "Parcial 3");
		bimestreSelectItemList.add(selectItem);
		indexQuimenestre = 0;
		quimestreSelectItemList = new ArrayList<SelectItem>();
		SelectItem selectItemQ = new SelectItem(0, "Quimestre 1");
		quimestreSelectItemList.add(selectItemQ);

		fase = 3;
		tabIndex = 1;
		calcularFase3();
	}

	public void calcularFase3() {
		for (PersonasMock personasMock : personasList) {

			if (personasMock.getB1() != null && personasMock.getB2() != null
					&& personasMock.getX1() != null) {
				personasMock.setQ1(((personasMock.getB1()
						.add(personasMock.getB2()).add(personasMock.getB2())
						.add(personasMock.getB1()))
						.multiply(new BigDecimal(80)).divide(
						new BigDecimal(400), 2, RoundingMode.HALF_UP))
						.add((personasMock.getX1().multiply(new BigDecimal(20))
								.divide(new BigDecimal(100), 2,
										RoundingMode.HALF_UP))));
				personasMock.setA(personasMock.getQ1().divide(
						new BigDecimal(2), 2, RoundingMode.HALF_UP));
				personasMock.setCompleto(true);
			} else {
				personasMock.setQ1(null);
				personasMock.setCompleto(false);
			}
			if (personasMock.getQ1() == null) {
				personasMock.setEstilo2("blanco");
			} else if (personasMock.getQ1().compareTo(new BigDecimal(5)) < 0) {
				personasMock.setEstilo2("rojo");
			} else if (personasMock.getQ1().compareTo(new BigDecimal(7)) < 0) {
				personasMock.setEstilo2("naranja");
			} else {
				personasMock.setEstilo2("verde");
			}
			calcularMediaQ1();
		}
	}

	public void prepararFase4() {
		indexBimenestre = 3;
		bimestreSelectItemList = new ArrayList<SelectItem>();
		SelectItem selectItem = new SelectItem(0, "Quimeste 1 - Parcial 1");
		bimestreSelectItemList.add(selectItem);
		selectItem = new SelectItem(1, "Quimeste 1 - Parcial 2");
		bimestreSelectItemList.add(selectItem);
		selectItem = new SelectItem(2, "Quimeste 1 - Parcial 3");
		bimestreSelectItemList.add(selectItem);
		selectItem = new SelectItem(3, "Quimeste 2 - Parcial 1");
		bimestreSelectItemList.add(selectItem);
		selectItem = new SelectItem(3, "Quimeste 2 - Parcial 2");
		bimestreSelectItemList.add(selectItem);
		selectItem = new SelectItem(3, "Quimeste 2 - Parcial 3");
		bimestreSelectItemList.add(selectItem);
		indexQuimenestre = 1;
		quimestreSelectItemList = new ArrayList<SelectItem>();
		SelectItem selectItemQ = new SelectItem(0, "Quimestre 1");
		quimestreSelectItemList.add(selectItemQ);
		selectItemQ = new SelectItem(1, "Quimestre 2");
		quimestreSelectItemList.add(selectItemQ);
		tabIndex = 1;
		fase = 4;
		calcularFase4();
	}

	public void calcularFase4() {
		for (PersonasMock personasMock : personasList) {

			if (personasMock.getB1() != null && personasMock.getB2() != null
					&& personasMock.getX2() != null) {
				personasMock.setQ2((personasMock.getB1()
						.add(personasMock.getB2()).add(personasMock.getB1())
						.add(personasMock.getB2()).multiply(new BigDecimal(80))
						.divide(new BigDecimal(400), 2, RoundingMode.HALF_UP))
						.add((personasMock.getX2().multiply(new BigDecimal(20))
								.divide(new BigDecimal(100), 2,
										RoundingMode.HALF_UP))));
				personasMock.setA(personasMock.getQ2()
						.add(personasMock.getQ1())
						.divide(new BigDecimal(2), 2, RoundingMode.HALF_UP));
				personasMock.setCompleto(true);
			} else {
				personasMock.setQ2(null);
				personasMock.setCompleto(false);
			}
			if (personasMock.getA() == null) {
				personasMock.setEstilo2("blanco");
			} else if (personasMock.getA().compareTo(new BigDecimal(5)) < 0) {
				personasMock.setEstilo2("rojo");
			} else if (personasMock.getA().compareTo(new BigDecimal(7)) < 0) {
				personasMock.setEstilo2("naranja");
			} else {
				personasMock.setEstilo2("verde");
			}
			calcularMediaQ2();
			calcularMediaA();
		}
	}

	public void calcularMediaParcial1() {
		BigDecimal resultado = new BigDecimal(0);
		for (PersonasMock personasMock : personasList) {
			if (personasMock.getB1() != null) {
				resultado = resultado.add(personasMock.getB1());
			} else {
				resultado = resultado.add(new BigDecimal(0));
			}
		}
		System.out.println("Si entraaaaaa "
				+ resultado.divide(new BigDecimal(personasList.size()), 2,
						RoundingMode.HALF_UP));
		mediaParcial1 = resultado.divide(new BigDecimal(personasList.size()),
				2, RoundingMode.HALF_UP);
	}

	public void calcularMediaA() {
		BigDecimal resultado = new BigDecimal(0);
		for (PersonasMock personasMock : personasList) {
			if (personasMock.getA() != null) {
				resultado = resultado.add(personasMock.getA());
			} else {
				resultado = resultado.add(new BigDecimal(0));
			}
		}
		mediaA = resultado.divide(new BigDecimal(personasList.size()), 2,
				RoundingMode.HALF_UP);
	}

	public void calcularMediaF() {
		BigDecimal resultado = new BigDecimal(0);
		for (PersonasMock personasMock : personasList) {
			if (personasMock.getF() != null) {
				resultado = resultado.add(personasMock.getF());
			} else {
				resultado = resultado.add(new BigDecimal(0));
			}
		}
		mediaF = resultado.divide(new BigDecimal(personasList.size()), 2,
				RoundingMode.HALF_UP);
	}

	public BigDecimal getMediaA() {
		return mediaA;
	}

	public void setMediaA(BigDecimal mediaA) {
		this.mediaA = mediaA;
	}

	public BigDecimal getMediaF() {
		return mediaF;
	}

	public void setMediaF(BigDecimal mediaF) {
		this.mediaF = mediaF;
	}

	public void calcularMediaParcial2() {
		BigDecimal resultado = new BigDecimal(0);
		for (PersonasMock personasMock : personasList) {
			if (personasMock.getB2() != null) {
				resultado = resultado.add(personasMock.getB2());
			} else {
				resultado = resultado.add(new BigDecimal(0));
			}
		}
		mediaParcial2 = resultado.divide(new BigDecimal(personasList.size()),
				2, RoundingMode.HALF_UP);
	}

	public void calcularMediaQ1() {
		BigDecimal resultado = new BigDecimal(0);
		for (PersonasMock personasMock : personasList) {
			if (personasMock.getQ1() != null) {
				resultado = resultado.add(personasMock.getQ1());
			} else {
				resultado = resultado.add(new BigDecimal(0));
			}
		}
		mediaQ1 = resultado.divide(new BigDecimal(personasList.size()), 2,
				RoundingMode.HALF_UP);
	}

	public void calcularMediaQ2() {
		BigDecimal resultado = new BigDecimal(0);
		for (PersonasMock personasMock : personasList) {
			if (personasMock.getQ2() != null) {
				resultado = resultado.add(personasMock.getQ2());
			} else {
				resultado = resultado.add(new BigDecimal(0));
			}
		}
		mediaQ2 = resultado.divide(new BigDecimal(personasList.size()), 2,
				RoundingMode.HALF_UP);
	}

	public void prepararFase5() {
		tabIndex = 2;
		for (PersonasMock personasMock : personasList) {
			personasMock.setF(personasMock.getA());
			if (personasMock.getA() != null) {
				if (personasMock.getA().compareTo(new BigDecimal(7)) >= 0) {
					personasMock.setPermitirR(true);
				} else if (personasMock.getA().compareTo(new BigDecimal(5)) >= 0) {
					personasMock.setPermitirS(true);
				} else {

					personasMock.setPendiente("Pendiente");
				}
			}
		}

		fase = 5;
		calcularFase5();
	}

	public void calcularFase5() {
		for (PersonasMock personasMock : personasList) {

			if (personasMock.getR1() != null) {
				if (personasMock.getQ1().compareTo(personasMock.getQ2()) > 0) {
					if (personasMock.getR1().compareTo(personasMock.getQ2()) > 0) {
						personasMock.setF(personasMock
								.getR1()
								.add(personasMock.getQ1())
								.divide(new BigDecimal(2), 2,
										RoundingMode.HALF_UP));
					} else {
						personasMock.setF(personasMock
								.getQ2()
								.add(personasMock.getQ1())
								.divide(new BigDecimal(2), 2,
										RoundingMode.HALF_UP));
					}
				} else {
					if (personasMock.getR1().compareTo(personasMock.getQ1()) > 0) {
						personasMock.setF(personasMock
								.getR1()
								.add(personasMock.getQ2())
								.divide(new BigDecimal(2), 2,
										RoundingMode.HALF_UP));
					} else {
						personasMock.setF(personasMock
								.getQ2()
								.add(personasMock.getQ1())
								.divide(new BigDecimal(2), 2,
										RoundingMode.HALF_UP));
					}
				}
			}
			if (personasMock.getS1() != null) {
				if (personasMock.getS1().compareTo(new BigDecimal(7)) >= 0) {
					personasMock.setF(new BigDecimal(7));
				} else {
					personasMock.setF(personasMock.getA());
				}

			}

			if (personasMock.getF().compareTo(new BigDecimal(7)) < 0) {
				personasMock.setEstilo3("rojo");
			} else {

				personasMock.setEstilo3("verde");
			}
			calcularMediaF();
		}
	}

	public void prepararFase6() {

		for (PersonasMock personasMock : personasList) {
			personasMock.setPendiente("");
			if (personasMock.getF().compareTo(new BigDecimal(7)) < 0) {
				personasMock.setPermitirRemedia(true);
				personasMock.setEstilo3("rojo");
			} else {
				personasMock.setEstilo3("verde");
			}

		}

		fase = 6;
		calcularFase6();
	}

	public void calcularFase6() {
		for (PersonasMock personasMock : personasList) {

			if (personasMock.getRemedial1() != null) {
				if (personasMock.getRemedial1().compareTo(new BigDecimal(7)) >= 0) {
					personasMock.setF(new BigDecimal(7));
				} else {
					personasMock.setF(personasMock.getA());
				}

			}
			if (personasMock.getF().compareTo(new BigDecimal(7)) < 0) {
				personasMock.setEstilo3("rojo");
			} else {

				personasMock.setEstilo3("verde");
			}
			calcularMediaF();
		}
	}

	public void prepararFase7() {

		for (PersonasMock personasMock : personasList) {
			personasMock.setPendiente("");
			if (personasMock.getF().compareTo(new BigDecimal(7)) < 0) {
				personasMock.setPermitirGracia(true);
				personasMock.setEstilo3("rojo");
			} else {
				personasMock.setEstilo3("verde");
			}

		}

		fase = 7;
		calcularFase7();
	}

	public void calcularFase7() {
		for (PersonasMock personasMock : personasList) {

			if (personasMock.getG1() != null) {
				if (personasMock.getG1().compareTo(new BigDecimal(7)) >= 0) {
					personasMock.setF(new BigDecimal(7));
				} else {
					personasMock.setF(personasMock.getA());
				}

			}
			if (personasMock.getF().compareTo(new BigDecimal(7)) < 0) {
				personasMock.setEstilo3("rojo");
			} else {

				personasMock.setEstilo3("verde");
			}
			calcularMediaF();
		}
	}

	// *******************disciplina************************

	public Integer getIndexBimenestre() {
		return indexBimenestre;
	}

	public void setIndexBimenestre(Integer indexBimenestre) {
		this.indexBimenestre = indexBimenestre;
	}

	public Integer getIndexQuimenestre() {
		return indexQuimenestre;
	}

	public void setIndexQuimenestre(Integer indexQuimenestre) {
		this.indexQuimenestre = indexQuimenestre;
	}

	public List<SelectItem> getBimestreSelectItemList() {
		return bimestreSelectItemList;
	}

	public void setBimestreSelectItemList(
			List<SelectItem> bimestreSelectItemList) {
		this.bimestreSelectItemList = bimestreSelectItemList;
	}

	public List<SelectItem> getQuimestreSelectItemList() {
		return quimestreSelectItemList;
	}

	public void setQuimestreSelectItemList(
			List<SelectItem> quimestreSelectItemList) {
		this.quimestreSelectItemList = quimestreSelectItemList;
	}

	private static BigDecimal newRandomBigDecimal(Random r, int precision) {

		BigDecimal resultado = new BigDecimal(Math.random() * 10);
		if (resultado.compareTo(new BigDecimal(4)) < 0) {
			resultado = resultado.add(new BigDecimal(4));
		}
		return resultado;
	}

	//
	// private static BigInteger newRandomBigInteger(BigInteger n, Random rnd) {
	// BigInteger r;
	// do {
	// r = new BigInteger(n.bitLength(), rnd);
	// } while (r.compareTo(n) >= 0);
	//
	// return r;
	// }

	public void generarMaterias() {
		materiaList = new ArrayList<Materia>();
		Materia materia = new Materia();
		materia.setNombre("Francés");
		materia.setDescripcion("El idioma francés es una lengua romance hablada en todo el territorio de Francia metropolitana.");
		materiaList.add(materia);
		materia = new Materia();
		materia.setNombre("Religión");
		materia.setDescripcion("La religión es una parte de la actividad humana consistente en creencias y prácticas acerca de lo considerado como divino o sagrado, de tipo existencial, moral y espiritual");
		materiaList.add(materia);
		materia = new Materia();
		materia.setNombre("Alemán");
		materia.setDescripcion("El alemán (Deutsch, en alemán) es una lengua indoeuropea perteneciente al grupo de las lenguas germánicas occidentales");
		materiaList.add(materia);
		materia = new Materia();
		materia.setNombre("Huerto");
		materia.setDescripcion("as actividades relacionadas son las que integran el llamado sector agrícola");
		materiaList.add(materia);

	}

	public void asignarFechas() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd");

		try {
			q1IDate = dateFormat.parse("2013/01/21");
			q1FDate = dateFormat.parse("2013/01/25");
			q2IDate = dateFormat.parse("2013/07/15");
			q2FDate = dateFormat.parse("2013/07/19");
			r1IDate = dateFormat.parse("2013/02/11");
			r1FDate = dateFormat.parse("2013/02/15");
			r2IDate = dateFormat.parse("2013/08/05");
			r2FDate = dateFormat.parse("2013/08/09");
			supletorioIDate = dateFormat.parse("2013/08/05");
			supletorioFDate = dateFormat.parse("2013/08/09");
			remedialIDate = dateFormat.parse("2013/08/12");
			remedialFDate = dateFormat.parse("2013/08/16");
			graciIDate = dateFormat.parse("2013/08/30");
			graciFDate = dateFormat.parse("2013/09/04");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String generarColumnas() {
		columnas = new ArrayList<String>();
		for (int i = 1; i <= numeroColumnas; i++) {
			columnas.add("P " + i);
		}
		return null;
	}

	// personasMock = new PersonasMock();
	// personasMock.setNombre("Salazar Arteaga José Francisco ");
	// personasMock.setOrden(21);
	// personasList.add(personasMock);
	// personasMock = new PersonasMock();
	// personasMock
	// .setNombre("Silva Silva Perales José Darío Perales José Darío");
	// personasMock.setOrden(22);
	// personasList.add(personasMock);
	// personasMock = new PersonasMock();
	// personasMock.setNombre("Vázquez Velázquez Jesús Armando ");
	// personasMock.setOrden(23);
	// personasList.add(personasMock);
	// personasMock = new PersonasMock();
	// personasMock.setNombre("Villarreal Villanueva Daniel ");
	// personasMock.setOrden(24);
	// personasList.add(personasMock);
	// personasMock = new PersonasMock();
	// personasMock.setNombre("Zúñiga Ruiz Xochitl Patricia ");
	// personasMock.setOrden(25);
	// personasList.add(personasMock);

	public void generarPersonas() {
		personasList = new ArrayList<PersonasMock>();
		PersonasMock personasMock = new PersonasMock();
		personasMock.setNombre("Aguilar Cerda Bernardino");
		personasMock.setOrden(1);
		personasList.add(personasMock);
		personasMock = new PersonasMock();
		personasMock.setNombre("Aguilar Hernández José A.");
		personasMock.setOrden(2);
		personasList.add(personasMock);
		personasMock = new PersonasMock();
		personasMock.setNombre("Almaguer Aguirre Martha ");
		personasMock.setOrden(3);
		personasList.add(personasMock);
		personasMock = new PersonasMock();
		personasMock.setNombre("Álvarez Moncada Juana de Jesús ");
		personasMock.setOrden(4);
		personasList.add(personasMock);
		// personasMock = new PersonasMock();
		// personasMock.setNombre("Andrade Morán Juan Jorge ");
		// personasMock.setOrden(5);
		// personasList.add(personasMock);
		// personasMock = new PersonasMock();
		// personasMock.setNombre("Arellano Castillo Yazmín Yesenia ");
		// personasMock.setOrden(6);
		// personasList.add(personasMock);
		// personasMock = new PersonasMock();
		// personasMock.setNombre("Barrientos Hernández Soledad ");
		// personasMock.setOrden(7);
		// personasList.add(personasMock);
		// personasMock = new PersonasMock();
		// personasMock.setNombre("Barrón Herrera Patricia Elizabeth");
		// personasMock.setOrden(8);
		// personasList.add(personasMock);
		// personasMock = new PersonasMock();
		// personasMock.setNombre("Becerra Trejo Oscar");
		// personasMock.setOrden(9);
		// personasList.add(personasMock);
		// personasMock = new PersonasMock();
		// personasMock.setNombre("Braña Cano Gabriela");
		// personasMock.setOrden(10);
		// personasList.add(personasMock);
		// personasMock = new PersonasMock();
		// personasMock.setNombre("Flores Elvira Cordelia");
		// personasMock.setOrden(11);
		// personasList.add(personasMock);
		// personasMock = new PersonasMock();
		// personasMock.setNombre("Gallegos Alejandro");
		// personasMock.setOrden(12);
		// personasList.add(personasMock);
		// personasMock = new PersonasMock();
		// personasMock.setNombre("Gómez Castillo Angélica");
		// personasMock.setOrden(13);
		// personasList.add(personasMock);
		// personasMock = new PersonasMock();
		// personasMock.setNombre("Gómez Saldivar Marco Antonio");
		// personasMock.setOrden(14);
		// personasList.add(personasMock);
		// personasMock = new PersonasMock();
		// personasMock.setNombre("González Picazo Laura Elena ");
		// personasMock.setOrden(15);
		// personasList.add(personasMock);
		// personasMock = new PersonasMock();
		// personasMock.setNombre("López Castillo Pablo ");
		// personasMock.setOrden(16);
		// personasList.add(personasMock);
		// personasMock = new PersonasMock();
		// personasMock.setNombre("Martínez Hernández Miguel Ángel ");
		// personasMock.setOrden(17);
		// personasList.add(personasMock);
		// personasMock = new PersonasMock();
		// personasMock.setNombre("Martínez Ibarra Esteban Guillermo ");
		// personasMock.setOrden(18);
		// personasList.add(personasMock);
		// personasMock = new PersonasMock();
		// personasMock.setNombre("Peña Martínez Gustavo");
		// personasMock.setOrden(19);
		// personasList.add(personasMock);
		// personasMock = new PersonasMock();
		// personasMock.setNombre("Pérez Rodríguez Daniel Cristobal");
		// personasMock.setOrden(20);
		// personasList.add(personasMock);
	}

	public List<PersonasMock> getPersonasList() {
		return personasList;
	}

	public void setPersonasList(List<PersonasMock> personasList) {
		this.personasList = personasList;
	}

	public List<String> getColumnas() {
		return columnas;
	}

	public void setColumnas(List<String> columnas) {
		this.columnas = columnas;
	}

	public Integer getNumeroColumnas() {
		return numeroColumnas;
	}

	public void setNumeroColumnas(Integer numeroColumnas) {
		this.numeroColumnas = numeroColumnas;
	}

	public String guardar() {
		addInfoMessage("Se ha guarado con éxito");
		return null;
	}

	public Date getQ1IDate() {
		return q1IDate;
	}

	public void setQ1IDate(Date q1iDate) {
		q1IDate = q1iDate;
	}

	public Date getQ2IDate() {
		return q2IDate;
	}

	public void setQ2IDate(Date q2iDate) {
		q2IDate = q2iDate;
	}

	public Date getSupletorioIDate() {
		return supletorioIDate;
	}

	public Integer getFase() {
		return fase;
	}

	public void setFase(Integer fase) {
		this.fase = fase;
	}

	public void setSupletorioIDate(Date supletorioIDate) {
		this.supletorioIDate = supletorioIDate;
	}

	public Date getRemedialIDate() {
		return remedialIDate;
	}

	public void setRemedialIDate(Date remedialIDate) {
		this.remedialIDate = remedialIDate;
	}

	public Date getGraciIDate() {
		return graciIDate;
	}

	public void setGraciIDate(Date graciIDate) {
		this.graciIDate = graciIDate;
	}

	public Date getQ1FDate() {
		return q1FDate;
	}

	public void setQ1FDate(Date q1fDate) {
		q1FDate = q1fDate;
	}

	public Date getQ2FDate() {
		return q2FDate;
	}

	public void setQ2FDate(Date q2fDate) {
		q2FDate = q2fDate;
	}

	public Date getSupletorioFDate() {
		return supletorioFDate;
	}

	public void setSupletorioFDate(Date supletorioFDate) {
		this.supletorioFDate = supletorioFDate;
	}

	public Date getRemedialFDate() {
		return remedialFDate;
	}

	public void setRemedialFDate(Date remedialFDate) {
		this.remedialFDate = remedialFDate;
	}

	public Date getGraciFDate() {
		return graciFDate;
	}

	public void setGraciFDate(Date graciFDate) {
		this.graciFDate = graciFDate;
	}

	public Date getR1IDate() {
		return r1IDate;
	}

	public void setR1IDate(Date r1iDate) {
		r1IDate = r1iDate;
	}

	public Date getR1FDate() {
		return r1FDate;
	}

	public void setR1FDate(Date r1fDate) {
		r1FDate = r1fDate;
	}

	public Date getR2IDate() {
		return r2IDate;
	}

	public void setR2IDate(Date r2iDate) {
		r2IDate = r2iDate;
	}

	public Date getR2FDate() {
		return r2FDate;
	}

	public void setR2FDate(Date r2fDate) {
		r2FDate = r2fDate;
	}

	public List<Materia> getMateriaList() {
		return materiaList;
	}

	public void setMateriaList(List<Materia> materiaList) {
		this.materiaList = materiaList;
	}

	public Materia getMateriaSeleccionada() {
		return materiaSeleccionada;
	}

	public void setMateriaSeleccionada(Materia materiaSeleccionada) {
		this.materiaSeleccionada = materiaSeleccionada;
	}

	public Integer getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(Integer tabIndex) {
		this.tabIndex = tabIndex;
	}

	public List<SelectItem> getDisciplinaSelectItemList() {
		disciplinaSelectItemList = new ArrayList<SelectItem>();
		SelectItem item = new SelectItem(null, "...");
		disciplinaSelectItemList.add(item);
		item = new SelectItem("A");
		disciplinaSelectItemList.add(item);
		item = new SelectItem("B");
		disciplinaSelectItemList.add(item);
		item = new SelectItem("C");
		disciplinaSelectItemList.add(item);
		item = new SelectItem("D");
		disciplinaSelectItemList.add(item);
		item = new SelectItem("E");
		disciplinaSelectItemList.add(item);
		return disciplinaSelectItemList;
	}

	public void setDisciplinaSelectItemList(
			List<SelectItem> disciplinaSelectItemList) {
		this.disciplinaSelectItemList = disciplinaSelectItemList;
	}

	public Integer getFaseD() {
		return faseD;
	}

	public void setFaseD(Integer faseD) {
		this.faseD = faseD;
	}

	@Override
	public String getInit() {
		// TODO Auto-generated method stub
		return null;
	}
}
