package ec.com.webcreativa.escolar.presentation.action;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import ec.com.webcreativa.escolar.presentation.datamanager.PaginaPersonaDM;

@Named("paginaPersonaAction")
@RequestScoped
public class PaginaPersonaAction {
	@Inject
	PaginaPersonaDM paginaPersonaDM;

}
