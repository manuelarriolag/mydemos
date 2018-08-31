package org.manuelarriola.demos.models;

import java.util.ArrayList;
import java.util.List;

public class ClienteListResponse extends GenericResponse {
	private List<Cliente> list;
	
	/***
	 * Constructor
	 */
	public ClienteListResponse() {
		super();
		this.list = new ArrayList<Cliente>();
	}

	/***
	 * Constructor
	 * 
	 * @param ok valor indicador de respuesta del server
	 * @param status estatus de respuesta
	 * @param statusText texto del estatus de la respuesta
	 * @param message mensaje de respuesta
	 */
	public ClienteListResponse(boolean ok, int status, String statusText, String message) {
		super(ok, status, statusText, message);
		this.list = new ArrayList<Cliente>();
	}


	public List<Cliente> getList() {
		return list;
	}

	public void setList(List<Cliente> list) {
		this.list = list;
	}


}
