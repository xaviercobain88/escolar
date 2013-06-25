/*
 */
package ec.com.webcreativa.escolar.persistence.dao.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.persistence.dao.ConfiguracionSistemaDao;
import ec.com.webcreativa.escolar.persistence.entity.ConfiguracionSistema;

/**
 * @author xavier
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class ConfiguracionSistemaDaoImpl extends
		GenericDaoImpl<ConfiguracionSistema, Integer> implements
		ConfiguracionSistemaDao {

	/**
	 * 
	 */
	public ConfiguracionSistemaDaoImpl() {
		super(ConfiguracionSistema.class);

	}

}
