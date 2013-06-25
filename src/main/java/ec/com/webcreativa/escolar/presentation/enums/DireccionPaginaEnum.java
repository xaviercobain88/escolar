/**
 * 
 */
package ec.com.webcreativa.escolar.presentation.enums;

/**
 * @author chan
 * 
 */
public enum DireccionPaginaEnum {

	LANDSCAPE("landscape"), PORTRAIT("portrait");

	private final String direccion;

	private DireccionPaginaEnum(final String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the id
	 */
	public String getDireccion() {
		return direccion;
	}

}
