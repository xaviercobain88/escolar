/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.RegionDao;
import ec.com.webcreativa.escolar.persistence.entity.Region;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.util.QueryParameter;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class RegionDaoImpl extends GenericDaoImpl<Region, Integer> implements
		RegionDao {

	/**
	 * 
	 */
	public RegionDaoImpl() {
		super(Region.class);

	}

	/*
	 * Busca las regiones de un pais
	 * 
	 * @see
	 * ec.com.webcreativa.escolar.persistence.dao.RegionDao#buscarRegionesPais
	 * (ec.com.webcreativa.escolar.persistence.entity.Pais)
	 */
	public List<Region> buscarRegionesPais(Integer idPais) throws EntidadNoEncontradaException {
		return findByNamedQuery("Region.findByPais",
				QueryParameter.with("idPais", idPais).parameters());

	}

}
