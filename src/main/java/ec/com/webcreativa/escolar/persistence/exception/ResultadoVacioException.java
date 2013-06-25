package ec.com.webcreativa.escolar.persistence.exception;

public class ResultadoVacioException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 5142152685073063059L;

    /**
     * 
     */
    public ResultadoVacioException() {
    }

    /**
     * @param message
     */
    public ResultadoVacioException(String message) {
	super(message);
    }

    /**
     * @param cause
     */
    public ResultadoVacioException(Throwable cause) {
	super(cause);
    }

    /**
     * @param message
     * @param cause
     */
    public ResultadoVacioException(String message, Throwable cause) {
	super(message, cause);
    }

}
