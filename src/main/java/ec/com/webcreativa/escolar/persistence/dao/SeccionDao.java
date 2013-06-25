package ec.com.webcreativa.escolar.persistence.dao;

import java.util.List;

import javax.ejb.Local;

import ec.com.webcreativa.escolar.persistence.entity.Seccion;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

@Local
public interface SeccionDao extends GenericDao<Seccion, Integer> {

	List<Seccion> buscarPorIdUnidadEducativa_IdSeccionPadre(Integer idUe,
			Integer idSeccion, Boolean activo) throws EntidadNoEncontradaException;
}
