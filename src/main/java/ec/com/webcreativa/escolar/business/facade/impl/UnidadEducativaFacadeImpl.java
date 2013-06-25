/*
 */
package ec.com.webcreativa.escolar.business.facade.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.business.facade.UnidadEducativaFacade;
import ec.com.webcreativa.escolar.persistence.dao.UnidadEducativaDao;
import ec.com.webcreativa.escolar.persistence.entity.UnidadEducativa;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoEncontradaException;
import ec.com.webcreativa.escolar.persistence.exception.EntidadNoGuardadaException;
import ec.com.webcreativa.escolar.util.BaseUtils;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class UnidadEducativaFacadeImpl extends BaseUtils implements
		UnidadEducativaFacade {

	@EJB
	UnidadEducativaDao unidadEducativaDao;

	public UnidadEducativa guardar(UnidadEducativa unidadEducativa)
			throws EntidadNoGuardadaException, EntidadNoEncontradaException {
		if(unidadEducativa.getIdUe()==null){
		return unidadEducativaDao.create(unidadEducativa);
		}else{
			return unidadEducativaDao.update(unidadEducativa);	
		}
		
	}

}
