package ec.com.webcreativa.escolar.persistence.enums;

/*
 * 0	Todos				
 * 1	Alumno
 * 2	Representante
 * 3	Profesor
 * 4	Inspector
 * 5	Jefe de Area
 * 6	Inspector General
 * 7	Sicologo
 * 8	Secretaria
 * 9	Rector
 * 10	Admin UE			
 * 20	Admin App			
 */
public enum RolesFuncionalesEnum {
	TODOS("Todos"), ALUMNO("Alumno"), REPRESENTANTE("Representante"), PROFESOR(
			"Profesor"), INSPECTOR("Inspector"), JEFE_AREA("Jefe de Area"), INSPECTOR_GENERAL(
			"Inspector General"), SICOLOGO("Sicologo"), SECRETARIA("Secretaria"), RECTOR(
			"Rector"), ADMIN_INSTITUCION("Administrador Institucion"), ADMIN_APLICACION(
			"Administrador Aplicacion");

	private final String descripcion;

	private RolesFuncionalesEnum(final String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

}
