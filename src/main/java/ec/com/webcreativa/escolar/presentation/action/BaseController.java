package ec.com.webcreativa.escolar.presentation.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ec.com.webcreativa.escolar.persistence.entity.ComboBoxModel;
import ec.com.webcreativa.escolar.presentation.datamanager.BaseControllerDM;
import ec.com.webcreativa.escolar.util.BaseUtils;
import ec.com.webcreativa.escolar.util.LabelsConstants;
import ec.com.webcreativa.escolar.util.MessagesConstants;
import ec.com.webcreativa.escolar.util.ParametersConstants;

public abstract class BaseController extends BaseUtils {


	public abstract String getInit();

	protected String getUsuario() {
		return getServletRequest().getUserPrincipal().getName();
	}

	protected void quitarPermisos(BaseControllerDM baseControllerDM) {
		baseControllerDM.setTodosAllow(false);
		baseControllerDM.setAlumnoAllow(false);
		baseControllerDM.setRepresentanteAllow(false);
		baseControllerDM.setProfesorAllow(false);
		baseControllerDM.setInspectorAllow(false);
		baseControllerDM.setJefeAreaAllow(false);
		baseControllerDM.setInspectorGeneralAllow(false);
		baseControllerDM.setSicologoAllow(false);
		baseControllerDM.setSecretariaAllow(false);
		baseControllerDM.setRectorAllow(false);
		baseControllerDM.setAdministradorInstitucionAllow(false);
		baseControllerDM.setAdministradorAplicacionAllow(false);

	}

	protected void addErrorMessage(final String resumen) {
		FacesMessage message = new FacesMessage(resumen);
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	protected void addErrorMessageBundle(final String resumenKey) {
		addErrorMessage(getMessageFromResourceBundle(resumenKey));
	}

	protected void addErrorMessage(final String resumen, final String detalle) {
		FacesMessage message = new FacesMessage(resumen, detalle);
		message.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	protected void addErrorMessageBundle(final String resumenKey,
			final String detalleKey) {
		addErrorMessage(getMessageFromResourceBundle(resumenKey),
				getMessageFromResourceBundle(detalleKey));
	}

	protected void addInfoMessage(final String resumen) {
		FacesMessage message = new FacesMessage(resumen);
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	protected void addInfoMessageBundle(final String resumenKey) {
		addInfoMessage(getMessageFromResourceBundle(resumenKey));
	}

	protected void addInfoMessage(final String resumen, final String detalle) {
		FacesMessage message = new FacesMessage(resumen, detalle);
		message.setSeverity(FacesMessage.SEVERITY_INFO);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	protected void addInfoMessageBundle(final String resumenKey,
			final String detalleKey) {
		addInfoMessage(getMessageFromResourceBundle(resumenKey),
				getMessageFromResourceBundle(detalleKey));
	}

	protected void addWarnMessage(final String resumen) {
		FacesMessage message = new FacesMessage(resumen);
		message.setSeverity(FacesMessage.SEVERITY_WARN);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	protected void addWarnMessageBundle(final String resumenKey) {
		addWarnMessage(getMessageFromResourceBundle(resumenKey));
	}

	protected void addWarnMessage(final String resumen, final String detalle) {
		FacesMessage message = new FacesMessage(resumen, detalle);
		message.setSeverity(FacesMessage.SEVERITY_WARN);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	protected void addWarnMessageBundle(final String resumenKey,
			final String detalleKey) {
		addWarnMessage(getMessageFromResourceBundle(resumenKey),
				getMessageFromResourceBundle(detalleKey));
	}

	public boolean isExistErrors() {
		Severity maximunSeverity = getFacesContext().getMaximumSeverity();
		if (FacesMessage.SEVERITY_ERROR.equals(maximunSeverity)) {
			return true;
		}
		return false;
	}

	protected static FacesContext getFacesContext() {
		return FacesContext.getCurrentInstance();
	}

	protected Object getRequestParameter(final String parameterName) {
		return getFacesContext().getExternalContext().getRequestParameterMap()
				.get(parameterName);
	}

	protected String getRemoteUser() {
		String username = FacesContext.getCurrentInstance()
				.getExternalContext().getRemoteUser();
		return username;
	}

	protected HttpSession getSession() {
		return (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(false);
	}

	protected ServletContext getServletContext() {
		return (ServletContext) FacesContext.getCurrentInstance()
				.getExternalContext().getContext();

	}

	protected HttpServletResponse getServletResponse() {
		return (HttpServletResponse) getFacesContext().getExternalContext()
				.getResponse();
	}

	protected HttpServletRequest getServletRequest() {
		return (HttpServletRequest) getFacesContext().getExternalContext()
				.getRequest();
	}

	protected Map<String, Object> getSessionMap() {
		return getFacesContext().getExternalContext().getSessionMap();
	}

	protected boolean isNumeric(final String value) {
		try {
			Long.valueOf(value);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public String getContextPath() {
		return getServletContext().getContextPath();
	}

	public String getMessageFromResourceBundle(String key) {
		return getFacesContext().getApplication()
				.getResourceBundle(getFacesContext(), MessagesConstants.NAME)
				.getString(key);
	}

	public String getParameterFromResourceBundle(String key) {
		return getFacesContext().getApplication()
				.getResourceBundle(getFacesContext(), ParametersConstants.NAME)
				.getString(key);
	}
	public String getLabelFromResourceBundle(String key) {
		return getFacesContext().getApplication()
				.getResourceBundle(getFacesContext(), LabelsConstants.NAME)
				.getString(key);
	}
	

	public String getNumeroFilas() {
		return (String) getParameterFromResourceBundle(ParametersConstants.NUMERO_FILAS);
	}

	public String getMaxPaginas() {
		return (String) getParameterFromResourceBundle(ParametersConstants.MAXIMO_PAGINAS);
	}

	public String getPatronFecha() {
		return (String) getParameterFromResourceBundle(ParametersConstants.PATRO_FECHA);
	}

	public String getPatronHora() {
		return (String) getParameterFromResourceBundle(ParametersConstants.PATRON_HORA);
	}

	public String getPatronFechaHora() {
		return (String) getParameterFromResourceBundle(ParametersConstants.PATRON_FECHA_HORA);
	}

	public Locale getDefaultLocale() {
		return new Locale(
				getParameterFromResourceBundle(ParametersConstants.LOCALE_LANGUAGE),
				getParameterFromResourceBundle(ParametersConstants.LOCALE_COUNTRY));
	}

	protected List<SelectItem> getSelectItems(
			List<? extends ComboBoxModel> lista, boolean itemSeleccione) {
		List<SelectItem> items = new ArrayList<SelectItem>();
		if (itemSeleccione) {
			items.add(new SelectItem(
					0,
					getLabelFromResourceBundle(LabelsConstants.COMBOBOX_SELECCIONE)));
		}
		if (lista != null) {
			for (ComboBoxModel item : lista) {
				items.add(new SelectItem(item.getComboBoxValue(), item
						.getComboBoxLabel()));
			}
		}
		return items;
	}
}