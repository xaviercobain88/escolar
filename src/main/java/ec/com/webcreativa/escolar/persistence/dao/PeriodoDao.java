package ec.com.webcreativa.escolar.persistence.dao;



import java.util.List;

import javax.ejb.Local;

import ec.com.webcreativa.escolar.persistence.entity.Periodo;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

@Local
public interface PeriodoDao extends GenericDao<Periodo, Integer>{

	/**
	 * Busca un periodo por estado y region
	 * @param estado
	 * @return
	 */
	List<Periodo> buscarPorRegionActivo(Integer idRegion, Boolean estado)throws EntidadNoEncontradaException;
}
