/*
 */
package ec.com.webcreativa.escolar.business.facade.impl;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import ec.com.webcreativa.escolar.business.facade.ListasUtilFacade;

@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ListasUtilFacadeImpl implements ListasUtilFacade {


}
