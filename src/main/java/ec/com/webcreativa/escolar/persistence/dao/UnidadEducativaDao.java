package ec.com.webcreativa.escolar.persistence.dao;

import javax.ejb.Local;

import ec.com.webcreativa.escolar.persistence.entity.UnidadEducativa;

@Local
public interface UnidadEducativaDao extends
		GenericDao<UnidadEducativa, Integer> {

}
