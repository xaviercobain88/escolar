/**
 * 
 */
package ec.com.webcreativa.escolar.persistence.enums;

public enum TipoMateriaEnum {

	SUGERIDA("sugerida"), ESPECIAL("especial"), OTRA("otra"), CAMBIADA("cambiada");

	private final String nombre;

	private TipoMateriaEnum(final String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

}
