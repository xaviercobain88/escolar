/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import static ec.com.webcreativa.escolar.util.QueryParameter.with;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;

import ec.com.webcreativa.escolar.persistence.dao.PersonaDao;
import ec.com.webcreativa.escolar.persistence.entity.Persona;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class PersonaDaoImpl extends GenericDaoImpl<Persona, Integer> implements
		PersonaDao {

	/**
	 * 
	 */
	public PersonaDaoImpl() {
		super(Persona.class);

	}

	/*
	 * Busca la persona por usuario
	 * 
	 * @see
	 * ec.com.webcreativa.escolar.persistence.dao.PersonaDao#buscarXUsuario(
	 * java.lang.String)
	 */
	public Persona buscarPorUsuario(String usuario)
			throws EntidadNoEncontradaException {
		List<Persona> resultado = findByNamedQuery("Persona.findByUsuario",
				with("usuario", usuario).parameters(), 1);
		if (resultado != null && !resultado.isEmpty()) {
			return resultado.get(0);
		}
		throw new EntidadNoEncontradaException();
	}

	@SuppressWarnings("unchecked")
	public List<Persona> buscarPorCriterios(String apellidos,
			String ciPasaporte, String usuario, Integer idRol, Integer idUe)
			throws EntidadNoEncontradaException {
		StringBuilder sqlString;
		if (idRol != null || idUe != null) {
			sqlString = new StringBuilder(
					"Select p from Persona p inner join p.rolList r where 1=1 ");
		} else {
			sqlString = new StringBuilder("Select p from Persona p where 1= 1 ");
		}

		if (apellidos != null && !apellidos.isEmpty()) {
			sqlString.append(" and p.apellidos like :apellidos");
		}
		if (ciPasaporte != null && !ciPasaporte.isEmpty()) {
			sqlString.append(" and p.ciPasaporte like :ciPasaporte");
		}
		if (usuario != null && !usuario.isEmpty()) {
			sqlString.append(" and p.usuario like :usuario");
		}
		if (idRol != null&& idRol>0) {
			sqlString.append(" and r.idRol = :idRol");
		}
		if (idUe != null&& idUe>0) {
			sqlString.append(" and r.unidadEducativa.idUe = :idUe");
		}
		Query query = entityManager.createQuery(sqlString.toString());
		if (apellidos != null && !apellidos.isEmpty()) {
			query.setParameter("apellidos", "%" + apellidos + "%");
		}
		if (ciPasaporte != null && !ciPasaporte.isEmpty()) {
			query.setParameter("ciPasaporte", "%" + ciPasaporte + "%");
		}
		if (usuario != null && !usuario.isEmpty()) {
			query.setParameter("usuario", "%" + usuario + "%");
		}
		if (idRol != null && idRol>0) {
			query.setParameter("idRol", idRol);
		}
		if (idUe != null && idUe>0) {
			query.setParameter("idUe", idUe);
		}

		List<Persona> resultado = query.getResultList();
		if (resultado != null && !resultado.isEmpty()) {
			System.out.println("***********"+resultado.size());
			return resultado;
		}
		System.out.println("no encuentra nada");
		throw new EntidadNoEncontradaException();
	}

}
