package org.manuelarriola.demos.controllers;

import org.manuelarriola.demos.models.Cliente;
import org.manuelarriola.demos.models.ClienteListResponse;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * 
 * @author Manuel Arriola
 *
 */
@RestController
@RequestMapping("/clientes")
@Api("Servicio para administración de clientes")
public class ClienteController {
	
	
	@Autowired
	private ClienteService clienteService;
	
		
	/***
	 * Constructor default y único para el controller
	 * 
	 * @param 
	 *  clienteService es el servicio responsable de la lógica de negocio.
	 */
	@Autowired 
	public ClienteController(ClienteService clienteService) {
	     this.clienteService = clienteService;
	}
		
	
	/***
	 * Obtiene la lista de clientes.
	 * 
	 * @return ClienteListResponse La lista de clientes registrados con lps 
	 */
	@ApiOperation(notes = "Obtiene la lista de clientes", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE, value = "")
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ClienteListResponse getList(){	
		return clienteService.findAll();
	}
	
	/***
	 * Obtiene el cliente especificado por ID.
	 * 
	 * @return ClienteListResponse Datos del cliente
	 */
	@ApiOperation(notes = "Obtiene el cliente especificado por ID", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE, value = "")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ClienteListResponse getById(@PathVariable("id") String id){	
		return clienteService.findById(id);
	}
	
	
	/***
	 * Obtiene el cliente especificado por NOMBRE.
	 * 
	 * @return ClienteListResponse Datos del cliente
	 */
	@ApiOperation(notes = "Obtiene el cliente especificado por NOMBRE", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE, value = "")
	@RequestMapping(method = RequestMethod.GET, params="nombre")
	public ClienteListResponse getByNombre(@RequestParam("nombre") String nombre){	
		return clienteService.findByNombre(nombre);
	}
	
	
	/***
	 * Crear el cliente especificado.
	 * 
	 * @return ClienteListResponse Datos del cliente
	 */
	@ApiOperation(notes = "Crear el cliente especificado", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE, value = "")
	@RequestMapping(method = RequestMethod.POST)
	public ClienteListResponse create(Cliente cliente){	
		return clienteService.save(cliente);
	}
}
