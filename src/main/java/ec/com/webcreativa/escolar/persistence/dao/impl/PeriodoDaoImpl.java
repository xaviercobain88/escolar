/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import static ec.com.webcreativa.escolar.util.QueryParameter.with;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.PeriodoDao;
import ec.com.webcreativa.escolar.persistence.entity.Periodo;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class PeriodoDaoImpl extends GenericDaoImpl<Periodo, Integer> implements
		PeriodoDao {

	/**
	 * 
	 */
	public PeriodoDaoImpl() {
		super(Periodo.class);

	}
	
	/**
	 * Busca un periodo por estado y region
	 * @param estado
	 * @return
	 * @throws EntidadNoEncontradaException 
	 */
	public List<Periodo> buscarPorRegionActivo(Integer idRegion, Boolean estado) throws EntidadNoEncontradaException {
		return findByNamedQuery("Periodo.findByRegionActivo", with("idReg", idRegion).and("activo", estado).
                parameters(), 1);
		
	}

	

}
