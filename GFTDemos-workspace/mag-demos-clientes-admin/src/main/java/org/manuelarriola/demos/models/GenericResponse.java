package org.manuelarriola.demos.models;



/***
 * Clase genérica de respuesta para exponerlo al front
 * e identificar que tipo de resultado y respuesta se genera
 * desde los servicios de backend.
 * 
 * @author Manuel Arriola
 *
 */
public class GenericResponse {

	/** resp. */
	private boolean ok;
	
	private int status;
			
	/** error msg. */
	private String statusText;
	
	/** error cod. */
	private String message;
	
	
	/***
	 * constructor por defecto que inicializa a error toda la respuesta y obliga al servicio a asignar un valor correspondiente.
	 */
	public GenericResponse() {
		this.ok = false;
		this.status = ResponseStateEnum.SIN_DATOS.getValue();
		this.statusText = "";
		this.message = "";
	}
		
	/***
	 * constructor inicializador
	 * @param ok
	 * @param status
	 * @param statusText
	 * @param message
	 */
	public GenericResponse(boolean ok, int status, String statusText, String message) {
		super();
		this.ok = ok;
		this.status = status;
		this.statusText = statusText;
		this.message = message;
	}


	public boolean isOk() {
		return ok;
	}


	public void setOk(boolean ok) {
		this.ok = ok;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getStatusText() {
		return statusText;
	}


	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}		
}
