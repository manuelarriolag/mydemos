package org.manuelarriola.demos.models;


/***
 * Enumerador para manejar los estatus devueltos desde los servicios,
 * para indicar si ocurrió un error, si la consulta trajo datos o no, etc.
 * 
 * @author Manuel Arriola
 *
 */
public enum ResponseStateEnum {
	
	ERROR_SERVIDOR(0),
	CON_DATOS(1), 
	SIN_DATOS(2),
	ERROR_VALIDACION(3);
	
		
	private int valor;
	
	/***
	 * Constructor
	 * @param valor valor del enumerador
	 */
	ResponseStateEnum(int valor) {
		this.valor = valor;
	}

	public int getValue() {
		return valor;
	}		
}
