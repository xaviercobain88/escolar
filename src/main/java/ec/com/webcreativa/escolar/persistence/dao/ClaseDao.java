package ec.com.webcreativa.escolar.persistence.dao;



import java.util.List;

import javax.ejb.Local;

import ec.com.webcreativa.escolar.persistence.entity.Clase;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;

@Local
public interface ClaseDao extends GenericDao<Clase, Integer>{

    /**
     * Buscar por Periodo y Profesor
     * @param profesor
     * @param periodo
     * @return
     */
    List<Clase> buscarXPeriodoProfesor(Integer idProfesor, Integer idPeriodo)throws EntidadNoEncontradaException;
}
