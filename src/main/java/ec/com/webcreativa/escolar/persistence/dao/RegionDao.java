package ec.com.webcreativa.escolar.persistence.dao;



import java.util.List;

import javax.ejb.Local;

import ec.com.webcreativa.escolar.persistence.entity.Region;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

@Local
public interface RegionDao extends GenericDao<Region, Integer>{

    /**
     * Busca las regiones de un pais
     * @return
     */
    List<Region> buscarRegionesPais(Integer idPais)throws EntidadNoEncontradaException;
}
