package org.manuelarriola.demos.controllers;

import org.manuelarriola.demos.models.Cliente;
import org.manuelarriola.demos.models.ClienteListResponse;
import org.manuelarriola.demos.models.ResponseStateEnum;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceMock implements ClienteService {
	
	@Override
	public ClienteListResponse findAll() {
		ClienteListResponse resp = new ClienteListResponse(true, 
				ResponseStateEnum.CON_DATOS.getValue(), ResponseStateEnum.CON_DATOS.toString(), "Datos obtenidos exitósamente");
		
		resp.getList().add(new Cliente("IND. TECNICAS MEXICANAS", "n/d", "4946 IND. TECNICAS MEXICANAS"));
		resp.getList().add(new Cliente("HEB TAMPICO 1", "n/d", "4886 HEB TAMPICO 1"));
		resp.getList().add(new Cliente("HEB SAN NICOLAS", "n/d", "4895 HEB SAN NICOLAS"));
		resp.getList().add(new Cliente("HEB SANTA CATARINA", "n/d", "4889 HEB SANTA CATARINA"));
		
		return resp;
	}

	@Override
	public ClienteListResponse findById(String id) {
		ClienteListResponse resp = new ClienteListResponse(true, 
				ResponseStateEnum.CON_DATOS.getValue(), ResponseStateEnum.CON_DATOS.toString(), "Datos obtenidos exitósamente");
		
		Cliente cliente = new Cliente("IND. TECNICAS MEXICANAS", "n/d", "4946 IND. TECNICAS MEXICANAS");
		cliente.setId(id);
		resp.getList().add(cliente);
		
		return resp;
	}

	@Override
	public ClienteListResponse findByNombre(String nombre) {
		ClienteListResponse resp = new ClienteListResponse(true, 
				ResponseStateEnum.CON_DATOS.getValue(), ResponseStateEnum.CON_DATOS.toString(), "Datos obtenidos exitósamente");
		
		Cliente cliente = new Cliente("IND. TECNICAS MEXICANAS", "n/d", "4946 IND. TECNICAS MEXICANAS");
		cliente.setNombre(nombre);
		resp.getList().add(cliente);
		
		return resp;
	}

	@Override
	public ClienteListResponse save(Cliente cliente) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ClienteListResponse update(Cliente cliente, String id) {
		throw new UnsupportedOperationException();
	}

	@Override
	public ClienteListResponse delete(String id) {
		throw new UnsupportedOperationException();
	}

}
