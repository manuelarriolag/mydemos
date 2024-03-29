package org.manuelarriola.demos.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.manuelarriola.demos.models.Cliente;
import org.manuelarriola.demos.models.ClienteListResponse;
import org.manuelarriola.demos.models.ResponseStateEnum;
import org.manuelarriola.demos.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class ClienteServiceImpl implements ClienteService {

	@Autowired
    ClienteRepository repository;

	@Override
	public ClienteListResponse findAll() {
		ClienteListResponse resp = new ClienteListResponse(true, 
				ResponseStateEnum.CON_DATOS.getValue(), ResponseStateEnum.CON_DATOS.toString(), "Datos obtenidos exitósamente usando findAll()");
		
		resp.setList(repository.findAll());
		
		return resp;

	}

	@Override
	public ClienteListResponse findByNombre(String nombre) {
		ClienteListResponse resp = new ClienteListResponse(true, 
				ResponseStateEnum.CON_DATOS.getValue(), ResponseStateEnum.CON_DATOS.toString(), "Datos obtenidos exitósamente usando findByNombre()");
		
		List<Cliente> list = repository.findByNombre(nombre);
		if (list.size() == 0) {
			resp.setOk(false);
			resp.setStatus(ResponseStateEnum.SIN_DATOS.getValue());
			resp.setStatusText(ResponseStateEnum.SIN_DATOS.toString());
			resp.setMessage("No se encontraron datos que coincidan con la consulta");
		}
		resp.setList(list);
		
		return resp;

	}

	@Override
	public ClienteListResponse findById(String id) {
		ClienteListResponse resp = new ClienteListResponse(true, 
				ResponseStateEnum.CON_DATOS.getValue(), ResponseStateEnum.CON_DATOS.toString(), "Datos obtenidos exitósamente usando findById()");
		
		List<Cliente> list = new ArrayList<Cliente>();
		Optional<Cliente> cliente = repository.findById(id);
		if (cliente.isPresent()) {
			list.add(cliente.get());
		} else {
			resp.setOk(false);
			resp.setStatus(ResponseStateEnum.SIN_DATOS.getValue());
			resp.setStatusText(ResponseStateEnum.SIN_DATOS.toString());
			resp.setMessage("No se encontraron datos que coincidan con la consulta");
		}
		resp.setList(list);
		
		return resp;

	}

	@Override
	public ClienteListResponse save(Cliente cliente) {
		ClienteListResponse resp = new ClienteListResponse(true, 
				ResponseStateEnum.CON_DATOS.getValue(), ResponseStateEnum.CON_DATOS.toString(), "Operación SAVE exitosa");
		
		try {
			repository.save(cliente);
			
			List<Cliente> list = new ArrayList<Cliente>();
			list.add(cliente);
			resp.setList(list);

		} catch (Exception e) {
			e.printStackTrace();
			resp.setOk(false);
			resp.setStatus(ResponseStateEnum.ERROR_SERVIDOR.getValue());
			resp.setStatusText(ResponseStateEnum.ERROR_SERVIDOR.toString());
			resp.setMessage(e.getMessage());
		}
		
		return resp;
	}
	
	@Override
	public ClienteListResponse update(Cliente cliente, String id) {
		ClienteListResponse resp = new ClienteListResponse(true, 
				ResponseStateEnum.SIN_DATOS.getValue(), ResponseStateEnum.SIN_DATOS.toString(), "Operación UPDATE exitosa");
		
		try {
			
			Optional<Cliente> clienteExistente = repository.findById(id);
			if (clienteExistente.isPresent()) {
				Cliente clienteModificado = clienteExistente.get();
				clienteModificado.setNombre(cliente.getNombre());
				clienteModificado.setApellidos(cliente.getApellidos());
				clienteModificado.setDomicilio(cliente.getDomicilio());
				repository.save(clienteModificado);
			} else {
				resp.setOk(false);
				resp.setStatus(ResponseStateEnum.SIN_DATOS.getValue());
				resp.setStatusText(ResponseStateEnum.SIN_DATOS.toString());
				resp.setMessage("No se encontraron datos que coincidan con el cliente solicitado");
			}
			

		} catch (Exception e) {
			e.printStackTrace();
			resp.setOk(false);
			resp.setStatus(ResponseStateEnum.ERROR_SERVIDOR.getValue());
			resp.setStatusText(ResponseStateEnum.ERROR_SERVIDOR.toString());
			resp.setMessage(e.getMessage());
		}
		
		return resp;
	}

	@Override
	public ClienteListResponse delete(String id) {
		ClienteListResponse resp = new ClienteListResponse(true, 
				ResponseStateEnum.SIN_DATOS.getValue(), ResponseStateEnum.SIN_DATOS.toString(), "Operación DELETE exitosa");
		
		try {
			
			Optional<Cliente> cliente = repository.findById(id);
			if (cliente.isPresent()) {
				repository.delete(cliente.get());
			} else {
				resp.setOk(false);
				resp.setStatus(ResponseStateEnum.SIN_DATOS.getValue());
				resp.setStatusText(ResponseStateEnum.SIN_DATOS.toString());
				resp.setMessage("No se encontraron datos que coincidan con el cliente solicitado");
			}
						
		} catch (Exception e) {
			e.printStackTrace();
			resp.setOk(false);
			resp.setStatus(ResponseStateEnum.ERROR_SERVIDOR.getValue());
			resp.setStatusText(ResponseStateEnum.ERROR_SERVIDOR.toString());
			resp.setMessage(e.getMessage());
		}
		
		return resp;
	}


}
