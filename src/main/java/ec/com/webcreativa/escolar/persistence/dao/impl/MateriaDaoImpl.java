/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import static ec.com.webcreativa.escolar.util.QueryParameter.with;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.MateriaDao;
import ec.com.webcreativa.escolar.persistence.entity.Materia;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class MateriaDaoImpl extends GenericDaoImpl<Materia, Integer> implements
		MateriaDao {

	/**
	 * 
	 */
	public MateriaDaoImpl() {
		super(Materia.class);

	}

	public List<Materia> buscarPorIdUe_IdCurso_Activo(Integer idUe,
			Integer idCurso, Boolean activo)
			throws EntidadNoEncontradaException{
		List<Materia> resultado = findByNamedQuery(
				"Materia.findByidUe_idCurso",
				with("idUe", idUe).and("idCurso", idCurso)
						.and("activo", activo).parameters());
		if (resultado != null && !resultado.isEmpty()) {
			return resultado;
		}
		return null;
	}

	public List<Materia> buscarPorIdUe_IdCursoNot_Activo(Integer idUe,
			Integer idCurso, Boolean activo)
			throws EntidadNoEncontradaException {
		List<Materia> resultado = findByNamedQuery(
				"Materia.findByidUe_idCursoNot",
				with("idUe", idUe).and("idCurso", idCurso)
						.and("activo", activo).parameters());
		if (resultado != null && !resultado.isEmpty()) {
			return resultado;
		}
		return null;
	}

	/*
	 * select mh from materia mp, materia mh where
	 * mp.id_materia=mh.id_materia_base and mh.id_materia_base in ( select
	 * m.id_materia from materia m, curso_materia cm, curso c where c.id_curso
	 * in (select cp.id_curso from curso ch, curso cp where
	 * cp.id_curso=ch.id_curso_base and ch.id_curso=30) and
	 * m.id_materia=cm.id_materia and c.id_curso=cm.id_curso) and mh.id_materia
	 * not in ( select m.id_materia from materia m, curso_materia cm, curso c
	 * where m.id_materia=cm.id_materia and c.id_curso=cm.id_curso and
	 * c.id_curso=30 ) and mh.activo='true'
	 */
	public List<Materia> buscarSugeridasPorIdCurso_Activo(Integer idCurso,
			Boolean activo) {
		System.out.println(idCurso);
		String sqlString = "select distinct mh.id_materia, mh.id_ue, mh.id_materia_base, mh.id_tip_materia, mh.nombre, mh.descripcion, mh.contenidos, mh.activo " +
				"from materia mp, materia mh where mp.id_materia=mh.id_materia_base and mh.id_materia_base in ("
				+ "select m.id_materia from  materia m, curso_materia cm, curso c where c.id_curso in "
				+ "(select cp.id_curso from curso ch, curso cp where cp.id_curso=ch.id_curso_base and ch.id_curso="
				+ idCurso
				+ ")"
				+ "and m.id_materia=cm.id_materia and c.id_curso=cm.id_curso) and mh.id_materia not in ("
				+ "select m.id_materia from  materia m, curso_materia cm, curso c "
				+ "where m.id_materia=cm.id_materia and c.id_curso=cm.id_curso and c.id_curso="
				+ idCurso + ") and mh.activo='" + activo.toString() + "'";
		List<Materia> resultado = findByNativeQuery(sqlString);
		if (resultado != null && !resultado.isEmpty()) {
			return resultado;
		}
		return null;
	}

	public List<Materia> buscarEspecialesPorIdCurso_IdUe_Activo(
			Integer idCurso, Integer idUe, Boolean activo)
			{
		String sqlString = "select  distinct m.id_materia, m.id_ue, m.id_materia_base, m.id_tip_materia, m.nombre, m.descripcion, m.contenidos, m.activo from materia m where m.id_ue = "
				+ idUe
				+ " and m.id_materia_base  is null and m.id_materia not in ("
				+ "select m.id_materia from  materia m, curso_materia cm, curso c "
				+ "where m.id_materia=cm.id_materia and c.id_curso=cm.id_curso and c.id_curso="
				+ idCurso + ") and m.activo='" + activo.toString()
				+ "' and m.id_ue=1";
		List<Materia> resultado = findByNativeQuery(sqlString);
		if (resultado != null && !resultado.isEmpty()) {
			return resultado;
		}
		return null;
	}

	/*
	 * Busca todas las mateerias q no sean sugeridas ni especiales
	 */
	public List<Materia> buscarNoSugeridasNoEspecialesPorIdCurso_IdUe_Activo(
			Integer idCurso, Integer idUe, Boolean activo)
			{
		String sqlString = "select distinct m.id_materia, m.id_ue, m.id_materia_base, m.id_tip_materia, m.nombre, m.descripcion, m.contenidos, m.activo from materia m where m.id_materia not in (select m.id_materia from materia m where m.id_ue = "
				+ idUe
				+ " and m.id_materia_base  is null and m.id_materia not in ("
				+ "select m.id_materia from  materia m, curso_materia cm, curso c where m.id_materia=cm.id_materia and c.id_curso=cm.id_curso and c.id_curso="
				+ idCurso
				+ ""
				+ ") and m.id_ue="
				+ idUe
				+ ") and m.id_materia not in (select mh.id_materia from materia mp, materia mh where mp.id_materia=mh.id_materia_base and mh.id_materia_base in ("
				+ "select m.id_materia from  materia m, curso_materia cm, curso c where c.id_curso in (select cp.id_curso from curso ch, curso cp where cp.id_curso=ch.id_curso_base and ch.id_curso="
				+ idCurso
				+ ")"
				+ "and m.id_materia=cm.id_materia and c.id_curso=cm.id_curso) and mh.id_materia not in ("
				+ "select m.id_materia from  materia m, curso_materia cm, curso c where m.id_materia=cm.id_materia and c.id_curso=cm.id_curso and c.id_curso="
				+ idCurso
				+ ""
				+ ")) and m.id_materia not in (select m.id_materia from  materia m, curso_materia cm, curso c where m.id_materia=cm.id_materia and c.id_curso=cm.id_curso and c.id_curso="
				+ idCurso
				+ ")"
				+ "and m.activo = '"
				+ activo.toString()
				+ "' and m.id_ue=" + idUe + "";
		List<Materia> resultado = findByNativeQuery(sqlString);
		if (resultado != null && !resultado.isEmpty()) {
			return resultado;
		}
		return null;
	}

}
